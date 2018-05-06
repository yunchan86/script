#!/bin/sh
function add(){
	#cur_path=`pwd`
	curr_path=$1
	for file in "$(svn status -v $curr_path | grep '^?' |grep -v Runtime | grep -v 'Static/images/clubqrcode/' |  grep -v 'Common/weixin_daniel' | awk '{print $2}')"
	do
		svn add $file
	done
}
function commit() {
	curr_path=$1
        for file in "$(svn status -v $curr_path | grep -E '^M|^A|^D' |grep -v Runtime | grep -v 'Static/images/clubqrcode/' | grep -v 'Common/weixin_daniel' | awk '{print $5}')"
        do
		svn ci -m "auto commit"  $file
        done
}
function delcommit() {
	curr_path=$1
        for file in "$(svn status -v $curr_path | grep -E '^!' |grep -v Runtime | grep -v 'Static/images/clubqrcode/' | awk '{print $5}')"
        do
                svn del $file
		svn ci -m "auto commit"  $file
        done
}
function update() {
	curr_path=$1
	svn up $curr_path
}
add $*
#delcommit $*
commit $*
