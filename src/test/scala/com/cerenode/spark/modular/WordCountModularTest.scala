package com.cerenode.spark.modular

import org.scalatest._

import com.cerenode.spark.spark.SharedSparkSession.sc
import org.apache.spark.rdd.RDD
@DoNotDiscover
class WordCountModularTest extends FlatSpec with Matchers {

  behavior of "WordCount"

  val fileLines = Array("Line One", "Line Two", "Line Three", "Line Four")

  val wc = new WordCountModularClass(sc, "not going to use")

  it should "countWordsInFile should count words" in {
    val inputRDD: RDD[String] = sc.parallelize[String](fileLines)
    val results = wc.countWords(inputRDD).collect
    results should contain ("Line One", 1)
  }

  it should "splitFile should split the file into words" in {
    val inputRDD: RDD[String] = sc.parallelize[String](fileLines)
    val wordsRDD = wc.splitFile(inputRDD)
    wordsRDD.count() should be (8)
  }

  it should "countWords should count the occurrences of each word" in {
    val words = Array("word", "count", "example", "word")
    val inputRDD: RDD[String] = sc.parallelize[String](words)
    val wordCounts = wc.countWords(inputRDD).collect
    wordCounts should contain ("word", 2)
    wordCounts should contain ("count", 1)
    wordCounts should contain ("example", 1)
  }

}
