#!/bin/sh

./createPathCPU.sh

criu=false
if [ $# -gt 2 ]; then
	criu=$3
fi

log=""
if [ $# -eq 4 ]; then
	log=$4	
fi

java -Dnode.bootstrap=$1 -Dproject.version=1.0-SNAPSHOT -Duse.criu=${criu} -Dexperiment.log=${log} -Dkevoree.corelibrary.version=2.0.5 -Dnode.name=$2 -Dinterproccess.lock.library=/home/inti/programs/kevoree-microsandbox/org.ipc.memory/libInterprocessLock.so -Dthread.control.library=/home/inti/programs/kevoree-microsandbox/org.kevoree.microsandbox.cgroupNode/libCPUThreadControl.so -Xbootclasspath/p:/tmp/ext-rt.jar:/tmp/shared-res-1.0-SNAPSHOT.jar -javaagent:/tmp/ext-agent1.0-SNAPSHOT.jar -jar /tmp/kevoree-runtime-2.0.12.jar

#java -Dnode.bootstrap=/home/inti/programs/kevoree-microsandbox/org.kevoree.microsandbox.watchdog/../ore/src/main/kevs/testingNaiveSocketChannel.kevs -Dproject.version=1.0-SNAPSHOT -Dkevoree.corelibrary.version=2.0.5 -Dnode.name=$1 -Xbootclasspath/p:/tmp/ext-rt.jar:/tmp/shared-res-1.0-SNAPSHOT.jar -javaagent:/tmp/ext-agent1.0-SNAPSHOT.jar -jar /tmp/kevoree-runtime-2.0.12.jar
