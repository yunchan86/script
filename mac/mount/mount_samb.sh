#!/bin/sh
function yun(){
	username='yun'
	pwd='yun9989'
	host='192.168.1.12'
	cd /Volumes
	mkdir samb_yun
	mount_smbfs //${username}:${pwd}@${host}/personal_yun  /Volumes/samb_yun
}
function xq(){
        username='xiaoqiang'
        pwd='xiaoqiang9527'
        host='192.168.1.12'
        cd /Volumes
        mkdir samb_xq
        mount_smbfs //${username}:${pwd}@${host}/personal_xiaoqiang  /Volumes/samb_xq
}
if [ $# -ne 1  ];then
	echo "Usage:$0 yun|xq"
	exit 0
fi
case $1 in
  yun)
	yun
	;;
  xq)
	xq
	;;
  *)
	echo "$0 yun|xq"
	;;
esac
