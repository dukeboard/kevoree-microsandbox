package org.kevoree.microsandbox.cgroupNode;

import org.kevoree.ComponentInstance;
import org.kevoree.DictionaryValue;
import org.kevoree.microsandbox.api.contract.PlatformDescription;
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
            String path = name.replaceAll("kev/","").replaceAll("/","_");
            if (!threads.contains(t.getId())) {
                threads.add(t.getId());

                int id;
                if (!components.containsKey(name)) {
                    ResourceContract contract = getComponent(name.replaceFirst(componentPrefix, ""));
                    if (contract != null && contract.getCPU() > 0) {
                        components.put(name, ++lastId);
                        double tmp = (1000.0 * contract.getCPU()) / description.availability_instr;
                        System.out.printf("%d %d %f %d\n", contract.getCPU(), description.availability_instr, tmp,
                                (int)Math.round(tmp));
                        CPUThreadControl.assignCPULimit(path, (int)Math.round(tmp));
//                        CPUThreadControl.assignLimit(lastId, (int)Math.round(tmp));
                        id = lastId;
                        CPUThreadControl.attachToCPUSubsystem(path);
//                        System.out.printf("Attaching 2 thread to %s and assigning id=%d\n", name, id);
                    }
                    else
                        System.out.println((contract != null));
                }
                else {
                    id = components.get(name);
                    CPUThreadControl.attachToCPUSubsystem(path);
//                    System.out.printf("Attaching 1 thread to %s and assigning id=%d\n", name, id);
                }
            }
        }
        return true;
    }

    public synchronized ResourceContract getComponent(String componentPath) {
        System.out.printf("Creating component with path %s\n", componentPath);
        ComponentInstance instance = null;
        for (ComponentInstance instance1 : componentList) {
            String path = String.format("nodes[%s]/components[%s]", nodeName,
                    instance1.getName());
            if (path.equals(componentPath))
                instance = instance1;
        }
        if (instance == null) {
            return null;
        }
        long mem = 0;
        long netIn = 0;
        long netOut = 0;
        long instr = 0;

        org.kevoree.Dictionary dictionary = instance.getDictionary();
        if (dictionary != null) {
            List<DictionaryValue> values = dictionary.getValues();


            for (int i = 0 ; i < values.size() ; i++) {
                DictionaryValue dv = values.get(i);
                String name = dv.getAttribute().getName();
                if (name.equals("cpu_wall_time")) {
                    instr = Long.parseLong(dv.getValue());
                }
                else if (name.equals("memory_max_size")) {
                    mem = Long.parseLong(dv.getValue());
                }
                else if (name.equals("network_input_peak_seconds")) {
                    netIn = Long.parseLong(dv.getValue());
                }
                else if (name.equals("network_output_peak_seconds")) {
                    netOut = Long.parseLong(dv.getValue());
                }
            }
//            System.out.println("Found " + instance.getName());
        }

        ResourceContract contract = new KevoreeComponentResourceContract(instr, mem, netOut, netIn);

        return contract;
    }

    public void freeze(String name, boolean b) {
        synchronized (threads){
            if (components.containsKey(name)) {
                int id = components.get(name);
                CPUThreadControl.setFrozen(id, b);
            }
        }
    }


    public synchronized void addComponent(ComponentInstance instance) {
        componentList.add(instance);
    }
}
