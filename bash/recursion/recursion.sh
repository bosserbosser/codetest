#!/usr/bin/env bash

function fib() {
	local _result=0
	if [ $1 -eq 1 -o $1 -eq 2 ]; then
		_result=1
	else
		fib $[$1-2]
		_result=$[ $? + $_result ]
		fib $[$1-1]
		_result=$[ $? + $_result ]
	fi
	return $_result
}

for ((i=1;i<=16;++i)); do
	fib $i
	result=$?
	echo "fib($i) = $result"
done

