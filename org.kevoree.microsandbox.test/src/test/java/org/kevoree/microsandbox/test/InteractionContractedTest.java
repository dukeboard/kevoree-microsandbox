package org.kevoree.microsandbox.test;

import org.junit.Assert;
import org.junit.Test;
import org.kevoree.microsandbox.api.event.ContractViolationEvent;
import org.kevoree.microsandbox.api.sla.Metric;

import java.util.Arrays;
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
public class InteractionContractedTest extends AbstractMicroSandboxTester {

    @Test
    public void testDetectViolationAboutCPUDueToInteraction() {
        //SLA nodes[node0]/components[tester0] CPU 101008059,000000 4000000,000000
        double maxValue1 = 4000000.0;
        double maxValue2 = 8.0;
        ContractViolationEvent violation1 = new ContractViolationEvent("nodes[node0]/components[tester0]", Metric.CPU, -1.0, maxValue1);
        String violationRegex1 = violation1.toRegex();
        ContractViolationEvent violation2 = new ContractViolationEvent("nodes[node0]/components[tester0]", Metric.PortUsage, -1.0, maxValue2);
        String violationRegex2 = violation2.toRegex();

        System.out.println(violationRegex1);
        System.out.println(violationRegex2);

        String result = runSandbox("interaction/cpu-violation-throught-interaction.kevs", 30000, Arrays.asList(violationRegex1, violationRegex2));

        String[] resultsArray = result.split("\n");

        Pattern pattern = Pattern.compile(violationRegex1);
        Matcher m = pattern.matcher(resultsArray[0]);
        if (m.find()) {
            double value = Double.parseDouble(m.group(1));
            Assert.assertEquals(true, value > maxValue1);

            pattern = Pattern.compile(violationRegex2);
            m = pattern.matcher(resultsArray[1]);
            if (m.find()) {
                value = Double.parseDouble(m.group(1));
                Assert.assertEquals(true, value > maxValue2);
            } else {
                fail("Unable to find needed events");
            }
        } else {
            fail("Unable to find needed events");
        }
    }

    @Test
    public void testDetectViolationAboutCPUDueToInteractionWithMultipleSenders() {
        //SLA nodes[node0]/components[tester0] CPU 101008059,000000 4000000,000000
        double maxValue1 = 4000000.0;
        double maxValue2 = 8.0;
        ContractViolationEvent violation1 = new ContractViolationEvent("nodes[node0]/components[tester0]", Metric.CPU, -1.0, maxValue1);
        String violationRegex1 = violation1.toRegex();
        ContractViolationEvent violation2 = new ContractViolationEvent("nodes[node0]/components[tester0]", Metric.PortUsage, -1.0, maxValue2);
        String violationRegex2 = violation2.toRegex();

        System.out.println(violationRegex1);
        System.out.println(violationRegex2);

        String result = runSandbox("interaction/cpu-violation-throught-interaction-with-multiple-senders.kevs", 30000, Arrays.asList(violationRegex1, violationRegex2));

        String[] resultsArray = result.split("\n");

        Pattern pattern = Pattern.compile(violationRegex1);
        Matcher m = pattern.matcher(resultsArray[0]);
        if (m.find()) {
            double value = Double.parseDouble(m.group(1));
            Assert.assertEquals(true, value > maxValue1);
            pattern = Pattern.compile(violationRegex1);
            m = pattern.matcher(resultsArray[1]);
            if (m.find()) {
                value = Double.parseDouble(m.group(1));
                Assert.assertEquals(true, value > maxValue2);
            } else {
                fail("Unable to find needed events");
            }
        } else {
            fail("Unable to find needed events");
        }


//        String[] results = result.split("\n");

        // What is the message that tell us "the violation is due to <something>" ?
    }
}
