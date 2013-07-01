package org.kevoree.monitoring.strategies;

import org.kevoree.monitoring.sla.Metric;

import java.util.EnumSet;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/28/13
 * Time: 7:03 PM
 *
 */
public abstract class AbstractMonitoringStrategy extends TimerTask implements MonitoringStrategy {

    public static final int ELAPSED_TIME = 1000; // 1 second

    protected static final double elapsedTime = ELAPSED_TIME;

    private final Object msg;

    private Timer timerForCPU;
    double previousCPU = 0; // in milliseconds
    long previousSent = 0;
    long previousReceived = 0;

    private boolean contractViolation;

    private EnumSet<Metric> violationOn;

    protected AbstractMonitoringStrategy(Object msg) {
        this.msg = msg;
    }

    @Override
    public void init(int startTime) {
        // init monitoring of thread execution
        timerForCPU = new Timer();
        timerForCPU.schedule(this, startTime, ELAPSED_TIME);
        contractViolation = false;
        violationOn = EnumSet.noneOf(Metric.class);
        // init monitoring of network communication
    }

    @Override
    public void pause() {
        // stop the monitoring
        timerForCPU.cancel();
    }

    @Override
    public void stop() {
        // stop the monitoring
        timerForCPU.cancel();
        previousCPU = 0;
        previousSent = 0;
        previousReceived = 0;
    }

    @Override
    public synchronized void actionOnContractViolation(Metric ... metrics) {
        // notify about action
        for (Metric m : metrics)
            violationOn.add(m);
        synchronized (msg) { msg.notify(); }
        contractViolation = true;
    }

    public synchronized void actionOnContractViolation( EnumSet<Metric> metrics) {
        // notify about action
        for (Metric m : metrics)
            violationOn.add(m);
        synchronized (msg) { msg.notify(); }
        contractViolation = true;
    }

    @Override
    public synchronized boolean isThereContractViolation() {
        return contractViolation;
    }

    @Override
    public synchronized EnumSet<Metric> getViolationOn() {
        return violationOn;
    }

    @Override
    public void passWithoutViolation() {
        synchronized (msg) {msg.notify();}
    }
}
