package org.kevoree.microsandbox.monitoredNode;

import org.resourceaccounting.contract.ComponentResourceContract;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/1/13
 * Time: 3:58 PM
 */
public class KevoreeComponentResourceContract extends ComponentResourceContract {
    public KevoreeComponentResourceContract(long cpu, long mem, long sent, long received) {
        super();
        setValue("CPU",(int)cpu);
        setValue("Memory",(int)mem);
        setValue("NetworkBandwidthIn",(int)received);
        setValue("NetworkBandwidthOut",(int)sent);
    }
}
