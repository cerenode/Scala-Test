package com.cerenode.spark.modular

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

class WordCountModularClass(sc:SparkContext, file:String) {


  lazy val wordsByLine =  sc.textFile(file)

  lazy val wordsCount = countwordsInFile(wordsByLine).persist()


  def countwordsInFile = splitFile _ andThen countWords _


  def splitFile(wordsByLine: RDD[String]): RDD[String] = {
    wordsByLine.flatMap(line => line.split(" "))
  }

  def countWords(words: RDD[String]): RDD[(String, Int)] = {
    words.map(word => (word, 1)).reduceByKey(_ + _)
  }


  def getTotalWordsCounts:Long = wordsCount.values.reduce(_ + _)

  def getdistinctWordsCount:Long = wordsCount.keys.count()


}
