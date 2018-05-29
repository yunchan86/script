set PROTOC_BIN_PATH=C:\opt\Protobuf\protoc-3.5.1-win32\bin
set PROTOC_PATH=C:\repository\git\project\open_source_server\source\nimitz\nimitz_protoc_file
set GO_OUT=C:\repository\git\project\open_source_server\source\nimitz\nimitz_protoc_file\semantic_go
set GO_PATH=C:\opt\Gopath
rem %PROTOC_BIN_PATH%\protoc --plugin=protoc-gen-grpc-go=%PROTOC_BIN_PATH%\protoc-gen-grpc-java-1.9.0-windows-x86_64.exe --grpc-java_out=%JAVA_OUT% --proto_path=%PROTOC_PATH% nimitz_semantic.proto

%PROTOC_BIN_PATH%\protoc --plugin=protoc-gen-go=%GOPATH%\bin\protoc-gen-go.exe --go_out=%GO_OUT% --proto_path=%PROTOC_PATH% nimitz_semantic.proto
rem %PROTOC_BIN_PATH%\protoc  --go_out=plugins=grpc:. %PROTOC_PATH%\nimitz_semantic.proto

pause