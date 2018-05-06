function test(){
	path=$1
	if svn info $path;then
		echo "success"
	else 
		echo "error"
	fi
}
test $*
