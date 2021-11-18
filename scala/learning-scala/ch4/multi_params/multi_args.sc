#!/usr/bin/env scala

def func(nums: Int*): Int = {
    var ret = 0
    for ( i <- nums ) ret += i
    return ret
}

println(func(1,2,3))

