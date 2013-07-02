package org.kevoree.microsandbox.api;

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
        @DictionaryAttribute(name = "memory_max_size"),
        @DictionaryAttribute(name = "memory_peak_mean_per_second"),
        @DictionaryAttribute(name = "memory_peak_mean_per_minute"),
        @DictionaryAttribute(name = "memory_peak_mean_per_hour")
})
@ComponentFragment
public interface MemoryContractedComponent {

}
