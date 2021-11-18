
case class Person(name:String, age:Int, sex:Boolean)

val p1 = Person("bosser", 26, true)
val p2 = Person("bosser", 26, true)

println("p1==p2 = " + (p1==p2))

val p3 = p1.copy(name="rose", sex=false)
println("p3 = " + p3)

