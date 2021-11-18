#!/usr/bin/env bash

i=9

until [ $i -eq 0 ]; do
	echo "i=$i"
	i=$[$i-1]
done

