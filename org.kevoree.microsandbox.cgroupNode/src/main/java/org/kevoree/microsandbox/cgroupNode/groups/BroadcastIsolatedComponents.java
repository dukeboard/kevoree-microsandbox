package org.kevoree.microsandbox.cgroupNode.groups;

import org.kevoree.ContainerRoot;
import org.kevoree.annotation.*;
import org.kevoree.api.ModelService;
import org.kevoree.api.handler.ModelListener;
import org.kevoree.api.handler.UpdateContext;

@GroupType
public class BroadcastIsolatedComponents implements ModelListener {

    @KevoreeInject
    public ModelService modelService;

    @Start
    public void start() {}

    @Stop
    public void stop() {}

    @Override
    public boolean preUpdate(UpdateContext updateContext) {return true;}

    @Override
    public boolean initUpdate(UpdateContext updateContext) {return true;}

    @Override
    public boolean afterLocalUpdate(UpdateContext updateContext) {return true;}

    @Override
    public void modelUpdated() {}

    @Override
    public void preRollback(UpdateContext updateContext) {}

    @Override
    public void postRollback(UpdateContext updateContext) {}

}



