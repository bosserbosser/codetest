#!/usr/bin/env bash

function f() {
	a=8
}

f
echo a: $a

function f1() {
	local x=1
	local x=2
}

f1
echo x: $x

while true; do
	#local y=4
	break
done
echo y: $y

function f2() {
	function f3() {
		z=19
	}
	f3
}

f2
echo "z=$z"

