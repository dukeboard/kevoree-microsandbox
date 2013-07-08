/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/22/13
 * Time: 2:57 PM
 *
 */
package org.resourceaccounting.binder;

import org.resourceaccounting.ObjectSizeProvider;
import org.resourceaccounting.contract.ResourceContract;
import org.resourceaccounting.contract.ResourceContractProvider;
import org.resourceaccounting.ResourcePrincipal;

public class ResourceCounter {
    private static ResourceCounterImpl ourInstance = new ResourceCounterImpl();

    private static final int MONITORING = 1;
    private static final int CONTROLLING_PORTS = 2;

    private static int monitoringFlags = 0;


    private final static synchronized boolean isMonitoring() {
        return ( monitoringFlags & MONITORING ) != 0;
    }

    public final static synchronized void setMonitoring(boolean b) {
        if (b)
            monitoringFlags |= MONITORING;
        else if (isMonitoring())
            monitoringFlags -= MONITORING;

        ourInstance.senders.clear();
        ourInstance.receivers.clear();
    }

    private final static synchronized boolean isControllingPorts() {
        return ( monitoringFlags & CONTROLLING_PORTS ) != 0;
    }

    public final static synchronized void setControllingPorts(boolean b) {
        if (b)
            monitoringFlags |= CONTROLLING_PORTS;
        else if (isControllingPorts())
            monitoringFlags -= CONTROLLING_PORTS;

    }

    public static ResourcePrincipal[] getApplications() {
        return ourInstance.innerGetApplications();
    }

    public static void increaseInstructions(int n, ResourcePrincipal principal) {
        if (isMonitoring()) {
            ResourcePrincipal p = ourInstance.search(principal);
            ourInstance.innerIncreaseInstructions(n, p);
        }
    }

    public static long getNbObjects(ResourcePrincipal principal) {
        ResourcePrincipal p = ourInstance.search(principal);
        return ourInstance.innerGetNbObjects(p);
    }

    public static long getNbInstructions(ResourcePrincipal principal) {
        ResourcePrincipal p = ourInstance.search(principal);
        return ourInstance.innerGetNbInstructions(p);
    }

    public static long getNbBytesSent(ResourcePrincipal principal) {
        ResourcePrincipal p = ourInstance.search(principal);
        return ourInstance.innerGetNbBytesSent(p);
    }

    public static long getNbBytesReceived(ResourcePrincipal principal) {
        ResourcePrincipal p = ourInstance.search(principal);
        return ourInstance.innerGetNbBytesReceived(p);
    }

    public static long getNbWrittenBytes(ResourcePrincipal principal) {
        ResourcePrincipal p = ourInstance.search(principal);
        return ourInstance.innerGetNbWrittenBytes(p);
    }

    public static long getNbReadBytes(ResourcePrincipal principal) {
        ResourcePrincipal p = ourInstance.search(principal);
        return ourInstance.innerGetNbReadBytes(p);
    }

    public static long getTotalSent() {
        return ourInstance.getTotalSent();
    }

    public static long getTotalReceived() {
        return ourInstance.getTotalReceived();
    }

    public static long getTotalRead() {
        return ourInstance.getTotalRead();
    }

    public static long getTotalWritten() {
        return ourInstance.getTotalWritten();
    }

    /**
     * Called to get the current resource principal
     * @return
     */
    public static ResourcePrincipal get() {
        Thread th = Thread.currentThread();
        return ourInstance.get(th);

    }

    public static void setResourceContractProvider(ResourceContractProvider provider) {
        ourInstance.setResourceContractProvider(provider);
    }

    public static ResourceContract getResourceContract(ResourcePrincipal rp) {
        return ourInstance.getContract(rp);
    }

    public static void setObjectSizeProvider(ObjectSizeProvider provider) {
        ourInstance.setObjectSizeProvider(provider);
    }

    public static int reportObjectCreation(Object obj) {
        ResourcePrincipal principal = get();
        principal = ourInstance.search(principal);
        ourInstance.innerIncreaseObjects(obj, principal);
//        java.lang.Class cl = obj.getClass();
//        try {
//            java.lang.reflect.Field f = cl.getField("__principalID__");
//        } catch (NoSuchFieldException e) {
//            String s = cl.getCanonicalName();
//            for (int i = 0 ; i < s.length() ; i++)
//                System.out.print(s.charAt(i));
//            System.exit(2);
//        }
        return principal.getId();
    }

    public static void reportObjectDestruction(Object obj, int id) {
        ResourcePrincipal principal = ourInstance.search(id);
        if (principal != null)
            ourInstance.innerDecreaseObjects(obj,principal);
    }

    public static void reportNewArray(Object obj) {
        ResourcePrincipal principal = get();
        principal = ourInstance.search(principal);
        ourInstance.innerArrayAllocated(obj, principal);
    }

    public static void reportPortProcessingRequest(Object component, Object port) {
        if (isMonitoring()) {
//            System.out.println("sdsdfdfsfsfsfsffsd : " + obj.toString() + " "
//                    + obj1.toString());
            ourInstance.senders.addInvocation(component.toString(), port.toString());
        }
        else if (isControllingPorts()) {
            if (ourInstance.senders.isControlled(component.toString(), port.toString())) {
                int max = ourInstance.senders.max_allowed(component.toString(), port.toString());
                int x0 = 1000000000/ max;
                int milli = x0 / 1000000;
                int nano = x0 % 1000000;
                try {
                    Thread.sleep(milli, nano);
                } catch (InterruptedException e) { }
            }
        }
    }

    public static void reportPortHandlerExecution(Object obj, Object obj1) {
        if (isMonitoring()) {
//            System.out.println("another event: reception : " + obj.toString() + "."
//                + obj1.toString() + " ");
            ourInstance.receivers.addInvocation(obj.toString(), obj1.toString());
        }
    }

    public static void reportNetworkDataRead(int n) {
        if (isMonitoring()) {
            ResourcePrincipal principal = get();
            principal = ourInstance.search(principal);
            ourInstance.innerIncreaseBytesReceived(n, principal);
        }
        else ourInstance.increaseTotalReceived(n);
    }

    public static void reportNetworkDataWrite(int n) {
        if (isMonitoring()) {
            ResourcePrincipal principal = get();
            principal = ourInstance.search(principal);
            ourInstance.innerIncreaseBytesSent(n,principal);
        }
        else ourInstance.increaseTotalSent(n);
    }

    public static void reportFileDataRead(int n) {
        if (isMonitoring()) {
            ResourcePrincipal principal = get();
            principal = ourInstance.search(principal);
            ourInstance.innerIncreaseFileRead(n, principal);
        }
        else ourInstance.increaseTotalRead(n);
    }

    public static void reportFileDataWrite(int n) {
        if (isMonitoring()) {
            ResourcePrincipal principal = get();
            principal = ourInstance.search(principal);
            ourInstance.innerIncreaseFileWrite(n, principal);
        }
        else ourInstance.increaseTotalWritten(n);
    }

    public static ResourcePrincipal getApplication(String appId) {
        return ourInstance.search(appId);
    }

    public static int getUsesOfProvidedPort(String component, String port) {
        return ourInstance.receivers.getNumberOfInvocations(component, port);
    }

    public static int getUsesOfRequiredPort(String component, String port) {
        return ourInstance.senders.getNumberOfInvocations(component, port);
    }
}
