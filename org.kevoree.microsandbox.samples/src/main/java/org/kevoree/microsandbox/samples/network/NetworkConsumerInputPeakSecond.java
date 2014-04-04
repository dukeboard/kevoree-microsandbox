package org.kevoree.microsandbox.samples.network;

import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Param;
import org.kevoree.annotation.Start;
import org.kevoree.annotation.Stop;
import org.kevoree.microsandbox.api.contract.impl.NetworkContractedImpl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 18:25
 */
@ComponentType
public class NetworkConsumerInputPeakSecond extends NetworkContractedImpl {

    @Param(optional = false)
    int sleepTime;
    @Param(optional = false)
    String url;
    @Param(defaultValue = "false")
    boolean violate;


    private boolean running;
    @Start
    public void startComponent() {
        running = true;
        new Thread(new Runnable() {
            public void run() {
                int total = 0;
                int c = 0;
                byte[] bytes = new byte[1024];
                int valueViolation = getNetwork_input_peak_seconds();
                while (((!violate && total + c <= valueViolation) || violate) && running) {
                    c = 0;
                    InputStream stream = null;
                    try {
                        URL urlElement = new URL(url);
                        stream = urlElement.openStream();
                        int n;
                        while ((n = stream.read(bytes)) != -1) {
                            c += n;
                        }
                        total += c;
//                        System.out.println("total received: " + total);
                        Thread.sleep(sleepTime);
                    } catch (MalformedURLException ignored) {
                        ignored.printStackTrace();
                    } catch (IOException ignored) {
                        ignored.printStackTrace();
                    } catch (InterruptedException ignored) {
                        ignored.printStackTrace();
                    } finally {
                        if (stream != null) {
                            try {
                                stream.close();
                            } catch (IOException ignored) {
                            }
                        }
                    }

                }
            }
        }).start();
    }
    @Stop
    public void stop() {
        running = false;
    }

}
