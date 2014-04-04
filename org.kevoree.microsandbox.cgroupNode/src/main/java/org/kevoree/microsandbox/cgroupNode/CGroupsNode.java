package org.kevoree.microsandbox.cgroupNode;

import org.kevoree.annotation.*;
import org.kevoree.microsandbox.core.OnNewThreadNotifier;
import org.kevoree.microsandbox.monitoredNode.AbstractMonitoredNode;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 1/7/14
 * Time: 3:57 PM
 */
@NodeType
@Library(name = "JavaSE")
public class CGroupsNode extends AbstractMonitoredNode<SharedKCLFactory>
{

    @Param(defaultValue = "/cgroup")// Fedora style
    String cgroup_fs_path;

    private NewThreadCreated threadCreated;

    @Start
    @Override
    public void startNode() {
        super.startNode();

        threadCreated = new NewThreadCreated("kev/", description, context.getNodeName());
        OnNewThreadNotifier.getInstance().setHandler(threadCreated);
    }

    @Override
    protected SharedKCLFactory getClassLoaderFactory() {
        return new SharedKCLFactory(context.getInstanceName(), false);
    }
}
