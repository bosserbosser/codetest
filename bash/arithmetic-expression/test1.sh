#!/usr/bin/env bash

for ((i=1; i<=9; ++i)); do
	((j = i**2))
	echo "pow($i,2) = $j"
done

