@echo off
rem 源文件生成目录
set SRC_PATH="D:\worker\tools\mybatis-generator-core-1.3.1-bundle\mybatis-generator-core-1.3.1\yacol\src"
rem mybatis的jar文件目录地址
set MYBATIS_PATH_JAR_FILE="D:\worker\tools\mybatis-generator-core-1.3.1-bundle\mybatis-generator-core-1.3.1\lib\mybatis-generator-core-1.3.1.jar"
rem mybatis生成文件的配置文件地址
set CONFIG_FILE="D:\worker\tools\mybatis-generator-core-1.3.1-bundle\mybatis-generator-core-1.3.1\yacol\yacol.xml"
rem 源文件目录是否存在
if exist %SRC_PATH% (goto  exitPath) else (goto createdir)
:createdir
md %SRC_PATH%
echo create diretory...
goto javacmd
:exitPath
rem 删除已经存在文件
del /q %SRC_PATH%\*
rem 删除已经存在的文件夹
for /d %%i in (%SRC_PATH%\*) do (rd /q /s %%i)
rem rd /q /s  %SRC_PATH%\*
echo delete files finished.
goto javacmd
:javacmd
java -jar %MYBATIS_PATH_JAR_FILE% -configfile %CONFIG_FILE% -overwrite
pause