package org.kevoree.monitoring.strategies.monitoring;


import org.kevoree.log.Log;
import org.kevoree.microsandbox.api.sla.Metric;

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

    private boolean contractViolation;

    private EnumSet<Metric> violationOn;

    protected AbstractMonitoringStrategy(Object msg) {
        this.msg = msg;
    }

    @Override
    public void init(int startTime) {
        // init monitoring of thread execution
        timerForCPU = new Timer();
        try {
            timerForCPU.schedule(this, startTime, ELAPSED_TIME);
            Log.debug("\t\t\t SCHEDULING {}", this);
        }
        catch (java.lang.IllegalStateException ex) {
            Log.error("I don't know who scheduled the task before {}", this);
        }
        contractViolation = false;
        violationOn = EnumSet.noneOf(Metric.class);
        // init monitoring of network communication
    }

    @Override
    public void pause() {
//        System.out.println("Who th hell is calling this");
//        System.exit(0);
        // stop the monitoring
        timerForCPU.cancel();
        timerForCPU.purge();
    }

    @Override
    public void stop() {
        // stop the monitoring
        timerForCPU.cancel();
        timerForCPU.purge();
        previousCPU = 0;
    }

    @Override
    public synchronized void actionOnContractViolation(Metric ... metrics) {
        // notify about action
        for (Metric m : metrics)
            violationOn.add(m);
        synchronized (msg) { msg.notify(); }
        contractViolation = true;
    }

    // FIXME Why do you define this method while the interface have another one ?
    /*public synchronized void actionOnContractViolation( EnumSet<Metric> metrics) {
        // notify about action
        for (Metric m : metrics)
            violationOn.add(m);
        synchronized (msg) { msg.notify(); }
        contractViolation = true;
    }*/

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
