package org.kevoree.microsandbox.api;

import org.kevoree.annotation.ComponentFragment;
import org.kevoree.annotation.DictionaryAttribute;
import org.kevoree.annotation.DictionaryType;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 16:26
 */

@DictionaryType({
        @DictionaryAttribute(name = "cpu_wall_time", dataType = Integer.class),
        @DictionaryAttribute(name = "cpu_peak_percent", dataType = Integer.class),
        @DictionaryAttribute(name = "cpu_mean_percent_per_second", dataType = Integer.class),
        @DictionaryAttribute(name = "cpu_mean_percent_per_minute", dataType = Integer.class),
        @DictionaryAttribute(name = "cpu_mean_percent_per_minute", dataType = Integer.class)
})
@ComponentFragment
public interface CPUContractedComponent {
}
