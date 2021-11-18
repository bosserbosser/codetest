
object Main extends App {
    def pow(a: Int)(implicit b: Int): Int = math.pow(a, b).toInt
    implicit val paramB: Int = 3
    println(pow(2))
}

