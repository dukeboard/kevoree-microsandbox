package org.kevoree.microsandbox.test;

import org.junit.Assert;
import org.junit.Test;
import org.kevoree.microsandbox.api.event.ContractViolationEvent;
import org.kevoree.microsandbox.api.event.MonitoringNotification;
import org.kevoree.microsandbox.api.sla.Metric;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 04/07/13
 * Time: 10:27
 *
 * @author Erwan Daubert
 * @version 1.0
 */
public class CPUContractedTest extends AbstractMicroSandboxTester {

    @Test
    public void testNoContractViolation() {
        double maxValue1 = 30000.0;
        MonitoringNotification notification = new MonitoringNotification(false);
        String monitoringRegex = notification.toRegex();
        ContractViolationEvent violation = new ContractViolationEvent("nodes[node0]/components[cpuComponent]", Metric.CPU, -1.0, maxValue1);
        String violationRegex = violation.toRegex();
        String result = runSandbox("cpu/cpu-sample-wall-time-good.kevs", 20000, Arrays.asList(monitoringRegex, violationRegex));
        Assert.assertEquals(true, "".equals(result) || result == null);
    }

    @Test
    public void testContractViolation() {
        EnumSet<Metric> reason =  EnumSet.noneOf(Metric.class);
        reason.add(Metric.CPU);
        double maxValue1 = 30000.0;
        MonitoringNotification notification = new MonitoringNotification(false, reason);
        String monitoringRegex = notification.toRegex();
        System.out.println(monitoringRegex);
        ContractViolationEvent violation = new ContractViolationEvent("nodes[node0]/components[cpuComponent]", Metric.CPU, -1.0, maxValue1);
        String violationRegex = violation.toRegex();
        System.out.println(violationRegex);

        String result = runSandbox("cpu/cpu-sample-wall-time-fail.kevs", 20000, Arrays.asList(monitoringRegex, violationRegex));

        Assert.assertEquals(true, result.contains(notification.toString()));

        String[] resultsArray = result.split("\n");
        Pattern pattern = Pattern.compile(violationRegex);
        Matcher m = pattern.matcher(resultsArray[1]);
        if (m.find()) {
            double value = Double.parseDouble(m.group(1));
            Assert.assertEquals(true, value > maxValue1);
        }
    }
}
