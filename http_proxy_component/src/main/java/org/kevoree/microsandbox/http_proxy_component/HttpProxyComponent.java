package org.kevoree.microsandbox.http_proxy_component;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import org.kevoree.ComponentInstance;
import org.kevoree.annotation.*;
import org.kevoree.api.handler.ModelListenerAdapter;
import org.kevoree.api.handler.UpdateContext;
import org.kevoree.log.Log;
import org.littleshoot.proxy.HttpFilters;
import org.littleshoot.proxy.HttpFiltersAdapter;
import org.littleshoot.proxy.HttpFiltersSourceAdapter;
import org.littleshoot.proxy.HttpProxyServer;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ComponentType
public class HttpProxyComponent extends ModelListenerAdapter {

    @Param(defaultValue = "true")
    boolean log;

    @Param(optional = false)
    int port;

    @Override
    public void modelUpdated() {}

    @Override
    public synchronized boolean preUpdate(UpdateContext context) {
        for (BackendServer server : servers) {
            ComponentInstance instance = (ComponentInstance)context.getProposedModel().findByPath(server.componentPath);
            if (instance == null) {
                server.markAsUseless();
            }
        }
        return super.preUpdate(context);
    }

    private class BackendServer {
        final String componentPath;
        final int port;
        private boolean useless = false;

        private BackendServer(String componentPath, int port) {
            this.componentPath = componentPath;
            this.port = port;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            BackendServer that = (BackendServer) o;

            if (port == that.port) return true;
            if (!componentPath.equals(that.componentPath)) return false;

            return true;
        }

        @Override
        public String toString() {
            return "BackendServer{" +
                    "componentPath='" + componentPath + '\'' +
                    ", port=" + port +
                    '}';
        }

        public synchronized void markAsUseless() {
            useless = true;
        }

        public synchronized boolean isUseless() {
            return useless;
        }
    }

    private List<BackendServer> servers = new ArrayList<BackendServer>();
    private int currentPort = 0;

    private synchronized BackendServer nextBackendServerInQueue() {
        BackendServer r = null;
        while ( r == null ) {
            int tmp = currentPort;
            currentPort++;
            if (currentPort == servers.size())
                currentPort = 0;
            BackendServer s = servers.get(tmp);
            if (!s.isUseless()) r = s;
        }
        return r;
    }

    private synchronized boolean addBackendServer(BackendServer server) {
        if (!servers.contains(server)) {
            servers.add(server);
            return true;
        }
        return false;
    }

    @KevoreeInject
    org.kevoree.api.Context context;

    @Input
    public synchronized void onNewBackend(Object m) {
        String msg = m.toString();
        String[] a = msg.split(",");
        String pathString = a[0];
        String portString = a[1];
        int newPort = Integer.parseInt(portString);
        if (addBackendServer(new BackendServer(pathString, newPort)))
            Log.info("Registering component {}:{}", pathString, newPort);
    }

    private HttpProxyServer server;

    @Start
    public void start() {
        Log.info("Starting Proxy:{} at port {}", context.getInstanceName(), port);
         server = DefaultHttpProxyServer.bootstrap()
                 .withPort(port).withAllowLocalOnly(false)
                 .withFiltersSource(new HttpFiltersSourceAdapter() {
                     public HttpFilters filterRequest(HttpRequest originalRequest, ChannelHandlerContext ctx) {
                         return new HttpFiltersAdapter(originalRequest) {

                             @Override
                             public HttpResponse clientToProxyRequest(HttpObject httpObject) {
                                 if (httpObject instanceof HttpRequest) {
                                     HttpRequest request = (HttpRequest) httpObject;
                                     try {
                                         URI uri = URI.create(request.getUri());
                                         if (uri == null || uri.getHost() == null) {
                                             Log.debug("\t\t\t\t\t\t\t\t\t\t THE END {}, value {}, {}", uri, uri.getHost(), uri.getScheme());
                                             return null;
                                         }
                                         if (uri.getHost().equals("inti.magic.site")) {
                                             printHttpRequest(request);
                                             BackendServer backendServer = nextBackendServerInQueue();

                                             Log.debug("\t\t\t I have to translate the request and send it to localhost:{}", backendServer);

                                             URI newUri = new URI(uri.getScheme(), uri.getUserInfo(), "localhost",
                                                     backendServer.port, uri.getPath(), uri.getQuery(), uri.getFragment());
                                             request.setUri(newUri.toString());
                                         }
                                         return null;
                                     } catch (URISyntaxException e) {
                                         e.printStackTrace();
                                     }
                                 }
                                 HttpResponse response = new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_GATEWAY);
                                 return response;
                             }
                         };

                     }
                 }).start();

                 }

    private void printHttpRequest(HttpRequest request) {
        String s = "";
        for (Map.Entry<String, String> entry : request.headers().entries()) {
            s += String.format("\t\t%s -> %s\n", entry.getKey(), entry.getValue());
        }
        Log.debug("A messsage is being sent: \n" +
                        "uri={}\n" +
                        "method={}\n" +
                        "protocolVersion={}\n" +
                        "headers=\n{}\n",
                request.getUri(),
                request.getMethod(),
                request.getProtocolVersion(),
                s);
    }

    @Stop
    public void stop() {
        server.stop();
    }

    @Update
    public void update() {
        stop();
        start();
    }

}



