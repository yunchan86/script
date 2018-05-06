@echo off
set MYSQL_HOME=D:/opt/mysql/mysql-5.6.24/
%MYSQL_HOME%bin/mysqld --install --defaults-file="D:/opt/mysql/mysql-5.6.24/my.ini"  mysql
pause