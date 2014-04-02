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
The framework is implemented with a combination of Kevoree components, a Kevoree Node and a Jave Agent. Such architectures
was choosen because the Java Agent is mandatory to (de)activate the probes on demand. The "smart" part of the approach was
implemented as component because it is more elegant. However, that last decision has impact on the portability of the
implementation. Indeed, while the Java Agent and other low-level pieces are easy to port to a different application container,
the adaptive algorithm must completely rewritten for a new middleware.

![alt tag](https://raw.githubusercontent.com/dukeboard/kevoree-microsandbox/master/documentation/overall-architecture.png)

* Kevoree: app container supporting models@runtime 
* Instrumentation agent: insert/remove accounting probes
* Resource Counter: stores consumption per resource principal
* Monitoring Component compares contracts against consumption
* Ranking Component implements the heuristic
* C0 .. Cn: Useful components

