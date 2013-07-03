package org.kevoree.microsandbox.api;

import org.kevoree.annotation.ChannelTypeFragment;
import org.kevoree.annotation.ComponentFragment;
import org.kevoree.annotation.DictionaryAttribute;
import org.kevoree.annotation.DictionaryType;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 03/07/13
 * Time: 17:57
 */

@DictionaryType({
        @DictionaryAttribute(name = "throughput_msg_per_second", optional = true),
        @DictionaryAttribute(name = "throughput_msg_per_minute", optional = true),
        @DictionaryAttribute(name = "throughput_msg_per_hour", optional = true)
})
@ComponentFragment
@ChannelTypeFragment
public interface ThroughputContracted {
}
