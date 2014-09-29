package org.kevoree.microsandbox.cgroupNode.models;

import org.kevoree.*;
import org.kevoree.Package;
import org.kevoree.impl.ContainerRootImpl;
import org.kevoree.kevscript.KevScriptEngine;
import org.kevoree.log.Log;
import org.resourceaccounting.utils.Set;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by inti on 11/06/14.
 */
public class ImportingAndExportingModels {

    public static String toString(ContainerRoot model, List<String> repositories, List<String> packages) {
        final StringBuilder buffer = new StringBuilder();
        for (Repository repo : model.getRepositories())
            if (repositories.isEmpty() || isListedRepo(repo.getUrl(), repositories))
                buffer.append("repo \"").append(repo.getUrl()).append("\"\n");

        for (Package p : model.getPackages()) {
            for (DeployUnit deployUnit : p.getDeployUnits()) {
                String s = String.format("include mvn:%s:%s:%s\n",
                        p.getName(), deployUnit.getName(), deployUnit.getVersion());
                if (packages.isEmpty() || isListedPackage(s, packages))
                    buffer.append(s);
            }
        }

        HashSet<String> addedNodes = new HashSet<String>();
        List<ContainerNode> nodes = new ArrayList<ContainerNode>();

        boolean someAdded = true;
        while (someAdded) {
            someAdded = false;
            for (ContainerNode node : model.getNodes()) {
                if (!addedNodes.contains(node.getName()) && (node.getHost() == null
                        || addedNodes.contains(node.getHost().getName()))) {
                    // no parents
                    addedNodes.add(node.getName());
                    nodes.add(node);

                    buffer.append("add ");
                    if (node.getHost() != null) {
                        buffer.append(node.getHost().getName()).append(".");
                    }
                    buffer.append(node.getName()).append(" : ").append(node.getTypeDefinition().getName()).append("\n");
                    exportDictionary(node, buffer);
                    someAdded = true;
                }
            }
        }

        for (ContainerNode node : nodes) {
            String nodeName = node.getName();

            for (ComponentInstance componentInstance : node.getComponents()) {
                buffer.append("add ").append(nodeName).append(".").append(componentInstance.getName()).append(" : ").append(componentInstance.getTypeDefinition().getName()).append("\n");
                exportDictionary(componentInstance, buffer);
            }
        }


        for (Channel channel : model.getHubs()) {
            buffer.append("add ").append(channel.getName()).append(" : ").append(channel.getTypeDefinition().getName()).append("\n");
            exportDictionary(channel, buffer);
        }

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

    private static void exportDictionary(Instance instance, StringBuilder stringBuilder) {
        if (instance.getDictionary() != null) {
            org.kevoree.Dictionary dico = instance.getDictionary();
            for (Value value : dico.getValues()) {
                stringBuilder.append("set ");
                if (instance instanceof ComponentInstance) {
                    stringBuilder.append(((ContainerNode) instance.eContainer()).getName()).append(".");
                }
                stringBuilder.append(instance.getName()).append(".").append(value.getName()).append(" = \"").append(value.getValue()).append("\"\n");
            }
        }
        for (FragmentDictionary fragmentDictionary : instance.getFragmentDictionary()) {
            for (Value value : fragmentDictionary.getValues()) {
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

    protected static boolean isListedPackage(String s, List<String> packages) {
        for (String ss : packages)
            if (s.contains(ss))
                return true;
        return false;
    }

    protected static boolean isListedRepo (String s, List<String> repositories) {
        return repositories.contains(s);
    }

    public static ContainerRoot toModel(String script) {
        if (System.getProperty("project.version") != null)
            script= script.replace("{project.version}",
                    System.getProperty("project.version"));
        if (System.getProperty("kevoree.corelibrary.version") != null)
            script= script.replace("{kevoree.corelibrary.version}",
                    System.getProperty("kevoree.corelibrary.version"));
        // FIXME modelService must be initialized and so this class must be a component type or we need to provide an empty model instead of using ModelService
        ContainerRoot mm = new ContainerRootImpl();
        return applyScriptToModel(mm, script);
    }

    public static ContainerRoot fromFile(String scriptFile,
                                                 List<String> repositories, List<String> packages) {
        String s = "";
        BufferedReader br = null;
        try {
            File f = new File(scriptFile);
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(scriptFile)
                    )
            );
            String tmp = br.readLine();
            while (tmp != null) {
                if (tmp.startsWith("include ")) {
                    String ss = tmp.replace("include ","");
                    ss = ss.replaceAll("'","");
                    ss = ss.replace("mvn:", "");
                    ss = ss.substring(0, ss.lastIndexOf(":"));
                    packages.add(ss);
                }
                else if (tmp.startsWith("repo ")) {
                    String ss = tmp.replace("repo ","");
                    ss = ss.replace("\"", "");
                    ss = ss.replace("'","");
                    repositories.add(ss);
                }
                s += tmp + "\n";
                tmp = br.readLine();
            }
//            Log.debug("Reading file with new script to apply");
            return toModel(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br!=null) {
                try {
                    br.close();
                } catch (IOException e) { }
            }
        }
        return null;
    }

    public static ContainerRoot applyScriptToModel(ContainerRoot model, String script) {
        try {
            if (script != null && !script.isEmpty()) {
//                Log.info("\tINTI - BEFOREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE\n{}", script);
                new KevScriptEngine().execute(script, model);
//                Log.info("\tINTI - AFTERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
            }
            return model;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
