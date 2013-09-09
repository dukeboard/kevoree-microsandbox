package org.kevoree.microsandbox.monitoring;

import org.kevoree.ContainerRoot;
import org.kevoree.api.service.core.handler.*;
import org.kevoree.context.ContextRoot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 09/09/13
 * Time: 10:57
 *
 * @author Erwan Daubert
 * @version 1.0
 */
public class KevoreeModelHandlerServiceMock implements KevoreeModelHandlerService {

    private ContainerRoot lastModel;
    private List<ContainerRoot> historyModel;
    private String nodeName;

    @Override
    public ContainerRoot getLastModel() {
        return lastModel;
    }

    @Override
    public List<ContainerRoot> getPreviousModel() {
        if (historyModel != null) {
        return historyModel;
        } else {
            return new ArrayList<ContainerRoot>(0);
        }
    }

    @Override
    public String getNodeName() {
        return nodeName;
    }

    public void setLastModel(ContainerRoot model) {
        if (historyModel == null) {
            historyModel = new ArrayList<ContainerRoot>(0);
        }
        historyModel.add(lastModel);
        lastModel = model;
    }

    public void setNodeName(String name) {
        nodeName = name;
    }

    @Override
    public UUIDModel getLastUUIDModel() {
        return null;
    }

    @Override
    public Date getLastModification() {
        return null;
    }

    @Override
    public void updateModel(ContainerRoot containerRoot) {
    }

    @Override
    public void updateModel(ContainerRoot containerRoot, ModelUpdateCallback modelUpdateCallback) {
    }

    @Override
    public Date atomicUpdateModel(ContainerRoot containerRoot) {
        return null;
    }

    @Override
    public void compareAndSwapModel(UUIDModel uuidModel, ContainerRoot containerRoot) {
    }

    @Override
    public void compareAndSwapModel(UUIDModel uuidModel, ContainerRoot containerRoot, ModelUpdateCallback modelUpdateCallback) {
    }

    @Override
    public Date atomicCompareAndSwapModel(UUIDModel uuidModel, ContainerRoot containerRoot) throws KevoreeModelUpdateException {
        return null;
    }

    @Override
    public void registerModelListener(ModelListener modelListener) {
    }

    @Override
    public void unregisterModelListener(ModelListener modelListener) {
    }

    @Override
    public ContextRoot getContextModel() {
        return null;
    }

    @Override
    public void acquireLock(ModelHandlerLockCallBack modelHandlerLockCallBack, Long aLong) {
    }

    @Override
    public void releaseLock(UUID uuid) {
    }

    @Override
    public boolean checkModel(ContainerRoot containerRoot) {
        return false;
    }
}
