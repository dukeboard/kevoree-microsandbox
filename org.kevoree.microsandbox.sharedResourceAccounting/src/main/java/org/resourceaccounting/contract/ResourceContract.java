package org.resourceaccounting.contract;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/18/13
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class ResourceContract implements Serializable {
    protected Map<String, Integer> map = new HashMap<String, Integer>();


    public ResourceContract() {
        map.put("CPU", Integer.MAX_VALUE);
        map.put("Memory", Integer.MAX_VALUE);
        map.put("NetworkBandwidthIn", Integer.MAX_VALUE);
        map.put("NetworkBandwidthOut", Integer.MAX_VALUE);
        map.put("IOWrite", Integer.MAX_VALUE);
        map.put("IORead", Integer.MAX_VALUE);
    }

    public int getCPU() {
        return map.get("CPU");
    }

    public int getMemory() {
        return map.get("Memory");
    }

    public int getNetworkIn() {
        return map.get("NetworkBandwidthIn");
    }

    public int getNetworkOut() {
        return map.get("NetworkBandwidthOut");
    }

    public int getWrite() {
        return map.get("IOWrite");
    }

    public int getRead() {
        return map.get("IORead");
    }

    public void setValue(String property, int n) {
        map.put(property, n);
    }

}
