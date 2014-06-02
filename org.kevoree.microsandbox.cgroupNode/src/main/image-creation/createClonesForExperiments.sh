#!/bin/bash

# this script create a new directory that will contain the clones for the experiments regarding CRIU-based deployment

if [ "$#" -ne 2 ]; then
    echo "Illegal number of parameters"
    echo "Usage $0 DIRECTORY NUMBER_OF_IMAGES"
    exit 1
fi

if [ ! -d $1 ]; then
	mkdir $1
fi

cp -f createImages.sh $1
cp -f createSingleClone.sh $1
cp -f dump.sh $1
cp -f newns.c $1

previous=`pwd`
cd $1

gcc -o newns newns.c
./createImages.sh $2

cd ${previous}
