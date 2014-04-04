package org.kevoree.microsandbox.api.contract.impl;

import org.kevoree.annotation.Param;
import org.kevoree.microsandbox.api.contract.CPUContracted;
import org.kevoree.microsandbox.api.contract.MemoryContracted;
import org.kevoree.microsandbox.api.contract.ThroughputContracted;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 04/04/14
 * Time: 13:47
 *
 * @author Erwan Daubert
 * @version 1.0
 */
public class CPUMemoryThroughputContractedImpl implements CPUContracted, MemoryContracted, ThroughputContracted {

    @Param(optional = true)
    Double cpu_wall_time;
    @Param(optional = true)
    Long cpu_peak_percent_per_second;
    @Param(optional = true)
    Long cpu_mean_percent_per_minute;
    @Param(optional = true)
    Long cpu_mean_percent_per_hour;
    @Param(optional = true)
    Double memory_max_size;
    @Param(optional = true)
    Long memory_peak_allocation_per_second;
    @Param(optional = true)
    Long memory_peak_allocation_per_minute;
    @Param(optional = true)
    Long memory_peak_allocation_per_hour;
    @Param(optional = true)
    Integer throughput_msg_per_second;
    @Param(optional = true)
    Integer throughput_msg_per_minute;
    @Param(optional = true)
    Integer throughput_msg_per_hour;


    @Override
    public double getCpu_wall_time() {
        return cpu_wall_time;
    }

    @Override
    public void setCpu_wall_time(double cpu_wall_time) {
        this.cpu_wall_time = cpu_wall_time;
    }

    @Override
    public long getCpu_peak_percent_per_second() {
        return cpu_peak_percent_per_second;
    }

    @Override
    public void setCpu_peak_percent_per_second(long cpu_peak_percent_per_second) {
        this.cpu_peak_percent_per_second = cpu_peak_percent_per_second;
    }

    @Override
    public long getCpu_mean_percent_per_minute() {
        return cpu_mean_percent_per_minute;
    }

    @Override
    public void setCpu_mean_percent_per_minute(long cpu_mean_percent_per_minute) {
        this.cpu_mean_percent_per_minute = cpu_mean_percent_per_minute;
    }

    @Override
    public long getCpu_mean_percent_per_hour() {
        return cpu_mean_percent_per_hour;
    }

    @Override
    public void setCpu_mean_percent_per_hour(long cpu_mean_percent_per_hour) {
        this.cpu_mean_percent_per_hour = cpu_mean_percent_per_hour;
    }

    @Override
    public double getMemory_max_size() {
        return memory_max_size;
    }

    @Override
    public void setMemory_max_size(double memory_max_size) {
        this.memory_max_size = memory_max_size;
    }

    @Override
    public long getMemory_peak_allocation_per_second() {
        return memory_peak_allocation_per_second;
    }

    @Override
    public void setMemory_peak_allocation_per_second(long memory_peak_allocation_per_second) {
        this.memory_peak_allocation_per_second = memory_peak_allocation_per_second;
    }

    @Override
    public long getMemory_peak_allocation_per_minute() {
        return memory_peak_allocation_per_minute;
    }

    @Override
    public void setMemory_peak_allocation_per_minute(long memory_peak_allocation_per_minute) {
        this.memory_peak_allocation_per_minute = memory_peak_allocation_per_minute;
    }

    @Override
    public long getMemory_peak_allocation_per_hour() {
        return memory_peak_allocation_per_hour;
    }

    @Override
    public void setMemory_peak_allocation_per_hour(long memory_peak_allocation_per_hour) {
        this.memory_peak_allocation_per_hour = memory_peak_allocation_per_hour;
    }

    @Override
    public Integer getThroughput_msg_per_second() {
        return throughput_msg_per_second;
    }

    @Override
    public void setThroughput_msg_per_second(Integer throughput_msg_per_second) {
        this.throughput_msg_per_second = throughput_msg_per_second;
    }

    @Override
    public Integer getThroughput_msg_per_minute() {
        return throughput_msg_per_minute;
    }

    @Override
    public void setThroughput_msg_per_minute(Integer throughput_msg_per_minute) {
        this.throughput_msg_per_minute = throughput_msg_per_minute;
    }

    @Override
    public Integer getThroughput_msg_per_hour() {
        return throughput_msg_per_hour;
    }

    @Override
    public void setThroughput_msg_per_hour(Integer throughput_msg_per_hour) {
        this.throughput_msg_per_hour = throughput_msg_per_hour;
    }
}
