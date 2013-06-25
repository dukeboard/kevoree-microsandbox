/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/23/13
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */

package org.resourceaccounting.binderinjector;


import org.resourceaccounting.binderinjector.strategies.MyResourceContractProvider;
import org.resourceaccounting.contract.ResourceContractProvider;
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

        String contractFile = "";
        String packageName = "";

        // reading arguments
        String[] args = agentArgs.split(",");
        for (String arg: args) {
            String[] ahh = arg.split(":");
            if (ahh[0].equals("ContractFile"))
                contractFile = ahh[1];
            else if (ahh[0].equals("PackageForContracts"))
                packageName = ahh[1];
        }

        // specifying where is the contract
        ResourceContractProvider provider = new MyResourceContractProvider(contractFile, packageName);
        ResourceCounter.setResourceContractProvider(provider);
        ResourceCounter.setObjectSizeProvider(new ObjectSizeProvider() {
            public long sizeOf(Object obj) {
                return globalInst.getObjectSize(obj);
            }
        });

        // setting the MBEAN to notify ResourceConsumption
//        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
//        ObjectName name;
//        try {
//            name = new ObjectName("org.resourceaccounting:type=ResourceConsumptionRecorder");
//            ResourceConsumptionRecorder mbean = new ResourceConsumptionRecorder();
//            mbs.registerMBean(mbean, name);
//        } catch (MalformedObjectNameException e) {
//            e.printStackTrace();
//        } catch (NotCompliantMBeanException e) {
//            e.printStackTrace();
//        } catch (InstanceAlreadyExistsException e) {
//            e.printStackTrace();
//        } catch (MBeanRegistrationException e) {
//            e.printStackTrace();
//        }
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
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.

                }
                catch (InterruptedException e) {

                }
            }
        }.start();

    }
}
