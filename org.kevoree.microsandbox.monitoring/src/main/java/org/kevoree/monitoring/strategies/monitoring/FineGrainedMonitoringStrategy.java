package org.kevoree.monitoring.strategies.monitoring;

import org.kevoree.ComponentInstance;
import org.kevoree.library.defaultNodeTypes.context.KevoreeDeployManager;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.api.sla.Metric;
import org.kevoree.monitoring.comp.MyLowLevelResourceConsumptionRecorder;
import org.kevoree.monitoring.sla.FaultyComponent;
import org.resourceaccounting.LowLevelResourceMonitorProxy;
import org.resourceaccounting.ResourcePrincipal;
import org.resourceaccounting.contract.ComponentResourceContract;
import org.resourceaccounting.contract.ResourceContract;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/30/13
 * Time: 10:00 PM
 *
 */
public abstract class FineGrainedMonitoringStrategy extends AbstractMonitoringStrategy {
    public static final int NUMBER_OF_STEPS = 3;
    public static final int ELAPSED_SECONDS = NUMBER_OF_STEPS - 1;
    protected List<ComponentInstance> ranking;
    protected ComponentInstance currentComponent;
    protected EnumSet<Metric> reason;


    protected ArrayList<FaultyComponent> faultyComponents = new ArrayList<FaultyComponent>();

    public FineGrainedMonitoringStrategy(EnumSet<Metric> reason, List<ComponentInstance> ranking, Object msg) {
        super(msg);
        this.ranking = ranking;
        this.reason = reason;
    }

    protected DataForCheckingContract getInfo(ResourcePrincipal principal) {
        LowLevelResourceMonitorProxy recorder = MyLowLevelResourceConsumptionRecorder.getInstance();
        long lastCPU = recorder.getExecutedInstruction(principal);
        long lastSent = recorder.getBytesSent(principal);
        long lastReceived = recorder.getBytesReceived(principal);
        long lastMemory = recorder.getMemoryConsumption(principal);
        long lastWrite = recorder.getWrittenBytes(principal);
        long lastRead = recorder.getReadBytes(principal);
        DataForCheckingContract r = new DataForCheckingContract(lastCPU, lastSent, lastReceived, lastMemory, lastWrite, lastRead);
        return r;
    }

    protected ResourcePrincipal getPrincipal(ComponentInstance instance) {
        LowLevelResourceMonitorProxy recorder = MyLowLevelResourceConsumptionRecorder.getInstance();
        Object obj = KevoreeDeployManager.
                instance$.getRef(instance.getClass().getName() + "_tg", instance.getName());
        ThreadGroup tg = (ThreadGroup) obj;
        ResourcePrincipal p = recorder.getApplication(tg.getName());
        if (p == null) {
            Log.error("No resource principal was found with such a name: {}", tg.getName());
//            System.err.println("No resource principal was found : " + tg.getName());
//            System.exit(2);
            //throw new RuntimeException("No resource principal was found : " + tg.getName());
        }

        return p;
    }

    protected String getAppId(ComponentInstance instance) {
        LowLevelResourceMonitorProxy recorder = MyLowLevelResourceConsumptionRecorder.getInstance();
        Object obj =KevoreeDeployManager.instance$.getRef(instance.getClass().getName() + "_tg", instance.getName());
        ThreadGroup tg = (ThreadGroup) obj;
        return tg.getName();
    }

    protected void makeContractAvailable(ResourcePrincipal principal, ComponentInstance instance) {
        if (principal.getContract() == null) {
            Object obj =KevoreeDeployManager.instance$.getRef(instance.getClass().getName() + "_contract", instance.getName());
            if (obj != null && obj instanceof ResourceContract) {
                ResourceContract contract = (ResourceContract)obj;
                principal.setContract(contract);
            }
            else principal.setContract(new ComponentResourceContract(){});
        }
    }

    public List<FaultyComponent> getFaultyComponents() {
        return faultyComponents;
    }

    @Override
    public boolean cancel() {
        currentComponent = null;
        return super.cancel();
    }
}
