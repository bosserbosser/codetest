#!/usr/bin/env python

def cal_fail_prob(m, n, k):
    return ( 1.0 - (1.0-1.0/m)**(n*k) ) ** k

def cal_mem_use_MB(m):
    return 1.0 * m / 8 / 1024 / 1024


################ test #################

print '###### bloom for java bitset use ######'
java_int_max = 2147483647
m = java_int_max
mem_use_MB = cal_mem_use_MB(m)
print '  m-max: %d(==1<<31-1: %s), mem_use_MB: %.2f' % (m, str((1<<31)-1==m), mem_use_MB)

print '###### bloom for general use ######'
left_shifts = [28, 29, 30, 31, 32, 33]
N = 2.5 * 10000 * 10000
n = 1 * 10000 * 10000
k = 24
print '  n: %d, k: %d, N: %d' % (n, k, N)
for left_shift in left_shifts:
    m = 1<<left_shift
    mem_use_MB = cal_mem_use_MB(m)
    fail_prob = cal_fail_prob(m, n, k)
    fail_num_prob = fail_prob * N
    print '  left_shift: %d, m: %d, mem_use_MB: %.2f, fail_prob: %f, fail_num_prob: %f' % (left_shift, m, mem_use_MB, fail_prob, fail_num_prob)

