package org.kevoree.microsandbox.cgroupNode;

import org.kevoree.annotation.*;
import org.kevoree.microsandbox.core.OnNewThreadNotifier;
import org.kevoree.microsandbox.monitoredNode.AbstractMonitoredNode;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 1/7/14
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
@DictionaryType({// FIXME How did you choose the default value ?
        @DictionaryAttribute(name = "cgroup_fs_path", defaultValue = "")
})
@NodeType
@Library(name = "JavaSE")
public class CGroupsNode extends AbstractMonitoredNode<SharedKCLFactory>
{

    private String cgroup_path = "/cgroup"; // Fedora style
    private NewThreadCreated threadCreated;

    @Start
    @Override
    public void startNode() {
        super.startNode();

        if (getDictionary().containsKey("cgroup_fs_path"))
            cgroup_path = getDictionary().get("cgroup_fs_path").toString();

        threadCreated = new NewThreadCreated("kev/", description, getNodeName());
        OnNewThreadNotifier.getInstance().setHandler(threadCreated);
    }

    @Override
    protected SharedKCLFactory getClassLoaderFactory() {
        return new SharedKCLFactory(getName(), false);
    }
}
