package org.kevoree.monitoring.strategies.monitoring;

/**
 * Created by inti on 01/10/14.
 */
public interface MemorySubstrategy {
    public long getMemoryConsumption(Object user_data);

    void newCycle();
}
