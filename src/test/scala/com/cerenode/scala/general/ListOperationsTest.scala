package com.cerenode.scala.general

case class MyClass(name: String) {
  override def equals(o: Any) = o match {
    case that: MyClass => that.name.equalsIgnoreCase(this.name)
    case _ => false
  }
}

class ListOperationsTest extends BaseTest("ListOperations") {

  val listOps = new ListOperations(List(2, 4, 6, 8, 1, 3, 5, 2, 4, 6, 8))

  it should "produce IndexOutOfBoundsException when index size is negative or " +
    "is more than or equal to list length" in {
    an [IndexOutOfBoundsException] should be thrownBy {
      listOps.getValueFromIndex(-1)
    }
    an [IndexOutOfBoundsException] should be thrownBy {
      listOps.getValueFromIndex(35)
    }
  }

  it should "return value at index when index size is non-negative and less than list length" in {
    assert(listOps.getValueFromIndex(3) == 8)
  }
}
