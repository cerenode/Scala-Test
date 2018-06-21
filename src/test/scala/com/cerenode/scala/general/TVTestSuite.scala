package com.cerenode.scala.general

import org.scalatest.{FeatureSpec, GivenWhenThen}

class TVTestSuite extends FeatureSpec with GivenWhenThen {
  info("As a TV set owner")
  info("I want to be able to turn the TV on and off")
  info("So I can watch TV when I want")
  info("And save energy when I'm not watching TV")

  feature("TV power button") {
    scenario("User presses power button when TV is off") {
      Given("a TV set that is switched off")
      val tv = new TV
      assert(!tv.isOn)
      When("the power button is pressed")
      tv.pressPowerButton()
      Then("the TV should switch on")
      assert(tv.isOn)
    }
      scenario("User presses power button when TV is on") {
      Given("a TV set that is switched on")
      val tv = new TV
      tv.pressPowerButton()
      assert(tv.isOn)
      When("the power button is pressed")
      tv.pressPowerButton()
      Then("the TV should switch off")
      assert(!tv.isOn)
    }
  }

}
