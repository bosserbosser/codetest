#!/usr/bin/env bash

logFile=
logConsole=true

function setLogConsole() {
	logConsole=true
}

function unsetLogConsole() {
	logConsole=false
}

function setLogFile() {
	logFile="$1"
}

function setLogFileBytime() {
	prefix="$1"
	setLogFile "$prefix.$(date +'%Y%m%d_%H%M%S_%N').log"
}

function unsetLogFile() {
	logFile=
}

function log() {
	level="$1"
	msg="$2"
	log_time=$(date +'%F %T.%N')
	dest_str="$log_time [$level] $msg"
	if [ "$logFile" != "" ]; then
		echo "$dest_str" >> $logFile
	fi
	if $logConsole; then
		echo "$dest_str"
	fi
}

function logDeb() {
	msg="$*"
	log "DEB" "$msg"
}

function logInf() {
	msg="$*"
	log "INF" "$msg"
}

function logWar() {
	msg="$*"
	log "WAR" "$msg"
}

function logErr() {
	msg="$*"
	log "ERR" "$msg"
}

function logTest() {
	setLogFile test.log
	unsetLogConsole
	logDeb "This is deb"
	logInf "This is inf"
	logWar This is war
	logErr Thsi is err
}

if [ "$1" == "test" ]; then
	logTest
fi

