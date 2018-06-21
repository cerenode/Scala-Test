package com.cerenode.scala.hotel

case class Guest(name: String) {
	require(!name.isEmpty,"Name must be defined")
}
