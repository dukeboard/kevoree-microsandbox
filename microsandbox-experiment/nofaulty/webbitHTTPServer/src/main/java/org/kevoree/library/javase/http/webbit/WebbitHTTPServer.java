package org.kevoree.library.javase.http.webbit;

import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Param;
import org.kevoree.annotation.Update;
import org.kevoree.library.javase.http.api.commons.HTTPOperationTuple;
import org.kevoree.library.javase.http.api.server.AbstractHTTPServer;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.api.contract.CPUContracted;
import org.kevoree.microsandbox.api.contract.MemoryContracted;
import org.kevoree.microsandbox.api.contract.ThroughputContracted;
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
@ComponentType(description = "Webbit server to server HTTP request. Thhis implementations is based on servlet API. However webbit doesn't provide a way to do chunked response for binary content. That's why this implementation is not able to stream binary content like media.")
public class WebbitHTTPServer extends AbstractHTTPServer implements MemoryContracted, CPUContracted, ThroughputContracted {

    @Param
    String uselessParameter;

    WebServer server;
    private WebbitHTTPHandler handler;

    @Override
    public void start() throws Exception {
        server = WebServers.createWebServer(port);
//        server.staleConnectionTimeout(Integer.parseInt(getDictionary().get("timeout").toString()));
        handler = new WebbitHTTPHandler(this);
        server.add(handler);
        server.start().get();
    }

    @Override
    public void stop() throws InterruptedException, ExecutionException {
        port = -1;
        Future future = server.stop();
        try {
            future.get(timeout, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            Log.warn("Time out when waiting the stop of the server. Maybe it is blocked!");
        }
    }

    @Update
    public void update() throws Exception {
        stop();
        start();
    }

    @Override
    // TODO replace Object with a specific type and rename the parameter
    public void response(/*HTTPOperationTuple*/Object param) {
        if (param != null && param instanceof HTTPOperationTuple) {
            handler.response((HTTPOperationTuple) param);
        }
    }

    // TODO replace Object with a specific type and rename the parameter
    public void request(/*HTTPOperationTuple*/Object param) {
        if (param != null && param instanceof HTTPOperationTuple /*&& request.getConnectedBindingsSize() > 0*/) {
            request.send(param);
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
