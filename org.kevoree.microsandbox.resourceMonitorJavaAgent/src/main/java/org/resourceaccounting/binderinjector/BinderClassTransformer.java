package org.resourceaccounting.binderinjector;

import org.kevoree.microsandbox.core.instrumentation.ExtraInstrumentationRules;
import org.kevoree.microsandbox.core.instrumentation.InstrumenterCommand;
import org.resourceaccounting.binder.MonitoringStatusList;

import java.lang.System;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/23/13
 * Time: 3:19 PM
 */
public class BinderClassTransformer implements ClassFileTransformer {

    private InstrumenterCommand cmd = new InstrumenterCommand();



    boolean debug = false;

    public BinderClassTransformer(Instrumentation inst, boolean debug) {
        this.debug = debug;
    }

    public byte[] transform(ClassLoader classLoader, String className, Class<?> aClass,
                            ProtectionDomain protectionDomain, byte[] bytes) throws IllegalClassFormatException {

        if (className.equals("java/lang/Integer")) {
//            System.out.println("ASKING FOR Integer");
            return cmd.instrumentProxyClass(bytes);
        }

        if (!ExtraInstrumentationRules.isInstrumentable(className)) {
            return null;
        }

        boolean instr_mem = false;
        boolean instr_instr = false;
        classLoader = searchProperLoader(classLoader);
        if (classLoader != null) {
            int hash = classLoader.hashCode();
            String appId = MonitoringStatusList.instance().getAppId(hash);
            if (MonitoringStatusList.instance().isMonitored(appId)) {
                instr_mem = MonitoringStatusList.instance().isMemoryMonitored(appId);
                instr_instr = MonitoringStatusList.instance().isCPUMonitored(appId);
//                System.out.printf("Classloader %d %s %s %s %s\n",hash, appId, className,instr_mem, instr_instr);
            }
        }


        // add code to account for memory consumption
        // 1 - add field __principalID__ to classes (no interfaces, no annotations, no enum, no abstract)
        // 2 - Add finalize (or modify) to the same set of classes
        // 3 - One problem remains, with the method above a class may have two or more __principalID__
        //     However, only one of them will have a value different from 0
        byte[] result = cmd.instrument(bytes, className, instr_mem, instr_instr);
        return result;
    }

    private ClassLoader searchProperLoader(ClassLoader loader) {
        while (loader != null &&
                !loader.getClass().getCanonicalName().endsWith("KevoreeJarClassLoaderCoverageInjection"))
            loader = loader.getParent();
        return loader;
    }
}
