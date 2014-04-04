package org.kevoree.microsandbox.api.contract;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 16:26
 */

public interface CPUContracted {

    /*@Param(optional = true)
    Double cpu_wall_time;
    @Param(optional = true)
    Long cpu_peak_percent_per_second;
    @Param(optional = true)
    Long cpu_mean_percent_per_minute;
    @Param(optional = true)
    Long cpu_mean_percent_per_hour;*/

    //    @Param(optional = true)
    public double getCpu_wall_time();

    public void setCpu_wall_time(double p0);
    //    @Param(optional = true)
    public long getCpu_peak_percent_per_second();

    public void setCpu_peak_percent_per_second(long p0) ;
    //    @Param(optional = true)
    public long getCpu_mean_percent_per_minute();

    public void setCpu_mean_percent_per_minute(long p0);
    //    @Param(optional = true)
    public long getCpu_mean_percent_per_hour();

    public void setCpu_mean_percent_per_hour(long p0);

}
