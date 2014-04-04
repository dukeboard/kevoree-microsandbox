package org.kevoree.monitoring.comp.monitor;

import org.kevoree.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 9/5/13
 * Time: 2:22 PM
 */
@ComponentType
public class ContractCreatorComponent {

    @Param(optional = false)
    String kevs_file;

    private double cpu;
    private double memory;

    HashMap<String,InfoForContractCreation> set = new HashMap<String,InfoForContractCreation>();


    @Start
    public void start() {

    }

    @Stop
    public void stop() {

    }

    @Update
    public void update() {
        stop();
        start();
    }

    @Input
    public void CPUThreshold(Object obj) {
        cpu = (Double)obj;
        saveInfo();
    }

    @Input
    public void MemThreshold(Object obj) {
        memory = (Double)obj;
        saveInfo();
    }

    @Input
    public void componentProcessor(Object obj) {
        InfoForContractCreation s = (InfoForContractCreation)obj;

        set.put(s.path, s);

        saveInfo();
    }

    private synchronized void saveInfo() {
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(kevs_file));
            ps.printf("addComponent monitoringComponent0@NODE_NAME: MonitoringComponent {\n" +
                    "\tcpu_threshold = '%f',\n" +
                    "\tmemory_threshold = '%f' \n" +
                    "}\n", cpu, memory);
            for (String name : set.keySet()) {
                InfoForContractCreation info = set.get(name);

                String s = String.format("throughput_msg_per_second='all=%d",info.allPortCalls);
                for (String ss : info.calls.keySet()) {
                    s += String.format(";%s=%d", ss, info.calls.get(ss));
                }
                s+="'\n";

                ps.printf("addComponent %s@NODE_NAME : %s {\n" +
                        "\tcpu_wall_time = '%d',\n" +
                        "\tmemory_max_size = '%d'\n" +
                        "\t" + s +
                        "}\n", name, name, info.maxCPU, info.maxReserved);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (ps != null)
                ps.close();
        }
    }
}
