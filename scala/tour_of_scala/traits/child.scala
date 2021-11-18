
trait Child {
	def sex() : String
}

class Boy extends Child {
	override def sex() : String = "boy"
}

class Girl extends Child {
	override def sex() : String = "girl"
}

var child1 = new Boy()
var child2 = new Girl()
println(s"child1 is a " + child1.sex())
println(s"child2 is a " + child2.sex())

