#!/bin/sh
ROOT_PATH_FLAG=1
root_path=
function _get_path() {
	echo 'this patams is '$#
	echo $1
	if [ $ROOT_PATH_FLAG -eq 1 ];then
		if [ $# -ne 1 ];then
			echo 'ERROR: must be root path.'
			exit
		fi
		root_path=$1
		echo ${root_path}
	fi
}

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

function _svn_add_file() {
        if [ $# -lt 1 ];then
                return
        fi
        local filepath=$1
        local parentpath=${filepath%/*}
        echo $filepath   $parentpath
	svn info $parentpath
	svnflag1=$?
        if [ $svnflag1 -eq 0 ];then
		svn info $filepath
		svnflag2=$?
                if [ $svnflag2 -eq 0 ];then
                        echo '$filepath had added.'
                else
			echo "$filepath added"
                        svn add $filepath
                fi
                return 0
        elif [[ $filepath == $parentpath ]]||[[ $parentpath == '' ]];then
                echo "error operator."
                return 1
        else
                echo "parent path executing is "$parentpath
                _svn_add_file $parentpath
                return $?
        fi
}

function _svn_commit_file() {
        if [ $# -lt 1 ];then
                return
        fi
        local filepath=$1
        local parentpath=${filepath%/*}
        echo $filepath   $parentpath
        svn log $parentpath --limit 1
        svnflag1=$?
        if [ $svnflag1 -eq 0 ];then
		svn commit -m " " $filepath
                return 0
        elif [[ $filepath == $parentpath ]]||[[ $parentpath == '' ]];then
                echo "error operator."
                return 1
        else
                echo "parent path executing is "$parentpath
                _svn_commit_file $parentpath
                return $?
        fi
}

#this function is svn add file commad.
#	1-file. this is a configure file,its a line content is a file or directory path. 
function add() {
	_get_path $2
	filepath=$1
	file_is_exists $filepath
	file_flag=$?
	if [ $file_flag != "1" ];then
		echo "Error:${filepath} add error."
		return
	fi
	#Read file content
	cat $filepath | while read linetmp
	do
		line=${root_path}$linetmp
		file_is_exists $line
		svn_file=$?
		if [ $svn_file != "-1" ];then
			#svn add $line
			_svn_add_file $line
		else
			echo "File Not Exists: svn add $line Fail."
		fi
	done
	
}
#this function is svn commit file commad.
#	1-file. this is a configure file,its a line content is a file or directory path. 
function commit() {
	_get_path $2
	filepath=$1
	file_is_exists $filepath
	file_flag=$?
	if [ $file_flag != "1" ];then
		echo "Error:${filepath} commit error."
		return
	fi
	#Read file content
	cat $filepath | while read linetmp
	do
		line=${root_path}$linetmp
		file_is_exists $line
		svn_file=$?
		if [ $svn_file != "-1" ];then
			echo svn commit -m " " $line
			#svn commit -m " " $line
			_svn_commit_file $line
			echo "end"
		else
			echo "File Not Exists: svn commit $line Fail."
		fi
	done
}
#this function is svn update file commad.
#	1-file. this is a configure file,its a line content is a file or directory path. 
function update() {
	_get_path $2
	filepath=$1
	file_is_exists $filepath
	file_flag=$?
	if [ $file_flag != "1" ];then
		echo "Error:${filepath} update error."
		return
	fi
	#Read file content
	cat $filepath | while read linetmp
	do
		line=${root_path}$linetmp
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
#this function is svn status file commad.
#	1-file. this is a configure file,its a line content is a file or directory path. 
function status() {
	_get_path $2
	filepath=$1
	file_is_exists $filepath
	file_flag=$?
	if [ $file_flag != "1" ];then
		echo "Error:${filepath} update error."
		return
	fi
	#Read file content
	cat $filepath | while read linetmp
	do
		line=${root_path}$linetmp
		file_is_exists $line
		svn_file=$?
		if [ $svn_file != "-1" ];then
			svn status -v $line
		else
			echo "File Not Exists: svn status $line Fail."
		fi
	done
	
}

