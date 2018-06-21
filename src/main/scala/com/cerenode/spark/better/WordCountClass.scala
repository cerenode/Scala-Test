package com.cerenode.spark.better

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD

class WordCountClass(sc:SparkContext, file:String) {

  val tokenized:RDD[String] = sc.textFile(file).flatMap(_.split(" "))

  val wordCounts = tokenized.map((_, 1)).reduceByKey(_ + _)

  def getTotalWordsCounts:Long = wordCounts.values.reduce(_ + _)

  def getdistinctWordsCount:Long = wordCounts.keys.count()


}
