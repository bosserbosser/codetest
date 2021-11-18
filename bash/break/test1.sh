#!/usr/bin/env bash

for ((i=1; i<=9; ++i)); do
	for ((j=1; j<=9; ++j)); do
		if [ $i -lt $j ]; then break 2; fi
		echo "i,j=$i,$j"
	done
done

