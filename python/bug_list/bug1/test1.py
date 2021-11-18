#!/usr/bin/env python

list1 = [func() for func in [lambda:i*i for i in range(1,10)]]
list2 = [(lambda:i*i)() for i in range(1,10)]

print 'list1 = ' + str(list1)
print 'list2 = ' + str(list2)

funcs = []
for i in range(1,10):
	funcs.append(lambda:i*i)
list3 = [func() for fun in funcs]
print 'list3 = ' + str(list3)

list4 = list(map(lambda f:f(), map(lambda i:(lambda:i*i), range(1,10)) ))
print 'list4 = ' + str(list4)

i = 1
funcs = []
while i<10:
	funcs.append(lambda:i*i)
	i += 1
list5 = [func() for fun in funcs]
print 'list5 = ' + str(list5)

