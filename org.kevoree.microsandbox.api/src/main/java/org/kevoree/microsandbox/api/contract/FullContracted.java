package org.kevoree.microsandbox.api.contract;

import org.kevoree.annotation.Param;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 30/05/13
 * Time: 14:02
 */
public abstract class FullContracted implements CPUContracted, MemoryContracted, NetworkContracted, ThroughputContracted {
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
    @Param(optional = true)
    String throughput_msg_per_second;
    @Param(optional = true)
    String throughput_msg_per_minute;
    @Param(optional = true)
    String throughput_msg_per_hour;


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
    public Integer getNetwork_input_peak_seconds() {
        return network_input_peak_seconds;
    }

    @Override
    public void setNetwork_input_peak_seconds(Integer network_input_peak_seconds) {
        this.network_input_peak_seconds = network_input_peak_seconds;
    }

    @Override
    public Integer getNetwork_output_peak_seconds() {
        return network_output_peak_seconds;
    }

    @Override
    public void setNetwork_output_peak_seconds(Integer network_output_peak_seconds) {
        this.network_output_peak_seconds = network_output_peak_seconds;
    }

    @Override
    public Integer getNetwork_input_mean_per_minute() {
        return network_input_mean_per_minute;
    }

    @Override
    public void setNetwork_input_mean_per_minute(Integer network_input_mean_per_minute) {
        this.network_input_mean_per_minute = network_input_mean_per_minute;
    }

    @Override
    public Integer getNetwork_output_mean_per_minute() {
        return network_output_mean_per_minute;
    }

    @Override
    public void setNetwork_output_mean_per_minute(Integer network_output_mean_per_minute) {
        this.network_output_mean_per_minute = network_output_mean_per_minute;
    }

    @Override
    public Integer getNetwork_input_mean_per_hour() {
        return network_input_mean_per_hour;
    }

    @Override
    public void setNetwork_input_mean_per_hour(Integer network_input_mean_per_hour) {
        this.network_input_mean_per_hour = network_input_mean_per_hour;
    }

    @Override
    public Integer getNetwork_output_mean_per_hour() {
        return network_output_mean_per_hour;
    }

    @Override
    public void setNetwork_output_mean_per_hour(Integer network_output_mean_per_hour) {
        this.network_output_mean_per_hour = network_output_mean_per_hour;
    }

    @Override
    public String getThroughput_msg_per_second() {
        return throughput_msg_per_second;
    }

    @Override
    public void setThroughput_msg_per_second(String throughput_msg_per_second) {
        this.throughput_msg_per_second = throughput_msg_per_second;
    }

    @Override
    public String getThroughput_msg_per_minute() {
        return throughput_msg_per_minute;
    }

    @Override
    public void setThroughput_msg_per_minute(String throughput_msg_per_minute) {
        this.throughput_msg_per_minute = throughput_msg_per_minute;
    }

    @Override
    public String getThroughput_msg_per_hour() {
        return throughput_msg_per_hour;
    }

    @Override
    public void setThroughput_msg_per_hour(String throughput_msg_per_hour) {
        this.throughput_msg_per_hour = throughput_msg_per_hour;
    }
}