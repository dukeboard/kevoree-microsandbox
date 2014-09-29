package org.kevoree.library.javase.copter;

import org.kevoree.annotation.*;
import org.kevoree.api.Port;
import org.kevoree.log.Log;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 28/08/13
 * Time: 17:35
 *
 * @author Erwan Daubert
 * @version 1.0
 */
@ComponentType(description = "This component simulate the copter which send an url of the stream that it is recording")
public class FakeCopterMediaSender {

    @Param(defaultValue = "http://mirror.bigbuckbunny.de/peach/bigbuckbunny_movies/big_buck_bunny_480p_h264.mov")
    private String url;

    @Output
    Port media;

    @Start
    public void start() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.debug("Start waiting {}", System.nanoTime());
                    Thread.sleep(15000);
                    Log.debug("Stop waiting {}", System.nanoTime());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (media.getConnectedBindingsSize() > 0) {
                    Log.info("Sending info URL from {}", this.getClass().getName());
                    media.send(url);
                }
            }
        }).start();

    }

    @Update
    public void update() {
        start();
    }
}
