package org.kevoree.microsandbox.experiment;

import org.kevoree.ContainerRoot;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.DictionaryAttribute;
import org.kevoree.annotation.DictionaryType;
import org.kevoree.annotation.Start;
import org.kevoree.api.service.core.script.KevScriptEngine;
import org.kevoree.api.service.core.script.KevScriptEngineException;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.service.handler.ModelListenerAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 17/09/13
 * Time: 14:48
 *
 * @author Erwan Daubert
 * @version 1.0
 */
@ComponentType
@DictionaryType({
        @DictionaryAttribute(name = "modelName", defaultValue = "none", optional = false)
})
public class AdaptationSubmitter extends AbstractComponentType {

    @Start
    public void start() {
        getModelService().registerModelListener(new ModelListenerAdapter() {
            private boolean doing = false;
            private boolean done = false;

            @Override
            public synchronized void modelUpdated() {
                if (!doing && !getDictionary().get("modelName").toString().equalsIgnoreCase("none")) {
                    doing = true;

                    getModelService().unregisterModelListener(this);
                    while (!done) {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException ignored) {
                        }

                        try {
                            // load the new model according to the template name and the currentAdaptationDone value
                            KevScriptEngine kengine = getKevScriptEngineFactory().createKevScriptEngine();

                            kengine.append(loadFromStream(getClass().getClassLoader().getResourceAsStream(getDictionary().get("modelName").toString())));
                            kengine.atomicInterpretDeploy();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (KevScriptEngineException ignored) {
                        }
                    }


                    doing = false;
                }
            }

            @Override
            public void preRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
            }

            @Override
            public void postRollback(ContainerRoot containerRoot, ContainerRoot containerRoot2) {
            }

            private String loadFromStream(InputStream stream) throws IOException {
                StringBuilder stringBuilder = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));

                String line = bufferedReader.readLine();
                while (line != null) {
                    stringBuilder.append(line).append("\n");
                    line = bufferedReader.readLine();
                }

                return stringBuilder.toString();
            }
        });
    }
}
