package org.kevoree.monitoring.strategies;

import org.kevoree.monitoring.comp.monitor.ContractVerificationRequired;
import org.kevoree.monitoring.sla.Metric;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/23/13
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
public interface MonitoringStrategy extends ContractVerificationRequired {
    void actionOnContractViolation(Metric ... metrics);
    boolean isThereContractViolation();

    void init();
    void pause();
    void stop();
}
