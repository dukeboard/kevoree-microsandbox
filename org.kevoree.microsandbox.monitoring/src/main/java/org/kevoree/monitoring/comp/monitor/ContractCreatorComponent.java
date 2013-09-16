package org.kevoree.monitoring.comp.monitor;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 9/5/13
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */
@Provides({
        @ProvidedPort(name = "CPUThreshold", type = PortType.MESSAGE),
        @ProvidedPort(name = "MemThreshold", type = PortType.MESSAGE),
        @ProvidedPort(name = "componentProcessor", type = PortType.MESSAGE)
})
@DictionaryType({
        @DictionaryAttribute(name = "kevs_file", dataType = String.class, optional = false)
})
@ComponentType
public class ContractCreatorComponent extends AbstractComponentType {


    private double cpu;
    private double memory;

    HashMap<String,InfoForContractCreation> set = new HashMap<String,InfoForContractCreation>();
    String file ;


    @Start
    public void start() {
        file = getDictionary().get("kevs_file").toString();
    }

    @Stop
    public void stop() {

    }

    @Update
    public void update() {
        stop();
        start();
    }

    @Port(name = "CPUThreshold")
    public void newCPU(Object obj) {
        cpu = (Double)obj;
        saveInfo();
    }

    @Port(name = "MemThreshold")
    public void newMem(Object obj) {
        memory = (Double)obj;
        saveInfo();
    }

    @Port(name = "componentProcessor")
    public void newComponentInfo(Object obj) {
        InfoForContractCreation s = (InfoForContractCreation)obj;

        set.put(s.path, s);

        saveInfo();
    }

    private synchronized void saveInfo() {
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(file));
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
