package org.kevoree.monitoring.strategies.monitoring;

import kotlin.Pair;
import org.heapexplorer.heapanalysis.ClassDetailsUsage;
import org.heapexplorer.heapanalysis.HeapAnalysis;
import org.heapexplorer.heapanalysis.PrincipalClassDetailsUsage;
import org.heapexplorer.heapanalysis.UpcallGetObjects;
import org.kevoree.ComponentInstance;
import org.kevoree.api.ModelService;
import org.kevoree.library.defaultNodeTypes.ModelRegistry;
import org.kevoree.library.defaultNodeTypes.wrapper.KInstanceWrapper;
import org.kevoree.log.Log;
import org.kevoree.modeling.api.KMFContainer;
import org.resourceaccounting.ResourcePrincipal;

import java.util.*;

/**
 * Created by inti on 01/10/14.
 */
public class HeapExplorerMemorySubstrategy implements MemorySubstrategy {

    public static final int ID_KEVOREE_ANALYSIS = 5;
    private final ModelService modelService;
    private final ModelRegistry modelRegistry;
    private final UpcallGetObjects upcall;
    private int currentCycle = 0;
    private int previousCycle;
    private HashMap<String, Long> results = new HashMap<String, Long>();

    public HeapExplorerMemorySubstrategy(ModelService ms, ModelRegistry mr) {
        this.modelService = ms;
        this.modelRegistry = mr;
        this.upcall = new UpcallGetObjects() {
            @Override
            public Object[] getJavaDefinedObjects(String ids) {

                KMFContainer kmfContainer = modelService.getCurrentModel().getModel().findByPath(ids.replace("kev/",""));

                if (kmfContainer != null) {
                    Log.info("\t\t\t Sexy {}", ids);
                    KInstanceWrapper wrapper = (KInstanceWrapper) modelRegistry.lookup(kmfContainer);
                    return new Object[]{wrapper.getTargetObj()};
                }
                return new Object[] {};
            }

            @Override
            public boolean mustAnalyse(String ids) {
                KMFContainer kmfContainer = modelService.getCurrentModel().getModel().findByPath(ids.replace("kev/",""));
                return  (kmfContainer != null && kmfContainer instanceof ComponentInstance);
            }
        };
        HeapAnalysis.callback = this.upcall;
    }

    @Override
    public long getMemoryConsumption(Object user_data) {
        if (currentCycle != previousCycle) {
            Object[] r = (Object[])HeapAnalysis.analysis(ID_KEVOREE_ANALYSIS); // ugly that fixed constant
            previousCycle = currentCycle;
            for (int j = 0 ; j < r.length ; j++) {
                PrincipalClassDetailsUsage principalClassDetailsUsage = (PrincipalClassDetailsUsage)r[j];
                results.put(principalClassDetailsUsage.resourceId, principalClassDetailsUsage.totalConsumption);
            }
        }

        Pair<ResourcePrincipal, DataForCheckingContract> pair = (Pair<ResourcePrincipal, DataForCheckingContract>)user_data;
        String id = pair.component1().toString();
        if (results.containsKey(id)) return results.get(id);

        return 0;
    }

    @Override
    public void newCycle() {
        currentCycle++;
    }
}
