
trait Human {
    def getName: String
}

trait Animal {
    def getFood: String
}

object Main extends App {
    val foo = new Human with Animal {
        override def getName = "bosser"
        override def getFood = "noodle"
        override def toString = s"${getName} who likes eate ${getFood}"
    }
    println(foo)
}

