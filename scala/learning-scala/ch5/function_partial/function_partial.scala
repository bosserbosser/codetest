#!/usr/bin/env scala

val fbase = (a:Double, b:Double)=>{a/b}

val ffull = fbase(_, _)
val f1 = fbase(_, 2)
val f2 = fbase(2, _)

val vals = Array(
    ffull(3, 4),
    f1(2),
    f2(4)
)

for (i <- vals) {
    println(i)
}

