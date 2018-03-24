@echo off
set KAFKA_PATH=/opt/kafka/kafka_2.11-0.10.0.0/
%KAFKA_PATH%bin/windows/kafka-server-start.bat %KAFKA_PATH%config/server.properties
pause