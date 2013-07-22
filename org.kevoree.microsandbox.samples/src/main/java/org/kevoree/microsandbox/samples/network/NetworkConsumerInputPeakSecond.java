package org.kevoree.microsandbox.samples.network;

import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.DictionaryAttribute;
import org.kevoree.annotation.DictionaryType;
import org.kevoree.annotation.Start;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.microsandbox.api.contract.FullContracted;

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

@DictionaryType({
        @DictionaryAttribute(name = "sleepTime", dataType = Integer.class, optional = false),
        @DictionaryAttribute(name = "url", dataType = String.class, optional = false),
        @DictionaryAttribute(name = "violate", defaultValue = "false", vals = {"true", "false"})
})
@ComponentType
public class NetworkConsumerInputPeakSecond extends AbstractComponentType implements FullContracted {

    @Start
    public void startComponent() {
        new Thread(new Runnable() {
            public void run() {
                int c = 0;
                byte[] bytes = new byte[1024];
                String urlString = getDictionary().get("url").toString();
                int sleepTime = Integer.parseInt(getDictionary().get("sleepTime").toString());
                boolean violate = "true".equals(getDictionary().get("violate").toString());
                int valueViolation = Integer.parseInt(getDictionary().get("network_input_peak_seconds").toString());
                while ((!violate && c + 1024 <= valueViolation) || violate) {
                    InputStream stream = null;
                    try {
                        URL url = new URL(urlString);
                        stream = url.openStream();
                        int n;
                        while ((n = stream.read(bytes)) != -1) {
//                            String ss = new String(bytes,n);
                            c += n;
                        }
                        System.out.println("total received: " + c);
                        Thread.sleep(sleepTime);
                    } catch (MalformedURLException ignored) {
                    } catch (IOException ignored) {
                    } catch (InterruptedException ignored) {
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

}
