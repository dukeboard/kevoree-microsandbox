package org.kevoree.microsandbox.samples.memory;

import org.kevoree.ComponentInstance;
import org.kevoree.ContainerNode;
import org.kevoree.Instance;
import org.kevoree.annotation.KevoreeInject;
import org.kevoree.api.BootstrapService;
import org.kevoree.api.ModelService;
import org.kevoree.api.PrimitiveCommand;
import org.kevoree.kcl.api.FlexyClassLoader;
import org.kevoree.library.defaultNodeTypes.KevoreeThreadGroup;
import org.kevoree.library.defaultNodeTypes.ModelRegistry;
import org.kevoree.library.defaultNodeTypes.command.ClassLoaderHelper;
import org.kevoree.library.defaultNodeTypes.wrapper.KInstanceWrapper;
import org.kevoree.library.defaultNodeTypes.wrapper.WrapperFactory;
import org.kevoree.log.Log;

import java.lang.reflect.Field;

/**
 * Created by inti on 15/09/14.
 */
public class MemoryAddInstance implements PrimitiveCommand, Runnable {

    final WrapperFactory wrapperFactory;
    final Instance c;
    final String nodeName;
    final ModelRegistry registry;
    final BootstrapService bs;
    final ModelService modelService;

    String nodeTypeName = null;
    ThreadGroup tg = null;
    boolean resultSub = false;

    public MemoryAddInstance(WrapperFactory wrapperFactory, Instance c, String nodeName, ModelRegistry registry, BootstrapService bs, ModelService modelService) {
        this.wrapperFactory = wrapperFactory;
        this.c = c;
        this.nodeName = nodeName;
        this.registry = registry;
        this.bs = bs;
        this.modelService = modelService;
    }

    @Override
    public boolean execute() {
        Thread subThread = null;
        try {
            tg = new KevoreeThreadGroup("kev/" + c.path());
            subThread = new Thread(tg, this);
            subThread.start();
            subThread.join();
            return resultSub;
        } catch(Throwable e) {
            if (subThread != null) {
                try {
                    subThread.stop(); //kill sub thread
                } catch(Throwable t) {
                    //ignore killing thread
                }
            }
            String message = "Could not add the instance " + c.getName() + ":" + c.getTypeDefinition().getName();
            Log.error(message, e);
            return false;
        }
    }

    @Override
    public void undo() {
//        RemoveInstance(wrapperFactory, c, nodeName, registry, bs, modelService).execute()
    }

    @Override
    public void run() {
        try {

            FlexyClassLoader newKCL = ClassLoaderHelper.createInstanceClassLoader(c, nodeName, bs);
            Thread.currentThread().setContextClassLoader(newKCL);
            Thread.currentThread().setName("KevoreeAddInstance" + c.getName());
            KInstanceWrapper newBeanKInstanceWrapper;
            if (c instanceof ContainerNode) {
                newBeanKInstanceWrapper = wrapperFactory.wrap(c, this/* nodeInstance is useless because launched as external process */, tg, bs, modelService);
                newBeanKInstanceWrapper.setKcl(newKCL);
                registry.register(c, newBeanKInstanceWrapper);
            } else {
                Object newBeanInstance = bs.createInstance(c, newKCL);
                newBeanKInstanceWrapper = wrapperFactory.wrap(c, newBeanInstance, tg, bs, modelService);
                newBeanKInstanceWrapper.setKcl(newKCL);
                registry.register(c, newBeanKInstanceWrapper);
                bs.injectDictionary(c, newBeanInstance, true);
            }
            if (c instanceof ComponentInstance) {
                KInstanceWrapper wrapper = (KInstanceWrapper) registry.lookup(c);
                Object obj = wrapper.getTargetObj();
                    Field []fields = obj.getClass().getDeclaredFields();
                    for (Field f : fields) {
                        if (f.getType().equals(ModelRegistry.class) /*&&
                                f.isAnnotationPresent(KevoreeInject.class)*/
                                )
                        {
                            try {
                                f.set(obj, registry);
                            } catch (IllegalAccessException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
            }
            newBeanKInstanceWrapper.create();
            resultSub = true;
            Thread.currentThread().setContextClassLoader(null);
            Log.info("Add instance {}", c.path());
        } catch(Throwable e) {
            Log.error("Error while adding instance {}", e, c.path());
            resultSub = false;
        }
    }
}

