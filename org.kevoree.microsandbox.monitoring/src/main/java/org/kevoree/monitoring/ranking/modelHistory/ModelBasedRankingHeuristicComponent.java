package org.kevoree.monitoring.ranking.modelHistory;

import org.kevoree.ComponentInstance;
import org.kevoree.ContainerNode;
import org.kevoree.ContainerRoot;
import org.kevoree.MBinding;
import org.kevoree.annotation.*;
import org.kevoree.api.Context;
import org.kevoree.api.ModelService;
import org.kevoree.api.handler.ModelListener;
import org.kevoree.api.handler.ModelListenerAdapter;
import org.kevoree.microsandbox.api.contract.ContractedComponentHelper;
import org.kevoree.microsandbox.api.heuristic.MonitoringEvent;
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
public class ModelBasedRankingHeuristicComponent implements RankingHeuristicComponent {

    private ContainerRoot currentModel;
    private List<ContainerRoot> modelHistory;

    private ModelListener listener;
    private Map<String, Long> deployTimes;

    @KevoreeInject
    ModelService modelService;
    @KevoreeInject
    Context context;

    @Override
    @Input
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
        } catch (Throwable t) {
            t.printStackTrace(System.out);
            return null;
        }
    }

    Comparator<ComponentInstance> defineComparator() {
        return new Comparator<ComponentInstance>() {
            @Override
            public int compare(ComponentInstance o1, ComponentInstance o2) {
                if (modelHistory != null) {
                    ContainerNode currentNodeModel = currentModel.findNodesByID(context.getNodeName());
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
            ContainerNode previousNodeModel = previousModel.findNodesByID(context.getNodeName());
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
    @Input
    public void triggerMonitoringEvent(MonitoringEvent event) {
        if (event.getName().equalsIgnoreCase("deployTime") && event.getValue() != null) {
            if (event.getOperation().equalsIgnoreCase("CREATE")) {
                deployTimes.put(event.getInstancePath(), event.getValue());
            } else {
                deployTimes.remove(event.getInstancePath());
            }
        }
    }

    @Start
    public void start() {
        modelHistory = new ArrayList<ContainerRoot>();
        listener = new ModelListenerHistory();
        modelService.registerModelListener(listener);
        deployTimes = new HashMap<String, Long>();
    }

    @Stop
    public void stop() {
        if (listener != null) {
            modelService.unregisterModelListener(listener);
            listener = null;
        }
    }

    @Update
    public void update() {

    }

    private class ModelListenerHistory extends ModelListenerAdapter {

        @Override
        public void modelUpdated() {
            modelHistory.add(currentModel);
            // as a feature of Kevoree2 has been removed in Kevoree3, we need to manage ourselves the storage of the modelHistory
            if (modelHistory.size() > 10) {
                modelHistory.remove(0);
            }
            currentModel = modelService.getCurrentModel().getModel();
        }

        @Override
        public void preRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
        }

        @Override
        public void postRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
        }
    }
}
