package com.cerenode.scala.general

import org.scalatest.{FlatSpec, Matchers}

class MatchersTest extends FlatSpec with Matchers {

  val g = new ListOperations(List(2, 4, 6, 8, 1, 3, 5, 2, 4, 6, 8))
  val result = g.addTwoNumbers(1, 2)

  result should equal (3)            // can customize equality
  result should === (3)       // can customize equality and enforce type constraints
  result should be (3)               // cannot customize equality, so fastest to compile
  result shouldEqual 3               // can customize equality, no parentheses required
  result shouldBe 3                  // cannot customize equality, so fastest to compile, no parentheses required


//  Some(result) should === (3)    // will fail because of type checking

  result should === (3.0)



}
