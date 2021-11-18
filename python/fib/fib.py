#!/usr/bin/env python

def fib(n):
	if n==1 or n==2: return 1
	else: return fib(n-2) + fib(n-1)

for n in range(1,34):
	print( 'fib(%d) = %d' % (n, fib(n)) )

