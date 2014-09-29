package org.kevoree.microsandbox.javase;

import org.kevoree.microsandbox.monitoredNode.AbstractMonitoredNode;

import org.kevoree.annotation.NodeType;

/**
 * Created by duke on 24/06/13.
 */
@NodeType
public class MonitoredNode extends AbstractMonitoredNode//<CoverageKCLFactory>
{

    @Override
    public void startNode() {
        super.startNode();
    }

//    @Override
//    protected CoverageKCLFactory getClassLoaderFactory() {
//        return new CoverageKCLFactory();
//    }
}
