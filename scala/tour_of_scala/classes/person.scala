
class Person {
	private var _name : String = null
	private var _age : Int = -1
	
	def name = _name
	def age = _age
	
	def name_= (a_name:String) : Unit = {_name = a_name}
	def age_= (a_age:Int) : Unit = {_age = a_age}
	
	override def toString() : String = {
		s"Person(name=$name,age=$age)"
	}
}

var person1 = new Person()
person1.name = "bosser"
person1.age = 26
println(person1)

