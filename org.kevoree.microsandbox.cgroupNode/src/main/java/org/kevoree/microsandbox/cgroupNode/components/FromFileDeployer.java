package org.kevoree.microsandbox.cgroupNode.components;

import org.kevoree.ContainerRoot;
import org.kevoree.api.service.core.script.KevScriptEngine;
import org.kevoree.api.service.core.script.KevScriptEngineException;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.log.Log;

import java.io.*;

/**
 * Created by inti on 3/3/14.
 */
public class FromFileDeployer extends AbstractComponentType {

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
                s += tmp + "\n";
                tmp = br.readLine();
            }
            Log.debug("Reading file with new script to apply");
            KevScriptEngine scriptEngine = getKevScriptEngineFactory().createKevScriptEngine();
            return scriptEngine.addVariable("project.version",
                    System.getProperty("project.version")).
                    addVariable("kevoree.corelibrary.version", System.getProperty("kevoree.corelibrary.version")).
                    append(s).interpret();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (KevScriptEngineException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br!=null) {
                try {
                    br.close();
                } catch (IOException e) { }
            }
        }
        return null;
    }
}
