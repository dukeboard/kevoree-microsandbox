package org.kevoree.microsandbox.samples.interaction;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.microsandbox.api.contract.CPUContracted;
import org.kevoree.microsandbox.api.contract.ThroughputContracted;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/6/13
 * Time: 3:29 PM
 *
 */

@Provides({
        @ProvidedPort(name = "primalityTester", type = PortType.MESSAGE)
})
@ComponentType
public class CPUConsumerByPrimalityTesting extends AbstractComponentType implements CPUContracted, ThroughputContracted {


    @Port(name = "primalityTester")
    public void tester(Object obj) {
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
