package org.kevoree.microsandbox.api.contract.impl;

import org.kevoree.annotation.Param;
import org.kevoree.microsandbox.api.contract.MemoryContracted;
import org.kevoree.microsandbox.api.contract.NetworkContracted;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 16:29
 */
public abstract class MemoryNetworkContractedImpl implements MemoryContracted, NetworkContracted {
    @Param(optional = true)
    Double memory_max_size;
    @Param(optional = true)
    Long memory_peak_allocation_per_second;
    @Param(optional = true)
    Long memory_peak_allocation_per_minute;
    @Param(optional = true)
    Long memory_peak_allocation_per_hour;
    @Param(optional = true)
    Integer network_input_peak_seconds;
    @Param(optional = true)
    Integer network_output_peak_seconds;
    @Param(optional = true)
    Integer network_input_mean_per_minute;
    @Param(optional = true)
    Integer network_output_mean_per_minute;
    @Param(optional = true)
    Integer network_input_mean_per_hour;
    @Param(optional = true)
    Integer network_output_mean_per_hour;

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


    @Override
    public Integer getNetwork_input_peak_seconds() {
        return network_input_peak_seconds;
    }

    @Override
    public void setNetwork_input_peak_seconds(Integer p0) {
        this.network_input_peak_seconds = p0;
    }

    @Override
    public Integer getNetwork_output_peak_seconds() {
        return network_output_peak_seconds;
    }

    @Override
    public void setNetwork_output_peak_seconds(Integer p0) {
        this.network_output_peak_seconds = p0;
    }

    @Override
    public Integer getNetwork_input_mean_per_minute() {
        return network_input_mean_per_minute;
    }

    @Override
    public void setNetwork_input_mean_per_minute(Integer p0) {
        this.network_input_mean_per_minute = p0;
    }

    @Override
    public Integer getNetwork_output_mean_per_minute() {
        return network_output_mean_per_minute;
    }

    @Override
    public void setNetwork_output_mean_per_minute(Integer p0) {
        this.network_output_mean_per_minute = p0;
    }

    @Override
    public Integer getNetwork_input_mean_per_hour() {
        return network_input_mean_per_hour;
    }

    @Override
    public void setNetwork_input_mean_per_hour(Integer p0) {
        this.network_input_mean_per_hour = p0;
    }

    @Override
    public Integer getNetwork_output_mean_per_hour() {
        return network_output_mean_per_hour;
    }

    @Override
    public void setNetwork_output_mean_per_hour(Integer p0) {
        this.network_output_mean_per_hour = p0;
    }
}