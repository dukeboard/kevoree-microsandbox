package org.kevoree.monitoring;

import org.kevoree.ComponentInstance;
import org.kevoree.ContainerNode;
import org.kevoree.ContainerRoot;
import org.kevoree.DeployUnit;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Start;
import org.kevoree.annotation.Stop;
import org.kevoree.annotation.Update;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.kaspects.TypeDefinitionAspect;
import org.kevoree.kcl.KevoreeJarClassLoader;
import org.kevoree.microsandbox.core.CoverageRuntime;

import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/24/13
 * Time: 3:55 PM
 *
 */
@ComponentType
public class CoverageChecker extends AbstractComponentType {
    private class Th extends Thread {
        private synchronized boolean isB() {
            return b;
        }

        private synchronized void setB(boolean b) {
            this.b = b;
        }

        boolean b;
        @Override
        public void run() {
            TypeDefinitionAspect lala = new TypeDefinitionAspect();
            while (!isB()) {
                try {
                    Thread.sleep(3000);

                    for (ComponentInstance instance : componentInstances) {
                        DeployUnit unit = lala.foundRelevantDeployUnit(instance.getTypeDefinition(),containerNode);
                        ClassLoader loader = loader(unit);
                        System.out.println("Trying RARA : " + loader.getClass() +
                                " component " + instance.getName() + " " +
                                CoverageRuntime.instance$.calculateCoverage(loader)
                        );
                    }

                } catch (InterruptedException e) {

                }
            }
        }
    }

    Th th;

    List<ComponentInstance> componentInstances;
    ContainerNode containerNode;

    public KevoreeJarClassLoader loader(DeployUnit unit) {
        return getBootStrapperService().getKevoreeClassLoaderHandler().getKevoreeClassLoader(unit);
    }

    @Start
    public void startComponent() {
        th = new Th();
        th.start();
        ContainerRoot root = getModelService().getLastModel();
        System.out.println("Deploy Units");
        for (DeployUnit unit : root.getDeployUnits()) {
            System.out.println("    " + unit.getUnitName());
        }



        System.out.println("Nodes");
        for (ContainerNode node : root.getNodes()) {
            if (!getNodeName().equals(node.getName())) continue;
            containerNode = node;
            System.out.println("    Node : " + node.getName());
            componentInstances = node.getComponents();
            for (ComponentInstance instance : node.getComponents()) {
                System.out.println("        Component : " + instance.getName());
            }
        }
    }

    @Stop
    public void stopComponent() {
        th.setB(true);
    }

    @Update
    public void updateComponent() {
        stopComponent();
        startComponent();
    }
}
