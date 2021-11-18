#!/usr/bin/env python

def func(n):
    if n > 3:
        for i in range(n):
            yield i

for i in func(2):
    print i

