#!/usr/bin/env python

val = None

def func():
    global val
    val = 1

func()
print val

