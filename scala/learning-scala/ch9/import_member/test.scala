
class Conf {
    protected var dir: String = ""
    def setDir(dir: String): Conf = { this.dir = dir; this }
    def getDir(): String = this.dir
}

object Conf {
    def apply(dir: String): Conf = new Conf().setDir(dir)
}

object Main extends App {
    import Conf.{apply => getConf}
    val conf = getConf("/bosser")
    import conf._
    println(setDir("/root").getDir())
}

