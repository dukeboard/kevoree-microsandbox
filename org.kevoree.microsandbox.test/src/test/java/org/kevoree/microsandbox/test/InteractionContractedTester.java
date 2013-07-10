package org.kevoree.microsandbox.test;

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
public class InteractionContractedTester extends AbstractMicroSandboxTester {

    @Test
    public void testGoodComponent() {
        //SLA nodes[node0]/components[tester0] CPU 101008059,000000 4000000,000000
        ContractViolationEvent violation = new ContractViolationEvent("nodes[node0]/components[tester0]", Metric.CPU, -1d, 4000000000000d);
        System.out.println(violation.toString());
        String regex = "SLA nodes\\[node0\\]/components\\[tester0\\] CPU (\\d*,\\d*) 4000000,000000";
        String result = runSandbox("interaction/cpu-violation-throught-interaction.kevs", 400000, Arrays.asList(regex));
        System.out.println(result.trim());

        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(result);
        if(m.find()) {
            double value = Double.parseDouble(m.group(1));

        }

//        String[] results = result.split("\n");

        // What is the message that tell us "the violation is due to <something>" ?
    }
}
