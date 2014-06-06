package org.kevoree.microsandbox.cgroupNode.components;

import org.kevoree.*;
import org.kevoree.annotation.Input;
import org.kevoree.annotation.KevoreeInject;
import org.kevoree.annotation.Param;
import org.kevoree.api.Context;
import org.kevoree.api.ModelService;
import org.kevoree.api.handler.ModelListener;
import org.kevoree.cloner.DefaultModelCloner;
import org.kevoree.kevscript.KevScriptEngine;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.cgroupNode.CGroupsNode;
import org.kevoree.microsandbox.cgroupNode.helper.SynchronizedUpdateCallback;

import java.io.*;
import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 1/8/14
 * Time: 6:14 PM
 */
@org.kevoree.annotation.ComponentType
public class CGroupDeployer extends FromFileDeployer implements ModelListener {

    @KevoreeInject
    ModelService modelService;
    @KevoreeInject
    Context context;

    @Param(optional = true, defaultValue = "")
    String log_file_for_experiments;
    @Param(optional = true, defaultValue = "")
    String KevScriptToDeploy;
    @Param(optional = true, defaultValue = "false")
    boolean CRIU_Based_Deployment;
    @Param(optional = true, defaultValue = "true")
    boolean distributed_deployment;

    SlaveRuntimeDeployer deployerStrategy;
    private long initialTime;
    private OutputStream logOutputStream;
    private long totalForkTime;
    private int countForks;

    @org.kevoree.annotation.Start
    public void start() {
        modelService.registerModelListener(this);

        if (log_file_for_experiments == null || log_file_for_experiments.isEmpty()) {
            if (logOutputStream == null)
                logOutputStream = System.err;
        } else try {
            logOutputStream = new FileOutputStream(log_file_for_experiments);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (KevScriptToDeploy==null || KevScriptToDeploy.isEmpty())
            return;

        deployerStrategy = SlaveRuntimeDeployerFactory.get(CRIU_Based_Deployment ?
                                                           SlaveRuntimeDeployerFactory.CRIU :
                                                           SlaveRuntimeDeployerFactory.PROCESSBasedStrategy);
        ContainerRoot model = getContainerRoot(KevScriptToDeploy);

        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(model), 100);
    }

    @org.kevoree.annotation.Stop
    public void stop() {
        modelService.unregisterModelListener(this);
    }

    @org.kevoree.annotation.Update
    public void update() {
        stop();
        start();
    }

    @Override
    public boolean initUpdate(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
        return true;
    }

    @Override
    public boolean afterLocalUpdate(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
        return true;
    }

    @Override
    public void modelUpdated() {
    }

    @Override
    public void preRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
    }

    @Override
    public void postRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
    }

    @Override
    public boolean preUpdate(ContainerRoot currentModel, ContainerRoot proposedModel) {

        Log.info("TRYING TO UPDATE {}", System.nanoTime());
        // print current model
        printModel("Current Model", currentModel);
        // print proposed model
        printModel("Proposed Model", proposedModel);

        Log.info("TRYING TO UPDATE (AFTER PRINTING) {}", System.nanoTime());


        if (!isAcceptable(proposedModel)) {
            Log.info("Removing model");
            Map<String, String> nodesToCreate = new HashMap<String, String>();
            ContainerRoot another = calculateAcceptableArchitecture(proposedModel, nodesToCreate);
            String locura = calculateDiffScript(another, nodesToCreate);

            Log.info("Another Script:\n" + locura);

            try {
                if (locura != null && !locura.isEmpty())
                    new KevScriptEngine().execute(locura, another);


                final File file = File.createTempFile("kevModel", ".kevs");
                file.deleteOnExit();
                PrintWriter writer = new PrintWriter(file);
                writer.write(export(another));
                writer.close();

                Log.info("FILE => " + file.getAbsolutePath());

                printModel("New model to deploy", another);
                initialTime = System.nanoTime();
                Log.debug("INITIAL NANOTIME (REMEMBER TO REMOVE THIS) {}", initialTime);

                totalForkTime = 0;
                countForks = 0;

                ThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(
                        Runtime.getRuntime().availableProcessors() / 2);
                executor.execute(new MyTimerTask(another));
                for (final String nodeName : nodesToCreate.values()) {
                    executor.execute(new Runnable() {
                        @Override
                        public void run() {
                            long forkTime = System.nanoTime();
//                    ContainerRoot anotherT0 = getKevScriptEngineFactory().
//                            createKevScriptEngine(another).append("addToGroup sync " + nodeName).interpret();
                            deployerStrategy.deploy(nodeName, file.getAbsolutePath());

                            forkTime = System.nanoTime() - forkTime;
                            totalForkTime += forkTime;
                            countForks++;

                            Log.info("Time for FORKING was {} milliseconds (Average = {})",
                                    forkTime / 1000000, totalForkTime / countForks / 1000000.0);
                        }
                    });
                }


            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
//            Timer timer = new Timer();
//            timer.schedule(new MyTimerTask(another), 50);

            return false;
        }
        Log.info("Accepting model as it is");
        if (initialTime == 0)
            initialTime = System.nanoTime();
        return true;
    }

    private class MyTimerTask extends TimerTask {
        ContainerRoot model;

        MyTimerTask(ContainerRoot model) {
            this.model = model;
        }

        @Override
        public void run() {
//            Channel ch = model.getHubs().get(0);
//            org.kevoree.Dictionary dico = ch.getDictionary();
//            if (dico != null) {
//                for (DictionaryValue value : dico.getValues()) {
//                    Log.info("La madre {} {}:{}", value.getAttribute().getName(),
//                            value.getValue(), value.getTargetNode().getName());
//                }
//            }
            SynchronizedUpdateCallback callback = new SynchronizedUpdateCallback();
            callback.initialize();
            System.out.printf("%s %s\n", modelService, model);
            modelService.update(model, callback);
            callback.waitForResult(5000);
        }
    }

    private ContainerRoot calculateAcceptableArchitecture(ContainerRoot model,
                                                          Map<String, String> nodesToCreate) {
        String script = "";
        for (ContainerNode node : model.getNodes()) {
            String nodeName = node.getName();
            // I only fix something in my local node
            if (nodeName.equals(context.getNodeName())) {
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
                    if (instance.getName().equals(context.getInstanceName())) continue;
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
        Log.info("Script:\n" + script);
        try {
            ContainerRoot another = (ContainerRoot) new DefaultModelCloner().clone(model);
            new KevScriptEngine().execute(script, another);
            return another;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String addMonitoringComponents(String script, String nodeName) {
        String reasonerName = "r_" + nodeName;
        String monitoringName = "mc_" + nodeName;
        String channelName = nodeName + "defMSGT_reasoning";
        script += String.format("add %s.%s : %s\n",
                nodeName, reasonerName, "MonitoringComponent");
        script += String.format("set %s.%s.adaptiveMonitoring = 'false'", nodeName, reasonerName);

        script += String.format("add %s@%s : NumberFailureBasedHeuristicComponent\n",
                monitoringName, nodeName);
        script += String.format("add %s : CamelNettyService\n", channelName + "1");
        script += String.format("bind %s.%s.getRankingOrder %s\n", nodeName, reasonerName, channelName+ "1");
        script += String.format("bind %s.%s.getRankingOrder %s\n", nodeName, monitoringName, channelName+ "1");
//        script += String.format("updateDictionary %s\n", channelName+ "1");
        script += String.format("add %s : CamelNettyService\n", channelName + "2");
        script += String.format("bind %s.%s.triggerMonitoringEvent %s\n", nodeName, reasonerName, channelName+ "2");
        script += String.format("bind %s.%s.triggerMonitoringEvent %s\n", nodeName, monitoringName, channelName+ "2");
//        script += String.format("updateDictionary %s\n", channelName+ "2");

        // FIXME maybe we need to fix port parameter for the channel
        return script;
    }

    private boolean isAcceptable(ContainerRoot model) {
        if (!distributed_deployment)
            return true;
        /*
         * So far, a model is acceptable iff for each Node n, n.components.count == 1
         */
        for (ContainerNode node : model.getNodes()) {
            if (context.getNodeName().equals(node.getName()) &&
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

                Log.info("Model is wrong because there" +
                        " are more than two components per Node");
                return false;
            }
            if (node.getComponents().size() == 2
                    && !node.getName().equals(context.getNodeName())) {
                Log.info("Model is wrong because even if there" +
                        " are only two components they don't include CGroupDeployer");
                return false;
            }
        }
        return true;
    }

    private void printModel(String title, ContainerRoot model) {
        Log.debug("Model: {}\n", title);
        for (ContainerNode node : model.getNodes()) {
            Log.debug("Node - {} : {}\n", node.getName(),
                    node.getTypeDefinition().getName());
            for (ComponentInstance componentInstance : node.getComponents()) {
                Log.debug("\t=> {} : {}\n", componentInstance.getName(),
                        componentInstance.getTypeDefinition().getName());
            }
        }
    }

    private String export(ContainerRoot model) {
        final StringBuilder buffer = new StringBuilder();
        for (Repository repo : model.getRepositories())
            if (isListedRepo(repo.getUrl()))
                buffer.append("repo \"").append(repo.getUrl()).append("\"\n");

        for (DeployUnit deployUnit : model.getDeployUnits()) {
            String s = String.format("include mvn:%s:%s:%s\n",
                    deployUnit.getGroupName(), deployUnit.getName(), deployUnit.getVersion());
            if (isListedPackage(s))
                buffer.append(s);
        }

        for (ContainerNode node : model.getNodes()) {
            String nodeName = node.getName();
            buffer.append("add ");
            if (node.getHost() != null) {
                buffer.append(node.getHost().getName()).append(".");
            }
            buffer.append(nodeName).append(" : ").append(node.getTypeDefinition().getName()).append("\n");
            exportDictionary(node, buffer);

            for (ComponentInstance componentInstance : node.getComponents()) {
                buffer.append("add ").append(nodeName).append(".").append(componentInstance.getName()).append(" : ").append(componentInstance.getTypeDefinition().getName()).append("\n");
                exportDictionary(componentInstance, buffer);
            }
        }

        for (Channel channel : model.getHubs()) {
            buffer.append("add ").append(channel.getName()).append(" : ").append(channel.getTypeDefinition().getName()).append("\n");
            exportDictionary(channel, buffer);
        }


        //process instance creation
//            model.visit(new ModelVisitor() {
//                @Override
//                public void visit(KMFContainer kmfContainer, String s, KMFContainer kmfContainer2) {
//                    if (kmfContainer instanceof Instance) {
//                        Instance currentInstance = (Instance) kmfContainer;
//                        String instanceID = null;
//
//                        if (currentInstance instanceof ComponentInstance) {
//                            Instance nodeParent = (Instance) kmfContainer.eContainer();
//                            instanceID = nodeParent.getName() + "." + currentInstance.getName();
//                            buffer.append("add " + instanceID + " : " + currentInstance.getTypeDefinition().getName() + "/" + currentInstance.getTypeDefinition().getVersion() + "\n");
//                        } else {
//                            instanceID = currentInstance.getName();
//                            buffer.append("add " + instanceID + " : " + currentInstance.getTypeDefinition().getName() + "/" + currentInstance.getTypeDefinition().getVersion() + "\n");
//                        }
//                        //output all the dictionary
//                        Dictionary dico = currentInstance.getDictionary();
//                        if (dico != null) {
//                            for (DictionaryValue value : dico.getValues()) {
//                                buffer.append("set " + instanceID + "." + value.getName() + " = \"" + value.getValue() + "\"\n");
//                            }
//                        }
//                        for (FragmentDictionary fdic : currentInstance.getFragmentDictionary()) {
//                            for (DictionaryValue value : fdic.getValues()) {
//                                buffer.append("set " + instanceID + "." + value.getName() + "/" + fdic.getName() + " = \"" + value.getValue() + "\"\n");
//                            }
//                        }
//                        buffer.append("set " + instanceID + ".started = \"" + currentInstance.getStarted() + "\"\n");
//                    }
//                }
//            }, true, true, false);
        //process binding
        for (MBinding mb : model.getmBindings()) {
            Port p = mb.getPort();
            ComponentInstance comp = (ComponentInstance) p.eContainer();
            ContainerNode node = (ContainerNode) comp.eContainer();
            buffer.append("bind ").append(node.getName()).append(".").append(comp.getName()).append(".").append(p.getPortTypeRef().getName()).append(" ").append(mb.getHub().getName()).append("\n");
        }

        //process group subscription
        for (Group group : model.getGroups()) {
            buffer.append("add ").append(group.getName()).append(":").append(group.getTypeDefinition().getName()).append("\n");
            exportDictionary(group, buffer);
            for (ContainerNode child : group.getSubNodes()) {
                buffer.append("attach ").append(child.getName()).append(" ").append(group.getName()).append("\n");
            }
        }
        return buffer.toString();
    }

    private void exportDictionary(Instance instance, StringBuilder stringBuilder) {
        if (instance.getDictionary() != null) {
            org.kevoree.Dictionary dico = instance.getDictionary();
            for (DictionaryValue value : dico.getValues()) {
                stringBuilder.append("set ");
                if (instance instanceof ContainerNode && ((ContainerNode) instance).getHost() != null) {
                    stringBuilder.append(((ContainerNode) instance).getHost().getName()).append(".");
                } else if (instance instanceof ComponentInstance) {
                    stringBuilder.append(((ContainerNode) instance.eContainer()).getName()).append(".");
                }
                stringBuilder.append(instance.getName()).append(".").append(value.getName()).append(" = \"").append(value.getValue()).append("\"\n");
            }
        }
        for (FragmentDictionary fragmentDictionary : instance.getFragmentDictionary()) {
            for (DictionaryValue value : fragmentDictionary.getValues()) {
                stringBuilder.append("set ");
                if (instance instanceof ContainerNode && ((ContainerNode) instance).getHost() != null) {
                    stringBuilder.append(((ContainerNode) instance).getHost().getName()).append(".");
                } else if (instance instanceof ComponentInstance) {
                    stringBuilder.append(((ContainerNode) instance.eContainer()).getName()).append(".");
                }
                stringBuilder.append(instance.getName()).append(".").append(value.getName()).append("/").append(fragmentDictionary.getName()).append(" = \"").append(value.getValue()).append("\"\n");
            }
        }
    }

    private String calculateDiffScript(ContainerRoot model, Map<String, String> nodesToCreate) {
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
                if (!node.getName().startsWith(context.getNodeName())) {
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
                for (DictionaryValue value : dico.getValues()) {
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
                if (node.getName().startsWith(context.getNodeName())) {
                    buffer.append(String.format("set %s.%s/%s = \"%d\"\n", channel.getName(), "port", node.getName(), 10000));
                }
                else {
                    buffer.append(String.format("set %s.%s/%s = \"%d\"\n", channel.getName(), "port", node.getName(), port++));
                }
                visitedNodes.add(node.getName());
//                binding.
//                System.out.printf("\tttttt %s\n", binding.eContainer());
//                if (binding.eContainer())
            }
//            boolean b = true;
//            while(b);
//            for (FragmentDictionary fragmentDictionary : channel.getFragmentDictionary()) {
//                for (DictionaryValue value : fragmentDictionary.getValues()) {
//
//                    buffer.append("set ");
//                    buffer.append(channel.getName()).append(".").append(value.getName()).append("/").append(fragmentDictionary.getName());
//                    if (value.getName().equalsIgnoreCase("port")) {
//                        // FIXME Ugly hack
//                        if (fragmentDictionary.getName().equals("node0")) {
//                            buffer.append(" = \"" + 10000 + "\"");
//                        } else
//                            buffer.append(" = \"" + port + "\"");
//                        port++;
//                    } else {
//                        buffer.append(" = \"").append(value.getValue()).append("\"\n");
//                    }
//                }
//            }
        }

        return buffer.toString();
    }

    long totalTime = 0;
    int count = 0;

    @Input
    public void startNotification(Object obj) {
        String[] s = obj.toString().split(",");
        long tmp = Long.parseLong(s[1]) - initialTime;
        totalTime += tmp;
        count++;
        PrintWriter ps = new PrintWriter(logOutputStream);
        Log.info("Node {} started in {} milliseconds. (Average = {}, Total = {})",
                s[0], tmp / 1000000, totalTime / 1000000.0 / count, totalTime / 1000000);

        ps.printf("Node %s started in %d milliseconds. (Average = %f, Total = %d)\n",
                s[0], tmp / 1000000, totalTime / 1000000.0 / count, totalTime / 1000000);
        ps.flush();
    }
}
