package com.cerenode.scala.general

import org.scalatest.{FlatSpec, Matchers}

abstract class BaseTest(className: String) extends FlatSpec with Matchers {
  behavior of className
}
