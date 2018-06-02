set PROTOC_BIN_PATH=C:\opt\Protobuf\protoc-3.5.1-win32\bin
set PROTOC_PATH=C:\repository\git\project\open_source_server\source\nimitz\nimitz_semantic\nimitz_semantic_baike\nimitzSemanticProxy
set GO_OUT=C:\repository\git\project\open_source_server\source\nimitz\nimitz_protoc_file\semantic_go
set GO_PATH=C:\opt\Gopath


protoc --plugin=protoc-gen-go=%GO_PATH%\bin\protoc-gen-go.exe --go_out=%GO_OUT% --proto_path=%PROTOC_PATH% nimitz_semantic.proto


pause