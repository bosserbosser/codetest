
object Main extends App {
    val add_1 = new Function1[Int, Int] {
        override def apply(input: Int): Int = input + 1
    }
    val mty_2 = new Function1[Int, Int] {
        override def apply(input: Int): Int = input * 2
    }
    println(add_1)
    println(mty_2)
    println((add_1 andThen mty_2)(3))
    println((add_1 compose mty_2)(3))
}

