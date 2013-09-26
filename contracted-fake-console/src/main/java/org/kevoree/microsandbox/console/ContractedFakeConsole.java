package org.kevoree.microsandbox.console;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.MessagePort;
import org.kevoree.library.FakeConsole;
import org.kevoree.microsandbox.api.contract.CPUContracted;
import org.kevoree.microsandbox.api.contract.MemoryContracted;



@Provides({
        @ProvidedPort(name = "input", type = PortType.MESSAGE)
})
@Requires({
        @RequiredPort(name = "output", type = PortType.MESSAGE, optional = true)
})
@ComponentType
public class ContractedFakeConsole extends AbstractComponentType implements CPUContracted, MemoryContracted {
    @Start
    public void start() {

    }

    @Stop
    public void stop() {

    }

    @Port(name = "input")
    public void handleInput(Object obj) {
        int n = Integer.parseInt(obj.toString());
        // find prime factors
        int i = 2;
        while (n > 1) {
            if (n % i == 0) {
                n = n/i;
            }
            else {
                i++; // no the best solution but who cares
            }
        }
        MessagePort messagePort = getPortByName("output", MessagePort.class);
        messagePort.process(n + "");
    }
}