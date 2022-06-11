#!/bin/sh

##/usr/bin/expect -f

#spawn zip -er ${file_name}.zip  ${file_name}
#expect  "password:"
#send "$password\n"
#expect  "password:"
#send "$password\n"
#interact

current_path=`pwd`
zip_path=${current_path}-bak



function zip_file(){
	file_name=$1
	echo "*****"
	echo $file_name
	inputpassword=$2
	password=${inputpassword}abc123456780xyz
	expect -c"
	set timeout 30
	spawn zip -er ${file_name}.zip  ${file_name}
	expect  \"password:\"
	send \"$password\n\"
	expect  \"password:\"
	send \"$password\n\"
	interact
	"
	mv ${file_name}.zip  $zip_path
}

function zip_files(){
	path=$1
	shellname=$2
	for file_item in $(ls $path)
	do
	   if [ -f $file_item ];then
	   	filename=`basename $file_item`
	   	if [[ $filename != $shellname &&  ! -f $zip_path/${filename}.zip ]];then
			zip_file $filename $filename
		fi
	   fi
	done 
}




COMMAND_LINE_ARFGS="zip_files"

if [ $# -lt 1 ];
then
        echo "USAGE: $0 $COMMAND_LINE_ARFGS"
        exit 1
fi
if [ ! -d $zip_path ];then
	cd ..
	mkdir $zip_path
	cd $current_path
fi
shellname=`basename $0`
case $1 in
	zip_files)
		zip_files $current_path $shellname
		;;
	*)
		echo "$0 {$COMMAND_LINE_ARFGS}"
		;;
esac