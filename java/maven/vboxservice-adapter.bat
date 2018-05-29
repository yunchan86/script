@echo OFF
set JDK_PATH=C:\Program Files\Java\jdk1.8.0_20
set PROJECT_PATH=C:\repository\git\project\dingdong_source_server\Trunk\Development\Source\Server\vboxservice-adapter
cd %PROJECT_PATH%
mvn clean package -Dmaven.test.skip=true
