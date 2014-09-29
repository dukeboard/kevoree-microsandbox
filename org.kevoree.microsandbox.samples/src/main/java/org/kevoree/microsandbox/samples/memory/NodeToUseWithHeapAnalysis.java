package org.kevoree.microsandbox.samples.memory;

import org.kevoree.annotation.*;
import org.kevoree.api.*;
import org.kevoree.api.handler.*;

@NodeType
@Library(name = "Java")
public class NodeToUseWithHeapAnalysis implements ModelListener, org.kevoree.api.NodeType {

    @KevoreeInject
    public ModelService modelService = null;

    @KevoreeInject
    public BootstrapService bootstrapService = null;

    @KevoreeInject
    Context context;

    @Start
    public void startNode() {

    }

    @Stop
    public void stopNode() {

    }




}



