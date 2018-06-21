package com.cerenode.scala.general

import org.scalatest.FlatSpec
import org.scalatest.tagobjects.Slow

class Fixtures extends FlatSpec {

  val g = new ListOperations(List(2, 4, 6, 8, 1, 3, 5, 2, 4, 6, 8))   // creating instance of a class to test the contents of the class

  "Testing" should "be productive" taggedAs Slow in g.withFile { (file, writer) =>
    writer.write("productive!")
    writer.flush()
    assert(file.length == 24)
  }

  it should "also write " taggedAs Slow in g.withFile { (file, writer) =>
    g.withAnotherFile { (file2, writer2) =>
      writer.write("concise!")
      writer.flush()
      writer2.write("functional")
      writer2.flush()
      assert(file.length() + file2.length() == 41)
    }
  }

}
