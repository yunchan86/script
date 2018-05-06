#!/usr/bin/expect -f
#设置超时时间为30秒
set timeout 60
#设置登录的主机ip地址
set host 192.168.1.12
#设置登录的用户名
set name yun
#设置用户的登录密码
set password yun9989
#使用spawn执行ssh的登录进程
spawn ssh $host -l $name
#等待响应，第一次登陆往往会提示是否永久保存RSA到本机的know hosts列表中；等到回答后，提示输出密码；之后直接提示输入密码
expect  "password:"
send "$password\n"
#expect "]*"
#exit
interact
