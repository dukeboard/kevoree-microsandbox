#!/bin/sh

java -Dproject.version=1.2.0-SNAPSHOT -Dkevoree.corelibrary.version=3.5.2 -Dnode.name=$2  -jar target/org.kevoree.microsandbox.watchdog-1.2.0-SNAPSHOT.jar 3.5.4 $1
