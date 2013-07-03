package org.kevoree.monitoring.strategies.adaptation;

import org.kevoree.ComponentInstance;
import org.kevoree.ContainerNode;
import org.kevoree.ContainerRoot;
import org.kevoree.api.service.core.handler.KevoreeModelHandlerService;
import org.kevoree.api.service.core.handler.KevoreeModelUpdateException;
import org.kevoree.api.service.core.handler.UUIDModel;
import org.kevoree.cloner.ModelCloner;
import org.kevoree.monitoring.sla.FaultyComponent;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/3/13
 * Time: 9:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class KillThemAll extends BasicAdaptation {

    public KillThemAll(KevoreeModelHandlerService service) {
        super(service);
    }

    @Override
    public boolean adapt(String nodeName, List<FaultyComponent> faultyComponents) {
        ModelCloner cloner = new ModelCloner();
        UUIDModel uuidModel = modelService.getLastUUIDModel();
        try {
            ContainerRoot clonedModel = cloner.clone(uuidModel.getModel());
            ContainerNode node = clonedModel.findNodesByID(nodeName);
            for (FaultyComponent c : faultyComponents) {
                clonedModel.findByPath(c.getComponentPath(), ComponentInstance.class).removeAllProvided();
                clonedModel.findByPath(c.getComponentPath(), ComponentInstance.class).removeAllRequired();
                node.removeComponents(clonedModel.findByPath(c.getComponentPath(), ComponentInstance.class));
            }
            modelService.atomicCompareAndSwapModel(uuidModel, clonedModel);
            return true;
        } catch (KevoreeModelUpdateException e) {
            return false;
        }

    }
}
