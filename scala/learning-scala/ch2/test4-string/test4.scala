#!/usr/bin/env scala

val str1: String = "Hello,\t World"
println("str1: " + str1)
// it's ok
val str2 = "Hello,\t World"
println(str1==str2)

val str3 = """ This is first line.
This is second line.\n
 This is thrid line.
"""
println(str3)

println("This is number " + 3 + ", which equals(3): " + (3==3))

val price: Double = 11.11
println("The current price is $price")
println(s"The current price is $price")
println(s"The current price is ${price*3}")
println(f"We will develop an new ${"application"}%.3s next year.")
println(f"Tomorrow's price is $price%.1f")

