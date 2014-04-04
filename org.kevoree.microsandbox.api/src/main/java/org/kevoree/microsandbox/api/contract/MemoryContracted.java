package org.kevoree.microsandbox.api.contract;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 16:29
 */
public interface MemoryContracted {
    /*@Param(optional = true)
    Long memory_max_size;
    @Param(optional = true)
    Long memory_peak_allocation_per_second;
    @Param(optional = true)
    Long memory_peak_allocation_per_minute;
    @Param(optional = true)
    Long memory_peak_allocation_per_hour;*/

    //    @Param(optional = true)
    public double getMemory_max_size();

    public void setMemory_max_size( double memory_max_size);
    //    @Param(optional = true)
    public long getMemory_peak_allocation_per_second();

    public void setMemory_peak_allocation_per_second( long memory_peak_allocation_per_second);
    //    @Param(optional = true)
    public long getMemory_peak_allocation_per_minute();

    public void setMemory_peak_allocation_per_minute( long memory_peak_allocation_per_minute);
    //    @Param(optional = true)
    public long getMemory_peak_allocation_per_hour();

    public void setMemory_peak_allocation_per_hour( long memory_peak_allocation_per_hour);

}
