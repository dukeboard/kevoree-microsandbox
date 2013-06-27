package org.kevoree.monitoring.comp.monitor;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/23/13
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
public interface MonitoringStrategy extends ContractVerificationRequired {
    void init();
    void stop();
    void actionOnContractViolation();
}
