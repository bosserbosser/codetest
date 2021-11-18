#!/usr/bin/env python3

''' --- additional info
go for desc in linux/mac profile: /etc/services
go for desc in http: http://www.iana.org/assignments/port-numbers
'''

import socket

for port in range(49152):
	try:
		name = socket.getservbyport(port)
	except:
		name = ''
	fields = [str(port), name]
	print('\t'.join(fields))

