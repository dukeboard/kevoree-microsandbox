package org.kevoree.microsandbox.api.contract.impl;

import org.kevoree.annotation.Param;
import org.kevoree.microsandbox.api.contract.MemoryContracted;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 16:29
 */
public abstract class MemoryContractedImpl implements MemoryContracted {

    @Param(optional = true)
    Double memory_max_size;
    @Param(optional = true)
    Long memory_peak_allocation_per_second;
    @Param(optional = true)
    Long memory_peak_allocation_per_minute;
    @Param(optional = true)
    Long memory_peak_allocation_per_hour;

    @Override
    public double getMemory_max_size() {
        return memory_max_size;
    }

    @Override
    public void setMemory_max_size(double p0) {
        this.memory_max_size = p0;
    }

    @Override
    public long getMemory_peak_allocation_per_second() {
        return memory_peak_allocation_per_second;
    }

    @Override
    public void setMemory_peak_allocation_per_second(long p0) {
        this.memory_peak_allocation_per_second = p0;
    }

    @Override
    public long getMemory_peak_allocation_per_minute() {
        return memory_peak_allocation_per_minute;
    }

    @Override
    public void setMemory_peak_allocation_per_minute(long p0) {
        this.memory_peak_allocation_per_minute = p0;
    }

    @Override
    public long getMemory_peak_allocation_per_hour() {
        return memory_peak_allocation_per_hour;
    }

    @Override
    public void setMemory_peak_allocation_per_hour(long p0) {
        this.memory_peak_allocation_per_hour = p0;
    }
}
