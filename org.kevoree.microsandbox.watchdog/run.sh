#!/bin/sh

java -Dproject.version=1.1 -Dkevoree.corelibrary.version=3.5.3 -Dnode.name=$2  -jar target/org.kevoree.microsandbox.watchdog-1.1.jar 3.5.6 $1
