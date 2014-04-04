package org.kevoree.microsandbox.api.contract.impl;

import org.kevoree.annotation.Param;
import org.kevoree.microsandbox.api.contract.CPUContracted;
import org.kevoree.microsandbox.api.contract.NetworkContracted;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 16:26
 */
public abstract class CPUNetworkContractedImpl implements CPUContracted, NetworkContracted {
    @Param(optional = true)
    Double cpu_wall_time;
    @Param(optional = true)
    Long cpu_peak_percent_per_second;
    @Param(optional = true)
    Long cpu_mean_percent_per_minute;
    @Param(optional = true)
    Long cpu_mean_percent_per_hour;
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
    public void setCpu_peak_percent_per_second(long p0) {
        this.cpu_peak_percent_per_second = p0;
    }

    @Override
    public long getCpu_mean_percent_per_minute() {
        return cpu_mean_percent_per_minute;
    }

    @Override
    public void setCpu_mean_percent_per_minute(long p0) {
        this.cpu_mean_percent_per_minute = p0;
    }

    @Override
    public long getCpu_mean_percent_per_hour() {
        return cpu_mean_percent_per_hour;
    }

    @Override
    public void setCpu_mean_percent_per_hour(long p0) {
        this.cpu_mean_percent_per_hour = p0;
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
