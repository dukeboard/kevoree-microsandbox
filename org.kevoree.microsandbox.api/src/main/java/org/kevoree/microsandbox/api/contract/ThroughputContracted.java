package org.kevoree.microsandbox.api.contract;

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
//@ComponentType
//@ChannelType
public interface ThroughputContracted {
}
