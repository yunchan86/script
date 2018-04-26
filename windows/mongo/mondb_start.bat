@echo off
set mongoHome=c:/opt/MongoDB/Server/3.2/bin/
set dbPath=c:/opt/MongoDB/Server/3.2/data/db
%mongoHome%mongod --dbpath %dbPath%
