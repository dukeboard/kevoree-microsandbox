package org.kevoree.monitoring.sla

import org.kevoree.ComponentInstance
import java.util.EnumSet

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/1/13
 * Time: 11:58 PM
 *
 */
public data class FaultyComponent(val componentPath : String, val metrics: EnumSet<Metric>)