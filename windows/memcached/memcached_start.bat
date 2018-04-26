@echo off
SET MEMCACHED_PATH=/opt/memcached/memcached-win64-1.4.4-14/
%MEMCACHED_PATH%memcached.exe -d start
pause