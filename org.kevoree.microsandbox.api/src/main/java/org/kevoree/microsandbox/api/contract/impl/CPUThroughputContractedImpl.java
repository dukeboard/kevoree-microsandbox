package org.kevoree.microsandbox.api.contract.impl;

import jet.runtime.typeinfo.JetValueParameter;
import org.kevoree.annotation.Param;
import org.kevoree.microsandbox.api.contract.CPUContracted;
import org.kevoree.microsandbox.api.contract.ThroughputContracted;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 16:26
 */
public abstract class CPUThroughputContractedImpl implements CPUContracted, ThroughputContracted {
    @Param(optional = true)
    Double cpu_wall_time;
    @Param(optional = true)
    Long cpu_peak_percent_per_second;
    @Param(optional = true)
    Long cpu_mean_percent_per_minute;
    @Param(optional = true)
    Long cpu_mean_percent_per_hour;
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
    public void setCpu_wall_time(double p0) {
        this.cpu_wall_time = p0;
    }

    @Override
    public long getCpu_peak_percent_per_second() {
        return cpu_peak_percent_per_second;
    }

    @Override
    public void setCpu_peak_percent_per_second(@JetValueParameter(name = "<set-?>") long p0) {
        this.cpu_peak_percent_per_second = p0;
    }

    @Override
    public long getCpu_mean_percent_per_minute() {
        return cpu_mean_percent_per_minute;
    }

    @Override
    public void setCpu_mean_percent_per_minute(@JetValueParameter(name = "<set-?>") long p0) {
        this.cpu_mean_percent_per_minute = p0;
    }

    @Override
    public long getCpu_mean_percent_per_hour() {
        return cpu_mean_percent_per_hour;
    }

    @Override
    public void setCpu_mean_percent_per_hour(@JetValueParameter(name = "<set-?>") long p0) {
        this.cpu_mean_percent_per_hour = p0;
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
