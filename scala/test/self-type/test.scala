#!/usr/bin/env scala

class Person(val id:Int, val name:String, val age:Int) {
	override def toString:String = s"Person{id=$id,name=$name,age=$age}"
}

trait Chinese {
	self: Person =>
	def speek: Unit = println("I'm is chinese")
}

class ChinesePerson extends Person with Chinese {}

val p = new ChinesePerson(1, "bosser", 29)
println(p)
p.speek

