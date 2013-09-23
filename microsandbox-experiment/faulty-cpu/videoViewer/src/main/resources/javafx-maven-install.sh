#!/bin/sh

mvn install:install-file -Dfile=/usr/lib/jvm/java-7-oracle/jre/lib/jfxrt.jar -DgroupId=com.oracle -DartifactId=javafx -Dversion=2.0 -Dpackaging=jar