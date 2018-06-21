package com.cerenode.spark.modular

import com.holdenkarau.spark.testing.{RDDComparisons, SharedSparkContext}
import org.scalatest._
import org.apache.spark.rdd.RDD

class TestBaseTest extends FlatSpec with Matchers with SharedSparkContext with RDDComparisons  {


  behavior of "WordCount"

  val fileLines = Array("Line One", "Line Two", "Line Three", "Line Four")

  val wc = new WordCountModularClass(sc, "not going to use")

  it should "countWordsInFile should count words" in {
    val inputRDD: RDD[String] = sc.parallelize[String](fileLines)

    val expectedRDD = sc.parallelize(Seq(("Line One",1),("Line Two",1), ("Line Three",1),("Line Four",1)))

    val results = wc.countWords(inputRDD)

    assertResult(None)(compareRDD(results, expectedRDD))

    assertRDDEquals(expectedRDD, results)
  }

  it should "splitFile should split the file into words" in {
    val inputRDD: RDD[String] = sc.parallelize[String](fileLines)
    val wordsRDD = wc.splitFile(inputRDD)
    wordsRDD.count() should be (8)
  }

  it should "countWords should count the occurrences of each word" in {

    val words = Array("word", "count", "example", "word")
    val expectedRDD = sc.parallelize(Seq(("word",2),("count",1), ("example",1)))

    val inputRDD: RDD[String] = sc.parallelize[String](words)

    val wordCounts = wc.countWords(inputRDD)

    assertRDDEquals(expectedRDD, wordCounts)

  }

}
