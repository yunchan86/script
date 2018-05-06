@echo off
set mongoHome=D:/opt/MongoDB/Server/3.2/bin/
set dbPath=D:/opt/MongoDB/Server/3.2/data/db
%mongoHome%mongod --dbpath %dbPath%
