package org.kevoree.microsandbox.cgroupNode.fakes;

import org.kevoree.annotation.Library;
import org.kevoree.annotation.NodeType;
import org.kevoree.annotation.Start;
import org.kevoree.microsandbox.cgroupNode.SharedKCLFactory;
import org.kevoree.microsandbox.monitoredNode.AbstractMonitoredNode;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 1/7/14
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
@NodeType
@Library(name = "JavaSE")
public class RaspberryPiNode extends AbstractMonitoredNode<SharedKCLFactory>
{


    @Start
    @Override
    public void startNode() {
    }

    @Override
    protected SharedKCLFactory getClassLoaderFactory() {
        return new SharedKCLFactory(context.getInstanceName(), false);
    }
}
