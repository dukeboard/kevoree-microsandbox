package org.resourceaccounting.contract;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 5/18/13
 * Time: 10:28 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ResourceContractProvider {
    ResourceContract obtainContractFor(String componentName);
}
