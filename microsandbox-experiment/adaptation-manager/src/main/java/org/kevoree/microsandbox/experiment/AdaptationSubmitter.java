package org.kevoree.microsandbox.experiment;

import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.KevoreeInject;
import org.kevoree.annotation.Param;
import org.kevoree.annotation.Start;
import org.kevoree.api.ModelService;
import org.kevoree.api.handler.ModelListenerAdapter;
import org.kevoree.komponents.helpers.SynchronizedUpdateCallback;

import java.io.*;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 17/09/13
 * Time: 14:48
 *
 * @author Erwan Daubert
 * @version 1.0
 */
@ComponentType
public class AdaptationSubmitter {

    @Param(optional = true)
    String modelName;

    @KevoreeInject
    ModelService modelService;


    SynchronizedUpdateCallback callback;

    int index;
    String s;

    @Start
    public void start() {
        callback = new SynchronizedUpdateCallback();
        if (modelName != null) {
            index = Integer.parseInt(modelName.substring(modelName.lastIndexOf('/') + 1, modelName.lastIndexOf('.')));
        } else {
            index = 7;
        }

        modelService.registerModelListener(new ModelListenerAdapter() {

            private boolean doing = false;

            private boolean done = false;

            @Override
            public synchronized void modelUpdated() {
                if (index < 7 && !doing && !modelName.equalsIgnoreCase("none")) {
                    doing = true;

                    modelService.unregisterModelListener(this);
                    while (!done && index < 2) {
                        String tmp = s.replaceFirst("[0-9]+\\.kevs", index + ".kevs");
                        index++;
                        try {
                            Thread.sleep(15000);
                            System.out.println("Time over, now switching to " + tmp);
                        } catch (InterruptedException ignored) {
                        }

                        InputStream newModel = null;
                        try {
                            // load the new model according to the template name and the currentAdaptationDone value

                            newModel = new FileInputStream(tmp);
                            callback.initialize();
                            modelService.submitScript(loadFromStream(newModel), callback);
                            callback.waitForResult(5000);
                            // TODO maybe 5000 is too short
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (Exception ignored) {
                        } finally {
                            if (newModel != null)
                                try {
                                    newModel.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                        }
                    }


                    doing = false;
                }
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
