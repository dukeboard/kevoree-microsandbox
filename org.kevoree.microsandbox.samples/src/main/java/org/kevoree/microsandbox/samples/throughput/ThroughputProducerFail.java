package org.kevoree.microsandbox.samples.throughput;

import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Output;
import org.kevoree.annotation.Start;
import org.kevoree.api.Port;
import org.kevoree.microsandbox.api.contract.impl.ThroughputContractedImpl;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 18:25
 */

@ComponentType
public class ThroughputProducerFail extends ThroughputContractedImpl {

    @Output
    Port output;

    java.util.List<Object> cache = new java.util.ArrayList<Object>();

    @Start
    public void startComponent() {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    output.send("payLoadMessage");
                }
            }
        }).start();
    }
}
