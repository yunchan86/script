#!/bin/sh
/usr/sbin/php-fpm -c /etc/php.ini  start
/opt/application/nginx/nginx-1.8.0/sbin/nginx
