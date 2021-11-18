#!/usr/bin/env scala

def pow(a: Int, b: Int): Int = { math.pow(a, b).toInt }
val func:(Int, Int)=>Int = pow _

println(pow(2, 3))
println(func(2, 3))

