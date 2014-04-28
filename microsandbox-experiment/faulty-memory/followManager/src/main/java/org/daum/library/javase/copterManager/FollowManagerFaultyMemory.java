package org.daum.library.javase.copterManager;


import org.daum.common.followermodel.Event;
import org.daum.common.followermodel.Follower;
import org.daum.common.followermodel.Message;
import org.daum.library.javase.copterManager.cache.MemCache;
import org.daum.library.javase.copterManager.ws.AddHandlerRequest;
import org.daum.library.javase.copterManager.ws.WebSocketChannel;
import org.kevoree.annotation.*;
import org.kevoree.api.ModelService;
import org.kevoree.api.Port;
import org.kevoree.api.handler.ModelListenerAdapter;
import org.kevoree.extra.marshalling.JacksonSerializer;
import org.kevoree.extra.marshalling.RichJSONObject;
import org.kevoree.library.javase.http.api.helper.HTTPHelper;
import org.kevoree.library.javase.http.api.page.AbstractHTTPHandler;
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

@ComponentType
public class FollowManagerFaultyMemory extends AbstractHTTPHandler implements Observer, MemoryContracted, CPUContracted, ThroughputContracted {

    @KevoreeInject
    ModelService modelService;

    @Param(optional = true)
    String current;
    @Param(optional = true)
    String uselessParameter;

    @Output(optional = false)
    Port addHandler;
    @Output(optional = false)
    Port removeHandler;

    private Follower currentFollower;
    private HashMap<String, Follower> list;
    private WebSocketChannel webSocketChannel;

    private MemoryFault fault;

    @Start
    public void start() throws Exception {
        fault = new MemoryFault();
        fault.create();
        list = new HashMap<String, Follower>();
        webSocketChannel = new WebSocketChannel();
        super.start();

        modelService.registerModelListener(new ModelListenerAdapter() {
            @Override
            public void modelUpdated() {
                Log.debug("Request Ws Demand");
                addHandler.send(new AddHandlerRequest("/followmanager", webSocketChannel));
            }
        });

        webSocketChannel.getNotifyConnection().addObserver(this);
    }

    @Stop
    public void stop() throws Exception {
        fault.destroy();
        Log.debug("Remove Ws Demand");
        removeHandler.send("/followmanager");
        super.stop();
    }

    @Update
    public void update() throws Exception {
        super.update();
    }


    @Input
    public void followmeuser(Object json) {

        Follower f = JacksonSerializer.convFromJSON(json.toString()).fromJSON(Follower.class);
        f.isfollowed = false;

        if (current != null && current.length() > 0) {

            if (f.id.equals(current)) {
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
        resp.addHeader("Content-Type", HTTPHelper.getMimeTypeFromURL("pages/followers.html"));

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

    @Param(optional = true)
    Double cpu_wall_time;
    @Param(optional = true)
    Long cpu_peak_percent_per_second;
    @Param(optional = true)
    Long cpu_mean_percent_per_minute;
    @Param(optional = true)
    Long cpu_mean_percent_per_hour;
    @Param(optional = true)
    Double memory_max_size;
    @Param(optional = true)
    Long memory_peak_allocation_per_second;
    @Param(optional = true)
    Long memory_peak_allocation_per_minute;
    @Param(optional = true)
    Long memory_peak_allocation_per_hour;
    @Param(optional = true)
    String throughput_msg_per_second;
    @Param(optional = true)
    String throughput_msg_per_minute;
    @Param(optional = true)
    String throughput_msg_per_hour;


    @Override
    public double getCpu_wall_time() {
        return cpu_wall_time;
    }

    @Override
    public void setCpu_wall_time(double cpu_wall_time) {
        this.cpu_wall_time = cpu_wall_time;
    }

    @Override
    public long getCpu_peak_percent_per_second() {
        return cpu_peak_percent_per_second;
    }

    @Override
    public void setCpu_peak_percent_per_second(long cpu_peak_percent_per_second) {
        this.cpu_peak_percent_per_second = cpu_peak_percent_per_second;
    }

    @Override
    public long getCpu_mean_percent_per_minute() {
        return cpu_mean_percent_per_minute;
    }

    @Override
    public void setCpu_mean_percent_per_minute(long cpu_mean_percent_per_minute) {
        this.cpu_mean_percent_per_minute = cpu_mean_percent_per_minute;
    }

    @Override
    public long getCpu_mean_percent_per_hour() {
        return cpu_mean_percent_per_hour;
    }

    @Override
    public void setCpu_mean_percent_per_hour(long cpu_mean_percent_per_hour) {
        this.cpu_mean_percent_per_hour = cpu_mean_percent_per_hour;
    }

    @Override
    public double getMemory_max_size() {
        return memory_max_size;
    }

    @Override
    public void setMemory_max_size(double memory_max_size) {
        this.memory_max_size = memory_max_size;
    }

    @Override
    public long getMemory_peak_allocation_per_second() {
        return memory_peak_allocation_per_second;
    }

    @Override
    public void setMemory_peak_allocation_per_second(long memory_peak_allocation_per_second) {
        this.memory_peak_allocation_per_second = memory_peak_allocation_per_second;
    }

    @Override
    public long getMemory_peak_allocation_per_minute() {
        return memory_peak_allocation_per_minute;
    }

    @Override
    public void setMemory_peak_allocation_per_minute(long memory_peak_allocation_per_minute) {
        this.memory_peak_allocation_per_minute = memory_peak_allocation_per_minute;
    }

    @Override
    public long getMemory_peak_allocation_per_hour() {
        return memory_peak_allocation_per_hour;
    }

    @Override
    public void setMemory_peak_allocation_per_hour(long memory_peak_allocation_per_hour) {
        this.memory_peak_allocation_per_hour = memory_peak_allocation_per_hour;
    }

    @Override
    public String getThroughput_msg_per_second() {
        return throughput_msg_per_second;
    }

    @Override
    public void setThroughput_msg_per_second(String throughput_msg_per_second) {
        this.throughput_msg_per_second = throughput_msg_per_second;
    }

    @Override
    public String getThroughput_msg_per_minute() {
        return throughput_msg_per_minute;
    }

    @Override
    public void setThroughput_msg_per_minute(String throughput_msg_per_minute) {
        this.throughput_msg_per_minute = throughput_msg_per_minute;
    }

    @Override
    public String getThroughput_msg_per_hour() {
        return throughput_msg_per_hour;
    }

    @Override
    public void setThroughput_msg_per_hour(String throughput_msg_per_hour) {
        this.throughput_msg_per_hour = throughput_msg_per_hour;
    }
}
