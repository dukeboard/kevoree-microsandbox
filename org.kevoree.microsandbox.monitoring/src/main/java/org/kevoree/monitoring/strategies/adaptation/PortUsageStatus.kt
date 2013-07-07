package org.kevoree.monitoring.strategies.adaptation

import java.util.HashMap
import org.kevoree.Port
import java.util.HashSet

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/7/13
 * Time: 11:10 AM
 * To change this template use File | Settings | File Templates.
 */
public data class PortUsageStatus(var wrongUsage : Boolean,
                                  var misUsedProvidedPorts : HashMap<String, HashSet<Port>>)