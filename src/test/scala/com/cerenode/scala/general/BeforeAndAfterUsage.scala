package com.cerenode.scala.general

import org.scalatest.{BeforeAndAfter, FlatSpec}

import scala.collection.mutable.ListBuffer

class BeforeAndAfterUsage extends FlatSpec with BeforeAndAfter {

  val builder = new StringBuilder
  val buffer = new ListBuffer[String]

  before {
    builder.append("ScalaTest is ")
  }

  after {
    builder.clear()
    buffer.clear()
  }

  "Testing" should " work" in {
    builder.append("easy!")
    println(builder)
    println(buffer)
    assert(builder.toString === "ScalaTest is easy!")
    assert(buffer.isEmpty)
    buffer += "sweet"
  }

  it should "be fun" in {
    builder.append("fun!")
    assert(builder.toString === "ScalaTest is fun!")
    assert(buffer.isEmpty)
  }

}
