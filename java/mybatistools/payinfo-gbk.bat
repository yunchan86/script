@echo off
rem Դ�ļ�����Ŀ¼
set SRC_PATH="C:\opt\mybatistools\sourcecode\payinfo\src"
rem mybatis��jar�ļ�Ŀ¼��ַ
set MYBATIS_PATH_JAR_FILE="C:\opt\mybatistools\mybatis-generator-core-1.3.1.jar"
rem mybatis�����ļ��������ļ���ַ
set CONFIG_FILE="C:\opt\mybatistools\payinfo.xml"
rem Դ�ļ�Ŀ¼�Ƿ����
if exist %SRC_PATH% (goto  exitPath) else (goto createdir)
:createdir
md %SRC_PATH%
echo create diretory...
goto javacmd
:exitPath
rem ɾ���Ѿ������ļ�
del /q %SRC_PATH%\*
rem ɾ���Ѿ����ڵ��ļ���
for /d %%i in (%SRC_PATH%\*) do (rd /q /s %%i)
rem rd /q /s  %SRC_PATH%\*
echo delete files finished.
goto javacmd
:javacmd
java -jar %MYBATIS_PATH_JAR_FILE% -configfile %CONFIG_FILE% -overwrite
pause