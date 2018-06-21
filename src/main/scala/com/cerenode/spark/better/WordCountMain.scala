package com.cerenode.spark.better

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object WordCountMain {

  def main(args: Array[String]) {
    // create Spark context with Spark configuration

    val sc = new SparkContext(new SparkConf().setAppName("Word Count"))

    val wordCount = new WordCountClass(sc, args(0))

    println(wordCount.getdistinctWordsCount)

    sc.stop()

  }

}
