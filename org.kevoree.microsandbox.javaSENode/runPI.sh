#java -Xbootclasspath/p:rtNew.jar:ResourceMonitor.jar -Xmx212m -Dnode.bootstrap=runner.kev -javaagent:ResourceMonitorAgent.jar -jar kevoree.jar
java -Xbootclasspath/p:ResourceMonitor.jar -Xmx212m -Dnode.bootstrap=runner.kev -jar kevoree.jar
