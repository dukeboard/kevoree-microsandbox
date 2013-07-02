package org.kevoree.microsandbox.javase;

import org.kevoree.Instance;
import org.kevoree.annotation.DictionaryAttribute;
import org.kevoree.annotation.DictionaryType;
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
@DictionaryType({
        @DictionaryAttribute(name = "availability_memory", defaultValue = "180000000"),
        @DictionaryAttribute(name = "availability_sent", defaultValue = "18000"),
        @DictionaryAttribute(name = "availability_received", defaultValue = "18000"),
        @DictionaryAttribute(name = "availability_instr", defaultValue = "1800000")
})
@NodeType
@Library(name = "JavaSE")
public class MonitoredNode extends JavaSENode {

    @Override
    public void startNode() {
        JCLContextHandler jclhandler = null;
        if (getBootStrapperService().getKevoreeClassLoaderHandler() instanceof JCLContextHandler) {
            jclhandler = (JCLContextHandler) getBootStrapperService().getKevoreeClassLoaderHandler();
        }
        else {
            System.err.println("What a crazy error");
            System.exit(3);
            super.startNode();
            return;
        }

        jclhandler.setKCLFactory(new CoverageKCLFactory());
        super.startNode();
        long max_sent = Long.valueOf(getDictionary().get("availability_sent").toString());
        long max_received = Long.valueOf(getDictionary().get("availability_received").toString());
        long max_memory = Long.valueOf(getDictionary().get("availability_memory").toString());
        ControlAdmissionSystem.instance$.init(max_memory, max_sent, max_received);
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
        if (pTypeName.equals(JavaSePrimitive.instance$.getRemoveInstance())) {
            return new MonitoredRemoveInstance((Instance) p.getRef(),
                    getNodeName(), this.getModelService(),
                    this.getKevScriptEngineFactory(),
                    this.getBootStrapperService(),
                    this);
        }
        return super.getPrimitive(p);
    }
}
