
// covariant
class Item[+A](private var _x: A) {
    def get(): A = _x
    //def set(_x: A): this.type = { this._x = _x; this }
}

class Human {}
class Man extends Human {}

object Main extends App {
    val item1: Item[Man] = new Item[Man](new Man())
    //val item2: Item[Human] = item1
    //item2.set(new Human())
    //item1.get()
}

