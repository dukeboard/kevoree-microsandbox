package org.kevoree.microsandbox.api.contract.impl;

import org.kevoree.annotation.Param;
import org.kevoree.microsandbox.api.contract.NetworkContracted;
import org.kevoree.microsandbox.api.contract.ThroughputContracted;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 16:24
 */
public abstract class NetworkThroughputContractedImpl implements NetworkContracted, ThroughputContracted {
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

    @Override
    public String getThroughput_msg_per_second() {
        return throughput_msg_per_second;
    }

    @Override
    public void setThroughput_msg_per_second(String p0) {
        this.throughput_msg_per_second = p0;
    }

    @Override
    public String getThroughput_msg_per_minute() {
        return throughput_msg_per_minute;
    }

    @Override
    public void setThroughput_msg_per_minute(String p0) {
        this.throughput_msg_per_minute = p0;
    }

    @Override
    public String getThroughput_msg_per_hour() {
        return throughput_msg_per_hour;
    }

    @Override
    public void setThroughput_msg_per_hour(String p0) {
        this.throughput_msg_per_hour = p0;
    }
}
