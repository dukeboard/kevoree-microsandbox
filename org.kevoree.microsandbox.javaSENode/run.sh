
PATH_KEVOREE=/home/inti/Desktop/Demo/
PATH_MODEL=src/main/kevs/main.kevs
LOCAL_PATH=`pwd`
cp $PATH_MODEL $PATH_KEVOREE/

cd $PATH_KEVOREE
java -Xbootclasspath/p:rtNew.jar:ResourceMonitor.jar -Xmx212m -Dnode.bootstrap=main.kevs -javaagent:ResourceMonitorAgent.jar -jar kevoree.jar
cd $LOCAL_PATH
