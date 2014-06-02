#!/bin/sh

# Usage
# Use this if you want to use Squirrel to isolate components in CPU containers and
# processes to isolate components in memory containers.
# No memory instrumentation is used
#

./createPathCPU.sh

criu=false
if [ $# -gt 2 ]; then
	criu=$3
fi

log=""
if [ $# -eq 4 ]; then
	log=$4	
fi

java -Dnode.bootstrap=$1 -Dproject.version=1.1 -Duse.criu=${criu} -Dexperiment.log=${log} -Dkevoree.corelibrary.version=3.5.3 -Dnode.name=$2 -Dinterproccess.lock.library=/home/inti/programs/kevoree-microsandbox/org.ipc.memory/libInterprocessLock.so -Dthread.control.library=/home/inti/programs/kevoree-microsandbox/org.kevoree.microsandbox.cgroupNode/libCPUThreadControl.so -Xbootclasspath/p:/tmp/ext-rt.jar:/tmp/shared-res-1.1.jar -javaagent:/tmp/ext-agent1.1.jar=squirrel -jar /tmp/kevoree-runtime-3.5.6.jar
