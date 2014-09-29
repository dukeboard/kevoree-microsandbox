#!/bin/sh

javac ReplaceVariable.java

TMP="tmp.kevs"
echo ${TMP}

java ReplaceVariable $1 {node.name} $2 | java ReplaceVariable {wakeup.port} 1000 > ${TMP}

java -Dproject.version=1.1 -Dkevoree.corelibrary.version=5.0.1 -Dnode.name=$2  -jar target/org.kevoree.microsandbox.watchdog-1.1.jar 5.0.7 ${TMP}
