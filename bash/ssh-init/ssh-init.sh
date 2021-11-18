#!/usr/bin/env bash

hosts='centos0'

for host in $hosts; do
	echo init ssh files for host $host ...
	cmd0="rm -rf ~/.ssh"
	cmd1="mkdir -m 700 -p ~/.ssh"
	cmd2="touch ~/.ssh/authorized_keys"
	cmd3="chmod 600 ~/.ssh/authorized_keys"
	cmd4="ssh-keygen -P '' -f ~/.ssh/id_rsa"
	ssh $host "$cmd0; $cmd1; $cmd2; $cmd3; $cmd4"
done

