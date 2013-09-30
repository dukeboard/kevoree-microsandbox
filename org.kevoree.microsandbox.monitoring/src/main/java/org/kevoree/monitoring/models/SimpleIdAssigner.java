/*
package org.kevoree.monitoring.models;

import org.kevoree.ContainerRoot;
import org.kevoree.api.service.core.handler.KevoreeModelHandlerService;

import java.util.List;

*/
/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/7/13
 * Time: 11:10 PM
 * For testing
 *//*

public class SimpleIdAssigner implements IdAssigner {
    public SimpleIdAssigner(KevoreeModelHandlerService service) {
        this.service = service;
    }

    KevoreeModelHandlerService service;

    @Override
    public ModelID getID(ContainerRoot model) {
        int i = 0;
        List<ContainerRoot> rootList = service.getPreviousModel();
        for (; i < rootList.size() ; i++)
            if (rootList.get(i).deepModelEquals(model))
                return new SimpleModelID(i);
        if (service.getLastModel().deepModelEquals(model))
            return new SimpleModelID(i);
        return null;
    }

    @Override
    public boolean isNewVersion(String componentPath, ModelID id) {
        int i = 0;
        List<ContainerRoot> rootList = service.getPreviousModel();
        for (; i < rootList.size() ; i++) {
            ModelID idTmp = new SimpleModelID(i);
            if (idTmp.isTheSameAs(id)) {
                // check if the component is a new version
                return true;
            }
        }
        ModelID idTmp = new SimpleModelID(i);
        if (idTmp.isTheSameAs(id)) {
            // check if the component is a new version
            return true;
        }
        return false;
    }


}
*/
