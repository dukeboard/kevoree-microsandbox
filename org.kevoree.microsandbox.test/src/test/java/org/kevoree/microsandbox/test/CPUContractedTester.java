package org.kevoree.microsandbox.test;

import org.junit.Assert;
import org.junit.Test;
import org.kevoree.microsandbox.api.event.ContractViolationEvent;
import org.kevoree.microsandbox.api.sla.Metric;

import java.util.Arrays;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 04/07/13
 * Time: 10:27
 *
 * @author Erwan Daubert
 * @version 1.0
 */
public class CPUContractedTester extends AbstractMicroSandboxTester {

    @Test
    public void testNoContractViolation() {
        double maxValue1 = 30000.0;
        ContractViolationEvent violation1 = new ContractViolationEvent("nodes[node0]/components[cpuComponent]", Metric.CPU, -1.0, maxValue1);
        String violationRegex = violation1.toRegex();
        String result = runSandbox("cpu/cpu-sample-wall-time-good.kevs", 15000, Arrays.asList(violationRegex));
        Assert.assertEquals("".equals(result) || result == null, true);
    }

    @Test
    public void testContractViolation() {
        double maxValue1 = 300.0;
        ContractViolationEvent violation1 = new ContractViolationEvent("nodes[node0]/components[cpuComponent]", Metric.CPU, -1.0, maxValue1);
        String violationRegex = violation1.toRegex();
        String result = runSandbox("cpu/cpu-sample-wall-time-fail.kevs", 200000, Arrays.asList(violationRegex));
        Assert.assertEquals("".equals(result) || result == null, true);
    }
}
