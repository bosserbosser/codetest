
trait Obj {
    type T
    def get(): T
    def apply(): T = get()
}

object Main extends App {
    val obj = new Obj {
        type T = Int
        def get() = 3
    }
    println(obj())
}

