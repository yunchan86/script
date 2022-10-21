#! /bin/bash

readonly dumpip=172.16.0.42
readonly dumpport=6667
readonly backupdir=/export/Data/backup
readonly datadir="${backupdir}/data"
readonly faileddir=failed
datestr=`date -d "1 day ago" +"%Y-%m-%d"`
readonly tooldir=/opt/apache-iotdb-0.14.0-SNAPSHOT-all-bin/tools


function import_data_day(){
	daydirname=$1
	for filename in $(ls ${datadir}/${daydirname} | grep "root.property.*" | grep -v $faileddir)
	do
		linecount=`wc -l ${datadir}/${daydirname}/$filename | awk '{print $1}'`
		linecountnum=`expr ${linecount//$'\r'}`
		if [ $linecountnum -gt 1 ];
		then
			echo "linecount enabled filename is" $filename
			$tooldir/import-csv.sh -h $dumpip -p $dumpport -u root -pw root -f ${datadir}/${daydirname}/$filename -fd ${datadir}/${daydirname}/$faileddir/
		fi
	done
}

function import_data_file(){
	filename=$1
	filenamedir=`dirname $filename`
	$tooldir/import-csv.sh -h $dumpip -p $dumpport -u root -pw root -f $filenamedir -fd $filenamedir/$faileddir/
}


function import_data_all(){
	for diritem in $(ls $datadir)
	do
		if [ -d "${datadir}/${diritem}" ];then
			#for filename in $(ls ${datadir}/$diritem/root.property.* | sed -n "$1, $2p")
			import_data_day $diritem
		fi
	done
}

function valid_date(){
	echo $1 | grep -Eq "[0-9]{4}-[0-9]{2}-[0-9]{2}" > /dev/null  2>&1
	is_valid=$?
}

COMMAND_LINE_ARFGS="[all|day ${yyyy-MM-dd}|filename $fipath]"

if [ $# -lt 1 ];
then
        echo "USAGE: $0 $COMMAND_LINE_ARFGS"
        exit 1
fi

if [ $# -ge 2 ];
then
	if [ $1 == "day" ];
	then
		valid_date $2
		if [ $is_valid -eq 0 ];
		then
			datestr=$2
		else
			echo "time format is error. corret format: yyyy-MM-dd"
			exit 1
		fi
	elif [ $1 == "filename" ];
	then
		echo ""
	fi
fi
	
case $1 in
	all)
		import_data_all
		;;
	day)
	   	import_data_day $datestr
	   	;;
	filename)
	   	import_data_file $2
	   	;;
	*)
		echo "$0 {$COMMAND_LINE_ARFGS}"
		;;
esac