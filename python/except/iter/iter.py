#!/usr/bin/env python

def myrange(amount):
	count = 0
	while count<amount:
		yield count
		count += 1

seq = myrange(10)
while True:
	try:
		print next(seq)
	except StopIteration:
		break

