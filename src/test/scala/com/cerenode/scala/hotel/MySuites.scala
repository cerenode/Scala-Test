package com.cerenode.scala.hotel

import org.scalatest.Suites

class MySuites extends Suites(
  new GuestTest,
  new RoomTest)