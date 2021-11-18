#!/usr/bin/env bash

read -p 'input your name here: ' name
case $name in
	bosser) echo branch 1;&
	boss) echo branch 2;;&
	bosser) echo branch 3;;&
	ynyao) echo branch 4;; 
	*) echo branch '*';;
esac

