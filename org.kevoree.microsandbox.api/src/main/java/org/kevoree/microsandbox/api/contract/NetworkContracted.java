package org.kevoree.microsandbox.api.contract;

import org.kevoree.annotation.ChannelTypeFragment;
import org.kevoree.annotation.ComponentFragment;
import org.kevoree.annotation.DictionaryAttribute;
import org.kevoree.annotation.DictionaryType;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 16:24
 */

@DictionaryType({
        @DictionaryAttribute(name = "network_input_peak_seconds", optional = true, dataType = Integer.class),
        @DictionaryAttribute(name = "network_output_peak_seconds", optional = true, dataType = Integer.class),
        @DictionaryAttribute(name = "network_input_mean_per_minute", optional = true, dataType = Integer.class),
        @DictionaryAttribute(name = "network_output_mean_per_minute", optional = true, dataType = Integer.class),
        @DictionaryAttribute(name = "network_input_mean_per_hour", optional = true, dataType = Integer.class),
        @DictionaryAttribute(name = "network_output_mean_per_hour", optional = true, dataType = Integer.class)
})
@ComponentFragment
@ChannelTypeFragment
public interface NetworkContracted {
}
