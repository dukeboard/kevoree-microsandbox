package org.kevoree.monitoring.comp.viewer;

import org.kevoree.*;
import org.kevoree.annotation.ComponentType;
import org.kevoree.annotation.Start;
import org.kevoree.annotation.Stop;
import org.kevoree.annotation.Update;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.kaspects.TypeDefinitionAspect;
import org.kevoree.kcl.KevoreeJarClassLoader;
import org.kevoree.microsandbox.core.CoverageRuntime;
import org.kevoree.microsandbox.core.Entry;
import org.kevoree.monitoring.ranking.ComponentExecutionInfo;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


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

                    for (WeakReference<ComponentInstance> ref : componentInstances) {
                        ComponentInstance instance = ref.get();
                        if (instance == null) continue;

                        DeployUnit unit = lala.foundRelevantDeployUnit(instance.getTypeDefinition(),containerNode);
                        ClassLoader loader = loader(unit);

                        ComponentExecutionInfo info1 = info.get(instance.getName());

                        Entry entry = CoverageRuntime.instance$.calculateCoverage(loader);
                        info1.setBranchCoverage(entry.getBranchCoverage());
                        info1.setInstructionCoverage(entry.getInstrCoverage());


                        System.out.println("Trying RARA : " + loader.getClass() +
                                " component " + instance.getName() + " " +
                                entry
                        );
                    }

                } catch (InterruptedException e) {

                }
            }
        }
    }

    Th th;

    List<WeakReference<ComponentInstance>> componentInstances;
    HashMap<String, ComponentExecutionInfo> info = new HashMap<String, ComponentExecutionInfo>();
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
            componentInstances = new ArrayList<WeakReference<ComponentInstance>>();
            for (ComponentInstance instance : node.getComponents()) {
                System.out.println("        Component : " + instance.getName());
                componentInstances.add(new WeakReference<ComponentInstance>(instance));
                info.put(instance.getName(), new ComponentExecutionInfo(instance.getName(),0));

                if (instance.getDictionary() != null) {
                    List<DictionaryValue> values = instance.getDictionary().getValues();
                    for (DictionaryValue v : values) {
                        System.out.println("            Parameter : " + v.getAttribute().getName() + "=" + v.getValue());
                    }
                }
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
