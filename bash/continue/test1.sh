#!/usr/bin/env bash

for ((i=1; i<=9; ++i)); do
	for ((j=1; j<=9; ++j)); do
		echo "pre: i,j=$i,$j"
		if [ $i -lt $j ]; then continue 2; fi
		echo "i,j=$i,$j"
	done
done

