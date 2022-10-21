#! /bin/bash

readonly dumpip=172.16.58.193
#readonly dumpip=172.16.0.42
readonly dumpport=6667
readonly max=61
readonly backupdir=/export/Data/backup
readonly devicedir="${backupdir}/devices"
readonly datadir="${backupdir}/data"
datestr=`date -d "1 day ago" +"%Y-%m-%d"`
readonly pagesize=1000
readonly predevicecount="device-count"
readonly predeviceids="device-ids"
devicecount=0
readonly tooldir=/export/servers/apache-iotdb-0.14.0.bak.20220902/tools

function count_total_device(){
	##export count devices
	echo "------------------------export count devices start------------------------"
	/bin/bash ${tooldir}/export-csv.sh -h $dumpip -p $dumpport -u root -pw root -td ${devicedir} -f ${predevicecount}-${datestr}.csv -q "count devices root.**"
	devicecount=`cat ${devicedir}/${predevicecount}-${datestr}.csv0_0.csv | grep -v count`
	echo "*****--"${devicecount}"--*****"
	echo "------------------------export count devices end------------------------"
}

function query_device_ids(){
	##export device id detail
	echo "------------------------export device id detail start------------------------"
	echo $devicecount
	devicecounttmp=`expr ${devicecount//$'\r'} / $pagesize`
	echo $devicecounttmp
	echo "----------------"
	for((i=0; i<=${devicecounttmp}; i++)); 
	do
		echo "this i value is "
		echo $i
		echo "&&&&&&&&&&&&&&&&&&&"
		offset=`expr $i \* $pagesize`
		/bin/bash ${tooldir}/export-csv.sh -h $dumpip -p $dumpport -u root -pw root -td ${devicedir} -f ${predeviceids}-${datestr}-${i}.csv -q "show devices root.** limit $pagesize offset $offset"
	done
	echo "------------------------export device id detail end------------------------"
}


function export_data(){
	##export device data timeserials
	echo "------------------------export device data start------------------------"
	if [ ! -d "${datadir}/${datestr}" ];then
		mkdir ${datadir}/${datestr}
	fi
	for filename in $(ls $devicedir | grep ${predeviceids}-${datestr})
	do
		echo "start export data from filename:" $filename
		while IFS="," read -r linedata status
		do
			echo "export device" $linedata "data."
			/bin/bash ${tooldir}/export-csv.sh -h $dumpip -p $dumpport -u root -pw root -td ${datadir}/${datestr}  -f ${linedata}-${datestr}.csv -q "select * from $linedata where time>${datestr}T00:00:00 and time<${datestr}T23:59:59.999"
		done < $devicedir/$filename
		echo "end export data from filename:" $filename
	done
	echo "------------------------export device data end------------------------"
}

function valid_date(){
	echo $1 | grep -Eq "[0-9]{4}-[0-9]{2}-[0-9]{2}" > /dev/null  2>&1
	is_valid=$?
}



COMMAND_LINE_ARFGS="all|count|device|data"

if [ $# -lt 1 ];
then
        echo "USAGE: $0 $COMMAND_LINE_ARFGS"
        exit 1
fi
if [ $# -ge 2 ];
then
	valid_date $2
	if [ $is_valid -eq 0 ];
	then
		datestr=$2
	else
		echo "time format is error. corret format: yyyy-MM-dd"
        exit 1
	fi
fi
case $1 in
	all)
		count_total_device
		query_device_ids
		export_data
		;;
	count)
	   	count_total_device
	   	;;
	device)
	   	query_device_ids
	   	;;
	data)
	   	export_data
	   	;;
	*)
		echo "$0 {$COMMAND_LINE_ARFGS}"
		;;
esac

