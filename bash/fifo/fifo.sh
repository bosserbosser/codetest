#!/usr/bin/env bash

fifo_name=pipe

function chuncate_pipe() {
	delete_pipe
	mkfifo $fifo_name
}

function delete_pipe() {
	rm -f $fifo_name
}

function writer() {
	i=0
	while ((i<10)); do
		i=$[$i+1]
		echo $i >> $fifo_name
		echo '[writer]' wrote $i
		sleep 0.5
	done
	echo over >> $fifo_name
	echo '[wirter]' wrote over
}

function reader() {
	while true; do
		echo '[reader]' ready to read
		read line <$fifo_name
		echo '[reader]' got $line
		if [ $line == "over" ]; then
			echo '[reader]' read over, exit
			break
		fi
	done
}

chuncate_pipe
writer & 
reader
delete_pipe

