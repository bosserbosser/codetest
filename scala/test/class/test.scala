#!/usr/bin/env scala

class Test {
	val _name:String = "bosser"
	def name:String = _name
}

val obj = new Test
println(obj.name)

