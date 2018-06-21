package com.cerenode.scala.general

import org.scalatest.WordSpec

class WordSpecTestSuite extends WordSpec{

  val g = new ListOperations(List(2, 4, 6, 8, 1, 3, 5, 2, 4, 6, 8))

  "GeneralClass" can {

    "AddTwoNumbers" can {
      "Adding positive numbers" should {
        "give +ve numbers " in {
          assert(g.addTwoNumbers(2, 4) == 6)
        }
      }
    }

    "GettingValueFromList" can {
      "accessing value from list elements" should {
        "return value at index" in {
          assert(g.getValueFromIndex(3) == 4)
        }

        "return IndexOutOfBoundsException if index out of bounds" ignore {
          intercept[IndexOutOfBoundsException] {
            g.getValueFromIndex(7)
          }
        }
      }
    }
  }

}
