package org.daum.library.javase.copterManager.javafx;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.MessagePort;
import org.kevoree.microsandbox.api.contract.CPUContracted;
import org.kevoree.microsandbox.api.contract.MemoryContracted;
import org.kevoree.microsandbox.api.contract.ThroughputContracted;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 01/08/13
 * Time: 11:36
 *
 * @author Erwan Daubert
 * @version 1.0
 */
@Library(name = "javafx", names = {"copterManager"})
@DictionaryType({
        @DictionaryAttribute(name = "wsURL", defaultValue = "ws://localhost:8092/followmanager", optional = true),
        @DictionaryAttribute(name = "uselessParameter", optional = true)
})
@Requires({
        @RequiredPort(name = "handle", type = PortType.MESSAGE, optional = false, needCheckDependency = true)
})
@ComponentType
public class WebSocketClientHandler extends AbstractComponentType implements MemoryContracted, CPUContracted, ThroughputContracted {

    final String scriptOnOpen = "showMessage('Connected!')";
    final String scriptOnClose = "showMessage('Lost connection')";

    private WebSocketClient client;
    private String wsURL;

    @Start
    public void start() throws InterruptedException, URISyntaxException {
        wsURL = getDictionary().get("wsURL").toString();
        client = new WebSocketClientImpl(new URI(wsURL));
        client.connectBlocking();
    }

    @Stop
    public void stop() throws InterruptedException {
        if (client != null) {
            client.closeBlocking();
            client = null;
        }
    }

    @Update
    public void update() throws InterruptedException, URISyntaxException {
        if (!wsURL.equals(getDictionary().get("wsURL").toString())) {
            start();
            stop();
        }
    }

    private class WebSocketClientImpl extends WebSocketClient {

        public WebSocketClientImpl(URI serverURI) {
            super(serverURI);
        }

        @Override
        public void onOpen(ServerHandshake serverHandshake) {
            if (isPortBinded("handle")) {
                getPortByName("handle", MessagePort.class).process(scriptOnOpen);
            }
        }

        @Override
        public void onMessage(String message) {
            final String script = "onMessageReceived('" + message + "');";
            if (isPortBinded("handle")) {
                getPortByName("handle", MessagePort.class).process(script);
            }
        }

        @Override
        public void onClose(int i, String s, boolean b) {
            if (isPortBinded("handle")) {
                getPortByName("handle", MessagePort.class).process(scriptOnClose);
            }
        }

        @Override
        public void onError(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
