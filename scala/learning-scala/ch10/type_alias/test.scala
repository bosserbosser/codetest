
class Decorator[T] {
    type selfType = Decorator[T]
    type dataType = T
    var data: Any = None
    def set(data: dataType): selfType = { this.data = data; this }
    def get(): dataType = this.data.asInstanceOf[dataType]
    override def toString: String = data.toString
}

object Main extends App {
    val dec = new Decorator().set(3)
    println(dec)
}

