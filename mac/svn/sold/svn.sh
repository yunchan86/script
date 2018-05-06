#!/bin/sh
function file_is_exists() {
	filepath=$1
	if [ -f $filepath ];then
		return 1
	elif [ -d $filepath ];then
		return 2
	else
		echo "file $1 not exists."
		return -1
	fi
}
function add() {
	filepath=$2
	file_is_exists $filepath
	file_flag=$?
	if [ $file_flag != "1" ];then
		echo "Error:${filepath} add error."
		return
	fi
	#Read file content
	cat $filepath | while read line
	do
		file_is_exists $line
		svn_file=$?
		if [ $svn_file != "-1" ];then
			svn add $line
		else
			echo "File Not Exists: svn add $line Fail."
		fi
	done
	
}
function commit() {
	filepath=$2
	file_is_exists $filepath
	file_flag=$?
	if [ $file_flag != "1" ];then
		echo "Error:${filepath} commit error."
		return
	fi
	#Read file content
	cat $filepath | while read line
	do
		file_is_exists $line
		svn_file=$?
		if [ $svn_file != "-1" ];then
			echo svn commit -m " " $line
			svn commit -m " " $line
			echo "end"
		else
			echo "File Not Exists: svn commit $line Fail."
		fi
	done
}
function update() {
	filepath=$2
	file_is_exists $filepath
	file_flag=$?
	if [ $file_flag != "1" ];then
		echo "Error:${filepath} update error."
		return
	fi
	#Read file content
	cat $filepath | while read line
	do
		file_is_exists $line
		svn_file=$?
		if [ $svn_file != "-1" ];then
			svn up $line
		else
			echo "File Not Exists: svn up $line Fail."
		fi
	done
}
function delete() {
	echo "No any operator."
	#svn delete $f
}
function status() {
	filepath=$2
	file_is_exists $filepath
	file_flag=$?
	if [ $file_flag != "1" ];then
		echo "Error:${filepath} update error."
		return
	fi
	#Read file content
	cat $filepath | while read line
	do
		file_is_exists $line
		svn_file=$?
		if [ $svn_file != "-1" ];then
			svn status -v $line
		else
			echo "File Not Exists: svn status $line Fail."
		fi
	done
	
}

case $1 in
  add)
	add $*
	;;
  commit|ci)
	commit $*
	;;
  update|up)
	update $*
	;;
  status|st)
	status $*
	;;
  delete|del)
	delete $*
	;;
  *)
	echo "$0 {add|commit|delete|status} files."
	;;
esac
