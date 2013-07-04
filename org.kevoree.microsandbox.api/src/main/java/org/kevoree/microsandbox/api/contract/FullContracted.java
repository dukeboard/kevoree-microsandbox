package org.kevoree.microsandbox.api.contract;

import org.kevoree.annotation.ChannelTypeFragment;
import org.kevoree.annotation.ComponentFragment;

/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 30/05/13
 * Time: 14:02
 */

@ChannelTypeFragment
@ComponentFragment
public interface FullContracted extends CPUContracted, MemoryContracted, NetworkContracted {



}
