package org.daum.library.javase.copterManager;


import org.daum.common.followermodel.Event;
import org.daum.common.followermodel.Follower;
import org.daum.common.followermodel.Message;
import org.daum.library.javase.copterManager.cache.MemCache;
import org.daum.library.javase.copterManager.ws.WebSocketChannel;
import org.daum.library.javase.copterManager.ws.WsHandler;
import org.kevoree.ContainerRoot;
import org.kevoree.annotation.*;
import org.kevoree.api.service.core.handler.ModelListener;
import org.kevoree.extra.marshalling.JacksonSerializer;
import org.kevoree.extra.marshalling.RichJSONObject;
import org.kevoree.library.javase.http.api.AbstractHTTPHandler;
import org.kevoree.library.javase.http.api.HTTPHelper;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.api.contract.CPUContracted;
import org.kevoree.microsandbox.api.contract.MemoryContracted;
import org.kevoree.microsandbox.api.contract.ThroughputContracted;
import org.webbitserver.WebSocketConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 * Created with IntelliJ IDEA.
 * User: jed
 * Date: 08/02/13
 * Time: 11:10
 */

@Requires({
        @RequiredPort(name = "ws", type = PortType.SERVICE, className = WsHandler.class, optional = false, needCheckDependency = true)
})
@Provides({
        @ProvidedPort(name = "followmeuser", type = PortType.MESSAGE)
})
@DictionaryType({@org.kevoree.annotation.DictionaryAttribute(name = "current", optional = true),
        @DictionaryAttribute(name = "uselessParameter", optional = true)})
@ComponentType
public class FollowManager extends AbstractHTTPHandler implements Observer, MemoryContracted, CPUContracted, ThroughputContracted {

    private Follower current;
    private HashMap<String, Follower> list;
    private WebSocketChannel webSocketChannel;

    @Start
    public void start() throws Exception {
        list = new HashMap<String, Follower>();
        webSocketChannel = new WebSocketChannel();
        super.start();

        getModelService().registerModelListener(new ModelListener() {
            @Override
            public boolean preUpdate(ContainerRoot containerRoot, ContainerRoot containerRoot1) {
                return true;
            }

            @Override
            public boolean afterLocalUpdate(ContainerRoot containerRoot, ContainerRoot containerRoot1) {
                return true;
            }


            @Override
            public boolean initUpdate(ContainerRoot containerRoot, ContainerRoot containerRoot1) {
                return true;
            }

            @Override
            public void modelUpdated() {
                Log.debug("Request Ws Demand");
                getPortByName("ws", WsHandler.class).addHandler("/followmanager", webSocketChannel);
            }

            @Override
            public void preRollback(ContainerRoot containerRoot, ContainerRoot containerRoot1) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void postRollback(ContainerRoot containerRoot, ContainerRoot containerRoot1) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        webSocketChannel.getNotifyConnection().addObserver(this);
    }

    @Stop
    public void stop() throws Exception {
        Log.debug("Remove Ws Demand");
        getPortByName("ws", WsHandler.class).removeHandler("/followmanager");
        super.stop();
    }

    @Update
    public void update() throws Exception {
        super.update();
    }


    @Port(name = "followmeuser")
    public void followme_users(Object json) {

        Follower f = JacksonSerializer.convFromJSON(json.toString()).fromJSON(Follower.class);
        f.isfollowed = false;

        String current_followerId = getDictionary().get("current").toString();

        if (current_followerId != null && current_followerId.length() > 0) {

            if (f.id.equals(current_followerId)) {
                f.isfollowed = true;
            }
        }


        if (f.event == Event.ADD) {
            list.put(f.id, f);

        } else if (f.event == Event.UPDATE) {

            if (!list.containsKey(f.id)) {
                f.event = Event.ADD;
            }
            list.put(f.id, f);
        } else if (f.event == Event.DELETE) {
            list.remove(f.id);
        }

        RichJSONObject t = new RichJSONObject(f);
        webSocketChannel.broadcast(t.toJSON());

    }


   /* @Override
    public KevoreeHttpResponse process(KevoreeHttpRequest kevoreeHttpRequest, KevoreeHttpResponse kevoreeHttpResponse) {
        String page = new String(MemCache.getRessource("pages/followers.html"));

        kevoreeHttpResponse.setContent(page);
        return kevoreeHttpResponse;
    }*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        writer.write(new String(MemCache.getRessource("pages/followers.html"), "UTF-8"));
//                writer.write(new String(MemCache.getRessource("pages/map-test.html"), "UTF-8"));
        writer.flush();
        resp.addHeader("Content-Type", HTTPHelper.getHttpHeaderFromURL("pages/followers.html"));

    }

    @Override
    public void update(Observable observable, Object connection) {
        loadAll((WebSocketConnection) connection);
    }


    public void loadAll(WebSocketConnection connection) {

        try {

            for (String key : list.keySet()) {
                Message data = list.get(key);
                data.event = Event.ADD;
                RichJSONObject t = new RichJSONObject(data);
                connection.send(t.toJSON());
            }


        } catch (Exception e) {
            Log.error("", e);
        }
    }
}
