#! /bin/bash

readonly backupdir=/export/Data/backup
readonly datadir="${backupdir}/data"

function count()
{
    for file in ` ls $1 `
    do
        if [ -d $1"/"$file ];then
            count $1"/"$file
        else
            declare -i fileLines
            fileLines=`sed -n '$=' $1"/"$file`
            let linesCount=$linesCount+$fileLines
            let filesCount=$filesCount+1
        fi
    done
}
if [ $# -gt 0 ];then
    for m_dir in $@
    do
        count $m_dir
    done
else
    count $datadir
fi
echo "filesCount=${filesCount}"
echo "linesCount=${linesCount}"

