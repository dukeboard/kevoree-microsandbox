package org.kevoree.microsandbox.api.contract;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 17:57
 */
public interface ThroughputContracted {
    /*@Param(optional = true)
    Integer throughput_msg_per_second;
    @Param(optional = true)
    Integer throughput_msg_per_minute;
    @Param(optional = true)
    Integer throughput_msg_per_hour;*/

    //    @Param(optional = true)
    public Integer getThroughput_msg_per_second();

    public void setThroughput_msg_per_second(Integer throughput_msg_per_second);
    //    @Param(optional = true)
    public Integer getThroughput_msg_per_minute();

    public void setThroughput_msg_per_minute(Integer throughput_msg_per_minute);
    //    @Param(optional = true)
    public Integer getThroughput_msg_per_hour();

    public void setThroughput_msg_per_hour(Integer throughput_msg_per_minute);

}
