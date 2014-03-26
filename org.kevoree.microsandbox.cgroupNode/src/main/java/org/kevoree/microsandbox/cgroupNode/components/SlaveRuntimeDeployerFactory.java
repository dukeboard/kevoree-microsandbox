package org.kevoree.microsandbox.cgroupNode.components;

/**
 * Created by inti on 3/11/14.
 */
class SlaveRuntimeDeployerFactory {

    public static final String CRIU = "CRIU";
    public static final String PROCESSBasedStrategy = "Process";

    private SlaveRuntimeDeployerFactory() {}

    public static SlaveRuntimeDeployer get(String name) {
        if (name.equals(CRIU))
            return new CRIUStrategy();
        else if (name.equals(PROCESSBasedStrategy)) {
            return new PROCESSBasedStrategy();
        }
        else throw new RuntimeException();
    }
}
