package org.kevoree.microsandbox.cgroupNode;

import org.kevoree.ComponentInstance;
import org.kevoree.DictionaryValue;
import org.kevoree.microsandbox.api.contract.PlatformDescription;
import org.kevoree.microsandbox.monitoredNode.ControlAdmissionSystem;
import org.kevoree.microsandbox.monitoredNode.KevoreeComponentResourceContract;
import org.resourceaccounting.contract.ResourceContract;
import org.resourceaccounting.contract.ResourceContractProvider;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 1/5/14
 * Time: 9:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class NewThreadCreated {

    private final String componentPrefix;
    private final PlatformDescription description;
    private final String nodeName;
    private Object lock = new Object();

    private final Set<Long> threads = new HashSet<Long>();
    private final Map<String,Integer> components = new HashMap<String,Integer>();

    private int lastId = 0;
    private List<ComponentInstance> componentList = new ArrayList<ComponentInstance>();

    public NewThreadCreated(String componentPrefix, PlatformDescription description, String nodeName) {
        this.componentPrefix = componentPrefix;
        this.description = description;
        this.nodeName = nodeName;
    }

    public boolean equals(Object obj) {
        synchronized (lock) {
            Thread t = Thread.currentThread();
            // fixme : go to the root ThreadGroup if needed
            String name = t.getThreadGroup().getName();
            System.out.println("ONE THREAD " + name);
            if (!name.startsWith(componentPrefix)) return true;
            String path = name.replaceAll("kev/","");
            String filePath = path.replaceAll("/","_");
            if (!threads.contains(t.getId())) {
                threads.add(t.getId());

                int id;
                if (!components.containsKey(name)) {

                    ResourceContract contract = ControlAdmissionSystem.instance$.getContract(path);
                     //getComponent(name.replaceFirst(componentPrefix, ""));
                    if (contract != null && contract.getCPU() > 0) {
                        components.put(name, ++lastId);
                        double tmp = (1000.0 * contract.getCPU()) / description.availability_instr;
                        System.out.printf("%d %d %f %d\n", contract.getCPU(), description.availability_instr, tmp,
                                (int)Math.round(tmp));
                        CPUThreadControl.assignCPULimit(filePath, (int)Math.round(tmp));
//                        CPUThreadControl.assignLimit(lastId, (int)Math.round(tmp));
                        id = lastId;
                        CPUThreadControl.attachToCPUSubsystem(filePath);
//                        System.out.printf("Attaching 2 thread to %s and assigning id=%d\n", name, id);
                    }
                    else {
                        System.out.println((contract != null));
                    }
                }
                else {
                    id = components.get(name);
                    CPUThreadControl.attachToCPUSubsystem(filePath);
//                    System.out.printf("Attaching 1 thread to %s and assigning id=%d\n", name, id);
                }
            }
        }
        return true;
    }

    public void freeze(String name, boolean b) {
        synchronized (threads){
            if (components.containsKey(name)) {
                int id = components.get(name);
                CPUThreadControl.setFrozen(id, b);
            }
        }
    }
}
