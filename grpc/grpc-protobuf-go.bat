set PROTOC_BIN_PATH=C:\opt\Protobuf\protoc-3.5.1-win32\bin
set PROTOC_PATH=C:\repository\git\project\open_source_server\source\nimitz\nimitz_protoc_file\go
set GO_OUT=C:\repository\git\project\open_source_server\source\nimitz\nimitz_protoc_file\go\semantic
set GO_PATH=C:\opt\Gopath

cd /d %PROTOC_PATH%

protoc --go_out=plugins=grpc:semantic  nimitz_user.proto

protoc --go_out=plugins=grpc:semantic  nimitz_semantic.proto

REM protoc --plugin=protoc-gen-go=%GO_PATH%\bin\protoc-gen-go.exe --go_out=%GO_OUT% --proto_path=%PROTOC_PATH% nimitz_semantic.proto

echo "Success."

pause