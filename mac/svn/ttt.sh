function test_exit(){
  val=$1
  if [ ! $val1 ];then
	val1="exit"
  fi
  if [ $val1 == 'exit' ];then
	echo "exit."
	exit
  fi
  echo "finish."
}
test_exit $*
echo "this is test."
