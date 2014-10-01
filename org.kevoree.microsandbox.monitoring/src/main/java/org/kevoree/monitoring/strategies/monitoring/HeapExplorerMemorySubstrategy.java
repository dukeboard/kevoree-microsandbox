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

    public HeapExplorerMemorySubstrategy(ModelService modelService, ModelRegistry modelRegistry) {
        this.modelService = modelService;
        this.modelRegistry = modelRegistry;
    }

    @Override
    public long getMemoryConsumption(Object user_data) {
        HeapAnalysis.callback = new UpcallGetObjects() {
            @Override
            public Object[] getJavaDefinedObjects(String ids) {

                KMFContainer kmfContainer = modelService.getCurrentModel().getModel().findByPath(ids.replace("kev/",""));

                KInstanceWrapper wrapper = (KInstanceWrapper)modelRegistry.lookup(kmfContainer);
//                for (int k = 0; k < r.length ; k++ )
//                    r[k] = new String(ids);

                return new Object[] {wrapper.getTargetObj()};
            }
        };
        Pair<ResourcePrincipal, DataForCheckingContract> pair = (Pair<ResourcePrincipal, DataForCheckingContract>)user_data;
        Object[] r = (Object[])HeapAnalysis.analysis(ID_KEVOREE_ANALYSIS); // ugly that fixed constant
        for (int j = 0 ; j < r.length ; j++) {
            PrincipalClassDetailsUsage principalClassDetailsUsage = (PrincipalClassDetailsUsage)r[j];
            if (!principalClassDetailsUsage.resourceId.equals(pair.component1())) continue;

            ClassDetailsUsage[] details = principalClassDetailsUsage.detailsUsages;
//            int totalCount = 0;
            int totalSize = 0;
            for ( int i = 0 ; i < details.length ; i++ ) {
//                totalCount += details[i].nbObjects;
                totalSize += details[i].totalSize;
            }

            return totalSize;
        }
        return 0;
    }
}
