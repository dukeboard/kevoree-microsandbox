#!/bin/sh

# Usage
# Use this if you want to use Scapegoat for CPU and memory monitoring.
# Instrumentation is used
#

criu=false
if [ $# -gt 2 ]; then
	criu=$3
fi

log=""
if [ $# -eq 4 ]; then
	log=$4	
fi

lock_library=/home/inti/programs/kevoree-microsandbox/org.ipc.memory/libInterprocessLock.so
thread_library=/home/inti/programs/kevoree-microsandbox/org.kevoree.microsandbox.cgroupNode/libCPUThreadControl.so
#-ea
java -Dversion=5.0.1 -Dnode.bootstrap=$1 -Dproject.version=1.1 -Duse.criu=${criu} -Dexperiment.log=${log} -Dkevoree.corelibrary.version=5.0.1 -Dnode.name=$2 -Dinterproccess.lock.library=${lock_library} -Dthread.control.library=${thread_library} -Xbootclasspath/p:/tmp/ext-rt.jar:/tmp/shared-res-1.1.jar -javaagent:/tmp/ext-agent1.1.jar=scapegoat2 -agentpath:/tmp/libheapViewer.so -jar /tmp/kevoree-runtime-5.0.1.jar