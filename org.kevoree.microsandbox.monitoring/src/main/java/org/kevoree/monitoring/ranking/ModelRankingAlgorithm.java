/*
package org.kevoree.monitoring.ranking;

import org.kevoree.ComponentInstance;
import org.kevoree.ContainerNode;
import org.kevoree.ContainerRoot;
import org.kevoree.api.Bootstraper;
import org.kevoree.api.service.core.handler.KevoreeModelHandlerService;
import org.kevoree.framework.service.handler.ModelListenerAdapter;
import org.kevoree.monitoring.models.ComponentExecutionInfo;

import java.util.List;

*/
/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 09/09/13
 * Time: 10:13
 *
 * @author Erwan Daubert
 * @version 1.0
 *//*

public class ModelRankingAlgorithm extends ModelListenerAdapter {
    private KevoreeModelHandlerService modelService;
    private Bootstraper bootstraper;
    private ComponentsInfoStorage componentInfo;

    private ContainerRoot currentModel;
    private List<ContainerRoot> modelHistory;

    public ModelRankingAlgorithm(KevoreeModelHandlerService modelService, Bootstraper bootstraper, ComponentsInfoStorage componentInfo) {
        this.modelService = modelService;
        this.bootstraper = bootstraper;
        this.componentInfo = componentInfo;
    }

    @Override
    public synchronized void modelUpdated() {
        if (modelService != null) {
            currentModel = modelService.getLastModel();
            modelHistory = modelService.getPreviousModel();
        }
    }

    @Override
    public void preRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
    }

    @Override
    public void postRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
    }

    public synchronized int rank(ComponentInstance component1, ComponentInstance component2) {
        if (modelHistory != null) {
            ContainerNode currentNodeModel = currentModel.findNodesByID(modelService.getNodeName());
            // check if components currently exist on the current model
            if (currentNodeModel.findComponentsByID(component1.getName()) != null && currentNodeModel.findComponentsByID(component2.getName()) != null) {
                return rankAccordingToModel(component1, component2, 1);
            } else {
                return rankWithDefault(component1, component2);
            }
        } else {
            return rankWithDefault(component1, component2);
        }
    }

    private int rankAccordingToModel(ComponentInstance component1, ComponentInstance component2, int historyIndex) {
        if (modelHistory.size() > historyIndex) {
            ContainerRoot previousModel = modelHistory.get(modelHistory.size() - historyIndex);
            ContainerNode previousNodeModel = previousModel.findNodesByID(modelService.getNodeName());
            // check if components exist on the previous model
            if (previousNodeModel.findComponentsByID(component1.getName()) != null && previousNodeModel.findComponentsByID(component2.getName()) != null) {
                return rankAccordingToModel(component1, component2, historyIndex + 1);
            } else if (previousNodeModel.findComponentsByID(component1.getName()) != null) {
                return -1;
            } else if (previousNodeModel.findComponentsByID(component2.getName()) != null) {
                return 1;
            } else {
                return rankWithDefault(component1, component2);
            }
        } else {
            return rankWithDefault(component1, component2);
        }
    }

    private int rankWithDefault(ComponentInstance component1, ComponentInstance component2) {
        // do the same thing like amount_of_time_alive
        long currentTime = System.currentTimeMillis();
        ComponentExecutionInfo x = componentInfo.getExecutionInfo(component1.path());
        ComponentExecutionInfo y = componentInfo.getExecutionInfo(component2.path());
        // TODO fix nullpointer
        if (x.timeAlive(currentTime) < y.timeAlive(currentTime)) {
            return 1;
        } else {
            return -1;
        }
    }
}
*/
