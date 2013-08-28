package org.kevoree.microsandbox.api.contract;

import org.kevoree.annotation.DictionaryAttribute;
import org.kevoree.annotation.DictionaryType;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 16:26
 */

@DictionaryType({
        @DictionaryAttribute(name = "cpu_wall_time", dataType = Double.class, optional = true),
        @DictionaryAttribute(name = "cpu_peak_percent_per_second", dataType = Long.class, optional = true),
        @DictionaryAttribute(name = "cpu_mean_percent_per_minute", dataType = Long.class, optional = true),
        @DictionaryAttribute(name = "cpu_mean_percent_per_hour", dataType = Long.class, optional = true)
        /* Thread affinity Core dispatch */
})
//@ComponentType
//@ChannelType
public interface CPUContracted {

}
