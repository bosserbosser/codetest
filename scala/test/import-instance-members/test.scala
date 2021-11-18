#!/usr/bin/env scala

case class Person(var name:String, var age:Int) {
	override def toString: String = s"Person{name=$name, age=$age}";
}

val p1 = new Person(name="bosser", age=28);

{
	import p1._;
	name = "boss"; age = 29;
	println(p1);
}

