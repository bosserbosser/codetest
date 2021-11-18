#!/usr/bin/env scala

/*
 * var: variable, val: value
 * (var|val) <name>[: <type>] = <literal>
 */
val x = 3
var y: String = "bit"
x = 4
// error
x = "bad"
// error
y = "good"
println(x)
println(y)

println(x.toString)

println(1,2)

