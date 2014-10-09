package org.kevoree.monitoring.ranking;

import org.kevoree.ComponentInstance;
import org.kevoree.ContainerNode;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Input;
import org.kevoree.annotation.KevoreeInject;
import org.kevoree.api.ModelService;
import org.kevoree.microsandbox.api.contract.ContractedComponentHelper;
import org.kevoree.microsandbox.api.heuristic.MonitoringEvent;
import org.kevoree.microsandbox.api.heuristic.RankingHeuristicComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by inti on 06/10/14.
 */
@ComponentType
public class RandomHeuristicComponent implements RankingHeuristicComponent {

    @KevoreeInject
    ModelService modelService;

    @Input
    @Override
    public ComponentInstance[] getRankingOrder(String nodeName) {
        ContainerNode node = modelService.getCurrentModel().getModel().findNodesByID(nodeName);
        if (node != null) {
            List<ComponentInstance> instances = new ArrayList<ComponentInstance>();

            for (ComponentInstance instance : node.getComponents()) {
                if (ContractedComponentHelper.instance$.isContractedComponent(instance.getTypeDefinition())) {
                    instances.add(instance);
                }
            }
            Collections.shuffle(instances);
            ComponentInstance[] instancesArray = new ComponentInstance[instances.size()];
            instances.toArray(instancesArray);
            return instancesArray;

        } else {
            return new ComponentInstance[0];
        }
    }

    @Input
    @Override
    public void triggerMonitoringEvent(MonitoringEvent event) { }
}
