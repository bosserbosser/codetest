#!/usr/bin/env python

def flatMap(n):
    yield_num = 0
    for i in range(n):
        yield i
        yield_num += 1
    if not yield_num:
        yield n

for i in flatMap(0):
    print i

