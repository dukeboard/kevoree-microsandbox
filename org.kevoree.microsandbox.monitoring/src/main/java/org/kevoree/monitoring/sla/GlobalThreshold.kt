package org.kevoree.monitoring.sla

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/30/13
 * Time: 8:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class GlobalThreshold(val cpu_threshold: Double,
                              val memory_threshold: Double,
                              val net_received_threshold: Double,
                              val net_sent: Double,
                              val io_read:Double,
                              val io_write: Double) {
}