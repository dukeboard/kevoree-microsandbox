package org.kevoree.microsandbox.cgroupNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class CPUThreadControl {

    static {
        System.load(System.getProperty("thread.control.library"));
    }

    private static final String SYS_FS_CGROUP = "/sys/fs/cgroup/";
    private static final String KEVOREE_SUBPATH = "inti/p0";

    public enum CGROUP_SUBSYSTEMS {
        CPU ("cpu"),
        MEMORY ("memory");

        String name;

        CGROUP_SUBSYSTEMS(String s) {
            name = s;
        }
    }

    public static native boolean setFrozen(int id, boolean b);

    public static native int getTTID();

    private static void createDir(String path) {
        File theDir = new File(path);
        if (!theDir.exists()) {
            theDir.mkdir();
        }
    }

    private static void writeValue(String fileName, int value) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
        pw.print(value);
        pw.close();
    }

    public static void assignCPULimit(String componentId, int milliSeconds) {
        writeValue(componentId, CGROUP_SUBSYSTEMS.CPU,  "notify_on_release", 1);
        writeValue(componentId, CGROUP_SUBSYSTEMS.CPU,  "cpu.cfs_period_us", 1000000);
        writeValue(componentId, CGROUP_SUBSYSTEMS.CPU, "cpu.cfs_quota_us", milliSeconds * 1000);
        writeValue(componentId, CGROUP_SUBSYSTEMS.CPU,  "a"+ File.separatorChar + "cpu.shares", 100);
    }

    private static void writeValue(String componentId,
                                   CGROUP_SUBSYSTEMS subsystem,
                                   String fileName,
                                   int value)
    {
        String path = SYS_FS_CGROUP + subsystem.name + File.separatorChar
                + KEVOREE_SUBPATH + File.separatorChar + componentId;
        createDir(path);
        path += File.separatorChar;
        while (fileName.contains(File.separatorChar + "")) {
            int index = fileName.indexOf(File.separatorChar);
            String dir = fileName.substring(0, index);
            if (!dir.isEmpty()) {
                createDir(path + dir);
                path = path + dir + File.separatorChar;
            }
            fileName = fileName.substring(index + 1);
        }

        try {
            writeValue(path + fileName, value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void attach(String idComponent, CGROUP_SUBSYSTEMS subsystem) {
        String path = SYS_FS_CGROUP + subsystem.name + File.separatorChar
                + KEVOREE_SUBPATH + File.separatorChar + idComponent +
                File.separatorChar + "a" + File.separatorChar;
        try {
            writeValue(path + "tasks", getTTID());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void attachToCPUSubsystem(String componentId) {
        attach(componentId, CGROUP_SUBSYSTEMS.CPU);
    }
}
