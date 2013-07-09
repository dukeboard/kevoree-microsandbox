package org.kevoree.monitoring.strategies.adaptation;

import org.kevoree.monitoring.sla.FaultyComponent;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/3/13
 * Time: 9:18 AM
 *
 */
public interface AdaptationStrategy {
    public List<FaultyComponent> adapt(String nodeName, List<FaultyComponent> faultyComponents);
}
