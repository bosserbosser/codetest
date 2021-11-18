#!/usr/bin/env python

import time

d = dict()

for i in range(10000 * 1000):
	d[i] = i*2

time.sleep(120 * 60)

