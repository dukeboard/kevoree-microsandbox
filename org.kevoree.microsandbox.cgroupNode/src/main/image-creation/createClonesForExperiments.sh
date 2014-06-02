#!/bin/bash

# this script create a new directory that will contain the clones for the experiments regarding CRIU-based deployment

if [ "$#" -ne 2 ]; then
    echo "Illegal number of parameters"
    echo "Usage $0 DIRECTORY NUMBER_OF_IMAGES"
    exit 1
fi

CRIU_APP='/home/inti/Downloads/criu-1.2/criu'
kevscript=/home/inti/programs/kevoree-microsandbox/org.kevoree.microsandbox.cgroupNode/src/main/kevs/criu-helper/runningInClones.kevs
thread_library=/home/inti/programs/kevoree-microsandbox/org.kevoree.microsandbox.cgroupNode/libCPUThreadControl.so

#checking a bunch of possible errors
if [ ! -f ${CRIU_APP} ]; then
    echo "CRIU is not located at ${CRIU_APP}"
    echo "It should be if you want to execute this script!!!"
    exit 1
fi
if [ ! -f ${kevscript} ]; then
    echo "The script runningInClones cannot be found at ${kevscript}"
    echo "It should be if you want to execute this script!!!"
    exit 1
fi
if [ ! -f ${thread_library} ]; then
    echo "The thread_library cannot be found at ${thread_library}"
    echo "It should be if you want to execute this script!!!"
    exit 1
fi
if [ ! -f /tmp/ext-rt.jar ]; then
    echo "The file ext-rt.jar cannot be found at /tmp"
    echo "It should be if you want to execute this script!!!"
    exit 1
fi
if [ ! -f /tmp/shared-res-1.1.jar ]; then
    echo "The file shared-res-1.1.jar cannot be found at /tmp"
    echo "It should be if you want to execute this script!!!"
    exit 1
fi
if [ ! -f /tmp/ext-agent1.1.jar ]; then
    echo "The file ext-agent1.1.jar cannot be found at /tmp"
    echo "It should be if you want to execute this script!!!"
    exit 1
fi
if [ ! -f /tmp/kevoree-runtime-3.5.6.jar ]; then
    echo "The file kevoree-runtime-3.5.6.jar cannot be found at /tmp"
    echo "It should be if you want to execute this script!!!"
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
