package org.kevoree.library.javase.http.webbit;

import org.kevoree.library.javase.http.api.HTTPOperationTuple;
import org.kevoree.library.javase.http.api.KevoreeHTTPServletRequest;
import org.kevoree.library.javase.http.api.KevoreeHTTPServletResponse;
import org.kevoree.library.javase.http.api.Monitor;
import org.kevoree.log.Log;
import org.webbitserver.HttpControl;
import org.webbitserver.HttpHandler;
import org.webbitserver.HttpRequest;
import org.webbitserver.HttpResponse;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 04/04/13
 * Time: 10:56
 *
 * @author Erwan Daubert
 * @version 1.0
 */
public class WebbitHTTPHandler implements HttpHandler {
    private WebbitHTTPServer server;
    private Monitor monitor;

    public WebbitHTTPHandler(WebbitHTTPServer server) {
        this.server = server;
        monitor = new Monitor(Long.parseLong(server.getDictionary().get("timeout").toString()), server);
    }

    @Override
    public void handleHttpRequest(HttpRequest httpRequest, HttpResponse httpResponse, HttpControl httpControl) throws Exception {
        Log.debug("New request to handle: {}", httpRequest.uri());
        // transform httpRequest in an adequate type, send it through the monitor
        KevoreeHTTPServletRequest request = new WebbitKevoreeHTTPServletRequest(httpRequest, server.server);
        KevoreeHTTPServletResponse response = new WebbitKevoteeHTTPServletResponse(httpResponse);
        HTTPOperationTuple result = monitor.request(new HTTPOperationTuple(request, response, monitor));
        Log.info("Status of the response: {} for request uri: {}", httpResponse.status(), request.getRequestURI());

        if (httpResponse.status() < 200 || (httpResponse.status() >= 300 && httpResponse.status() < 500)) {
            /*if (server.isPortBinded("error")) {
                monitor.error(result);
            } else {
                Log.info("There is no management of client error status code");
            }*/
            httpResponse.end();
        } else {
            ((WebbitKevoteeHTTPServletResponse) response).end();
        }
        // FIXME there is maybe a bug in webbit (see local clone of the repo)
        Log.debug("End of handler for {}", httpRequest.uri());
    }

    void response(HTTPOperationTuple param) {
        // use the response
        monitor.response(param);
    }
}
