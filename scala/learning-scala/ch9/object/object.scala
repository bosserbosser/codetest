
class Base {
    override def toString = "toString: This is class Base"
}

object Obj extends Base {
    println("Obj initializing ...")
    def apply() = {
        println("apply: This is Obj")
    }
    override def toString = "toString: This is Obj"
}

object Main extends App {
    Obj()
    println(Obj.toString)
}

