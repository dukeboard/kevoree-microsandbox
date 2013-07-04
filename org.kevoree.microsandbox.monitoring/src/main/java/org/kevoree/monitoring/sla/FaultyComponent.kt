package org.kevoree.monitoring.sla

import org.kevoree.ComponentInstance
import java.util.EnumSet
import java.util.EnumMap
import org.kevoree.microsandbox.api.sla.Metric

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/1/13
 * Time: 11:58 PM
 *
 */
public data class FaultyComponent(val componentPath : String, val metrics: EnumMap<Metric, Double>)