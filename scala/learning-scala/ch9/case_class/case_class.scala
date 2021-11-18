
case class Person(name: String, val age: Int, var sex: Boolean) {
    var height = 0
}

object Main extends App {
    val p = Person("bosser", 30, true)
    println(p)
    println(Person.unapply(p))
    p.height=76
    println(p.copy().height)
    println(p == new Person("bosser", 30, true))
    println(p.hashCode == new Person("bosser", 30, true).hashCode)
}

