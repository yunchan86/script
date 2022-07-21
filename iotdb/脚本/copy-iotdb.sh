#!/bin/bash

FROM_PATH=/opt/iotdb-tmp/apache-iotdb-0.14.0-SNAPSHOT-all-bin
TO_PATH=/opt/iotdb/apache-iotdb-0.14.0-SNAPSHOT-all-bin

CONFIG_NODE=confignode
DATA_NODE=datanode

CONF=conf

mv ${TO_PATH}/${CONFIG_NODE}/${CONF}/iotdb-confignode.properties  ${TO_PATH}/${CONFIG_NODE}/${CONF}/iotdb-confignode.properties.local
cp ${FROM_PATH}/${CONFIG_NODE}/${CONF}/iotdb-confignode.properties  ${TO_PATH}/${CONFIG_NODE}/${CONF}/
cp ${FROM_PATH}/${CONFIG_NODE}/*.sh  ${TO_PATH}/${CONFIG_NODE}/


mv ${TO_PATH}/${DATA_NODE}/${CONF}/iotdb-engine.properties  ${TO_PATH}/${DATA_NODE}/${CONF}/iotdb-engine.properties.local
cp ${FROM_PATH}/${DATA_NODE}/${CONF}/iotdb-engine.properties  ${TO_PATH}/${DATA_NODE}/${CONF}/
cp ${FROM_PATH}/${DATA_NODE}/*.sh  ${TO_PATH}/${DATA_NODE}/