package org.kevoree.microsandbox.core.instrumentation.strategies;

import org.objectweb.asm.commons.InstructionAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/8/13
 * Time: 8:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class IdRetriveStrategyForKevoree extends AbstractIdRetrieveStrategy {
    public IdRetriveStrategyForKevoree(InstructionAdapter instructionAdapter) {
        super(instructionAdapter);
    }

    public void generateByteCodeToGetId() {
        instructionAdapter.invokestatic("org/resourceaccounting/binder/ResourceCounter",
                "get", "()Lorg/resourceaccounting/ResourcePrincipal;");
    }
}
