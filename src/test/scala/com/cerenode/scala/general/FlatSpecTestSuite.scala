package com.cerenode.scala.general

import org.scalatest.tagobjects.{Network, Slow}
import org.scalatest.{FlatSpec, Matchers}

class FlatSpecTestSuite extends FlatSpec with Matchers {

  "An empty Set" should "have size 0" in {  // example
    assert(Set.empty.size == 0)
  }

  it should "produce NoSuchElementException when head is invoked" taggedAs (Slow, Network) in {  // just an example for tagging
    an [NoSuchElementException] should be thrownBy{
      Set.empty.head
    }
  }

  2+2 should equal(4)  // example
}
