@echo off
REM Windows ����Ч
REM set PHP_FCGI_CHILDREN=5

REM ÿ�����̴���������������������Ϊ Windows ��������
set PHP_FCGI_MAX_REQUESTS=1000
 
echo Starting PHP FastCGI...

set RunHiddenConsoleHome=D:/opt/php/RunHiddenConsole/
set PHPHome=D:/opt/php/php-5.6.24/

%RunHiddenConsoleHome%RunHiddenConsole.exe  %PHPHome%php-cgi.exe -b 127.0.0.1:9000 -c %PHPHome%php.ini

echo Starting nginx...
set NginxHome=D:/opt/nginx/nginx-1.10.1/
%RunHiddenConsoleHome%RunHiddenConsole.exe %NginxHome%nginx.exe -p %NginxHome%

pause