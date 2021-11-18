#!/usr/bin/env bash

hosts='centos0'

for host in $hosts; do
	echo dispatch pub key to host $host ...
	cat ~/.ssh/id_rsa.pub | ssh $host "cat >> ~/.ssh/authorized_keys"
done

