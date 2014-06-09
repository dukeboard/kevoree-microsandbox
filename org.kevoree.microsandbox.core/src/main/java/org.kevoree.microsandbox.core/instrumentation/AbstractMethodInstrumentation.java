package org.kevoree.microsandbox.core.instrumentation;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.InstructionAdapter;
import org.kevoree.microsandbox.core.instrumentation.strategies.IdRetriveStrategyForKevoree;

public abstract class AbstractMethodInstrumentation extends InstructionAdapter {

    protected final static String MONITOR_INSTRUCTIONS_EVENT_NAME = "increaseInstructions";
    protected final static String MONITOR_INSTRUCTIONS_EVENT_SIG =
            "(I)V";

    /**
     * Name of the class
     */
    protected String className;

    /**
     * Index of the local variable to store the ResourcePrincipal which is calling the method
     */
    private final IdRetrieveStrategy strategy;


    protected AbstractMethodInstrumentation(MethodVisitor visitor, String className) {
        super(Opcodes.ASM5, visitor);
        this.className = className;
        this.strategy = new IdRetriveStrategyForKevoree(this);
    }

    protected void loadResourcePrincipal() {
        strategy.generateByteCodeToGetId();
    }

    /**
     * Generate the code to send a notification about CPU consumption
     * @param count
     */
    protected void registerCPUConsumption(int count) {
        if (count == 0) return;
        this.iconst(count);
//        loadResourcePrincipal();
        this.invokestatic(ExtraInstrumentationRules.MONITOR_CLASS_NAME,
                MONITOR_INSTRUCTIONS_EVENT_NAME,
                MONITOR_INSTRUCTIONS_EVENT_SIG);
    }
}