package org.kevoree.monitoring.strategies.adaptation;

import org.kevoree.*;
import org.kevoree.api.ModelService;
import org.kevoree.api.handler.UUIDModel;
import org.kevoree.factory.DefaultKevoreeFactory;
import org.kevoree.microsandbox.api.communication.MonitoringReporterFactory;
import org.kevoree.microsandbox.api.event.AdaptationEvent;
import org.kevoree.modeling.api.ModelCloner;
import org.kevoree.monitoring.sla.FaultyComponent;
import org.kevoree.monitoring.helper.SynchronizedUpdateCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/3/13
 * Time: 9:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class KillThemAll extends BasicAdaptation {

    public KillThemAll(ModelService service) {
        super(service);
    }

    @Override
    public List<FaultyComponent> adapt(String nodeName, List<FaultyComponent> faultyComponents) {
        int index = 0;
        ModelCloner cloner = new ModelCloner(new DefaultKevoreeFactory());
        UUIDModel uuidModel = modelService.getCurrentModel();
        ContainerRoot clonedModel = (ContainerRoot) cloner.clone(uuidModel.getModel());
        ContainerNode node = clonedModel.findNodesByID(nodeName);
        for (FaultyComponent c : faultyComponents) {
            MonitoringReporterFactory.reporter().trigger(new AdaptationEvent(getActionName(), c.getComponentPath()));/*.adaptation(getActionName(), c.getComponentPath());*/

            ComponentInstance cc = (ComponentInstance)clonedModel.findByPath(c.getComponentPath());
            node.removeComponents(cc);
            for (Port p : cc.getProvided()) {
                for (MBinding b : p.getBindings()) {
                    clonedModel.removeMBindings(b);
                    b.getHub().removeBindings(b);
                }
            }
            for (Port p : cc.getRequired()) {
                for (MBinding b : p.getBindings()) {
                    clonedModel.removeMBindings(b);
                    b.getHub().removeBindings(b);
                }
            }
        }
        SynchronizedUpdateCallback callback = new SynchronizedUpdateCallback();
        callback.initialize();
        modelService.compareAndSwap(clonedModel, uuidModel.getUUID(), callback);
        callback.waitForResult(5000);
        return new ArrayList<FaultyComponent>();

    }

    private String getActionName() {
        return "remove";
    }
}
