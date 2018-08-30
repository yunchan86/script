备份数据库
备份数据库表（-d）：
mysqldump.exe -uvbox -p -h127.0.0.1 -d vboxserver > vboxserver_structure.sql
备份数据库表结构及数据：
mysqldump.exe -uvbox -p -h127.0.0.1  vboxserver  > vboxserver_data.sql
备份数据库表结构及数据（-d）：
mysqldump.exe -uvbox -p -h127.0.0.1 -d vboxserver test > vboxserver_data.sql