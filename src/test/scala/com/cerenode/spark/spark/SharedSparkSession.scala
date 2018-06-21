package com.cerenode.spark.spark

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

object SharedSparkSession {
  lazy val spark: SparkSession = createSparkSession
  lazy val sc:SparkContext = spark.sparkContext
  private def createSparkSession: SparkSession = {
    val session = SparkSession
      .builder()
      .appName("spark_test")
      .master("local[4]")
      .config("spark.ui.enabled", "false")
      .getOrCreate()
    session
  }

}
