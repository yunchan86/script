#!/bin/sh
source svn-tools.sh
source batch-copy.sh
#SOUR_PATH=/Volumes/samb_yun/ecstore
#SOUR_PATH=/opt/respository/svn-ecstore
SOUR_PATH=/Users/chy/Documents/workspace/merge/patch-source-20160301/ecstore_product
#DIR_PATH_BRANCH=/Volumes/samb_yun/ecstore
DIR_PATH_TRUNK=/opt/respository/svn-ecstore/ecstore/trunk/ecstore_online
DIR_PATH_BRANCH=/opt/respository/svn-ecstore/ecstore/branches/ecstoreDev20150722
#DIR_PATH=/opt/respository/svn-ecstore/ecstore-dev/cpdemo/
#branch default is false,svn not update.
BRANCH_FLAG=1
#trunk defaule is true,svn update.
TRUNK_FLAG=1
COMMIT_ADD=1
function common_copy(){
	if [ $BRANCH_FLAG -eq 1 ];then
                copy $1 $SOUR_PATH $DIR_PATH_BRANCH
        fi
        if [ $TRUNK_FLAG -eq 1 ];then
                copy $1 $SOUR_PATH $DIR_PATH_TRUNK
        fi
}
function common_cmd() {
	if [ $BRANCH_FLAG -eq 1 ];then
		$1 $2 $DIR_PATH_BRANCH
	fi
	if [ $TRUNK_FLAG -eq 1 ];then
		$1 $2 $DIR_PATH_TRUNK
	fi
}
echo $#
echo $*
if [ $# -ne 2 ];then
	echo "Useage: $0 {add|commit|delete|status} filepath"
        exit
fi
check_file $2
file_flag=$?
if [ $file_flag -ne 1 ];then
	echo "this configure file $2 not exists."
	exit
fi
case $1 in
  add)
        common_copy $2
	common_cmd add $2 
        ;;
  commit|ci)
	common_copy $2
	#common_cmd update $2
	if [ $COMMIT_ADD -eq 1 ];then
		common_cmd add $2
	fi
        common_cmd commit $2
        ;;
  update|up)
        common_cmd update $2
        ;;
  status|st)
        common_cmd status $2
        ;;
  delete|del)
        delete $*
	common_cmd update $2
        ;;
  copy|cp)
	common_copy $2
	;;
  *)
        echo "$0 {add|commit|delete|status} files."
        ;;
esac

