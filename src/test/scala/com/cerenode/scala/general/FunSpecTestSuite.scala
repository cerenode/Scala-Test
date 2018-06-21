package com.cerenode.scala.general

import org.scalatest.FunSpec
import org.scalatest.tagobjects.Slow

class FunSpecTestSuite extends FunSpec {

  val g = new ListOperations(List(2, 4, 6, 8, 1, 3, 5, 2, 4, 6, 8))
  describe("adding function") {
    describe("adding integers") {
      it("should return positive values for adding positive integers") {
        assert(g.addTwoNumbers(3, 4) == 7)
      }
    }
  }

  describe("list access") {
    describe("accessing elements inside list") {
      it("should return element at index if index less than list size") {
        assert(g.getValueFromIndex(3) == 4)
      }
    }

    describe("accessing elements outside index") {
      it("should produce IndexOutOfBoundsException", Slow) {
        intercept[IndexOutOfBoundsException] {
          g.getValueFromIndex(7)
        }
      }
    }
  }

}
