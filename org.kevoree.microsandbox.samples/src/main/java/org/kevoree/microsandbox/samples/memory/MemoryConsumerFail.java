package org.kevoree.microsandbox.samples.memory;

import org.kevoree.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 18:25
 */

@ComponentType
@Provides(value = {@ProvidedPort(name = "sayHello", type = org.kevoree.annotation.PortType.MESSAGE)
        , @org.kevoree.annotation.ProvidedPort(name = "saludar", type = org.kevoree.annotation.PortType.MESSAGE)})
@org.kevoree.annotation.Requires(value = {@org.kevoree.annotation.RequiredPort(name = "askWorld", optional = true, type = org.kevoree.annotation.PortType.MESSAGE)})
public class MemoryConsumerFail extends org.kevoree.framework.AbstractComponentType implements ContractedComponent {

    java.util.List<java.lang.Object> cache = new java.util.ArrayList<java.lang.Object>();

    @org.kevoree.annotation.Port(name = "sayHello")
    public void sayHello(java.lang.Object text) {
        new java.lang.Thread(new java.lang.Runnable() {
            public void run() {
                while (true) ;
            }
        }).start();
        java.lang.System.out.print("Hello ");
        if (isPortBinded("askWorld")) {
            getPortByName("askWorld", org.kevoree.framework.MessagePort.class).process(text);
        }
    }

    @org.kevoree.annotation.Port(name = "saludar")
    public void saludar(java.lang.Object text) {
        cache.add(new byte[1000000]);
        java.lang.System.out.print("Hola ");
        if (isPortBinded("askWorld")) {
            getPortByName("askWorld", org.kevoree.framework.MessagePort.class).process(text);
        }
    }

}
