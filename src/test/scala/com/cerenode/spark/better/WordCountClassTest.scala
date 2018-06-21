package com.cerenode.spark.better

import org.scalatest.{BeforeAndAfterAll, DoNotDiscover, FlatSpec}
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
@DoNotDiscover
class WordCountClassTest extends FlatSpec with BeforeAndAfterAll {

  var sparkConf: SparkConf = _
  var sc: SparkContext = _


  val testFilePath = getClass.getResource("/test.txt").getPath

  override def beforeAll() {
    sparkConf = new SparkConf().setAppName("unit-testing").setMaster("local")
    sc = new SparkContext(sparkConf)

  }

  "WordCountClass" should "get total words count in file" in {
    val wordCount = new WordCountClass(sc, testFilePath)
    val result = wordCount.getTotalWordsCounts
    assertResult(12)(result)
  }

  "WordCountClass" should "get distinct words count in file" in {
    val wordCount = new WordCountClass(sc, testFilePath)
    val result = wordCount.getdistinctWordsCount
    assertResult(11)(result)
  }

  override def afterAll() {
    sc.stop()
  }
}
