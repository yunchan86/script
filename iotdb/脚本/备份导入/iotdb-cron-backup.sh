#! /bin/bash

source /etc/profile
/bin/bash /export/servers/apache-iotdb-0.14.0.bak.20220902/iotdb-backup.sh  all >> /export/servers/apache-iotdb-0.14.0.bak.20220902/nohup.log 2>&1 &
