package org.kevoree.monitoring.comp.monitor;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 9/11/13
 * Time: 1:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class InfoForContractCreation {
    public String path;
    public long maxCPU = 0;
    public long maxSent = 0;
    public long maxReceived = 0;
    public long maxWritten = 0;
    public long maxRead = 0;
    public long maxReserved = 0;

    public int allPortCalls;

    public HashMap<String, Integer> calls = new HashMap<String, Integer>();

    public boolean updatePortUsage(String name, int usage) {
        if (calls.containsKey(name)) {
            int x = calls.get(name);
            if (x < usage) {
                calls.put(name, usage);
                return true;
            }
            return false;
        }
        else {
            calls.put(name, usage);
            return true;
        }
    }
}
