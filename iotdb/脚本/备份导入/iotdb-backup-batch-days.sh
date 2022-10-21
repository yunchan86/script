#! /bin/bash

datestartstr=`date -d "2022-09-16" +"%Y-%m-%d"`
datenum=1
datebatchstr=$datestartstr
dateendstr=`date -d "2022-09-18" +"%Y-%m-%d"`

function export_data_by_days(){
	for((i=0; i<=${datenum}; i++)); 
	do
		datebatchstr=`date -d "${datestartstr} +${i} day" +"%Y-%m-%d"`
		echo ${datebatchstr}
		./iotdb-backup.sh all ${datebatchstr}
	done
}


COMMAND_LINE_ARFGS="all"


case $1 in
	all)
		export_data_by_days
		;;
	*)
		echo "$0 {$COMMAND_LINE_ARFGS}"
		;;
esac
