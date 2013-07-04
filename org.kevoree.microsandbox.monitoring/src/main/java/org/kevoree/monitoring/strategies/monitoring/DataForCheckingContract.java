package org.kevoree.monitoring.strategies.monitoring;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/11/13
 * Time: 4:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataForCheckingContract {
    public long lastCPU;
    public long lastMem;
    public long lastSent;
    public long lastReceived;
    public long lastWrite;
    public long lastRead;

    public DataForCheckingContract(long lastCPU, long lastSent,
                                   long lastReceived, long lastMem,
                                   long lastWrite, long lastRead) {
        this.lastCPU = lastCPU;
        this.lastSent = lastSent;
        this.lastReceived = lastReceived;
        this.lastMem = lastMem;
        this.lastWrite = lastWrite;
        this.lastRead = lastRead;
    }
}
