#!/usr/bin/env python

try:
    #n = int('abc')
    n = int('123')
except:
    print 'type error'
else:
    print 'good num: %d' % n

try:
    int('a123')
except Exception, err:
    print err

