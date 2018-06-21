package com.cerenode.scala.general

import org.scalatest.FlatSpec

class Assertion2 extends FlatSpec {

  val numer = 45
  val g = new ListOperations(List(2, 4, 6, 8, 1, 3, 5, 2, 4, 6, 8))
  assertThrows[ArithmeticException] {
    numer / 0
  }

}
