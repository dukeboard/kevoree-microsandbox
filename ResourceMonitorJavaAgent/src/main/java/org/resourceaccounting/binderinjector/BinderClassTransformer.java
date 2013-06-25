package org.resourceaccounting.binderinjector;

import org.jacoco.core.analysis.*;
import org.jacoco.core.data.ExecutionDataStore;
import org.jacoco.core.data.SessionInfoStore;
import org.jacoco.core.instr.Instrumenter;
import org.jacoco.core.runtime.IRuntime;
import org.jacoco.core.runtime.LoggerRuntime;
import org.jacoco.core.runtime.RuntimeData;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.System;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/23/13
 * Time: 3:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinderClassTransformer implements ClassFileTransformer {

    private InstrumenterCommand cmd = new InstrumenterCommand();

    private final IRuntime runtime;
    private final Instrumenter instr;
    private final RuntimeData data;

    boolean debug = false;


    class ClassToCover {
        String clazz;
        ClassLoader loader;

        ClassToCover(String clazz, ClassLoader loader) {
            this.clazz = clazz;
            this.loader = loader;
        }

        private void printCounter(final String unit, final ICounter counter) {
            final Integer missed = Integer.valueOf(counter.getMissedCount());
            final Integer total = Integer.valueOf(counter.getTotalCount());
            System.out.printf("%s of %s %s missed%n", missed, total, unit);
        }

        void calculateCoverage() {
            ExecutionDataStore dataStore = new ExecutionDataStore();
            SessionInfoStore infoStore = new SessionInfoStore();
            data.collect(dataStore, infoStore, false);
            CoverageBuilder coverageBuilder = new CoverageBuilder();
            Analyzer analyzer = new Analyzer(dataStore, coverageBuilder);
            InputStream a = loader.getResourceAsStream(clazz + ".class");
            try {
                analyzer.analyzeClass(a);
                a.close();
            } catch (IOException e) {
                System.out.println("Problems with file : " + clazz);
            }
            for (final IClassCoverage cc : coverageBuilder.getClasses()) {

//                System.out.printf("Coverage of class %s%n", cc.getName());
//
//                for (IMethodCoverage methodCoverage : cc.getMethods()) {
//
//                    System.out.printf("Coverage of method : %s%n", methodCoverage.getName());
//
//                    printCounter("instructions", methodCoverage.getInstructionCounter());
//                    printCounter("branches", methodCoverage.getBranchCounter());
//                    printCounter("lines", methodCoverage.getLineCounter());
//                    printCounter("methods", methodCoverage.getMethodCounter());
//                    printCounter("complexity", methodCoverage.getComplexityCounter());
//                }
            }
        }
    }

    ArrayList<ClassToCover> classes = new ArrayList<ClassToCover>();

    /**
     * Thread to check the coverage of classes
     */
    class CoverageChecker implements Runnable {

        public void run() {
            while (true) {
                try {
//                    System.out.println("Checking Coverage");
                    Thread.sleep(1000);
                    synchronized (classes) {
                        for (int i = 0 ; i < classes.size() ; i++)
                            classes.get(i).calculateCoverage();

                    }
                } catch (InterruptedException e) { }
            }
        }
    }

    public BinderClassTransformer(Instrumentation inst, boolean debug) {
        this.debug = debug;
        // For instrumentation and runtime we need a IRuntime instance
        // to collect execution data:
        runtime = new LoggerRuntime();

        // The Instrumenter creates a modified version of our test target class
        // that contains additional probes for execution data recording:
        instr = new Instrumenter(runtime);

        data = new RuntimeData();

        try {
            runtime.startup(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        new Thread(new CoverageChecker()).start();
    }

    public byte[] transform(ClassLoader classLoader, String className, Class<?> aClass,
                            ProtectionDomain protectionDomain, byte[] bytes) throws IllegalClassFormatException {

        if (className.equals("java/lang/Integer")) {
            System.out.println("ASKING FOR Object");
            return cmd.instrumentProxyClass(bytes);
        }

        if (!ExtraInstrumentationRules.isInstrumentable(className)) {
            return null;
        }

        // add code to account for memory consumption
        // 1 - add field __principalID__ to classes (no interfaces, no annotations, no enum, no abstract)
        // 2 - Add finalize (or modify) to the same set of classes
        // 3 - One problem remains, with the method above a class may have two or more __principalID__
        //     However, only one of them will have a value different from 0
        byte[] result = cmd.instrument(bytes, className);
//        if (((InstForAccountingPerInvocation)visitor).wasComponent()) {
//            result = instr.instrument(result);
//            synchronized (classes) {
//                classes.add(new ClassToCover(className, classLoader));
//            }
//        }
        return result;
    }
}
