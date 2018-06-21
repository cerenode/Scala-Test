package com.cerenode.scala.general

import org.scalatest.FlatSpec

class AssertionTest extends FlatSpec {

  // normal assertions
  val left = 2
  val right = 1
  assert(left != right)  // assertion returning true

//  assert(left ==  right)  // assertion returning false


  //  when operands are lengthy expressions
  val a = 5
  val b = 2
  assertResult(3) {
    a - b
  }

  // assertThrows succeeds if expected Exception is thrown
  // but complete abruptly if execution succeeds or returns an unexpected Exception
  val str = "hi"
  assertThrows[IndexOutOfBoundsException] {
    str.charAt(3)
  }

}
