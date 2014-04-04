package org.kevoree.microsandbox.samples.update;

import org.kevoree.annotation.*;
import org.kevoree.api.ModelService;
import org.kevoree.microsandbox.api.contract.FullContracted;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/7/13
 * Time: 5:48 PM
 *
 */
@ComponentType
public class SimpleComponent extends FullContracted {

    @KevoreeInject
    ModelService modelService;

    @Start
    public void startComponent() {
        System.out.println("Starting : " + SimpleComponent.class.getName());

        System.out.println("\t" + modelService.getCurrentModel().getUUID());
        System.out.println("\t" + modelService.getCurrentModel().getUUID());



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
