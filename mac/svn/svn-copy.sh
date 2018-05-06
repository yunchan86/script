#!/bin/sh
SOUR_PATH=/Volumes/samb_yun/ecstore/
DIR_PATH=/opt/respository/svn-ecstore/ecstore/trunk/ecstore_online/
#DIR_PATH=/opt/respository/svn-ecstore/ecstore/branches/ecstoreDev20150722/
#DIR_PATH=/opt/respository/svn-ecstore/ecstore-dev/cpdemo/
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
function copy() {
	if [ $# -ne 1 ];then
		echo "Useage: $0 filepath"
		return -1
	fi
        filepath=$1
        file_is_exists $filepath
        file_flag=$?
        if [ $file_flag != "1" ];then
                echo "Error:${filepath} add error."
                return
        fi
        #Read file content
        cat $filepath | while read tmp
        do
                line=${SOUR_PATH}${tmp}
		file_is_exists $line
                svn_file=$?
                if [ $svn_file == "2" ];then
			mkdir -pv ${DIR_PATH}${filepath}
                        cp -rf ${line} ${DIR_PATH}${tmp}
		elif [ $svn_file == "1" ];then
			dtmpdir=${DIR_PATH}${tmp}
			tmpdir=${dtmpdir%/*}
			mkdir -pv ${tmpdir}
			cp -rf ${line} ${tmpdir}
                else
                        echo "File Not Exists: copy $line Fail."
                fi
        done

}
copy $*
