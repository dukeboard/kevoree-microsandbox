package org.kevoree.microsandbox.cgroupNode.models;

import org.kevoree.*;
import org.kevoree.Dictionary;
import org.kevoree.factory.DefaultKevoreeFactory;
import org.kevoree.kevscript.KevScriptEngine;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.cgroupNode.CGroupsNode;
import org.kevoree.microsandbox.cgroupNode.components.CGroupDeployer;
import org.kevoree.modeling.api.ModelCloner;

import java.util.*;

/**
 * Created by inti on 11/06/14.
 */
public class StrategyForModelTransformation {
    public static boolean isAcceptable(ContainerRoot model, String nodeName) {
        /*
         * So far, a model is acceptable iff for each Node n, n.components.count == 1
         */
        for (ContainerNode node : model.getNodes()) {
            if (nodeName.equals(node.getName()) &&
                    !node.getTypeDefinition().getName().equals(CGroupsNode.class.getSimpleName()))
                return false;

            if (node.getComponents().size() > 2) {

                int flags = 0;
                for (ComponentInstance instance : node.getComponents()) {
                    if (instance.getTypeDefinition().getName().equals(CGroupDeployer.class.getSimpleName()))
                        flags |= 1;
                    else if (instance.getTypeDefinition().getName().equals("MonitoringComponent"))
                        flags |= 2;
                    else if (instance.getTypeDefinition().getName().equals("NumberFailureBasedHeuristicComponent"))
                        flags |= 4;
                }

                if (flags == 7)
                    return true;

                Log.error("Model is wrong because there" +
                        " are more than two components per Node");
                return false;
            }
            if (node.getComponents().size() == 2
                    && !node.getName().equals(nodeName)) {
                Log.warn("Model is wrong because even if there" +
                        " are only two components they don't include CGroupDeployer");
                return false;
            }
        }
        return true;
    }

    public static ContainerRoot transform(ContainerRoot proposedModel, String nodeName, String instanceName, Map<String, String> nodesToCreate) {
        ContainerRoot another = calculateAcceptableArchitecture(proposedModel, nodeName, instanceName, nodesToCreate);
        String locura = calculateDiffScript(another, nodeName,  nodesToCreate);

        Log.debug("Another Script:\n" + locura);


        return ImportingAndExportingModels.applyScriptToModel(another, locura);
    }



    private static ContainerRoot calculateAcceptableArchitecture(ContainerRoot model, String localNode,
                                                                 String instanceName,
                                                          Map<String, String> nodesToCreate) {
        String script = "";
        for (ContainerNode node : model.getNodes()) {
            String nodeName = node.getName();
            // I only fix something in my local node
            if (nodeName.equals(localNode)) {
                List<String> groups = new ArrayList<String>();

                for (Group group : model.getGroups())
                    for (ContainerNode child : group.getSubNodes())
                        if (child.getName().equals(nodeName))
                            groups.add(group.getName());

                // continue only if there are more than two components
                if (node.getComponents().size() <= 2) break;

                int count = -1;
                for (int i = 0; i < node.getComponents().size(); ++i) {
                    ComponentInstance instance = node.getComponents().get(i);
//                    Log.info("\t{}:{}", instance.getName(), count);
                    if (instance.getName().equals(instanceName)) continue;
                    count++;
                    if (count == 0) continue;
                    String newName = "virtualNode" + count;
//                    Log.info("\t\tHERE {} and then it goes to {}", count, newName);
                    script += String.format("add %s : %s\n", newName, CGroupsNode.class.getSimpleName());
                    script += String.format("set %s.log = \"info\"\n", newName);
                    script += String.format("set %s.started = \"true\"\n", newName);

                    script += String.format("move %s.%s %s\n",
                            nodeName, instance.getName(), newName);
                    nodesToCreate.put(instance.getName(), newName);
                }

            }
        }
        Log.debug("Script:\n" + script);

        ContainerRoot another = (ContainerRoot) new ModelCloner(new DefaultKevoreeFactory()).clone(model);
        return ImportingAndExportingModels.applyScriptToModel(another, script);
    }

    private static String calculateDiffScript(ContainerRoot model,String localNode, Map<String, String> nodesToCreate) {
        // FIXME: add new repo for channels and so on
        StringBuilder buffer = new StringBuilder();

        // check what channels must be removed
        // a channel is only removed if all its bindings are in the same node and
        // such a node is the one to split
        List<Channel> removed = new ArrayList<Channel>();
        for (Channel channel : model.getHubs()) {
            boolean toRemove = true;
            for (MBinding mb : channel.getBindings()) {
                Port p = mb.getPort();
                ComponentInstance comp = (ComponentInstance) p.eContainer();
                ContainerNode node = (ContainerNode) comp.eContainer();
                if (!node.getName().startsWith(localNode)) {
                    toRemove = false;
                    break;
                }
            }
            if (toRemove)
                removed.add(channel);
        }

        // remove old channels and add the new ones
        for (Channel channel : removed) {
            // remove all bindings
            for (MBinding mb : channel.getBindings()) {
                Port p = mb.getPort();
                ComponentInstance comp = (ComponentInstance) p.eContainer();
                ContainerNode node = (ContainerNode) comp.eContainer();
                String s = String.format("unbind %s.%s.%s %s\n", node.getName(), comp.getName(),
                        p.getPortTypeRef().getName(), channel.getName());
                buffer.append(s);
            }

            // TODO updateDictionary with nothing is quite useless
//            buffer.append(String.format("set %s\n", channel.getName()));
            buffer.append("remove " + channel.getName() + "\n");

            buffer.append("add " + channel.getName() + "0:KevoreeSharedMemoryChannel\n");
            for (MBinding mb : channel.getBindings()) {
                Port p = mb.getPort();
                ComponentInstance comp = (ComponentInstance) p.eContainer();
                ContainerNode node = (ContainerNode) comp.eContainer();
                String s = String.format("bind %s.%s.%s %s\n", node.getName(), comp.getName(),
                        p.getPortTypeRef().getName(), channel.getName() + "0");
                buffer.append(s);
            }
            // TODO updateDictionary with nothing is quite useless
            buffer.append(String.format("set %s0\n", channel.getName()));
        }

//        for (ContainerNode node : model.getNodes()) {
//            String nodeName = node.getName();
//            buffer.append(addMonitoringComponents("", nodeName));
//        }

        // update per channel dictionaries
        int port = 18000;
        for (Channel channel : model.getHubs()) {
            if (channel.getDictionary() != null) {
                org.kevoree.Dictionary dico = channel.getDictionary();
                for (Value value : dico.getValues()) {
                    buffer.append("set ");
                    buffer.append(channel.getName()).append(".").append(value.getName()).append(" = \"").append(value.getValue()).append("\"\n");
                }
            }
            Set<String> visitedNodes = new HashSet<String>();
            for (MBinding binding : channel.getBindings()) {
                Port p = binding.getPort();
                ComponentInstance comp = (ComponentInstance) p.eContainer();
                ContainerNode node = (ContainerNode) comp.eContainer();
                if (visitedNodes.contains(node.getName())) continue;
                if (node.getName().startsWith(localNode)) {
                    buffer.append(String.format("set %s.%s/%s = \"%d\"\n", channel.getName(), "port", node.getName(), 10000));
                }
                else {
                    buffer.append(String.format("set %s.%s/%s = \"%d\"\n", channel.getName(), "port", node.getName(), port++));
                }
                visitedNodes.add(node.getName());
            }
        }

        return buffer.toString();
    }
}
