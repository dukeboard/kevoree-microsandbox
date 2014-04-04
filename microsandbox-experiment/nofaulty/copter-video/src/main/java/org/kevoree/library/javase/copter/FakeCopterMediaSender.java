package org.kevoree.library.javase.copter;

import org.kevoree.annotation.*;
import org.kevoree.api.Port;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 28/08/13
 * Time: 17:35
 *
 * @author Erwan Daubert
 * @version 1.0
 */
@Library(name = "copterManager")
@ComponentType(description = "This component simulate the copter which send an url of the stream that it is recording")
public class FakeCopterMediaSender {

    @Param(defaultValue = "http://mirror.bigbuckbunny.de/peach/bigbuckbunny_movies/big_buck_bunny_480p_h264.mov")
    private String url;

    @Output
    Port media;

    @Start
    public void start() {
        if (media.getConnectedBindingsSize() > 0) {
            media.send(url);
        }
    }

    @Update
    public void update() {
        start();
    }
}
