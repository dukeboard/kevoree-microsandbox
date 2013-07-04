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

    private static boolean monitoring = false;

    private final static synchronized boolean isMonitoring() {
        return monitoring;
    }

    public final static synchronized void setMonitoring(boolean b) {
        monitoring = b;
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

    private static void increaseBytesSent(int n, ResourcePrincipal principal) {
        ResourcePrincipal p = ourInstance.search(principal);
        ourInstance.innerIncreaseBytesSent(n, p);
    }

    private static void increaseFileWrite(int n, ResourcePrincipal principal) {
        ResourcePrincipal p = ourInstance.search(principal);
        ourInstance.innerIncreaseFileWrite(n, p);
    }

    private static void increaseBytesReceived(int n, ResourcePrincipal principal) {
        ResourcePrincipal p = ourInstance.search(principal);
        ourInstance.innerIncreaseBytesReceived(n, p);
    }

    private static void increaseBytesRead(int n, ResourcePrincipal principal) {
        ResourcePrincipal p = ourInstance.search(principal);
        ourInstance.innerIncreaseBytesRead(n, p);
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
     * Called at the start of every operation in components. It is inserted
     * by the Accounting System
     * @param operation
     */
    public static void newInvocation(String operation) {
        if (isMonitoring()) {
            Thread th = Thread.currentThread();
            ourInstance.newInvocation(th, operation);
        }
    }

    public static void associateToInvocation(Thread newTh) {
        if (isMonitoring()) {
            Thread th = Thread.currentThread();
            ourInstance.associateToInvocation(th, newTh);
        }
    }

    /**
     * Called at the end of every operation in components. It is inserted
     * by the Accounting System
     */
    public static void stopInvocation() {
        if (isMonitoring()) {
            Thread th = Thread.currentThread();
            ourInstance.stopInvocation(th);
        }
    }

    /**
     * Called to get the current resource principal
     * @return
     */
    public static ResourcePrincipal get() {
        Thread th = Thread.currentThread();
        return ourInstance.get(th);

    }

    /**
     * Called when a component performs a call to external operation
     * @param str
     */
    public static void externalOperationCall(String str) {
        if (isMonitoring()) {
            Thread th = Thread.currentThread();
            ourInstance.externalOperationCall(th, str);
        }
    }


    public static void push() {
        if (isMonitoring()) {
            Thread th = Thread.currentThread();
            ourInstance.push(th);
        }
    }

    public static void pop() {
        if (isMonitoring()) {
            Thread th = Thread.currentThread();
            ourInstance.pop(th);
        }
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

    public static void reportNetworkDataRead(int n) {
        if (isMonitoring()) {
            ResourcePrincipal principal = get();
            increaseBytesReceived(n, principal);
        }
        else ourInstance.increaseTotalReceived(n);
    }

    public static void reportNetworkDataWrite(int n) {
        if (isMonitoring()) {
            ResourcePrincipal principal = get();
            increaseBytesSent(n, principal);
        }
        else ourInstance.increaseTotalSent(n);
    }

    public static void reportFileDataRead(int n) {
        if (isMonitoring()) {
            ResourcePrincipal principal = get();
            increaseBytesReceived(n, principal);
        }
        else ourInstance.increaseTotalRead(n);
    }

    public static void reportFileDataWrite(int n) {
        if (isMonitoring()) {
            ResourcePrincipal principal = get();
            increaseBytesSent(n, principal);
        }
        else ourInstance.increaseTotalWritten(n);
    }

    public static ResourcePrincipal getApplication(String appId) {
        return ourInstance.search(appId);
    }
}
