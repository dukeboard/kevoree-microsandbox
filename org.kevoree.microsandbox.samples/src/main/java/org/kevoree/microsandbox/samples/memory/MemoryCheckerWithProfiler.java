package org.kevoree.microsandbox.samples.memory;

import org.kevoree.annotation.*;

import org.heapexplorer.heapanalysis.*;
import org.kevoree.api.ModelService;
import org.kevoree.library.defaultNodeTypes.ModelRegistry;
import org.kevoree.library.defaultNodeTypes.wrapper.KInstanceWrapper;
import org.kevoree.modeling.api.KMFContainer;

import java.util.Arrays;
import java.util.Comparator;

@ComponentType
public class MemoryCheckerWithProfiler {

    @Param(defaultValue = "1000")
    int sleepTime;

    @KevoreeInject
    org.kevoree.api.Context context;

    @KevoreeInject
    ModelService modelService;

    public ModelRegistry register;

    private static void standardPrint(Object obj) {
        Object[] r = (Object[])obj;
        for (int j = 0 ; j < r.length ; j++) {

            PrincipalClassDetailsUsage principalClassDetailsUsage = (PrincipalClassDetailsUsage)r[j];
            ClassDetailsUsage[] details = principalClassDetailsUsage.detailsUsages;
            Arrays.sort(details, new Comparator() {
                public int compare(Object obj1, Object obj2) {
                    ClassDetailsUsage a = (ClassDetailsUsage) obj1, b = (ClassDetailsUsage) obj2;
                    if (a.totalSize > b.totalSize)
                        return -1;
                    else if (a.totalSize < b.totalSize)
                        return 1;
                    else if (a.nbObjects > b.nbObjects)
                        return -1;
                    else if (a.nbObjects < b.nbObjects)
                        return 1;
                    else
                        return a.className.compareTo(b.className);
                }

                public boolean equals(Object obj) {
                    return false;
                }
            });
            int totalCount = 0;
            int totalSize = 0;
            for ( int i = 0 ; i < details.length ; i++ ) {
                totalCount += details[i].nbObjects;
                totalSize += details[i].totalSize;
            }

			/* Print out sorted table */
            System.out.printf("Heap View for %s, Total of %d objects found, with a total size of %d.\n\n",
                    principalClassDetailsUsage.resourceId, totalCount, totalSize);

//            System.out.printf("Nro.      Space      Count      Class Signature\n");
//            System.out.printf("--------- ---------- ---------- ----------------------\n");
//            for (int i = 0 ; i < details.length ; i++) {
//                if ( details[i].totalSize == 0 || i > 25 ) {
//                    break;
//                }
//                System.out.printf("%9d %10d %10d %s\n",
//                        i,
//                        details[i].totalSize,
//                        details[i].nbObjects,
//                        details[i].className);
//            }
//            System.out.printf("--------- ---------- ---------- ----------------------\n");
        }
    }

    @Start
    public void start() {
        HeapAnalysis.callback = new UpcallGetObjects() {
            @Override
            public Object[] getJavaDefinedObjects(String ids) {

//                Object[] r = new Object[10000];
                KMFContainer kmfContainer = modelService.getCurrentModel().getModel().findByPath(ids.replace("kev/",""));

                KInstanceWrapper wrapper = (KInstanceWrapper)register.lookup(kmfContainer);
//                for (int k = 0; k < r.length ; k++ )
//                    r[k] = new String(ids);

                return new Object[] {wrapper.getTargetObj()};
            }

            @Override
            public boolean mustAnalyse(String ids) {
                return false;
            }
        };
        new Thread() {
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(1000);
                        Object r = HeapAnalysis.analysis(5);
                        standardPrint(r);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }

    @Stop
    public void stop() {}

    @Update
    public void update() {System.out.println("Param updated!");}

}



