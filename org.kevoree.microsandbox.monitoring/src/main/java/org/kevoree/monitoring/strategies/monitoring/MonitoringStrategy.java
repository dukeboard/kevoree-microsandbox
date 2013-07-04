package org.kevoree.monitoring.strategies.monitoring;

import org.kevoree.microsandbox.api.sla.Metric;
import org.kevoree.monitoring.comp.monitor.ContractVerificationRequired;

import java.util.EnumSet;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/23/13
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
public interface MonitoringStrategy extends ContractVerificationRequired {
    void actionOnContractViolation(Metric... metrics);
    boolean isThereContractViolation();

    void init(int startTime);
    void pause();
    void stop();
    void passWithoutViolation();

    EnumSet<Metric> getViolationOn();
}
