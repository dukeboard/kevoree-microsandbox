package org.kevoree.microsandbox.cgroupNode.components;

import org.kevoree.ContainerRoot;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.KevoreeInject;
import org.kevoree.api.ModelService;
import org.kevoree.cloner.DefaultModelCloner;
import org.kevoree.kevscript.KevScriptEngine;
import org.kevoree.log.Log;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by inti on 3/3/14.
 */
@ComponentType
// see further to know if the class must be a component type or not
public class FromFileDeployer {

    @KevoreeInject
    ModelService modelService;

    protected List<String> packages = new ArrayList<String>();
    protected List<String> repositories = new ArrayList<String>();

    protected boolean isListedPackage(String s) {
        for (String ss : packages)
            if (s.contains(ss))
                return true;
        return false;
    }

    protected boolean isListedRepo (String s) {
        return repositories.contains(s);
    }

    protected ContainerRoot getContainerRoot(String scriptFile) {
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
//                    Log.info(" MIERDA {}", ss);
                    packages.add(ss);
                }
                else if (tmp.startsWith("repo ")) {
                    String ss = tmp.replace("repo ","");
                    ss = ss.replace("\"", "");
                    ss = ss.replace("'","");
//                    Log.info(" MIERDA {}", ss);
                    repositories.add(ss);
                }
                s += tmp + "\n";
                tmp = br.readLine();
            }
            Log.debug("Reading file with new script to apply");
            KevScriptEngine scriptEngine = new KevScriptEngine();
            /*return scriptEngine.addVariable("project.version",
                    System.getProperty("project.version")).
                    addVariable("kevoree.corelibrary.version", System.getProperty("kevoree.corelibrary.version")).
                    append(s).interpret();*/
            s= s.replace("{project.version}", System.getProperty("project.version"));
            s= s.replace("{kevoree.corelibrary.version}", System.getProperty("kevoree.corelibrary.version"));
            // FIXME modelService mustbeinitialized and so this class must be a component type or we need to provide an empty model instead of using ModelService
            scriptEngine.execute(s, (ContainerRoot)new DefaultModelCloner().clone(modelService.getCurrentModel().getModel()));
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
}
