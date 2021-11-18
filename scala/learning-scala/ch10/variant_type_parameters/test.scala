
// covariant
class Container[+A](_x: A) {
    def apply(): A = _x
}

// contravariant
class Checker[-A]() {
    def apply(_x: A): Boolean = true
}

class Human {}
class Man {}

object Main extends App {
    //new Container[Human](new Human())
    // error
    val container: Container[Human] = new Container[Man](new Man())
}

