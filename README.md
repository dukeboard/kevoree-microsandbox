kevoree-microsandbox
====================


##[Modules]
	org.kevoree.microsandbox.core - In charge of instrumenting for both: coverage and resource accounting
	org.kevoree.microsandbox.javaSENode - A new Kevoree NodeType with resource management concern
	org.kevoree.microsandbox.monitoring - Components in charge of doing the monitoring
	ResourceMonitorArtifact	- Structure that stores information about resource consumption per application
	ResourceMonitorJavaAgent	- Java Agent for instrumenting Java Application, should be refactored to keep here only the agent. I am going to move the instrumentation library to org.kevoree.microsandbox.core
	JarInstrumenter - Allows the offline instrumentation of any jar file. Used to instrument Java RT
	
##[Documentation](https://docs.google.com/document/d/1XofC_g57ZS8WYwFgBW2RBI8EZvxW_kmaPU8AsCftwkw/edit?usp=sharing)
##[Overall Architecture]()
![alt tag](https://github.com/dukeboard/kevoree-microsandbox/blob/master/documentation/overall-architecture.png)
