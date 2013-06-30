mvn kevM:run

PATH_KEVOREE=/home/inti/Desktop/Demo/
PATH_MODEL=./target/classes/runner.kev
LOCAL_PATH=`pwd`
cp $PATH_MODEL $PATH_KEVOREE

cd $PATH_KEVOREE
java -Xbootclasspath/p:rtNew.jar:ResourceMonitor.jar -Xmx212m -Dnode.bootstrap=runner.kev -javaagent:ResourceMonitorAgent.jar -jar kevoree.jar
cd $LOCAL_PATH
