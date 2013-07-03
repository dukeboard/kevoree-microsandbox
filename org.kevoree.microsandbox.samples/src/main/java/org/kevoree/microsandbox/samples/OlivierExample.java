package org.kevoree.microsandbox.samples;

import org.kevoree.microsandbox.api.ContractedComponent;

@org.kevoree.annotation.ComponentType
@org.kevoree.annotation.Library(name = "DIVERSIFY")
@org.kevoree.annotation.Provides(value = {@org.kevoree.annotation.ProvidedPort(name = "sayHello", type = org.kevoree.annotation.PortType.MESSAGE)
        ,@org.kevoree.annotation.ProvidedPort(name = "saludar", type = org.kevoree.annotation.PortType.MESSAGE)})
@org.kevoree.annotation.Requires(value = {@org.kevoree.annotation.RequiredPort(name = "askWorld", optional = true, type = org.kevoree.annotation.PortType.MESSAGE)})
public class OlivierExample extends org.kevoree.framework.AbstractComponentType implements ContractedComponent {
    public OlivierExample() {
    }

    java.util.List<java.lang.Object>  cache = new java.util.ArrayList<java.lang.Object> ();

    @org.kevoree.annotation.Start
    public void start() {
        java.lang.System.out.println(("Starting component" + (getName())));
    }

    @org.kevoree.annotation.Stop
    public void stop() {
        java.lang.System.out.println(("Stopping component" + (getName())));
    }

    @org.kevoree.annotation.Port(name = "sayHello")
    public void sayHello(java.lang.Object text) {
        new java.lang.Thread(new java.lang.Runnable() {
            public void run() {
                while (true)
                    ;
            }

        }).start();
        java.lang.System.out.print("Hello ");
        if (isPortBinded("askWorld")) {
            getPortByName("askWorld" ,org.kevoree.framework.MessagePort.class).process(text);
        }
    }

    @org.kevoree.annotation.Port(name = "saludar")
    public void saludar(java.lang.Object text) {
        cache.add(new byte[1000000]);
        java.lang.System.out.print("Hola ");
        if (isPortBinded("askWorld")) {
            getPortByName("askWorld" ,org.kevoree.framework.MessagePort.class).process(text);
        }
    }

}
