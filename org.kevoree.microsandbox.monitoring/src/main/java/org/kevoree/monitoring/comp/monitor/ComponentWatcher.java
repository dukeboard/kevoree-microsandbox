package org.kevoree.monitoring.comp.monitor;

import org.kevoree.monitoring.AbstractBehaviorObserver;
import org.kevoree.monitoring.comp.*;

import org.resourceaccounting.ResourcePrincipal;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/11/13
 * Time: 4:26 PM
 * To change this template use File | Settings | File Templates.
 */
class DataForCheckingContract {
    long lastCPU;
    long lastSent;
    long lastReceived;

    DataForCheckingContract(long lastCPU, long lastSent, long lastReceived) {
        this.lastCPU = lastCPU;
        this.lastSent = lastSent;
        this.lastReceived = lastReceived;
    }
}
public class ComponentWatcher extends AbstractBehaviorObserver<DataForCheckingContract> implements
        Runnable{

    private boolean isTerminated = false;
    private Set<ResourcePrincipal> principals;
    private List<ContractVerificationRequired> listeners;

    public ComponentWatcher() {
        principals = new HashSet<ResourcePrincipal>();
        listeners = new ArrayList<ContractVerificationRequired>(1);
    }

    @Override
    public void run() {
        while (!isTerminated()) {
            try{
                Thread.sleep(1000);
                ResourcePrincipal[] tmp = MyResourceConsumptionRecorder.getInstance().getApplications();

                Set<ResourcePrincipal> newSet = new HashSet<ResourcePrincipal>(tmp.length);

                for (int i = 0; i < tmp.length; i++) {
                    if (!principals.contains(tmp[i])) this.newApp(tmp[i]);
                    else this.informationChange(tmp[i]);
                    newSet.add(tmp[i]);
                }

                for (ResourcePrincipal rp : principals)
                    if (!newSet.contains(rp))
                        this.removeApp(rp);

                principals = newSet;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void setTerminated(boolean terminated) {
        isTerminated = terminated;
    }

    public synchronized boolean isTerminated() {
        return isTerminated;
    }

    @Override
    protected void updateAssociatedValue(ResourcePrincipal principal, DataForCheckingContract v) {


        for(int i = 0 ; i < listeners.size() ; i++)
            listeners.get(i).verifyContract(principal, v);

        System.out.printf("Principal %s has excuted %d instructions\n",
                principal.toString(),principal.getExecutedInstructions());
        System.out.printf("Principal %s has consumed %d CPU nanoseconds of CPU\n",
                principal.toString(), principal.getCPUUsage());

        long cpu = principal.getExecutedInstructions() - v.lastCPU;
        long sent = principal.getExecutedInstructions() - v.lastSent;
        long received = principal.getExecutedInstructions() - v.lastReceived;

        v.lastCPU = principal.getExecutedInstructions();
        v.lastSent = principal.getBytesSent();
        v.lastReceived = principal.getBytesReceived();

//        if (cpu > principal.getContract().getCPU())
//            System.out.println("Contract violated for CPU");
    }

    @Override
    protected DataForCheckingContract getNewAssociatedValue(ResourcePrincipal principal) {
        return new DataForCheckingContract(principal.getExecutedInstructions(),
                principal.getBytesSent(),
                principal.getBytesReceived());
    }

    public void addContractVerificationRequieredListener(ContractVerificationRequired verificationRequeried) {
        listeners.add(verificationRequeried);
    }
}
