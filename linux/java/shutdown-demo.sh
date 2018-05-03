#!/bin/sh
pid=`jps -lv | grep com.ll.nimitz.dispatch.DispServer | awk '{print $1}'`
kill -9 $pid
echo 'Dispatch Server  is shutdown.'
