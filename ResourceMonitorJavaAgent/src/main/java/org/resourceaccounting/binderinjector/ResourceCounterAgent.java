/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/23/13
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */

package org.resourceaccounting.binderinjector;


import org.kevoree.microsandbox.core.instrumentation.strategies.MyResourceContractProvider;
import org.resourceaccounting.ObjectSizeProvider;
import org.resourceaccounting.binder.ResourceCounter;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class ResourceCounterAgent {
    private static volatile Instrumentation globalInst;
    public static void premain(String agentArgs, Instrumentation inst) {

        if (!inst.isRetransformClassesSupported()) {
            System.out.println("Class re-transformation is not supported");
            System.exit(2);
        }

        globalInst = inst;

        System.out.println(globalInst.getObjectSize(new boolean[100]));

        ResourceCounter.setResourceContractProvider(new MyResourceContractProvider("",""));
        ResourceCounter.setObjectSizeProvider(new ObjectSizeProvider() {
            public long sizeOf(Object obj) {
                return globalInst.getObjectSize(obj);
            }
        });

        boolean debug = agentArgs != null && agentArgs.length() > 0 &&  agentArgs.equals("debug");
        inst.addTransformer(new BinderClassTransformer(inst, debug),true);

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                    globalInst.retransformClasses(Integer.class);
                }
                catch (UnmodifiableClassException e) {
                }
                catch (InterruptedException e) {
                }
            }
        }.start();

    }
}
