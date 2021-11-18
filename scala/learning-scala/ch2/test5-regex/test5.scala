#!/usr/bin/env scala

// regex base on java's Pattern
val pattern = """.*([\d]+).*""".r
println(pattern.getClass)

val pattern(caughtNum) = "I have 39 yuan."
println(caughtNum, caughtNum.getClass)

// matches, replaceAll, replaceFirst

