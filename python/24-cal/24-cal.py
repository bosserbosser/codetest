#!/usr/bin/env python

import sys
from comb import *
from expr import *

def count_integer_length(num):
	if num<0: num=-num
	if num==0: return 1
	count = 0
	while num!=0:
		count += 1
		num = (int)(num/10)
	return count

def count_integer_length_test():
	def test_turn(num):
		length = count_integer_length(num)
		print 'count_integer_length of %d is %d' % (num, length)
	test_turn(0)
	test_turn(10)
	test_turn(100)
	test_turn(1009)
	test_turn(-1009)

def search_exprs_dest_test_24():
	dest = 24
	nums = Comb(int(arg) for arg in sys.argv[1:])
	rsts = search_exprs(nums, dest)
	rsts_count_length = count_integer_length(len(rsts))
	for i,expr in enumerate(rsts):
		count_format = '%' + str(rsts_count_length) + 'd'
		print ('%s $  %%s = %%d' % count_format) % (i+1, str(expr), dest)

def search_exprs_dest_test_any():
	if len(sys.argv)<2: return
	dest = int(sys.argv[1])
	nums = Comb(int(arg) for arg in sys.argv[2:])
	rsts = search_exprs(nums, dest)
	rsts_count_length = count_integer_length(len(rsts))
	for i,expr in enumerate(rsts):
		count_format = '%' + str(rsts_count_length) + 'd'
		print ('%s $  %%s = %%d' % count_format) % (i+1, str(expr), dest)

def search_exprs_test_batch():
	for n1 in range(1,11):
		for n2 in range(n1,11):
			for n3 in range(n2,11):
				for n4 in range(n3,11):
					print 'ITEM %d %d %d %d ' % (n1, n2, n3, n4)
					rsts = search_exprs(Comb((n1,n2,n3,n4)), 24)
					for rst in rsts:
						print 'EXPR %s' % rst.__str__()

## main
#search_exprs_dest_test_any()

