#!/bin/bash

echo "Using path: $1"
echo "Using pv directory prefix: $2"
echo "Number of directory to create: $3"
echo "Using export file name: $4" 
dirNum=$3
dirCount=0

while [ $dirCount -lt $dirNum ]
do
   echo $dirCount
   dirCount=`expr $dirCount + 1`
   pathToCreate="$1/$2$dirCount"
   echo "Creating directory: $pathToCreate"
   mkdir $pathToCreate
   chown nfsnobody:nfsnobody $pathToCreate
   chmod 777 $pathToCreate
   echo "$pathToCreate *(rw,root_squash)" >> $4
done

exportfs -a
showmount -e

