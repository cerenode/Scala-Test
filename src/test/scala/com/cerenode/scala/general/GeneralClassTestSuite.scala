package com.cerenode.scala.general

import com.holdenkarau.spark.testing.SharedSparkContext
import org.scalatest.FunSuite
import org.scalatest.tagobjects.Slow

class GeneralClassTestSuite extends FunSuite with SharedSparkContext {

  val gen = new ListOperations(List(2, 4, 6, 8, 1, 3, 5, 2, 4, 6, 8))

  test("Adding two positive numbers should return another positive number") {
    assert(gen.addTwoNumbers(3, 4) == 7)
  }

  test("Adding two negative numbers should return a negative number") {
    assert(gen.addTwoNumbers(-3, -4) == -7)
  }

  test("Adding a positive and negative number might result in a positive or negative number") {
    assert(gen.addTwoNumbers(-3, 4) == 1)
    assert(gen.addTwoNumbers(3, -4) == -1)
  }

  test("invoking index value greater than index value should return IndexOutOfBoundException", Slow) {
    intercept[IndexOutOfBoundsException] {
      gen.getValueFromIndex(7)
    }
  }



}
