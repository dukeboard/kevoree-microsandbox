package org.kevoree.microsandbox.api.contract;

import org.kevoree.annotation.ChannelTypeFragment;
import org.kevoree.annotation.ComponentFragment;
import org.kevoree.annotation.DictionaryAttribute;
import org.kevoree.annotation.DictionaryType;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 16:29
 */
@DictionaryType({
        @DictionaryAttribute(name = "memory_max_size", optional = true, dataType = Long.class),
        @DictionaryAttribute(name = "memory_peak_allocation_per_second", optional = true, dataType = Long.class),
        @DictionaryAttribute(name = "memory_peak_allocation_per_minute", optional = true, dataType = Long.class),
        @DictionaryAttribute(name = "memory_peak_allocation_per_hour", optional = true, dataType = Long.class)
})
@ComponentFragment
@ChannelTypeFragment
public interface MemoryContracted {

}
