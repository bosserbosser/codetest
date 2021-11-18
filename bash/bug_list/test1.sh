#!/usr/bin/env bash

/*
function do_command() {
	echo $* | bash | while read line; do
		echo $line
	done
}
*/

function do_command() {
	eval $*
}

j=-1
for ((i=1; i<10; ++i)); do
	do_command "j=$[$i*$i]"
	echo "j=$j"
done

