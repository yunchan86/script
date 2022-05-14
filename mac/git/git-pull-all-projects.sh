#!/bin/sh

current_path=`pwd`
echo $current_path


function pull_all() {
	path=$1
	for dir in $(ls $path)
	do
	   if [ -d $dir ];then
		cd $dir
		git pull
		branch_name=`git branch -a | grep "*" | awk '{print $2}'`
		git checkout master
		git pull
		git checkout $branch_name
		cd ..
		#echo `pwd`
	   fi
	done 
}

function statics_noaccess() {
	path=$1
	for dir in $(ls $path)
	do
	   if [ -d $dir ];then
		cd $dir
		data=`git remote -v | grep push | awk  '{print (dir,"\t"$2)}' dir="${dir}" | grep -E "source.jd.com|git.jd.com"`
		if [ -n "$data" ]; then
			echo $data
		fi
		cd ..
		#echo `pwd`
	   fi
	done 
}

function modify_project_remote() {
	project_new=$1
	git remote set-url origin $project_new
}

COMMAND_LINE_ARFGS="all|noaccess|modify_remote"

if [ $# -lt 1 ];
then
        echo "USAGE: $0 $COMMAND_LINE_ARFGS"
        exit 1
fi
case $1 in
	all)
		pull_all $current_path
		;;
	noaccess)
	   	statics_noaccess $current_path
	   	;;
	modify_remote)
	 	if [ $# -gt 1 ];then
	 		modify_project_remote $2
	 	else
	 		echo "USAGE: $0 modify_remote $git_project_remote_newname"
	 	fi
	   	;;
	*)
		echo "$0 {$COMMAND_LINE_ARFGS}"
		;;
esac

