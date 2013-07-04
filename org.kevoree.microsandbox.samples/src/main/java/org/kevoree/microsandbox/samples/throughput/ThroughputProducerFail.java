package org.kevoree.microsandbox.samples.throughput;

import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.RequiredPort;
import org.kevoree.annotation.Requires;
import org.kevoree.annotation.Start;
import org.kevoree.framework.MessagePort;
import org.kevoree.microsandbox.api.contract.ThroughputContracted;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 18:25
 */

@ComponentType
@Requires({
    @RequiredPort(name = "output")
})

public class ThroughputProducerFail extends org.kevoree.framework.AbstractComponentType implements ThroughputContracted {

    java.util.List<Object> cache = new java.util.ArrayList<Object>();

    @Start
    public void startComponent() {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    getPortByName("output", MessagePort.class).process("payLoadMessage");
                }
            }
        }).start();
    }

}
