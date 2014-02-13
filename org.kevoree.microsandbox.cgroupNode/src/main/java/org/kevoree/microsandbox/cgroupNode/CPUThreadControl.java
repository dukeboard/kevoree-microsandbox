package org.kevoree.microsandbox.cgroupNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class CPUThreadControl {

    static {
        System.load(System.getProperty("thread.control.library"));
    }

    public static final String SYS_FS_CGROUP = "/sys/fs/cgroup/";
    public static final String CPU_SUBSYSTEM = "cpu";
    public static final String KEVOREE_SUBPATH = "inti/p0";

    public static native boolean assignLimit(int id, int msPerSecond);
	public static native boolean attach(int id);

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

    public static boolean assignLimit(String idComponent, int msPerSecond) {
        String path = SYS_FS_CGROUP + CPU_SUBSYSTEM + "/"
                + KEVOREE_SUBPATH + "/" + idComponent;
        System.out.printf("Assigning limits %d to %s\n", msPerSecond, idComponent);
        createDir(path);
        try {
            writeValue(path + "/" + "notify_on_release", 1);
            writeValue(path + "/" + "cpu.cfs_period_us", 1000000);
            writeValue(path + "/" + "cpu.cfs_quota_us", msPerSecond*1000);
            createDir(path+"/a");
            writeValue(path + "/a/" + "cpu.shares", 100);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void attach(String idComponent) {
        String path = SYS_FS_CGROUP + CPU_SUBSYSTEM + "/"
                + KEVOREE_SUBPATH + "/" + idComponent + "/a/";
        try {
            writeValue(path + "tasks", getTTID());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
