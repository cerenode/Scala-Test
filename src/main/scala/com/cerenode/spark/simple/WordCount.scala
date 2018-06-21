package com.cerenode.spark.simple

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD

object SparkWordCount {
  def main(args: Array[String]) {

    // create Spark context with Spark configuration

    val sc = new SparkContext(new SparkConf().setAppName("Word Count"))


    // read in text file and split each document into words
    val tokenized:RDD[String] = sc.textFile(args(0)).flatMap(_.split(" "))

    // count the occurrence of each word
    val wordCounts = tokenized.map((_, 1)).reduceByKey(_ + _)

    val distinctWords:Long = wordCounts.keys.count()

    println(distinctWords)

    sc.stop()

  }
}
