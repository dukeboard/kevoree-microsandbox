package org.kevoree.microsandbox.test;

import org.junit.Test;

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
    public void testGoodComponent() {
        runSandbox("cpu/cpu-sample-peak-percent-per-hour.kevs", 8000, Arrays.asList("ASKING FOR Integer"));
    }
}
