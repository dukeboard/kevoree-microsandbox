package org.kevoree.microsandbox.cgroupNode.fakes;

import org.kevoree.annotation.*;
import org.kevoree.microsandbox.cgroupNode.NewThreadCreated;
import org.kevoree.microsandbox.cgroupNode.SharedKCLFactory;
import org.kevoree.microsandbox.core.OnNewThreadNotifier;
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
public class ArduinoNode extends AbstractMonitoredNode<SharedKCLFactory>
{


    @Start
    @Override
    public void startNode() {
    }

    @Override
    protected SharedKCLFactory getClassLoaderFactory() {
        return new SharedKCLFactory(getName(), false);
    }
}
