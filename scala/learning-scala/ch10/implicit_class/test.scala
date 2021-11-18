
object Something {
    implicit class MyInt(private var n: Int) {
        def implicitMark: this.type = this
        def set(n: Int): MyInt = { this.n = n; this }
        def get(): Int = n
        override def toString(): String = s"MyInt(${n})"
    }
}

object Main extends App {
    import Something._
    val n1 = 3
    val n2 = 3.implicitMark
    val n3: MyInt = 3
    println(n1)
    println(n2)
    println(n3)
}

