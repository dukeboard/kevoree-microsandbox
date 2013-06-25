package org.resourceaccounting.binderinjector.strategies;

import org.objectweb.asm.commons.InstructionAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/30/13
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class IdRetrieveStrategyBasedOnThread extends AbstractIdRetrieveStrategy {

    public IdRetrieveStrategyBasedOnThread(InstructionAdapter instructionAdapter) {
        super(instructionAdapter);
    }

    public void generateByteCodeToGetId() {
        instructionAdapter.invokestatic("java/lang/Thread", "currentThread" ,"()Ljava/lang/Thread;");
        instructionAdapter.invokestatic("org/resourceaccounting/binder/ThreadResourcePrincipal",
                "get", "(Ljava/lang/Thread;)Lorg/resourceaccounting/ResourcePrincipal;");
    }

}
