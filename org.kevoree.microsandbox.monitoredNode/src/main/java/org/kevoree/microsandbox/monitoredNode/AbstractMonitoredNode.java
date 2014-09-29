package org.kevoree.microsandbox.monitoredNode;

import org.kevoree.Instance;
import org.kevoree.annotation.KevoreeInject;
import org.kevoree.annotation.NodeType;
import org.kevoree.annotation.Param;
import org.kevoree.api.*;
import org.kevoree.api.adaptation.AdaptationPrimitive;
//import org.kevoree.bootstrap.kernel.KevoreeCLFactory;
import org.kevoree.library.defaultNodeTypes.JavaNode;
import org.kevoree.library.defaultNodeTypes.planning.JavaPrimitive;
import org.kevoree.library.defaultNodeTypes.wrapper.WrapperFactory;
import org.kevoree.microsandbox.api.contract.PlatformDescription;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 2/11/14
 * Time: 6:45 PM
 */
@NodeType
public abstract class AbstractMonitoredNode //<ClassLoaderFactory extends Object/*KevoreeCLFactory*/>
        extends JavaNode {
    // FIXME How did you choose the default value ?
    @Param(defaultValue = "180000000")
    private long availability_memory;
    @Param(defaultValue = "18000")
    private long availability_sent;
    @Param(defaultValue = "18000")
    private long availability_received;
    @Param(defaultValue = "180000000")
    private long availability_instr;
    @Param(defaultValue = "18000")
    private long availability_write_disc;
    @Param(defaultValue = "18000")
    private long availability_read_disc;

    @KevoreeInject
    protected Context context;
    @KevoreeInject
    protected ModelService modelService;
    @KevoreeInject
    protected BootstrapService bootstrapService;
    @KevoreeInject
    protected KevScriptService kevscriptService;

    protected PlatformDescription description;
    protected MonitoringRegistry monitoringRegistry;

    @Override
    public void startNode() {
        monitoringRegistry = MonitoringRegistry.getInstance();
//        setupKCLFactory(getClassLoaderFactory());
        super.startNode();

        description = new PlatformDescription(availability_memory, availability_sent,
                availability_received, availability_instr,
                availability_write_disc, availability_read_disc);

        monitoringRegistry.register(modelService.getPendingModel().findNodesByID(context.getNodeName()).path() + "_platformDescription", description);

        ControlAdmissionSystem.instance$.init(description);
    }

//    protected abstract ClassLoaderFactory getClassLoaderFactory();
//
//    private void setupKCLFactory(Object/*KevoreeCLFactory*/ factory) {
//        JCLContextHandler jclhandler = null;
//        if (bootstrapService.getKevoreeClassLoaderHandler() instanceof JCLContextHandler) {
//            jclhandler = (JCLContextHandler) bootstrapService.getKevoreeClassLoaderHandler();
//        }
//        else {
//            System.err.println("What a crazy error");
//            System.exit(3);
//            super.startNode();
//            return;
//        }
//        // FIXME we need to do something at the Kevoree level
////        ((KevoreeCLKernel) bootstrapService).setKevoreeCLFactory(factory);
//    }

    @Override
    protected WrapperFactory createWrapperFactory(String nodeName) {
        return super.createWrapperFactory(nodeName);
    }

    @Override
    public PrimitiveCommand getPrimitive(AdaptationPrimitive p) {
        String pTypeName = p.getPrimitiveType();
        // FIXME replace "createWrapperFactory(...)" with wrapperFactory when it use the protected scope
        if (pTypeName.equals(JavaPrimitive.AddInstance.name())) {
            return new MonitoredAddInstance(createWrapperFactory(context.getNodeName()), (Instance) p.getRef(),
                    context.getNodeName(), modelRegistry, monitoringRegistry, modelService,
                    kevscriptService, bootstrapService/*, this*/);
        }
        else if (pTypeName.equals(JavaPrimitive.RemoveInstance.name())) {
            return new MonitoredRemoveInstance(createWrapperFactory(context.getNodeName()), (Instance) p.getRef(),
                    context.getNodeName(), modelRegistry, monitoringRegistry, modelService,
                    kevscriptService, bootstrapService/*, this*/);
        }
        return super.getPrimitive(p);
    }
}
