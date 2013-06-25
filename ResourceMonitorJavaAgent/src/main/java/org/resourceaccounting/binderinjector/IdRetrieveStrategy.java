package org.resourceaccounting.binderinjector;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/30/13
 * Time: 11:59 AM
 * To change this template use File | Settings | File Templates.
 */
public interface IdRetrieveStrategy {
    /**
     * Generate the bytecode to get the resource principal that must be charge for the resource consumption
     */
    public void generateByteCodeToGetId();
}
