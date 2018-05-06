#!/bin/sh
#file veridate
#return value:1-file;2-directory;other-not file or direcotry
function check_file() {
        filepath=$1
        if [ -f $filepath ];then
                return 1
        elif [ -d $filepath ];then
                return 2
        else
                echo "file $1 not exists."
                return 99
        fi
}
function exit_check_file(){
	filepath=$1
	type=$2
	check_file $filepath
	flag=$?
	if [ $flag -eq 99 ];then
		echo "$filepath is not exists."
		exit
	elif [[ flag -eq 1 ]]&&[[  type == 'd' ]];then
		exit
	fi
}
#this function has 3 params.
#	1-file,this is configure file.a line content is a file path.
#	2-source directory.
#	3-destination directory
function copy() {
	echo 'this copy params is ' $*
        if [ $# -ne 3 ];then
                echo "Useage: $0 filepath source_parent_path destinct_parent_path"
                return -1
        fi
        filepath=$1
        check_file $filepath
        file_flag=$?
        if [ $file_flag != "1" ];then
                echo "Error:${filepath} add error."
                return
        fi
        #Read file content
        cat $filepath | while read tmp
        do
                line=${2}${tmp}
		echo $line
                check_file $line
                svn_file=$?
                if [ $svn_file == "2" ];then
                        mkdir -pv ${3}${filepath}
                        cp -rf ${line} ${3}${tmp}
                elif [ $svn_file == "1" ];then
                        dtmpdir=${3}${tmp}
                        tmpdir=${dtmpdir%/*}
                        mkdir -pv ${tmpdir}
                        cp -rf ${line} ${tmpdir}
                else
                        echo "File Not Exists: copy $line Fail."
                fi
        done

}
#copy file from source to destination
#	1-source path.
#	2-destination path.
#	3-copy's file or directory.
function copy_full() {
	if [ $# -lt 3 ];then
		echo "Usage:$0 filepath  destinationpath cppath"
		return 1
	fi
	exit_check_file $1 'd'
	exit_check_file $2 'd'
	local source_dir=$1
	local des_dir=$2
	local cpfile=$3
	local logflag=$4
	if [ ! -d logs ];then
		mkdir -pv logs
	fi
	local log1=logs/cover_full_process.log
	local log2=logs/cover_copy_detail.log
	#local log2=logs/cover_full_process.log
	if [ -z $logflag ];then
		echo "["`date +'%Y-%m-%d %H:%M:%S'`"]==================================================================================================================="  >> $log1
		cp -rf ${source_dir}'/'$cpfile  ${des_dir}
		echo "["`date +'%Y-%m-%d %H:%M:%S'`"]==================================================================================================================="  >> $log2
	fi
	#cp -rf ${source_dir}'/'$cpfile  ${des_dir}
	for filenametmp in `ls ${source_dir}'/'$cpfile`
		do
			local filename=$filenametmp
			if [ -f ${source_dir}'/'${cpfile}'/'${filename} ];then
				echo '/'${cpfile}'/'${filename} >> $log2
			elif [ -d ${source_dir}'/'${cpfile}'/'${filename} ];then
				copy_full $source_dir $des_dir  $cpfile'/'${filename}  true
			fi
		done
	echo "# ${source_dir}/$cpfile  to ${des_dir}" >> $log1
}
#copy file from source to destination.copy to destination from source while the reference file name is the same to source.
#	1-source path.
#	2-reference path.
#	3-destination path.
#	4-copy's file or directory.
#	5-destination file or directory
#	6-log flag
function cover_copy() {
	if [ $# -lt 5 ];then
		echo "Usage:$0 filepath referencepath destinationpath cppath despath"
		return 1
	fi
	exit_check_file $1 'd'
	exit_check_file $2 'd'
	exit_check_file $3 'd'
	local source_dir=$1
	local ref_dir=$2
	local des_dir=$3
	local cpfile=$4
	local desfile=$5
	local logflag=$6
	if [ ! -d logs ];then
		mkdir logs
	fi
	local log1=logs/cover_copy_cp.log
	local log2=logs/cover_copy_process.log
	local log3=logs/cover_copy_detail.log
	if [ -z $logflag ];then
		echo "["`date +'%Y-%m-%d %H:%M:%S'`"]==================================================================================================================="  >> $log1
		echo "["`date +'%Y-%m-%d %H:%M:%S'`"]==================================================================================================================="  >> $log2
		echo "["`date +'%Y-%m-%d %H:%M:%S'`"]==================================================================================================================="  >> $log3
	fi
	for filenametmp in `ls ${source_dir}'/'$cpfile`
		do
			local filename=$filenametmp
			if [ -f ${ref_dir}'/'${desfile}'/'${filename} ];then
				echo '/'${desfile}'/'${filename} >> $log3
			fi
			echo "***"${source_dir}'/'$cpfile'/'$filename" start.">> $log2
			if [[ -f ${source_dir}'/'$cpfile'/'${filename} ]]&&[[ -f ${ref_dir}'/'$desfile'/'${filename} ]];then
			#if [ -f ${source_dir}'/'$cpfile'/'${filename} ];then
				local desdir=${des_dir}'/'$desfile
				mkdir -pv $desdir
				cp ${source_dir}'/'$cpfile'/'${filename}  $desdir
				echo "# ${source_dir}/$cpfile/${filename}  to $desdir" >> $log1
			elif [[ -d ${source_dir}'/'${cpfile}'/'${filename} ]]&&[[ -d ${ref_dir}'/'${desfile}'/'${filename} ]];then
				#echo ${source_dir}'/'$cpfile'/'${filename}
				cover_copy $source_dir $ref_dir $des_dir $cpfile'/'${filename}  $desfile'/'${filename}  true
			fi
			echo "***"${source_dir}'/'$cpfile'/'$filename" end.">> $log2
		done
}
#back copy file from source to destination.copy to destination from source while the reference file name is the same to source.
#	1-source path.
#	2-reference path.
#	3-destination path.
#	4-copy's file or directory.
#	5-destination file or directory
#	6-log flag
function cover_copy_bak() {
	if [ $# -lt 5 ];then
		echo "Usage:$0 filepath referencepath destinationpath cppath despath"
		return 1
	fi
	exit_check_file $1 'd'
	exit_check_file $2 'd'
	exit_check_file $3 'd'
	local source_dir=$1
	local ref_dir=$2
	local des_dir=$3
	local cpfile=$4
	local desfile=$5
	local logflag=$6
	if [ ! -d logs ];then
		mkdir logs
	fi
	local log1=logs/cover_copy_bak_cp.log
	local log2=logs/cover_copy_bak_process.log
	#local log3=logs/cover_copy_detail.log
	if [ -z $logflag ];then
		echo "["`date +'%Y-%m-%d %H:%M:%S'`"]==================================================================================================================="  >> $log1
		echo "["`date +'%Y-%m-%d %H:%M:%S'`"]==================================================================================================================="  >> $log2
		#echo "["`date +'%Y-%m-%d %H:%M:%S'`"]==================================================================================================================="  >> $log3
	fi
	for filenametmp in `ls ${source_dir}'/'$cpfile`
		do
			local filename=$filenametmp
			#if [ -f ${source_dir}'/'${cpfile}'/'${filename} ];then
			#	echo '/'${cpfile}'/'${filename} >> $log3
			#fi
			echo "***"${source_dir}'/'$cpfile'/'$filename" start.">> $log2
			if [[ -f ${source_dir}'/'$cpfile'/'${filename} ]]&&[[ -f ${ref_dir}'/'$desfile'/'${filename} ]];then
				local old_parent=${desfile%%/*}
				local sub_parent=${desfile#*/}
				local tmpdesfile=''
				if [[ $old_parent ==  $desfile ]]&&[[ $sub_parent ==  $desfile ]];then
					tmpdesfile=${old_parent}_old
				else
					tmpdesfile=${old_parent}_old'/'${sub_parent}
				fi
				#local tmpdesfile=${old_parent}_old'/'${sub_parent}
				local desdir=${des_dir}'/'${tmpdesfile}
				mkdir -pv $desdir
				cp ${ref_dir}'/'$desfile'/'${filename}  $desdir
				echo "# ${source_dir}/$cpfile/${filename} to $desdir" >> $log1
			elif [[ -d ${source_dir}'/'${cpfile}'/'${filename} ]]&&[[ -d ${ref_dir}'/'${desfile}'/'${filename} ]];then
				cover_copy_bak $source_dir $ref_dir $des_dir $cpfile'/'${filename}  $desfile'/'${filename}  true
			fi
			echo "***"${source_dir}'/'$cpfile'/'$filename" end.">> $log2
		done
}
function exists_copy() {
	if [ $# -ne 2 ];then
		echo "Usage:$0 filepath file_multi_extension(example:.tag.gz;txt;doc)"
		return 1
	fi
	extensions=$2
	ext_arr=($(echo $extensions | tr '#' ' ' | tr -s ' '))
	length=${#ext_arr[@]}
	for ((i=0; i<$length; i++))
		do
			echo ${a[$i]}
		done
}
function _verify_file_extension(){
	
	#a=($(echo $str2 | tr '#' ' ' | tr -s ' '))
	echo ""
}
#delete extension of file or directory.
#	1-file path.
#	2-exclude file extension
function delete_extension() {
	if [ $# -ne 2 ];then
		echo "Usage:$0 filepath file_multi_extension\(example:.tag.gz;txt;doc\)"
		return 1
	fi
	filepath=$1
	if [ -f $filepath ];then
		echo ""
	fi		
}
#filter copy.this is 3 params.
#	1-source directory
#	2-destination directory
#	3-exclude file extension
function exclude_copy() {
	source_dir=$1
	for filename in `ls ${source_dir}`
		do
			if [ -d ${source_dir}'/'${filename} ];then
				echo ""
			else
				echo ""
			fi
		done
	echo "test"
}
