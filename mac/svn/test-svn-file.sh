function _check_svn_file() {
	if [ $# -lt 1 ];then
		return
	fi
        local filepath=$1
        local parentpath=${filepath%/*}
	echo $filepath   $parentpath
        if `svn info $parentpath 2> /dev/null`;then
                if `svn info $filepath 2> /dev/null`;then
                        echo '$filepath had added.'
                else 
                        svn add $filepath
                fi
		return 0
        elif [[ $filepath == $parentpath ]]||[[ $parentpath == '' ]];then
                echo "error operator."
                return 1
        else    
               	echo "parent path exec."
		_check_svn_file `echo $parentpath`
		#return $?
        fi

}
_check_svn_file $*
