package org.kevoree.microsandbox.javase;

import org.kevoree.Instance;
import org.kevoree.api.PrimitiveCommand;
import org.kevoree.kompare.JavaSePrimitive;
import org.kevoree.library.defaultNodeTypes.JavaSENode;
import org.kevoree.tools.aether.framework.JCLContextHandler;

import org.kevoree.annotation.Library;
import org.kevoree.annotation.NodeType;
import org.kevoreeadaptation.AdaptationPrimitive;

/**
 * Created by duke on 24/06/13.
 */
@NodeType
@Library(name = "JavaSE")
public class MonitoredNode extends JavaSENode {

    @Override
    public void startNode() {

        JCLContextHandler jclhandler = (JCLContextHandler) getBootStrapperService().getKevoreeClassLoaderHandler();
        jclhandler.setKCLFactory(new CoverageKCLFactory());
        super.startNode();
        ControlAdmissionSystem.instance$.init();
    }

    @Override
    public PrimitiveCommand getPrimitive(AdaptationPrimitive p) {
        String pTypeName = p.getPrimitiveType().getName();
        if (pTypeName.equals(JavaSePrimitive.instance$.getAddInstance())) {
            return new MonitoredAddInstance((Instance) p.getRef(),
                    getNodeName(), this.getModelService(),
                    this.getKevScriptEngineFactory(),
                    this.getBootStrapperService(),
                    this);
        }
        return super.getPrimitive(p);
    }
}
