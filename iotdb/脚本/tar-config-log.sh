#!/bin/bash

IOTDB_PATH=/opt/iotdb/apache-iotdb-0.14.0-SNAPSHOT-all-bin
CONFIG_NODE=confignode
DATA_NODE=datanode

TAR_FILE_NAME=iotdb-master.tar.gz

tar -czvf $TAR_FILE_NAME  $IOTDB_PATH/$CONFIG_NODE/conf $IOTDB_PATH/$CONFIG_NODE/logs  $IOTDB_PATH/$DATA_NODE/conf $IOTDB_PATH/$DATA_NODE/logs
echo "tar success"
rm -f /tmp/aaa/tmp/$TAR_FILE_NAME
mv $TAR_FILE_NAME  /tmp/aaa/tmp/
#other