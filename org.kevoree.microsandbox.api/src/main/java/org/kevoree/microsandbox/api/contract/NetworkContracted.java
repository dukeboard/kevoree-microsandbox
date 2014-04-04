package org.kevoree.microsandbox.api.contract;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 16:24
 */
public interface NetworkContracted {
    /*@Param(optional = true)
    Integer network_input_peak_seconds;
    @Param(optional = true)
    Integer network_output_peak_seconds;
    @Param(optional = true)
    Integer network_input_mean_per_minute;
    @Param(optional = true)
    Integer network_output_mean_per_minute;
    @Param(optional = true)
    Integer network_input_mean_per_hour;
    @Param(optional = true)
    Integer network_output_mean_per_hour;*/

    //    @Param(optional = true)
    public Integer getNetwork_input_peak_seconds();

    public void setNetwork_input_peak_seconds(Integer network_input_peak_seconds);
    //    @Param(optional = true)
    public Integer getNetwork_output_peak_seconds();

    public void setNetwork_output_peak_seconds(Integer network_output_peak_seconds);
    //    @Param(optional = true)
    public Integer getNetwork_input_mean_per_minute();

    public void setNetwork_input_mean_per_minute(Integer network_input_mean_per_minute);
    //    @Param(optional = true)
    public Integer getNetwork_output_mean_per_minute();

    public void setNetwork_output_mean_per_minute(Integer network_output_mean_per_minute);
    //    @Param(optional = true)
    public Integer getNetwork_input_mean_per_hour();

    public void setNetwork_input_mean_per_hour(Integer network_input_mean_per_hour);
    //    @Param(optional = true)
    public Integer getNetwork_output_mean_per_hour();

    public void setNetwork_output_mean_per_hour(Integer network_output_mean_per_hour);

}
