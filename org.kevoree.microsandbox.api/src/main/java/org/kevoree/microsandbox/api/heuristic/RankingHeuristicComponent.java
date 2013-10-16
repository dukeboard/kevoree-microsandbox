package org.kevoree.microsandbox.api.heuristic;

import org.kevoree.ComponentInstance;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 26/09/13
 * Time: 14:34
 *
 * @author Erwan Daubert
 * @version 1.0
 */
public interface RankingHeuristicComponent {
    /**
     * Calculate the order of the components that must be monitored
     * First element in the list is the first component to monitor.
     * @return a @{List} of @{ComponentInstance}.
     */
    // use of ComponentInstance instead of List<ComponentInstance> to by pass a bug on Kevoree (version 2.0.12)
    ComponentInstance[] getRankingOrder(String nodeName);

    /**
     * Allow to send some information from monitoring core to rankingHeuristic
     * @param name the name of the "event"
     * @param value the value of the "event"
     */
    // FIXME this method must be remove and a better solution must be fine but we don't have time currently
    void triggerMonitoringEvent(String operation, String name, String instancePath, Long value);
}
