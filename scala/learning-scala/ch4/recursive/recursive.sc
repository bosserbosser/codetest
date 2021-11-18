#!/usr/bin/env scala

def func(n: Int): Int = {
    if (n==0) {
        return 0
    } else {
        return 2 + func(n-1)
    }
}

println(func(0))
println(func(1))
println(func(2))
println(func(3))

