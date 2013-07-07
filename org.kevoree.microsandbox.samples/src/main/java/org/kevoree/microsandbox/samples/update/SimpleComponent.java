package org.kevoree.microsandbox.samples.update;

import org.kevoree.ContainerRoot;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Start;
import org.kevoree.annotation.Stop;
import org.kevoree.annotation.Update;
import org.kevoree.api.service.core.handler.ModelListener;
import org.kevoree.api.service.core.handler.UUIDModel;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.microsandbox.api.contract.FullContracted;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/7/13
 * Time: 5:48 PM
 *
 */
@ComponentType
public class SimpleComponent extends AbstractComponentType implements FullContracted {
    @Start
    public void startComponent() {
        System.out.println("Starting : " + SimpleComponent.class.getName());

        System.out.println("\t" + getModelService().getLastUUIDModel().getUUID());
        System.out.println("\t" + getModelService().getLastUUIDModel().getUUID());



//        System.out.println("Funny string");
    }

    @Stop
    public void stopComponent() {
        System.out.println("Stopping : " + SimpleComponent.class.getName());
    }

    @Update
    public void updateComponent() {
        stopComponent();
        System.out.println("Updating : " + SimpleComponent.class.getName());
        startComponent();
    }
}
