
class Animal {
    override def toString = "animal"
}
class Human extends Animal {
    override def toString = "human"
}
class Man extends Human {
    override def toString = "man"
}

object Main extends App {
    def forHumanLower[T <: Human](obj: T): Unit = {
        println(s"forHumanLower: ${obj}")
    }
    def forHumanUpper[T >: Human](obj: T): Unit = {
        println(s"forHumanUpper: ${obj}")
    }
    forHumanLower(new Man())
    forHumanUpper(new Animal())
    forHumanLower(new Human())
    forHumanUpper(new Human())
}

