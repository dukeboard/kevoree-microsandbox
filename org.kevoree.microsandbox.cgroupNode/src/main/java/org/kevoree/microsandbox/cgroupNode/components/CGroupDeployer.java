package org.kevoree.microsandbox.cgroupNode.components;

import org.kevoree.*;
import org.kevoree.core.impl.KevoreeCoreBean;
import org.kevoree.Dictionary;
import org.kevoree.Port;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.DictionaryAttribute;
import org.kevoree.annotation.*;
import org.kevoree.api.service.core.handler.ModelListener;
import org.kevoree.api.service.core.script.KevScriptEngine;
import org.kevoree.api.service.core.script.KevScriptEngineException;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.ModelHandlerServiceProxy;
import org.kevoree.library.defaultNodeTypes.JavaSENode;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.cgroupNode.CGroupsNode;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.TimeoutException;

//import org.kevoree.kevscript.KevScriptExporter;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 1/8/14
 * Time: 6:14 PM
 *
 */
@org.kevoree.annotation.DictionaryType({
        @DictionaryAttribute(name = "KevScriptToDeploy", optional = true, defaultValue = ""),
        @DictionaryAttribute(name = "CRIU_Based_Deployment", optional = true,
                defaultValue = "false", dataType = Boolean.class)
})
@ComponentType
public class CGroupDeployer extends FromFileDeployer implements ModelListener {

    SlaveRuntimeDeployer deployerStrategy;

    @Start
    public void start() {
        getModelService().registerModelListener(this);
        final String scriptFile = getDictionary().containsKey("KevScriptToDeploy")?
                getDictionary().get("KevScriptToDeploy").toString():"";
        if (scriptFile.isEmpty())
            return;
        boolean b = Boolean.parseBoolean(getDictionary().get("CRIU_Based_Deployment").toString());
        deployerStrategy = SlaveRuntimeDeployerFactory.get(b?
                SlaveRuntimeDeployerFactory.CRIU:
                SlaveRuntimeDeployerFactory.PROCESSBasedStrategy);
        ContainerRoot model = getContainerRoot(scriptFile);

        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(model), 100);
    }

    @Stop
    public void stop() {
        getModelService().unregisterModelListener(this);
    }

    @Update
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

        // print current model
        printModel("Current Model", currentModel);
        // print proposed model
        printModel("Proposed Model", proposedModel);


        if (!isAcceptable(proposedModel)) {
            Log.info("Removing model as it is");
            Map<String, String> nodesToCreate = new HashMap<String, String>();
            ContainerRoot another = calculateAcceptableArchitecture(proposedModel, nodesToCreate);
            String locura = calculateDiffScript(another, nodesToCreate);

            Log.info("Another Script:\n" + locura);

            try {
                another = getKevScriptEngineFactory().
                        createKevScriptEngine(another).append(locura).interpret();

                File file = File.createTempFile("kevModel",".kevs");
                file.deleteOnExit();
                PrintWriter writer = new PrintWriter(file);
                writer.write(export(another));
                writer.close();
                Log.info("FILE => " + file.getAbsolutePath());

                for (String nodeName : nodesToCreate.values()) {
//                    ContainerRoot anotherT0 = getKevScriptEngineFactory().
//                            createKevScriptEngine(another).append("addToGroup sync " + nodeName).interpret();
                    deployerStrategy.deploy(nodeName, file.getAbsolutePath());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (KevScriptEngineException e) {
                e.printStackTrace();
            }

            printModel("New model to deploy", another);


            Timer timer = new Timer();
            timer.schedule(new MyTimerTask(another), 100);

            return false;
        }
        Log.info("Accepting model as it is");
        return true;
    }

    class MyTimerTask extends TimerTask {
        ContainerRoot model;

        MyTimerTask(ContainerRoot model) {
            this.model = model;
        }

        @Override
        public void run() {
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

    private static String export(ContainerRoot model) {
        final StringBuilder buffer = new StringBuilder();
        for (Repository repo : model.getRepositories()) {
            buffer.append("addRepo \"" + repo.getUrl() + "\"\n");
        }

        for (DeployUnit deployUnit : model.getDeployUnits()) {
            buffer.append("merge \"mvn:" +
                    deployUnit.getGroupName() + "/" +
                    deployUnit.getUnitName() + "/" +
                    deployUnit.getVersion() + "\"\n");
        }

        for (ContainerNode node : model.getNodes()) {
            String nodeName = node.getName();
            buffer.append("addNode " + nodeName + " : " + node.getTypeDefinition().getName() + "{\n");
            Dictionary dico = node.getDictionary();
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
            Dictionary dico = channel.getDictionary();
            if (dico != null) {
                for (DictionaryValue value : dico.getValues()) {
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
        return buffer.toString();
    }
}

interface SlaveRuntimeDeployer {
    public boolean deploy(String nodeName, String fileName);
}

class CRIUStrategy implements SlaveRuntimeDeployer {

    @Override
    public boolean deploy(String nodeName, String fileName) {
        DatagramSocket socket = null;
        try {
            // restore virtual machine
            ProcessBuilder builder = new ProcessBuilder("/home/inti/tests/executingInCRIU/restore.sh",
                    nodeName);

//            if (!Files.exists(Paths.get(nodeName))) {
//                Files.createDirectory(Paths.get(nodeName));
//            }
            builder = builder.directory(new File("/home/inti/tests/executingInCRIU"));

            Process process = builder.
                    redirectOutput(ProcessBuilder.Redirect.INHERIT).
                    redirectError(ProcessBuilder.Redirect.INHERIT).start();

            socket = new DatagramSocket();
            socket.setSoTimeout(100);
            byte[] buf = String.format("%s\n%s", nodeName, fileName).getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length,
                    InetAddress.getByName("localhost"), 9876);
            byte[] buf2 = new byte[10];
            DatagramPacket packet2 = new DatagramPacket(buf2, buf2.length);
            while (true) {
                socket.send(packet);
                try {
                    socket.receive(packet2);
                    Log.info("Slave {} wake up", nodeName);
                    break; // hehe: ugly but I saved one line of code
                }
                catch (SocketTimeoutException exception) { }
            }
            socket.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

class PROCESSBasedStrategy implements SlaveRuntimeDeployer {

    @Override
    public boolean deploy(String nodeName, String fileName) {
        try {
            String jarPath = Log.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            String path = jarPath.substring(0,jarPath.lastIndexOf("/") + 1);
            ProcessBuilder builder = new ProcessBuilder("java",
                    "-Dproject.version=" + System.getProperty("project.version"),
                    "-Dkevoree.corelibrary.version=" + System.getProperty("kevoree.corelibrary.version"),
                    "-Dinterproccess.lock.library="+System.getProperty("interproccess.lock.library"),
                    "-Dthread.control.library="+System.getProperty("thread.control.library"),
                    "-Dnode.bootstrap="+fileName,
                    "-Xbootclasspath/p:"+ path +"ext-rt.jar:"
                            + path + "shared-res-1.0-SNAPSHOT.jar",
                    "-javaagent:" + path + "ext-agent1.0-SNAPSHOT.jar",
                    String.format("-Dnode.name=%s", nodeName),
                    "-jar",
                    jarPath);

            if (!Files.exists(Paths.get(nodeName))) {
                Files.createDirectory(Paths.get(nodeName));
            }
            builder = builder.directory(new File(nodeName));
            Process process = builder.
                    redirectOutput(ProcessBuilder.Redirect.INHERIT).
                    redirectError(ProcessBuilder.Redirect.INHERIT).start();

            return true;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

class SlaveRuntimeDeployerFactory {

    public static final String CRIU = "CRIU";
    public static final String PROCESSBasedStrategy = "Process";

    private SlaveRuntimeDeployerFactory() {}

    public static SlaveRuntimeDeployer get(String name) {
        if (name.equals(CRIU))
            return new CRIUStrategy();
        else if (name.equals(PROCESSBasedStrategy)) {
            return new PROCESSBasedStrategy();
        }
        else throw new RuntimeException();
    }
}
