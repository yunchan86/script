@echo off
set HOSTS_PATH="C:\Windows\System32\drivers\etc"
copy /Y  %HOSTS_PATH%\hosts.test  %HOSTS_PATH%\hosts
pause