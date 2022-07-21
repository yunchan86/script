#!/bin/sh

current_path=`pwd`
IOTDB_HOME=/d/respository/iotdb/distribution/target/apache-iotdb-0.14.0-SNAPSHOT-all-bin/apache-iotdb-0.14.0-SNAPSHOT-all-bin
CONFIG_NODE_PATH=$IOTDB_HOME/confignode
DATA_NODE_PATH=$IOTDB_HOME/datanode
CONF_DIR=conf
FILE_IOTDB_CONFIGNODE_CONF=iotdb-confignode.properties
FILE_IOTDB_DATANODE_CONF=iotdb-datanode.properties

CLUSTER_HOSTS=172.16.58.192,172.16.58.193,172.16.58.194
CLUSTER_CONFIGNODE_HOSTS=$CLUSTER_HOSTS
CLUSTER_DATANODE_HOSTS=$CLUSTER_HOSTS
TARGET_CONFIGNODE_HOST=172.16.58.192

IOTDB_DATA_DIR=/export/Data/iotdb_data
IOTDB_LOGS_DIR=/export/Logs/iotdb_logs

CONFIG_NODE_DATA_DIR=$IOTDB_DATA_DIR/confignode/data
CONFIG_NODE_EXT_DIR=$IOTDB_DATA_DIR/confignode/ext
CONFIG_NODE_DATA_SYETEM_DIR=$CONFIG_NODE_DATA_DIR/system
CONFIG_NODE_DATA_CONDSENSUS_DIR=$CONFIG_NODE_DATA_DIR/consensus
CONFIG_NODE_EXT_UDF_DIR=$CONFIG_NODE_EXT_DIR/udf
CONFIG_NODE_EXT_TEMPORARY_DIR=$CONFIG_NODE_EXT_DIR/temporary

DATA_NODE_DATA_DIR=$IOTDB_DATA_DIR/confignode/data
DATA_NODE_EXT_DIR=$IOTDB_DATA_DIR/confignode/ext
DATA_NODE_DATA_SYETEM_DIR=$DATA_NODE_DATA_DIR/system
DATA_NODE_DATA_DATA_DIR=$DATA_NODE_DATA_DIR/data
DATA_NODE_DATA_INDEX_DIR=$DATA_NODE_DATA_DIR/index
DATA_NODE_DATA_CONDSENSUS_DIR=$DATA_NODE_DATA_DIR/consensus
DATA_NODE_DATA_WAL_DIR=$DATA_NODE_DATA_DIR/wal
DATA_NODE_DATA_TRACING_DIR=$DATA_NODE_DATA_DIR/tracing
DATA_NODE_EXT_TRIGGER_DIR=$DATA_NODE_EXT_DIR/trigger
DATA_NODE_EXT_UDF_DIR=$DATA_NODE_EXT_DIR/udf
DATA_NODE_EXT_TEMPORARY_DIR=$DATA_NODE_EXT_DIR/temporary

NEW_CONFIG_DIR=config1



CONFIG_NODE_CONF_PATH=$CONFIG_NODE_PATH/$CONF_DIR
DATA_NODE_CONF_PATH=$DATA_NODE_PATH/$CONF_DIR

escape_str(){
	str=$1
	
}

confignode_properties(){
echo "---------------------------confignode_properties start.---------------------------"
	OLD_IFS="$IFS"
	IFS=","
	hosts=($CLUSTER_HOSTS)
	IFS="$OLD_IFS"
	for host in ${hosts[*]}
	do
		echo "---------------------" $host "start." "---------------------"
		new_config=$NEW_CONFIG_DIR/confignode-$host/$CONF_DIR
		mkdir -p $new_config
		cp $CONFIG_NODE_CONF_PATH/$FILE_IOTDB_CONFIGNODE_CONF  $new_config
		
		sed -i "s/internal_address=0.0.0.0/internal_address=${host}/g"  $new_config/$FILE_IOTDB_CONFIGNODE_CONF
		
		sed -i "s/target_config_nodes=0.0.0.0:22277/target_config_nodes=${TARGET_CONFIGNODE_HOST}:22277/g"  $new_config/$FILE_IOTDB_CONFIGNODE_CONF
		
		
		CONFIG_NODE_DATA_SYETEM_DIR_TMP=$(echo $CONFIG_NODE_DATA_SYETEM_DIR | sed 's/\//\\\//g')
		sed -i "s/# system_dir=data\/system/system_dir=${CONFIG_NODE_DATA_SYETEM_DIR_TMP}/g"  $new_config/$FILE_IOTDB_CONFIGNODE_CONF
		
		CONFIG_NODE_DATA_CONDSENSUS_DIR_TMP=$(echo $CONFIG_NODE_DATA_CONDSENSUS_DIR | sed 's/\//\\\//g')
		sed -i "s/\# consensus_dir=data\/consensus/consensus_dir=${CONFIG_NODE_DATA_CONDSENSUS_DIR_TMP}/g"  $new_config/$FILE_IOTDB_CONFIGNODE_CONF
		
		CONFIG_NODE_EXT_UDF_DIR_TMP=$(echo $CONFIG_NODE_EXT_UDF_DIR | sed 's/\//\\\//g')
		sed -i "s/\# udf_lib_dir=ext\/udf/udf_lib_dir=${CONFIG_NODE_EXT_UDF_DIR_TMP}/g"  $new_config/$FILE_IOTDB_CONFIGNODE_CONF
		
		CONFIG_NODE_EXT_TEMPORARY_DIR_TMP=$(echo $CONFIG_NODE_EXT_TEMPORARY_DIR | sed 's/\//\\\//g')
		sed -i "s/\# temporary_lib_dir=ext\/temporary/temporary_lib_dir=${CONFIG_NODE_EXT_TEMPORARY_DIR_TMP}/g"  $new_config/$FILE_IOTDB_CONFIGNODE_CONF
		
		echo "---------------------" $host "end." "---------------------"
	done
	echo "---------------------------confignode_properties end.---------------------------"
}

datanode_properties(){
	echo "---------------------------datanode_properties start.---------------------------"
	OLD_IFS="$IFS"
	IFS=","
	hosts=($CLUSTER_HOSTS)
	IFS="$OLD_IFS"
	for host in ${hosts[*]}
	do
		echo "---------------------" $host "start." "---------------------"
		new_config=$NEW_CONFIG_DIR/datanode-$host/$CONF_DIR
		mkdir -p $new_config
		cp $DATA_NODE_CONF_PATH/$FILE_IOTDB_DATANODE_CONF  $new_config
		
		sed -i "s/rpc_address=0.0.0.0/rpc_address=${host}/g"  $new_config/$FILE_IOTDB_DATANODE_CONF
		sed -i "s/rpc_address=127.0.0.1/rpc_address=${host}/g"  $new_config/$FILE_IOTDB_DATANODE_CONF
		
		sed -i "s/internal_address=0.0.0.0/internal_address=${host}/g"  $new_config/$FILE_IOTDB_DATANODE_CONF
		sed -i "s/internal_address=127.0.0.1/internal_address=${host}/g"  $new_config/$FILE_IOTDB_DATANODE_CONF
		
		sed -i "s/target_config_nodes=0.0.0.0:22277/target_config_nodes=${TARGET_CONFIGNODE_HOST}:22277/g"  $new_config/$FILE_IOTDB_DATANODE_CONF
		sed -i "s/target_config_nodes=127.0.0.1:22277/target_config_nodes=${TARGET_CONFIGNODE_HOST}:22277/g"  $new_config/$FILE_IOTDB_DATANODE_CONF
		
		
		DATA_NODE_DATA_SYETEM_DIR_TMP=$(echo $DATA_NODE_DATA_SYETEM_DIR | sed 's/\//\\\//g')
		sed -i "s/# system_dir=data\/system/system_dir=${DATA_NODE_DATA_SYETEM_DIR_TMP}/g"  $new_config/$FILE_IOTDB_DATANODE_CONF
		
		DATA_NODE_DATA_CONDSENSUS_DIR_TMP=$(echo $DATA_NODE_DATA_CONDSENSUS_DIR | sed 's/\//\\\//g')
		sed -i "s/\# consensus_dir=data\/consensus/consensus_dir=${DATA_NODE_DATA_CONDSENSUS_DIR_TMP}/g"  $new_config/$FILE_IOTDB_DATANODE_CONF
		
		DATA_NODE_DATA_DATA_DIR_TMP=$(echo $DATA_NODE_DATA_DATA_DIR | sed 's/\//\\\//g')
		sed -i "s/\# data_dirs=data\/data/data_dirs=${DATA_NODE_DATA_DATA_DIR_TMP}/g"  $new_config/$FILE_IOTDB_DATANODE_CONF
		
		DATA_NODE_DATA_INDEX_DIR_TMP=$(echo $DATA_NODE_DATA_INDEX_DIR | sed 's/\//\\\//g')
		sed -i "s/# index_root_dir=data\/index/index_root_dir=${DATA_NODE_DATA_INDEX_DIR_TMP}/g"  $new_config/$FILE_IOTDB_DATANODE_CONF
		
		DATA_NODE_DATA_TRACING_DIR_TMP=$(echo $DATA_NODE_DATA_TRACING_DIR | sed 's/\//\\\//g')
		sed -i "s/\# tracing_dir=data\/tracing/tracing_dir=${DATA_NODE_DATA_TRACING_DIR_TMP}/g"  $new_config/$FILE_IOTDB_DATANODE_CONF
		
		DATA_NODE_DATA_WAL_DIR_TMP=$(echo $DATA_NODE_DATA_WAL_DIR | sed 's/\//\\\//g')
		sed -i "s/\# wal_dirs=data\/wal/wal_dirs=${DATA_NODE_DATA_WAL_DIR_TMP}/g"  $new_config/$FILE_IOTDB_DATANODE_CONF
		
		DATA_NODE_EXT_UDF_DIR_TMP=$(echo $DATA_NODE_EXT_UDF_DIR | sed 's/\//\\\//g')
		sed -i "s/\# udf_root_dir=ext\/udf/udf_root_dir=${DATA_NODE_EXT_UDF_DIR_TMP}/g"  $new_config/$FILE_IOTDB_DATANODE_CONF
		
		DATA_NODE_EXT_TEMPORARY_DIR_TMP=$(echo $DATA_NODE_EXT_TEMPORARY_DIR | sed 's/\//\\\//g')
		sed -i "s/\# temporary_lib_dir=ext\/temporary/temporary_lib_dir=${DATA_NODE_EXT_TEMPORARY_DIR_TMP}/g"  $new_config/$FILE_IOTDB_DATANODE_CONF
		
		DATA_NODE_EXT_TRIGGER_DIR_TMP=$(echo $DATA_NODE_EXT_TRIGGER_DIR | sed 's/\//\\\//g')
		sed -i "s/\# trigger_root_dir=ext\/trigger/trigger_root_dir=${DATA_NODE_EXT_TRIGGER_DIR_TMP}/g"  $new_config/$FILE_IOTDB_DATANODE_CONF
		
		echo "---------------------" $host "end." "---------------------"
	done
	echo "---------------------------datanode_properties end.---------------------------"
}

confignode_properties
datanode_properties

