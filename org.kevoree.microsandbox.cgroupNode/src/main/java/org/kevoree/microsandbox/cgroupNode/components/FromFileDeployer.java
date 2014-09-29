package org.kevoree.microsandbox.cgroupNode.components;

import org.kevoree.ContainerRoot;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.KevoreeInject;
import org.kevoree.api.ModelService;
import org.kevoree.impl.ContainerRootImpl;
import org.kevoree.kevscript.KevScriptEngine;
import org.kevoree.log.Log;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by inti on 3/3/14.
 */
@ComponentType
// see further to know if the class must be a component type or not
public class FromFileDeployer {

    @KevoreeInject
    ModelService modelService;

    protected List<String> packages = new ArrayList<String>();
    protected List<String> repositories = new ArrayList<String>();
}
