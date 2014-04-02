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

There are three sources of documentation:
1. The link in this section. It includes some discussion.
2. The accepted publication, "Scapegoat: and adaptive monitoring framework for component-based systems", WICSA 2014, Sydney, Australia
3. The presentation (It will be under the folder document after the Conference)

###[Approach description]()
![alt tag](https://raw.githubusercontent.com/dukeboard/kevoree-microsandbox/master/documentation/main-loop.png)

Note: Even if the adaptation of the system was not a big concern during the implementation of the framework, it is indeed very important
for an industrial solution. That is why we implemented a a few adaptation policies during the early stages of the experiments.
You can find them somewhere in the source code, if you are willing to do so ;-). 

###[Overall Architecture]()
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

