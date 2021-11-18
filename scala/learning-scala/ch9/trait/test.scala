
trait Person {
    protected var name: String = null;
    def setName(_name: String): Person;
    def getName: String
}

trait Animal {
    protected var sex: Boolean = false
}

class Man extends Person with Animal {
    override def setName(name: String) = {
        this.name = name
        this
    }
    override def getName(): String = name
}

object Main extends App {
    val m = new Man().setName("bosser")
    println(m.getName)

    val p = new Person {
        override def setName(name: String) = { this.name = name; this }
        override def getName: String = name
    }() with Animal
}

