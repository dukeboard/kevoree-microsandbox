package org.kevoree.library.javase.http.webbit;

import org.kevoree.annotation.*;
import org.kevoree.framework.MessagePort;
import org.kevoree.library.javase.http.api.AbstractHTTPServer;
import org.kevoree.library.javase.http.api.HTTPOperationTuple;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.api.contract.FullContracted;
import org.webbitserver.WebServer;
import org.webbitserver.WebServers;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 04/04/13
 * Time: 11:01
 *
 * @author Erwan Daubert
 * @version 1.0
 */
@ComponentType (description = "Webbit server to server HTTP request. Thhis implementations is based on servlet API. However webbit doesn't provide a way to do chunked response for binary content. That's why this implementation is not able to stream binary content like media.")
@Requires({
        @RequiredPort(name = "error", type = PortType.MESSAGE, optional = true/*, messageType = HTTPOperationTuple.class.getName()*/)
})

/*@Provides({
        @ProvidedPort(name = "errorResponse", type = PortType.MESSAGE*//*, messageType = HTTPOperationTuple.class.getName()*//*)
})*/
public class WebbitHTTPServerFaultyMemory extends AbstractHTTPServer implements FullContracted {
    private int port;
    WebServer server;
    private WebbitHTTPHandler handler;

    private MemoryFault fault;

    @Override
    public void start() throws ExecutionException, InterruptedException {
        fault = new MemoryFault();
        fault.create();
        port = Integer.parseInt(getDictionary().get("port").toString());

        server = WebServers.createWebServer(port);
//        server.staleConnectionTimeout(Integer.parseInt(getDictionary().get("timeout").toString()));
        handler = new WebbitHTTPHandler(this);
        server.add(handler);
        server.start().get();
    }

    @Override
    public void stop() throws InterruptedException, ExecutionException {
        fault.destroy();
        port = -1;
        Future future = server.stop();
        try {
            future.get(Integer.parseInt(getDictionary().get("timeout").toString()), TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            Log.warn("Time out when waiting the stop of the server. Maybe it is blocked!");
        }
    }

    @Override
    public void update() throws ExecutionException, InterruptedException {
        if (port != Integer.parseInt(getDictionary().get("port").toString())) {
            stop();
            start();
        }
    }

    @Override
    // TODO replace Object with a specific type and rename the parameter
    public void response(/*HTTPOperationTuple*/Object param) {
        if (param != null && param instanceof HTTPOperationTuple) {
            handler.response((HTTPOperationTuple) param);
        }
    }

    // TODO replace Object with a specific type and rename the parameter
    void request(/*HTTPOperationTuple*/Object param) {
        if (param != null && param instanceof HTTPOperationTuple && isPortBinded("request")) {
            getPortByName("request", MessagePort.class).process(param);
        }
    }

    /*// TODO replace Object with a specific type and rename the parameter
    void error(*//*HTTPOperationTuple*//*Object param) {
        if (param != null && param instanceof HTTPOperationTuple && isPortBinded("error")) {
            getPortByName("error", MessagePort.class).process(param);
        }
    }*/

    /*@Port(name = "errorResponse")
    // TODO replace Object with a specific type and rename the parameter
    public void errorResponse(*//*HTTPOperationTuple*//*Object param) {
        if (param != null && param instanceof HTTPOperationTuple) {
            handler.response((HTTPOperationTuple) param);
        }
    }*/
}
