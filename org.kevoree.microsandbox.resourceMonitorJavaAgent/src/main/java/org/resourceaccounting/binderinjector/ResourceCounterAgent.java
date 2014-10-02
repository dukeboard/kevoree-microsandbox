/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/23/13
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */

package org.resourceaccounting.binderinjector;


import org.kevoree.microsandbox.core.OnNewThreadNotifier;
import org.kevoree.microsandbox.core.instrumentation.strategies.DefaultResourceContractProvider;
import org.resourceaccounting.ObjectSizeProvider;
import org.resourceaccounting.binder.MonitoringStatusList;
import org.resourceaccounting.binder.ResourceCounter;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class ResourceCounterAgent implements OnNewThreadNotifier.HandlerSet{
    private static final String SCAPEGOAT = "scapegoat";
    private static final String SCAPEGOAT2 = "scapegoat2";
    private static final String SQUIRREL = "squirrel";
    private static volatile Instrumentation globalInst;

    public static void premain(String agentArgs, Instrumentation inst) {

        OnNewThreadNotifier.getInstance().setListener(new ResourceCounterAgent());

        if (!inst.isRetransformClassesSupported()) {
            System.out.println("Class re-transformation is not supported");
            System.exit(2);
        }

        globalInst = inst;



        final boolean isScapegoat = agentArgs != null && agentArgs.length() > 0 && agentArgs.equals(SCAPEGOAT);
        final boolean isSquirrel =  !isScapegoat &&
                agentArgs != null && agentArgs.length() > 0 && agentArgs.equals(SQUIRREL);
        final boolean isScapegoat2 =  !isScapegoat && !isSquirrel &&
                agentArgs != null && agentArgs.length() > 0 && agentArgs.equals(SCAPEGOAT2);

        if (isScapegoat) {
            System.out.println("Agent started and it has been detected Scapegoat mode");
            ResourceCounter.setResourceContractProvider(new DefaultResourceContractProvider("",""));
            ResourceCounter.setObjectSizeProvider(new ObjectSizeProvider() {
                public long sizeOf(Object obj) {
                    return globalInst.getObjectSize(obj);
                }
            });
            MonitoringStatusList.instance().setGlobalInst(globalInst);

            boolean debug = agentArgs != null && agentArgs.length() > 0 &&  agentArgs.equals("debug");
            BinderClassTransformer bct = new BinderClassTransformer(inst, debug);
            inst.addTransformer(bct,true);
            bct.setScapegoat();
        }
        else if (isScapegoat2) {
            System.out.println("Agent started and it has been detected Scapegoat2 mode");
            ResourceCounter.setResourceContractProvider(new DefaultResourceContractProvider("",""));
            ResourceCounter.setObjectSizeProvider(new ObjectSizeProvider() {
                public long sizeOf(Object obj) {
                    return globalInst.getObjectSize(obj);
                }
            });
            MonitoringStatusList.instance().setGlobalInst(globalInst);

            BinderClassTransformer bct = new BinderClassTransformer(inst, false);
            inst.addTransformer(bct,true);
            bct.setScapegoat2();
        }
        else {
            System.out.println("Agent started and it has been detected non-scapegoat mode");
            BinderClassTransformer bct = new BinderClassTransformer(inst, false);
            bct.setSquirrel();
            inst.addTransformer(bct,true);
        }

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(300);
                    globalInst.retransformClasses(Integer.class);
                    System.out.println("Retransforming the proxy class");
                }
                catch (UnmodifiableClassException e) { }
                catch (InterruptedException e) { }
            }
        }.start();

    }

    @Override
    public void onHandlerSet(Object obj) {
        ResourceCounter.handlerNewThread = obj;
    }
}
