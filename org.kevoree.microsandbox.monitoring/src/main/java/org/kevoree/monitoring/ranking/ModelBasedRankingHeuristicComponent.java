package org.kevoree.monitoring.ranking;

import org.kevoree.ComponentInstance;
import org.kevoree.ContainerNode;
import org.kevoree.ContainerRoot;
import org.kevoree.annotation.*;
import org.kevoree.api.service.core.handler.ModelListener;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.service.handler.ModelListenerAdapter;
import org.kevoree.microsandbox.api.heuristic.RankingHeuristicComponent;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 26/09/13
 * Time: 16:43
 *
 * @author Erwan Daubert
 * @version 1.0
 */

@ComponentType
@Provides({
        @ProvidedPort(name = "ranking", type = PortType.SERVICE, className = RankingHeuristicComponent.class)
})
public class ModelBasedRankingHeuristicComponent extends AbstractComponentType implements RankingHeuristicComponent {

    private ContainerRoot currentModel;
    private List<ContainerRoot> modelHistory;

    private ModelListener listener;

    @Override
    @Port(name = "ranking", method = "getRankingOrder")
    public ComponentInstance[] getRankingOrder(String nodeName) {
        List<ComponentInstance> instances = currentModel.findNodesByID(nodeName).getComponents();
        Collections.sort(instances, defineComparator());
        ComponentInstance[] instancesArray = new ComponentInstance[instances.size()];
        instances.toArray(instancesArray);
        return instancesArray;
    }

    Comparator<ComponentInstance> defineComparator() {
        return new Comparator<ComponentInstance>() {
            @Override
            public int compare(ComponentInstance o1, ComponentInstance o2) {
                if (modelHistory != null) {
                    ContainerNode currentNodeModel = currentModel.findNodesByID(getModelService().getNodeName());
                    // check if components currently exist on the current model
                    if (currentNodeModel.findComponentsByID(o1.getName()) != null && currentNodeModel.findComponentsByID(o2.getName()) != null) {
                        return rankAccordingToModel(o1, o2, 1);
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        };
    }

    private int rankAccordingToModel(ComponentInstance component1, ComponentInstance component2, int historyIndex) {
        if (modelHistory.size() > historyIndex) {
            ContainerRoot previousModel = modelHistory.get(modelHistory.size() - historyIndex);
            ContainerNode previousNodeModel = previousModel.findNodesByID(getModelService().getNodeName());
            // check if components exist on the previous model
            if (previousNodeModel.findComponentsByID(component1.getName()) != null && previousNodeModel.findComponentsByID(component2.getName()) != null) {
                return rankAccordingToModel(component1, component2, historyIndex + 1);
            } else if (previousNodeModel.findComponentsByID(component1.getName()) != null) {
                return -1;
            } else if (previousNodeModel.findComponentsByID(component2.getName()) != null) {
                return 1;
            } else {

                return -1;
            }
        } else {
            return -1;
        }
    }

    @Override
    @Port(name = "ranking", method = "triggerMonitoringEvent")
    public void triggerMonitoringEvent(String operation, String name, String instancePath, Long value) {
    }

    @Start
    public void start() {
        listener = new ModelListenerHistory();
        getModelService().registerModelListener(listener);
    }

    @Stop
    public void stop() {
        if (listener != null) {
            getModelService().unregisterModelListener(listener);
            listener = null;
        }
    }

    @Update
    public void update() {

    }

    private class ModelListenerHistory extends ModelListenerAdapter {

        @Override
        public void modelUpdated() {
            currentModel = getModelService().getLastModel();
            modelHistory = getModelService().getPreviousModel();
        }

        @Override
        public void preRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
        }

        @Override
        public void postRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
        }
    }
}
