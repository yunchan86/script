@echo off

set PRE=nimitz
set CONF=conf
set LIB=lib
set TARGET=target
set PARENT_PROJECT=%PRE%_semantic
set FLOW=flow
set session=session


rem set NIMITZ_PATH=%1
rem if %NIMITZ_PATH% == "" (set NIMITZ_PATH=C:\repository\git\otherproject\nimitz)

set NIMITZ_PATH=C:\repository\git\otherproject\nimitz

set NIMITZ_PATH_DEST=C:\repository\git\otherproject\nimitzdest

set SHORT_NAME=faq
set NIMITZ_PROJECT_PATH=%NIMITZ_PATH%\%PARENT_PROJECT%
set PROJECT_NAME=%PARENT_PROJECT%_%SHORT_NAME%

mkdir %NIMITZ_PATH_DEST%\%PARENT_PROJECT%\%PROJECT_NAME%
mkdir %NIMITZ_PATH_DEST%\%PARENT_PROJECT%\%PROJECT_NAME%\%LIB%
mkdir %NIMITZ_PATH_DEST%\%PARENT_PROJECT%\%PROJECT_NAME%\%CONF%
copy  %NIMITZ_PROJECT_PATH%\%PROJECT_NAME%\target\%PROJECT_NAME%.jar  %NIMITZ_PATH_DEST%\%PARENT_PROJECT%\%PROJECT_NAME% 
copy  %NIMITZ_PROJECT_PATH%\%PROJECT_NAME%\target\bin\startup.sh  %NIMITZ_PATH_DEST%\%PARENT_PROJECT%\%PROJECT_NAME% 
copy  %NIMITZ_PROJECT_PATH%\%PROJECT_NAME%\target\bin\shutdown.sh  %NIMITZ_PATH_DEST%\%PARENT_PROJECT%\%PROJECT_NAME% 
xcopy %NIMITZ_PROJECT_PATH%\%PROJECT_NAME%\target\%LIB%  %NIMITZ_PATH_DEST%\%PARENT_PROJECT%\%PROJECT_NAME%\%LIB% /s /e /f /Y 
xcopy %NIMITZ_PROJECT_PATH%\%PROJECT_NAME%\target\%CONF%  %NIMITZ_PATH_DEST%\%PARENT_PROJECT%\%PROJECT_NAME%\%CONF% /s /e  /f /Y 
pause