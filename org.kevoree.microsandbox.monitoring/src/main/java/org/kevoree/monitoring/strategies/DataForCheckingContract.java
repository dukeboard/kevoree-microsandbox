package org.kevoree.monitoring.strategies;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/11/13
 * Time: 4:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataForCheckingContract {
    public long lastCPU;
    public long lastSent;
    public long lastReceived;

    public DataForCheckingContract(long lastCPU, long lastSent, long lastReceived) {
        this.lastCPU = lastCPU;
        this.lastSent = lastSent;
        this.lastReceived = lastReceived;
    }
}
