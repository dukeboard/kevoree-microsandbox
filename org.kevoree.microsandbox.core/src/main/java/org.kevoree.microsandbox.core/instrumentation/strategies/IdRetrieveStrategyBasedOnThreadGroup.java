package org.kevoree.microsandbox.core.instrumentation.strategies;

import org.objectweb.asm.commons.InstructionAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/30/13
 * Time: 6:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class IdRetrieveStrategyBasedOnThreadGroup extends AbstractIdRetrieveStrategy {
    public IdRetrieveStrategyBasedOnThreadGroup(InstructionAdapter instructionAdapter) {
        super(instructionAdapter);
    }

    public void generateByteCodeToGetId() {
        instructionAdapter.invokestatic("java/lang/Thread", "currentThread" ,"()Ljava/lang/Thread;");
        instructionAdapter.invokestatic("org/resourceaccounting/binder/ThreadGroupResourcePrincipal",
                "get", "(Ljava/lang/Thread;)Lorg/resourceaccounting/ResourcePrincipal;");
    }
}
