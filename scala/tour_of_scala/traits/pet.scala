
trait Pet {
	val pet_type : String
	val name : String
}

class Cat(val name: String, val pet_type: String = "cat") extends Pet
class Dog(val name: String, val pet_type: String = "dog") extends Pet

val pet1: Pet = new Cat("sara")
val pet2: Pet = new Dog("hell")

println(s"pet1 is a " + pet1.pet_type + " of name " + pet1.name)
println(s"pet2 is a " + pet2.pet_type + " of name " + pet2.name)

