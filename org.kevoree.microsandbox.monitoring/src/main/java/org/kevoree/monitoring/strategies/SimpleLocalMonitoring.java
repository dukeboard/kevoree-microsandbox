package org.kevoree.monitoring.strategies;

import org.kevoree.ComponentInstance;
import org.kevoree.monitoring.comp.MyResourceConsumptionRecorder;
import org.resourceaccounting.ResourcePrincipal;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/30/13
 * Time: 10:04 PM
 *
 */
public class SimpleLocalMonitoring extends AbstractLocalMonitoringStrategy {

    public SimpleLocalMonitoring(Iterator<ComponentInstance> ranking, Object msg) {
        super(ranking, msg);
    }

    @Override
    public void verifyContract(ResourcePrincipal principal, Object obj) {
    }

    @Override
    public void onGCVerifyContract(long used, long max) {
    }

    @Override
    public void run() {
        while (ranking.hasNext()) {
            currentComponent = ranking.next();
            System.out.println("dsfdsf " + currentComponent.getName());
            ResourcePrincipal principal = getPrincipal();
            DataForCheckingContract data = getInfo(principal);
            System.out.printf("%s consumes %d CPU, %d Memory, %d Sent and %d Received\n",
                                principal.toString(),
                                data.lastCPU,
                                MyResourceConsumptionRecorder.getInstance().getMemoryConsumption(principal),
                                data.lastSent,
                                data.lastReceived
                    );
        }
        System.out.println("Done with the simple local monitoring");
    }
}
