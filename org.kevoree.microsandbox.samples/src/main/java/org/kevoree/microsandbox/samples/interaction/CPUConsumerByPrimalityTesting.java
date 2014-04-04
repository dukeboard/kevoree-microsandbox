package org.kevoree.microsandbox.samples.interaction;

import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Input;
import org.kevoree.annotation.Start;
import org.kevoree.microsandbox.api.contract.impl.CPUThroughputContractedImpl;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/6/13
 * Time: 3:29 PM
 *
 */
@ComponentType
public class CPUConsumerByPrimalityTesting extends CPUThroughputContractedImpl {

    @Start
    public void startComponent() {

    }

    @Input
    public void primalityTester(Object obj) {
        Integer n = Integer.valueOf(obj.toString());
        int c = 0;
        for (int i = 2 ; i < n ; i++)
            if (n % i == 0) c++;
        if (c == 0)
            System.out.println("Prime number : " + n);
        else
            System.out.println("Non-prime number : " + n);
    }
}
