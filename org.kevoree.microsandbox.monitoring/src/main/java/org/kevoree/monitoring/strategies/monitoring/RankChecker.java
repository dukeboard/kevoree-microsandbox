package org.kevoree.monitoring.strategies.monitoring;

import org.kevoree.ComponentInstance;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 9/4/13
 * Time: 2:18 PM
 * To change this template use File | Settings | File Templates.
 */
public interface RankChecker {
    List<ComponentInstance> getRanking();
}
