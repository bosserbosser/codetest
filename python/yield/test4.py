#!/usr/bin/env python

def func(n):
    if n < 1:
        return
    for each in range(1, n+1):
        yield each

for i in func(0):
    print i

