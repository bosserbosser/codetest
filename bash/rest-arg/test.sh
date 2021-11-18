#!/usr/bin/env bash

rest_args="${@:2:$#}"

echo "rest_args: $rest_args"

sh sub.sh "$rest_args"

