
object Main extends App {

    def func_empty_formal(_val: Int) = {}

    def func_empty(_val: => Int): Unit = {}

    def func_times(_val: => Int): Unit = {
        for (i <- 1 to 9) {
            println("The val is now " + _val.toString)
        }
    }

    class StateFulGetter {
        var _val: Int = 1
        def apply(): Int = {
            val rst = _val
            _val += 1
            rst
        }
    }

    val getter = new StateFulGetter()
    func_empty_formal(getter())
    func_empty(getter())
    func_times(getter())

}

