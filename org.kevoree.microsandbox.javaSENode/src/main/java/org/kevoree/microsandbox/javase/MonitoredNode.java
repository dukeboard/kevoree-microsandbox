package org.kevoree.microsandbox.javase;

import org.kevoree.Instance;
import org.kevoree.annotation.DictionaryAttribute;
import org.kevoree.annotation.DictionaryType;
import org.kevoree.api.PrimitiveCommand;
import org.kevoree.kompare.JavaSePrimitive;
import org.kevoree.library.defaultNodeTypes.JavaSENode;
import org.kevoree.microsandbox.api.contract.PlatformDescription;
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
        @DictionaryAttribute(name = "availability_instr", defaultValue = "180000000"),
        @DictionaryAttribute(name = "availability_write_disc", defaultValue = "18000"),
        @DictionaryAttribute(name = "availability_read_disc", defaultValue = "18000")
})
@NodeType
@Library(name = "JavaSE")
public class MonitoredNode extends JavaSENode {

    PlatformDescription description;

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
        long max_instr = Long.valueOf(getDictionary().get("availability_instr").toString());
        long max_write = Long.valueOf(getDictionary().get("availability_write_disc").toString());
        long max_read = Long.valueOf(getDictionary().get("availability_read_disc").toString());

        description = new PlatformDescription(max_memory, max_sent,
                                                max_received, max_instr,
                                                max_write, max_read);
        ControlAdmissionSystem.instance$.init(description);
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
