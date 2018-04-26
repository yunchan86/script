@echo off
SET PROJECT_NAME="C:\repository\git\project\dingdong_source_server\Trunk\Development\Source\Server\deviceservice\target"
cd /d  "%PROJECT_NAME%"
rem java -classpath ".;%ROJECT_NAME%\conf;%ROJECT_NAME%\lib;%ROJECT_NAME%\deviceservice\deviceservice.jar" com.ll.vbox.deviceservice.main.DeviceServiceMainClient
rem java -classpath "conf;lib;deviceservice.jar" com.ll.vbox.deviceservice.main.DeviceServiceMainClient
java -jar deviceservice.jar -Djava.ext.dirs="./lib/*.jar;./conf/*" 
pause