package com.cerenode.scala.general

class TV {
  private var on: Boolean = false
  def isOn: Boolean = on
  def pressPowerButton() { on = !on }
}