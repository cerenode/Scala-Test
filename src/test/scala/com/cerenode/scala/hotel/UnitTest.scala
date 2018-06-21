package com.cerenode.scala.hotel

import org.scalatest.{FlatSpec, Matchers}

abstract class UnitTest(component: String) extends FlatSpec with Matchers{

  behavior of component

}