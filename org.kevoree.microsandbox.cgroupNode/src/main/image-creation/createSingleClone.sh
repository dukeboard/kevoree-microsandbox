#!/bin/bash

kevscript=/home/inti/programs/kevoree-microsandbox/org.kevoree.microsandbox.cgroupNode/src/main/kevs/criu-helper/runningInClones.kevs
thread_library=/home/inti/programs/kevoree-microsandbox/org.kevoree.microsandbox.cgroupNode/libCPUThreadControl.so

index=$2
nodeName=$1
log_fileName="${nodeName}.log"

currentDirectory="${nodeName}Directory"

if [ ! -d ${currentDirectory} ]; then
	mkdir ${currentDirectory}
fi

nameTmp="${currentDirectory}/${index}.kevs"
namename="${index}.kevs"
java ReplaceVariable ${kevscript} {node.name} ${nodeName} | java ReplaceVariable {wakeup.port} ${index} > ${nameTmp}

cd ${currentDirectory}
pwd

pid=`sudo ../newns ${log_fileName} java -Dnode.bootstrap=${namename} -Dwakeup.port=${index} -Dproject.version=1.1 -Dkevoree.corelibrary.version=3.5.3 -Dnode.name=${nodeName} -Dthread.control.library=${thread_library} -Xmx256m -Xbootclasspath/p:/tmp/ext-rt.jar:/tmp/shared-res-1.1.jar -javaagent:/tmp/ext-agent1.1.jar=squirrel -jar /tmp/kevoree-runtime-3.5.6.jar`

cd ..

wait_seconds() {
	local c
	let c=$1
	while [ $c -gt 0 ] ; do
		echo "$2 $c"
	       	sleep 1	
		let c=c-1
	done	
}

wait_seconds 14 "Downcount to dump the process"

echo "Attempting to dump process with pid: ${pid}"
sudo ./dump.sh ${pid} ${nodeName}

