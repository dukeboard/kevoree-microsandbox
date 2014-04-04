package org.kevoree.microsandbox.api.contract.impl;

import org.kevoree.annotation.Param;
import org.kevoree.microsandbox.api.contract.ThroughputContracted;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 17:57
 */
public abstract class ThroughputContractedImpl implements ThroughputContracted {
    @Param(optional = true)
    Integer throughput_msg_per_second;
    @Param(optional = true)
    Integer throughput_msg_per_minute;
    @Param(optional = true)
    Integer throughput_msg_per_hour;

    @Override
    public Integer getThroughput_msg_per_second() {
        return throughput_msg_per_second;
    }

    @Override
    public void setThroughput_msg_per_second(Integer p0) {
        this.throughput_msg_per_second = p0;
    }

    @Override
    public Integer getThroughput_msg_per_minute() {
        return throughput_msg_per_minute;
    }

    @Override
    public void setThroughput_msg_per_minute(Integer p0) {
        this.throughput_msg_per_minute = p0;
    }

    @Override
    public Integer getThroughput_msg_per_hour() {
        return throughput_msg_per_hour;
    }

    @Override
    public void setThroughput_msg_per_hour(Integer p0) {
        this.throughput_msg_per_hour = p0;
    }
}
