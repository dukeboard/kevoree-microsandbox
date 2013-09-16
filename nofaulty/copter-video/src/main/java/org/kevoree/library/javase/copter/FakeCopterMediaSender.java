package org.kevoree.library.javase.copter;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.MessagePort;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 28/08/13
 * Time: 17:35
 *
 * @author Erwan Daubert
 * @version 1.0
 */
@Library(name = "copterManager")
@Requires({
        @RequiredPort(name = "media", type = PortType.MESSAGE, optional = true, needCheckDependency = true)
})
@DictionaryType({
        @DictionaryAttribute(name = "url", defaultValue = "http://mirror.bigbuckbunny.de/peach/bigbuckbunny_movies/big_buck_bunny_480p_h264.mov")
})
@ComponentType(description = "This component simulate the copter which send an url of the stream that it is recording")
public class FakeCopterMediaSender extends AbstractComponentType {

    private String url;
    private boolean isBound;

    @Start
    public void start() {
        url = getDictionary().get("url").toString();
        isBound = isPortBinded("media");
        if (isBound) {
            getPortByName("media", MessagePort.class).process(url);
        }
    }

    @Update
    public void update() {
        if (!url.equals(getDictionary().get("url").toString()) || isBound != isPortBinded("media")) {
            start();
        }
    }
}
