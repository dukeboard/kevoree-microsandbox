package org.kevoree.monitoring.ranking.modelHistory;

import org.kevoree.*;
import org.kevoree.annotation.*;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Port;
import org.kevoree.annotation.PortType;
import org.kevoree.api.service.core.handler.ModelListener;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.service.handler.ModelListenerAdapter;
import org.kevoree.microsandbox.api.contract.ContractedComponentHelper;
import org.kevoree.microsandbox.api.heuristic.RankingHeuristicComponent;
import org.kevoree.monitoring.ranking.modelHistory.internal.Step;

import java.util.*;

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
    private Map<String, Long> deployTimes;

    @Override
    @Port(name = "ranking", method = "getRankingOrder")
    public ComponentInstance[] getRankingOrder(String nodeName) {
        try {
        System.out.println("Sorting components according to ModelBasedHeuristic");
        List<ComponentInstance> instances = new ArrayList<ComponentInstance>(currentModel.findNodesByID(nodeName).getComponents());
        Collections.sort(instances, defineComparator());

        Step firstStep = buildStep(instances);
        instances = firstStep.sort();

        ComponentInstance[] instancesArray = new ComponentInstance[instances.size()];
        instances.toArray(instancesArray);
        return instancesArray;
        }catch (Throwable t) {
            t.printStackTrace(System.out);
            return null;
        }
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


    private Step buildStep(List<ComponentInstance> instancesToSort) {
        Step firstStep = new Step();
        Step currentStep = firstStep;
        List<ComponentInstance> alreadySortedInstances = new ArrayList<ComponentInstance>(instancesToSort.size());

        for (ComponentInstance instance : instancesToSort) {
            if (ContractedComponentHelper.instance$.isContractedComponent(instance.getTypeDefinition()) && !alreadySortedInstances.contains(instance)) {
                currentStep.setInstances(Arrays.asList(instance));
                alreadySortedInstances.add(instance);

                Step nextStep = new Step();
                currentStep.setNextStep(nextStep);

                List<ComponentInstance> requiredInstances = new LinkedList<ComponentInstance>();
                for (org.kevoree.Port p : instance.getRequired()) {
                    for (MBinding binding : p.getBindings()) {
                        for (MBinding otherBinding : binding.getHub().getBindings()) {
                            if (otherBinding.getPort() != p) {
                                ComponentInstance requiredInstance = (ComponentInstance) otherBinding.getPort().eContainer();
                                if (ContractedComponentHelper.instance$.isContractedComponent(instance.getTypeDefinition()) && !alreadySortedInstances.contains(requiredInstance)) {
                                    requiredInstances.add(requiredInstance);
                                    alreadySortedInstances.add(requiredInstance);
                                } else if (alreadySortedInstances.contains(requiredInstance)) {
                                    firstStep.reduce(requiredInstance);
                                }
                            }
                        }
                    }
                }

                nextStep.setInstances(requiredInstances);

                Step nextStep2 = new Step();
                nextStep.setNextStep(nextStep2);

                currentStep = nextStep2;

            } else if (alreadySortedInstances.contains(instance)) {
                firstStep.reduce(instance);
            }
        }
        return firstStep;
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
                return rangAccordingToInteraction(component1, component2);
            }
        } else {
            return rangAccordingToInteraction(component1, component2);
        }
    }

    private int rangAccordingToInteraction(ComponentInstance component1, ComponentInstance component2) {
        for (org.kevoree.Port p : component1.getRequired()) {
            for (MBinding binding : p.getBindings()) {
                for (MBinding otherBinding : binding.getHub().getBindings()) {
                    if (otherBinding.getPort().eContainer() != component1 && otherBinding.getPort().eContainer() == component2) {
                        return 1;
                    }
                }
            }
        }
        for (org.kevoree.Port p : component2.getRequired()) {
            for (MBinding binding : p.getBindings()) {
                for (MBinding otherBinding : binding.getHub().getBindings()) {
                    if (otherBinding.getPort().eContainer() != component2 && otherBinding.getPort().eContainer() == component1) {
                        return 1;
                    }
                }
            }
        }
        return ranAccordingToTimeAlive(component1, component2);
    }

    private int ranAccordingToTimeAlive(ComponentInstance component1, ComponentInstance component2) {
        long deployTimeO1 = deployTimes.get(component1.path());
        long deployTimeO2 = deployTimes.get(component2.path());
        if (deployTimeO1 == 0 || deployTimeO2 == 0) {
            // that must not appear
            return 1;
        }

        return (int) (deployTimeO2 - deployTimeO1);
    }

    @Override
    @Port(name = "ranking", method = "triggerMonitoringEvent")
    public void triggerMonitoringEvent(String operation, String name, String instancePath, Long value) {
        if (name.equalsIgnoreCase("deployTime") && value != null) {
            if (operation.equalsIgnoreCase("CREATE")) {
                deployTimes.put(instancePath, value);
            } else {
                deployTimes.remove(instancePath);
            }
        }
    }

    @Start
    public void start() {
        listener = new ModelListenerHistory();
        getModelService().registerModelListener(listener);
        deployTimes = new HashMap<String, Long>();
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
