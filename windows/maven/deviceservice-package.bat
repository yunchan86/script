@echo off
set PROJECT_NAME="C:/repository/git/project/dingdong_source_server/Trunk/Development/Source/Server/deviceservice"
set SETTING_PATH="C:/repository/maven/settings.xml"
cd /d %PROJECT_NAME%
mvn -s %SETTING_PATH% clean package -Dmaven.test.skip=true
echo success
pause