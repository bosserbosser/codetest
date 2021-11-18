#!/usr/bin/env scala

import scala.language.postfixOps

def getMillisecNow = System.nanoTime

class Timer {
    val time1: Long = getMillisecNow
    var time2: Long = getMillisecNow
    def time3: Long = getMillisecNow
    lazy val time4: Long = getMillisecNow
    //lazy var time5: Long = getMillisecNow
    override def toString = {
        val _time3 = time3
        val _time4 = time4
        s"Timer[time1=$time1, time2=$time2, time3=$time3, time4=$time4, time4>time3: ${_time4>_time3}"
    }
}

val timer = new Timer
util.Try(Thread.sleep(1000)) getOrElse None
println(timer)
util.Try(Thread.sleep(1000)) getOrElse None
println(timer)

