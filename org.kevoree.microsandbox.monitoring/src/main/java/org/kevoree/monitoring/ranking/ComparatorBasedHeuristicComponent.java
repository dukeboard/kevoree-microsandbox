package org.kevoree.monitoring.ranking;

import org.kevoree.ComponentInstance;
import org.kevoree.ContainerNode;
import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.microsandbox.api.contract.ContractedComponentHelper;
import org.kevoree.microsandbox.api.heuristic.RankingHeuristicComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 26/09/13
 * Time: 17:38
 *
 * @author Erwan Daubert
 * @version 1.0
 */
@ComponentType
@Provides({
        @ProvidedPort(name = "ranking", type = PortType.SERVICE, className = RankingHeuristicComponent.class)
})
public abstract class ComparatorBasedHeuristicComponent extends AbstractComponentType implements RankingHeuristicComponent {
    @Override
    @Port(name = "ranking", method = "getRankingOrder")
    public ComponentInstance[] getRankingOrder(String nodeName) {

        ContainerNode node = getModelService().getLastModel().findNodesByID(nodeName);
        if (node != null) {
            List<ComponentInstance> instances = new ArrayList<ComponentInstance>();

            for (ComponentInstance instance : node.getComponents()) {
                if (ContractedComponentHelper.instance$.isContractedComponent(instance.getTypeDefinition())) {
                    instances.add(instance);
                }
            }
            Collections.sort(instances, defineComparator());
            ComponentInstance[] instancesArray = new ComponentInstance[instances.size()];
            instances.toArray(instancesArray);
            return instancesArray;

        } else {
            return new ComponentInstance[0];
        }
    }

    abstract Comparator<ComponentInstance> defineComparator();

    @Override
    @Port(name = "ranking", method = "triggerMonitoringEvent")
    public abstract void triggerMonitoringEvent(String operation, String name, String instancePath, Long value);

}
