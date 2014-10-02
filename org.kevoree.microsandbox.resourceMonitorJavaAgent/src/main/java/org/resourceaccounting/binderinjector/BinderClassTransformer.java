package org.resourceaccounting.binderinjector;

import org.kevoree.microsandbox.core.OnNewThreadNotifier;
import org.kevoree.microsandbox.core.instrumentation.ExtraInstrumentationRules;
import org.kevoree.microsandbox.core.instrumentation.InstrumenterCommand;
import org.resourceaccounting.binder.LowLevelMonitoringModes;
import org.resourceaccounting.binder.MonitoringStatusList;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/23/13
 * Time: 3:19 PM
 */
public class BinderClassTransformer implements ClassFileTransformer {

    private InstrumenterCommand cmd = new InstrumenterCommand();

    boolean debug = false;

    LowLevelMonitoringModes lowLevelMonitoringModes = LowLevelMonitoringModes.SCAPEGOAT;

    public void setScapegoat() {
        lowLevelMonitoringModes = LowLevelMonitoringModes.SCAPEGOAT;
    }

    public void setSquirrel() {
        lowLevelMonitoringModes = LowLevelMonitoringModes.SQUIRREL;
    }

    public void setScapegoat2() {
        lowLevelMonitoringModes = LowLevelMonitoringModes.SCAPEGOAT2;
    }

    public BinderClassTransformer(Instrumentation inst, boolean debug) {
        this.debug = debug;
    }

    public byte[] transform(ClassLoader classLoader, String className, Class<?> aClass,
                            ProtectionDomain protectionDomain, byte[] bytes) throws IllegalClassFormatException {

        if (className.equals("java/lang/Integer")) {
//            System.out.println("ASKING FOR Integer");
            return cmd.instrumentProxyClass(bytes);
        }

//        if (className.contains("MonitoringStatusList")) {
//            System.err.printf("1111 - Loading %s %s\n", className, classLoader);
//            for (StackTraceElement e : Thread.currentThread().getStackTrace()) {
//                System.err.printf("\t %s \n", e.toString());
//            }
//        }

//        if (!isScapegoat) {
//            System.out.println("Doing the job for class : " + className);
//            return cmd.instrumentThreadCreationDetection(bytes, className,
//                    "java/lang/Integer", "__reportNewThread__");
//        }

        if (!ExtraInstrumentationRules.isInstrumentable(className)) {
            return null;
        }

        boolean instr_mem = false;
        boolean instr_instr = false;
        boolean instr_thread_creation = lowLevelMonitoringModes.equals(LowLevelMonitoringModes.SQUIRREL);
        ClassLoader original = classLoader;
        classLoader = searchProperLoader(classLoader);
//        System.out.printf("Discovering if class %s has to be modified %s\n", className, classLoader);
        if (classLoader != null) {
            int hash = classLoader.hashCode();
            String appId = MonitoringStatusList.instance().getAppId(hash);
//            if (appId == null || appId.equals("")) {
//                // pepe
//                if (className.contains("org/daum/library/javase")) {
//                    System.err.printf("EL COCO NO TIENE AGUA classname=%s cl_found=(%s,%d) cl_thread=(%d)\n",
//                            className, original,original.hashCode(), Thread.currentThread().getContextClassLoader().hashCode());
//                }
//            }
            // I should save this class to re-transform it as soon as the system decides
            // In fact, the solution is close to using a Pair<Name, ClassLoader> as key
            // I say "close" because of the hierarchy between classloaders
            MonitoringStatusList.instance().saveClassName(appId, className, original);
            if (lowLevelMonitoringModes.equals(LowLevelMonitoringModes.SCAPEGOAT)
                    && MonitoringStatusList.instance().isMonitored(appId)) {
                instr_mem = MonitoringStatusList.instance().isMemoryMonitored(appId);
                instr_instr = MonitoringStatusList.instance().isCPUMonitored(appId);
                //System.out.printf("Classloader %d %s %s %s %s 000\n",hash, appId, className,instr_mem, instr_instr);
            }
            else if (lowLevelMonitoringModes.equals(LowLevelMonitoringModes.SCAPEGOAT)
                    && MonitoringStatusList.instance().isMemoryMonitored(appId)) {
                instr_mem = true;
//                System.out.printf("Classloader %d %s %s %s %s 111\n",hash, appId, className,instr_mem, instr_instr);
            }
            else if (lowLevelMonitoringModes.equals(LowLevelMonitoringModes.SCAPEGOAT2)
                    && MonitoringStatusList.instance().isMonitored(appId)) {
                instr_instr = MonitoringStatusList.instance().isCPUMonitored(appId);
            }
        }


        // add code to account for memory consumption
        // 1 - add field __principalID__ to classes (no interfaces, no annotations, no enum, no abstract)
        // 2 - Add finalize (or modify) to the same set of classes
        // 3 - One problem remains, with the method above a class may have two or more __principalID__
        //     However, only one of them will have a value different from 0
        byte[] result = cmd.instrument(bytes, className, instr_mem, instr_instr, instr_thread_creation);
        return result;
    }

    private ClassLoader searchProperLoader(ClassLoader loader) {
        while (loader != null &&
                !loader.getClass().getCanonicalName().endsWith("KevoreeJarClassLoaderCoverageInjection") &&
                !loader.getClass().getCanonicalName().endsWith("SharedClassLoader") &&
                !loader.getClass().getCanonicalName().endsWith("FlexyClassLoaderImpl") &&
                !loader.getClass().getCanonicalName().endsWith("MicrosandboxLoader")) {
            loader = loader.getParent();
        }

        return loader;
    }

    static Object handler;

    public static synchronized void setHandler(Object h) {
        handler = h;
    }
}
