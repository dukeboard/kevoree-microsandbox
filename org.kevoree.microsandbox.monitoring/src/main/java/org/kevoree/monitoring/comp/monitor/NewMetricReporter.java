package org.kevoree.monitoring.comp.monitor;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 9/11/13
 * Time: 2:56 PM
 * To change this template use File | Settings | File Templates.
 */
public interface NewMetricReporter {
    public void report(String component, InfoForContractCreation info);
}
