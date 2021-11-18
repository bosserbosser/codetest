#!/usr/bin/env scala

// types: Byte, Short, Int, Long, Float, Double
// to<Type>
val byte: Byte = 9
val int: Int = byte
val float: Float = int
var double: Double = float
println(double)

val int2: Int = double
val int3 = double.toInt
println(int3)

val x = 9
val x = 5.0

