package org.kevoree.monitoring;

import org.kevoree.annotation.ComponentFragment;
import org.kevoree.annotation.DictionaryAttribute;
import org.kevoree.annotation.DictionaryType;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 30/05/13
 * Time: 14:02
 */

@DictionaryType({
        @DictionaryAttribute(name = "memory_max_size"),
        @DictionaryAttribute(name = "cpu_wall_time"),
        @DictionaryAttribute(name = "network_input_seconds"),
        @DictionaryAttribute(name = "network_output_seconds")
})
@ComponentFragment
public interface ContractedComponent {



}
