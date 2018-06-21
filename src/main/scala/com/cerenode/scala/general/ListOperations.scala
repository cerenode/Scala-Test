package com.cerenode.scala.general

import java.io.{File, FileWriter}

class ListOperations[T](list: List[T]) {

  def addList(otherList: List[T]): List[T] = this.list ++ otherList

  def getValueFromIndex(idx: Int): T = list(idx)

  def getUniqueElements: List[T] = list.distinct

  def addTwoNumbers(a: Int, b: Int): Int = a + b

  def withFile(testCode: (File, FileWriter) => Any) {
    val file = File.createTempFile("hello", "world") // create the fixture
    val writer = new FileWriter(file)
    try {
      writer.write("ScalaTest is ") // set up the fixture
      testCode(file, writer) // "loan" the fixture to the test
    }
    finally writer.close() // clean up the fixture
  }

  def withAnotherFile(testCode: (File, FileWriter) => Any) {
    val file = File.createTempFile("hello", "world") // create the fixture
    val writer = new FileWriter(file)
    try {
      writer.write("Scala is a") // set up the fixture
      testCode(file, writer) // "loan" the fixture to the test
    }
    finally writer.close() // clean up the fixture
  }

}
