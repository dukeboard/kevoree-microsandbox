#!/bin/sh

java -Dproject.version=1.1 -Dkevoree.corelibrary.version=2.0.5 -Dnode.name=$2  -jar target/org.kevoree.microsandbox.watchdog-1.1.jar 2.0.12 $1
