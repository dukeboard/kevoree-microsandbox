package org.kevoree.microsandbox.cgroupNode.groups;

import org.kevoree.annotation.*;
import org.kevoree.api.handler.ModelListener;

@GroupType
@Library(name = "Java")
public class BroadcastIsolatedComponents implements ModelListener {

    @KevoreeInject
    public ModelService modelService;

    @Start
    public void start() {}

    @Stop
    public void stop() {}

    @Override
    public boolean preUpdate(ContainerRoot currentModel, ContainerRoot proposedModel) {return true;}

    @Override
    public boolean initUpdate(ContainerRoot currentModel, ContainerRoot proposedModel) {return true;}

    @Override
    public boolean afterLocalUpdate(ContainerRoot currentModel, ContainerRoot proposedModel) {return true;}

    @Override
    public void modelUpdated() {}

    @Override
    public void preRollback(ContainerRoot currentModel, ContainerRoot proposedModel) {}

    @Override
    public void postRollback(ContainerRoot currentModel, ContainerRoot proposedModel) {}

}



