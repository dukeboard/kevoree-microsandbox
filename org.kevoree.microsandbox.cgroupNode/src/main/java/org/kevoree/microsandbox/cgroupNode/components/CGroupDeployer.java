package org.kevoree.microsandbox.cgroupNode.components;

import org.kevoree.*;
import org.kevoree.Port;
import org.kevoree.PortType;
import org.kevoree.annotation.*;
import org.kevoree.annotation.DictionaryAttribute;
import org.kevoree.api.service.core.handler.ModelListener;
import org.kevoree.api.service.core.script.KevScriptEngineException;
import org.kevoree.framework.MessagePort;
import org.kevoree.kcl.KevoreeJarClassLoader;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.cgroupNode.CGroupsNode;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeoutException;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 1/8/14
 * Time: 6:14 PM
 *
 */
@Provides({
        @ProvidedPort(name = "startNotification", type = org.kevoree.annotation.PortType.MESSAGE)
})
@org.kevoree.annotation.DictionaryType({
        @org.kevoree.annotation.DictionaryAttribute(name = "KevScriptToDeploy", optional = true, defaultValue = ""),
        @org.kevoree.annotation.DictionaryAttribute(name = "CRIU_Based_Deployment", optional = true,
                defaultValue = "false", dataType = Boolean.class),
        @org.kevoree.annotation.DictionaryAttribute(name = "distributed_deployment", optional = true,
                defaultValue = "true", dataType = Boolean.class),
        @org.kevoree.annotation.DictionaryAttribute(name = "log_file_for_experiments", optional = true, defaultValue = "")
})
@org.kevoree.annotation.ComponentType
public class CGroupDeployer extends FromFileDeployer implements ModelListener {

    SlaveRuntimeDeployer deployerStrategy;
    private long initialTime;
    private OutputStream logOutputStream;

    private boolean distributed_deployment = true;
    private long totalForkTime;
    private int countForks;

    @org.kevoree.annotation.Start
    public void start() {
        getModelService().registerModelListener(this);

        String s = getDictionary().containsKey("log_file_for_experiments")?
                getDictionary().get("log_file_for_experiments").toString():"";

        if (s.isEmpty()) {
            if (logOutputStream == null)
                logOutputStream = System.err;
        }
        else try {
            logOutputStream = new FileOutputStream(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        final String scriptFile = getDictionary().containsKey("KevScriptToDeploy")?
                getDictionary().get("KevScriptToDeploy").toString():"";
        if (scriptFile.isEmpty())
            return;
        boolean b = Boolean.parseBoolean(getDictionary().get("CRIU_Based_Deployment").toString());
        distributed_deployment = Boolean.parseBoolean(getDictionary().get("distributed_deployment").toString());
        deployerStrategy = SlaveRuntimeDeployerFactory.get(b?
                SlaveRuntimeDeployerFactory.CRIU:
                SlaveRuntimeDeployerFactory.PROCESSBasedStrategy);
        ContainerRoot model = getContainerRoot(scriptFile);

        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(model), 100);
    }

    @org.kevoree.annotation.Stop
    public void stop() {
        getModelService().unregisterModelListener(this);
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
    public void modelUpdated() { }

    @Override
    public void preRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) { }

    @Override
    public void postRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) { }

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
                another = getKevScriptEngineFactory().
                        createKevScriptEngine(another).append(locura).interpret();

                final File file = File.createTempFile("kevModel",".kevs");
                file.deleteOnExit();
                PrintWriter writer = new PrintWriter(file);
                writer.write(export(another));
                writer.close();

                Log.info("FILE => " + file.getAbsolutePath());

                printModel("New model to deploy", another);
                initialTime = System.nanoTime();
                Log.info("INITIAL NANOTIME (REMEMBER TO REMOVE THIS) {}", initialTime);

                totalForkTime = 0;
                countForks = 0;

                ThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(
                        Runtime.getRuntime().availableProcessors()/2);
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
                                    forkTime / 1000000, totalForkTime/countForks/1000000.0);
                        }
                    });
                }


            } catch (IOException e) {
                e.printStackTrace();
            } catch (KevScriptEngineException e) {
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
            getModelService().updateModel(model);
        }
    }

    private ContainerRoot calculateAcceptableArchitecture(ContainerRoot model,
                                                          Map<String, String> nodesToCreate) {
        String script = "";
        for (ContainerNode node : model.getNodes()) {
            String nodeName = node.getName();
            // I only fix something in my local node
            if (nodeName.equals(this.getNodeName())) {
                List<String> groups = new ArrayList<String>();

                for (Group group : model.getGroups())
                    for (ContainerNode child : group.getSubNodes())
                        if (child.getName().equals(nodeName))
                            groups.add(group.getName());

                // continue only if there are more than two components
                if (node.getComponents().size() <= 2) break;

                int count = -1;
                for (int i = 0 ; i < node.getComponents().size() ; ++i) {
                    ComponentInstance instance = node.getComponents().get(i);
//                    Log.info("\t{}:{}", instance.getName(), count);
                    if (instance.getName().equals(this.getName())) continue;
                    count++;
                    if (count == 0) continue;
                    String newName = "virtualNode" + count;
//                    Log.info("\t\tHERE {} and then it goes to {}", count, newName);
                    script += String.format("addNode %s : %s\n", newName, CGroupsNode.class.getSimpleName()/*CGroupsNode.class.getSimpleName()*/);
                    script += String.format("moveComponent %s@%s => %s\n",
                            instance.getName(), nodeName, newName);
                    nodesToCreate.put(instance.getName(), newName);
                }

            }
        }
        Log.info("Script:\n" + script);
        try {
            ContainerRoot another = getKevScriptEngineFactory().
                    createKevScriptEngine(model).append(script).interpret();
            return another;

        } catch (KevScriptEngineException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String addMonitoringComponents(String script, String nodeName) {
        String reasonerName = "r_" + nodeName;
        String monitoringName= "mc_" + nodeName;
        String channelName = nodeName + "defMSGT_reasoning";
        script += String.format("addComponent %s@%s : %s{ adaptiveMonitoring='false' }\n",
                reasonerName, nodeName, "MonitoringComponent");
        script += String.format("addComponent %s@%s : NumberFailureBasedHeuristicComponent\n",
                monitoringName, nodeName);
        script += String.format("addChannel %s : CamelNettyService\n", channelName);
        script += String.format("bind %s.ranking@%s => %s\n", reasonerName, nodeName, channelName);
        script += String.format("bind %s.ranking@%s => %s\n", monitoringName, nodeName , channelName);
        script += String.format("updateDictionary %s\n", channelName);
        return script;
    }

    private boolean isAcceptable(ContainerRoot model) {
        if (!distributed_deployment)
            return true;
        /*
         * So far, a model is acceptable iff for each Node n, n.components.count == 1
         */
        for (ContainerNode node : model.getNodes()) {
            if (getNodeName().equals(node.getName()) &&
                    !node.getTypeDefinition().getName().equals(CGroupsNode.class.getSimpleName()))
                return false;

            if (node.getComponents().size() > 2) {

                int flags = 0;
                for (ComponentInstance instance : node.getComponents()) {
                    if (instance.getTypeDefinition().getName().equals(CGroupDeployer.class.getSimpleName()))
                        flags|=1;
                    else if (instance.getTypeDefinition().getName().equals("MonitoringComponent"))
                        flags|=2;
                    else if (instance.getTypeDefinition().getName().equals("NumberFailureBasedHeuristicComponent"))
                        flags|=4;
                }

                if (flags == 7)
                    return true;

                Log.info("Model is wrong because there" +
                        " are more than two components per Node");
                return false;
            }
            if (node.getComponents().size() == 2
                    && !node.getName().equals(this.getNodeName())) {
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
                buffer.append("addRepo \"" + repo.getUrl() + "\"\n");

        for (DeployUnit deployUnit : model.getDeployUnits()) {
            String s = String.format("merge 'mvn:%s/%s/%s'\n",
                    deployUnit.getGroupName(),deployUnit.getUnitName(), deployUnit.getVersion());
            if (isListedPackage(s))
                buffer.append(s);
        }

        for (ContainerNode node : model.getNodes()) {
            String nodeName = node.getName();
            buffer.append("addNode " + nodeName + " : " + node.getTypeDefinition().getName() + "{\n");
            org.kevoree.Dictionary dico = node.getDictionary();
            if (dico != null) {
                for (DictionaryValue value : dico.getValues()) {
                    buffer.append(value.getAttribute().getName() + " = \"" + value.getValue() + "\"\n");
                }
            }
            buffer.append("}\n");

            for (ComponentInstance componentInstance : node.getComponents()) {
                buffer.append("addComponent " + componentInstance.getName()
                        + "@" +nodeName + " : "
                        + componentInstance.getTypeDefinition().getName() + "{\n");
                dico = componentInstance.getDictionary();
                if (dico != null) {
                    int i = 0;
                    List<DictionaryValue> values = dico.getValues();
                    for (; i < values.size() - 1; ++i) {
                        DictionaryValue value = values.get(i);
                        buffer.append(value.getAttribute().getName() + " = \'" + value.getValue() + "\',\n");
                    }
                    if (i < values.size()) {
                        DictionaryValue value = values.get(i);
                        buffer.append(value.getAttribute().getName() + " = \'" + value.getValue() + "\'\n");
                    }
                }
                buffer.append("}\n");
            }
        }

        for (Channel channel : model.getHubs()) {
            buffer.append("addChannel " + channel.getName()
                    + " : " + channel.getTypeDefinition().getName() + "{\n");
            org.kevoree.Dictionary dico = channel.getDictionary();
            if (dico != null) {
                for (DictionaryValue value : dico.getValues()) {
                    if (!value.getAttribute().getFragmentDependant())
                        buffer.append(value.getAttribute().getName() + " = \"" + value.getValue() + "\"\n");
                }
            }
            buffer.append("}\n");
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
        for (MBinding mb : model.getMBindings()) {
            Port p = mb.getPort();
            ComponentInstance comp = (ComponentInstance) p.eContainer();
            ContainerNode node = (ContainerNode) comp.eContainer();
            buffer.append("bind " + comp.getName() + "." + p.getPortTypeRef().getName() +
                    "@" + node.getName() + " => " + mb.getHub().getName() + "\n");
        }

        // update per channel dictionaries
        for (Channel channel : model.getHubs()) {
            org.kevoree.Dictionary dico = channel.getDictionary();
            if (dico != null) {
                for (DictionaryValue value : dico.getValues()) {
                    if (value.getAttribute().getFragmentDependant()) {
                        buffer.append("updateDictionary " + channel.getName()+"{");
                        buffer.append(value.getAttribute().getName() + " = '" + value.getValue() + "'");
                        buffer.append("}@"+value.getTargetNode().getName() + "\n");
                    }
                }
            }
        }

        //process group subscription
        for (Group group : model.getGroups()) {
            buffer.append("addGroup " + group.getName() + ":" +
                    group.getTypeDefinition().getName() + "\n");
            for (ContainerNode child : group.getSubNodes()) {
                buffer.append("addToGroup " + group.getName() + " " + child.getName() + "\n");
            }
        }
        return buffer.toString();
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
                if (!node.getName().startsWith(getNodeName())) {
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
                String s = String.format("unbind %s.%s@%s => %s\n", comp.getName(),
                        p.getPortTypeRef().getName(), node.getName(), channel.getName());
                buffer.append(s);
            }

            buffer.append(String.format("updateDictionary %s\n", channel.getName()));
            buffer.append("removeChannel " + channel.getName() + "\n");

            buffer.append("addChannel " + channel.getName() + "0:KevoreeSharedMemoryChannel\n");
            for (MBinding mb : channel.getBindings()) {
                Port p = mb.getPort();
                ComponentInstance comp = (ComponentInstance) p.eContainer();
                ContainerNode node = (ContainerNode) comp.eContainer();
                String s = String.format("bind %s.%s@%s => %s\n", comp.getName(),
                        p.getPortTypeRef().getName(), node.getName(), channel.getName() + "0");
                buffer.append(s);
            }
            buffer.append(String.format("updateDictionary %s0\n", channel.getName()));
        }

//        for (ContainerNode node : model.getNodes()) {
//            String nodeName = node.getName();
//            buffer.append(addMonitoringComponents("", nodeName));
//        }

        // update per channel dictionaries
        int port = 18000;
        for (Channel channel : model.getHubs()) {
            org.kevoree.Dictionary dico = channel.getDictionary();
            if (dico != null) {
                for (DictionaryValue value : dico.getValues()) {
                    if (value.getAttribute().getFragmentDependant()) {
                        buffer.append("updateDictionary " + channel.getName()+"{");
                        if (value.getAttribute().getName().equalsIgnoreCase("port")) {
                            // FIXME Ugly hack
                            if (value.getTargetNode().getName().equals("node0")) {
                                buffer.append("port = \""+10000+"\"");
                            }
                            else
                                buffer.append("port = \""+port+"\"");
                            port++;
                        }
                        else
                            buffer.append(value.getAttribute().getName() + " = \"" + value.getValue() + "\"\n");

                        buffer.append("}@"+value.getTargetNode().getName() + "\n");
                    }
                }
            }
        }

        return buffer.toString();
    }

    long totalTime = 0;
    int count = 0;

    @org.kevoree.annotation.Port(name = "startNotification")
    public void onStartNotification(Object obj) {
        String[] s = obj.toString().split(",");
        long tmp = Long.parseLong(s[1]) - initialTime;
        totalTime += tmp;
        count++;
        PrintWriter ps = new PrintWriter(logOutputStream);
        Log.info("Node {} started in {} milliseconds. (Average = {}, Total = {})",
                s[0], tmp/1000000, totalTime/1000000.0/count, totalTime/1000000);

        ps.printf("Node %s started in %d milliseconds. (Average = %f, Total = %d)\n",
                s[0], tmp / 1000000, totalTime / 1000000.0 / count, totalTime / 1000000);
        ps.flush();
    }
}
