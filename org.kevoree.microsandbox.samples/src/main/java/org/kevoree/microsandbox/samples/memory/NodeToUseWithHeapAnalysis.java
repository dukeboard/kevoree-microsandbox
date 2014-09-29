package org.kevoree.microsandbox.samples.memory;

import jet.runtime.typeinfo.JetValueParameter;
import org.jetbrains.annotations.NotNull;
import org.kevoree.ComponentInstance;
import org.kevoree.Instance;
import org.kevoree.annotation.*;
import org.kevoree.annotation.NodeType;
import org.kevoree.api.*;
import org.kevoree.api.adaptation.AdaptationPrimitive;
import org.kevoree.api.handler.*;
import org.kevoree.library.defaultNodeTypes.JavaNode;
import org.kevoree.library.defaultNodeTypes.ModelRegistry;
import org.kevoree.library.defaultNodeTypes.command.AddInstance;
import org.kevoree.library.defaultNodeTypes.planning.JavaPrimitive;
import org.kevoree.library.defaultNodeTypes.wrapper.KInstanceWrapper;
import org.kevoree.library.defaultNodeTypes.wrapper.WrapperFactory;
import org.kevoree.log.Log;

@NodeType
public class NodeToUseWithHeapAnalysis  extends JavaNode {

    @Start
    public void startNode() {
        super.startNode();
    }

    @Stop
    public void stopNode() {
        super.stopNode();
    }


    @Override
    public org.kevoree.api.PrimitiveCommand getPrimitive(AdaptationPrimitive adaptationPrimitive) {
        String pTypeName = adaptationPrimitive.getPrimitiveType();
        String nodeName = modelService.getNodeName();
        org.kevoree.api.PrimitiveCommand result = null;

        if (pTypeName.equals(JavaPrimitive.AddInstance.name())) {
            Instance instance = (Instance) adaptationPrimitive.getRef();
            result = new MemoryAddInstance(wrapperFactory,
                    instance,
                    nodeName, modelRegistry, bootstrapService, modelService);
//

//            Log.info("Wrapper type is {}", wrapper.getClass());
            return result;
        }
        else
            return super.getPrimitive(adaptationPrimitive);
    }

}



