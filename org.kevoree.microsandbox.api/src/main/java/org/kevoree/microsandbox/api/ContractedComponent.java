package org.kevoree.microsandbox.api;

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
        @DictionaryAttribute(name = "cpu_wall_time")
})
@ComponentFragment
public interface ContractedComponent {



}
