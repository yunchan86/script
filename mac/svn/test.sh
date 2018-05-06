#!/bin/sh
TEST_FLAG=1
function test_echo(){
	vars=$1
	echo $1
	if [ $vars == 'ss' ];then
		echo 'hello.'
		return ""
	else
		echo 'hello world.'
		return "world"
	fi
}
function test() {
	if [ $TEST_FLAG -eq 1 ];then
		echo 'test flag is true'
	else
		echo 'test flag is false'
	fi
	$1 $2
	echo $?
}
test $*

