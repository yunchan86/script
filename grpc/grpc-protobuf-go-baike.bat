set PROTOC_BIN_PATH=C:\opt\Protobuf\protoc-3.5.1-win32\bin
set PROTOC_PATH=C:\repository\git\project\nimitz_source_server\nimitz\nimitz_protoc_file\go\xinyuan
set GO_OUT=C:\repository\git\project\nimitz_source_server\nimitz\nimitz_protoc_file\go
set GO_PATH=C:\opt\Gopath

cd /d %PROTOC_PATH%

protoc --go_out=plugins=grpc:.  xinyuan.proto

echo "Success."

pause