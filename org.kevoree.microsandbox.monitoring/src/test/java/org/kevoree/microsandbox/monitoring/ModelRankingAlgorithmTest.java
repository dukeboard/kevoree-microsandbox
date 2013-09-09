package org.kevoree.microsandbox.monitoring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kevoree.ComponentInstance;
import org.kevoree.ContainerRoot;
import org.kevoree.framework.KevoreeXmiHelper;
import org.kevoree.monitoring.models.ComponentExecutionInfo;
import org.kevoree.monitoring.models.SimpleModelID;
import org.kevoree.monitoring.ranking.ModelRankingAlgorithm;
import org.kevoree.tools.aether.framework.NodeTypeBootstrapHelper;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 09/09/13
 * Time: 10:56
 *
 * @author Erwan Daubert
 * @version 1.0
 */
public class ModelRankingAlgorithmTest {

    private ModelRankingAlgorithm modelRanker;
    private KevoreeModelHandlerServiceMock modelService;

    @Before
    public void beforeTest() {
        modelService = new KevoreeModelHandlerServiceMock();
        modelRanker = new ModelRankingAlgorithm(modelService, new NodeTypeBootstrapHelper(), ComponentsInfoStorageMock.instance);

    }

    @Test
    public void testComponentsComeFromTheFirstAdaptationButFirstOneIsAliveSinceMoreTime() {
        ContainerRoot model = KevoreeXmiHelper.instance$.loadStream(getClass().getClassLoader().getResourceAsStream("models/TwoComponents.kev"));

        modelService.setLastModel(model);
        modelService.setNodeName("node0");

        ComponentInstance memory = model.findNodesByID("node0").findComponentsByID("memory");
        ComponentInstance cpu = model.findNodesByID("node0").findComponentsByID("cpu");

        // fix timeAlive
        ComponentExecutionInfo memoryInfo = new ComponentExecutionInfo(memory, new SimpleModelID(0), System.currentTimeMillis() - 10);
        ComponentExecutionInfo cpuInfo = new ComponentExecutionInfo(memory, new SimpleModelID(0), System.currentTimeMillis());
        ComponentsInfoStorageMock.instance.defineOrReplaceInfo(memory, memoryInfo);
        ComponentsInfoStorageMock.instance.defineOrReplaceInfo(cpu, cpuInfo);

        modelRanker.modelUpdated();
        Assert.assertEquals(-1, modelRanker.rank(memory, cpu));
    }

    @Test
    public void testComponentsComeFromTheFirstAdaptationButSecondOneIsAliveSinceMoreTime() {
        ContainerRoot model = KevoreeXmiHelper.instance$.loadStream(getClass().getClassLoader().getResourceAsStream("models/TwoComponents.kev"));

        modelService.setLastModel(model);
        modelService.setNodeName("node0");

        ComponentInstance memory = model.findNodesByID("node0").findComponentsByID("memory");
        ComponentInstance cpu = model.findNodesByID("node0").findComponentsByID("cpu");

        // fix timeAlive
        ComponentExecutionInfo memoryInfo = new ComponentExecutionInfo(memory, new SimpleModelID(0), System.currentTimeMillis());
        ComponentExecutionInfo cpuInfo = new ComponentExecutionInfo(memory, new SimpleModelID(0), System.currentTimeMillis() - 10);
        ComponentsInfoStorageMock.instance.defineOrReplaceInfo(memory, memoryInfo);
        ComponentsInfoStorageMock.instance.defineOrReplaceInfo(cpu, cpuInfo);

        modelRanker.modelUpdated();
        Assert.assertEquals(1, modelRanker.rank(memory, cpu));
    }

    @Test
    public void testFirstComponentIsMoreRecent() {
        ContainerRoot model = KevoreeXmiHelper.instance$.loadStream(getClass().getClassLoader().getResourceAsStream("models/TwoComponents.kev"));

        modelService.setLastModel(KevoreeXmiHelper.instance$.loadStream(getClass().getClassLoader().getResourceAsStream("models/OneComponents.kev")));
        modelService.setLastModel(model);
        modelService.setNodeName("node0");

        ComponentInstance memory = model.findNodesByID("node0").findComponentsByID("memory");
        ComponentInstance cpu = model.findNodesByID("node0").findComponentsByID("cpu");

        // fix timeAlive
        ComponentExecutionInfo memoryInfo = new ComponentExecutionInfo(memory, new SimpleModelID(0), System.currentTimeMillis() - 10);
        ComponentExecutionInfo cpuInfo = new ComponentExecutionInfo(memory, new SimpleModelID(0), System.currentTimeMillis());
        ComponentsInfoStorageMock.instance.defineOrReplaceInfo(memory, memoryInfo);
        ComponentsInfoStorageMock.instance.defineOrReplaceInfo(cpu, cpuInfo);

        modelRanker.modelUpdated();
        Assert.assertEquals(1, modelRanker.rank(memory, cpu));
    }

    @Test
    public void testSecondComponentIsMoreRecent() {
        ContainerRoot model = KevoreeXmiHelper.instance$.loadStream(getClass().getClassLoader().getResourceAsStream("models/TwoComponents.kev"));

        modelService.setLastModel(KevoreeXmiHelper.instance$.loadStream(getClass().getClassLoader().getResourceAsStream("models/OneComponents-bis.kev")));
        modelService.setLastModel(model);
        modelService.setNodeName("node0");

        ComponentInstance memory = model.findNodesByID("node0").findComponentsByID("memory");
        ComponentInstance cpu = model.findNodesByID("node0").findComponentsByID("cpu");

        // fix timeAlive
        ComponentExecutionInfo memoryInfo = new ComponentExecutionInfo(memory, new SimpleModelID(0), System.currentTimeMillis() - 10);
        ComponentExecutionInfo cpuInfo = new ComponentExecutionInfo(memory, new SimpleModelID(0), System.currentTimeMillis());
        ComponentsInfoStorageMock.instance.defineOrReplaceInfo(memory, memoryInfo);
        ComponentsInfoStorageMock.instance.defineOrReplaceInfo(cpu, cpuInfo);

        modelRanker.modelUpdated();
        Assert.assertEquals(-1, modelRanker.rank(memory, cpu));
    }

    @Test
    public void testComponentsComeFromTheSameAdaptationButFirstOneIsAliveSinceMoreTime() {
        ContainerRoot model = KevoreeXmiHelper.instance$.loadStream(getClass().getClassLoader().getResourceAsStream("models/TwoComponents.kev"));

        modelService.setLastModel(KevoreeXmiHelper.instance$.loadStream(getClass().getClassLoader().getResourceAsStream("models/OneOtherComponent.kev")));
        modelService.setLastModel(model);
        modelService.setLastModel(KevoreeXmiHelper.instance$.loadStream(getClass().getClassLoader().getResourceAsStream("models/ThreeComponents.kev")));
        modelService.setNodeName("node0");

        ComponentInstance memory = model.findNodesByID("node0").findComponentsByID("memory");
        ComponentInstance cpu = model.findNodesByID("node0").findComponentsByID("cpu");

        // fix timeAlive
        ComponentExecutionInfo memoryInfo = new ComponentExecutionInfo(memory, new SimpleModelID(0), System.currentTimeMillis() - 10);
        ComponentExecutionInfo cpuInfo = new ComponentExecutionInfo(memory, new SimpleModelID(0), System.currentTimeMillis());
        ComponentsInfoStorageMock.instance.defineOrReplaceInfo(memory, memoryInfo);
        ComponentsInfoStorageMock.instance.defineOrReplaceInfo(cpu, cpuInfo);

        modelRanker.modelUpdated();
        Assert.assertEquals(-1, modelRanker.rank(memory, cpu));
    }

    @Test
    public void testComponentsComeFromTheSameAdaptationButSecondOneIsAliveSinceMoreTime() {
        ContainerRoot model = KevoreeXmiHelper.instance$.loadStream(getClass().getClassLoader().getResourceAsStream("models/TwoComponents.kev"));

        modelService.setLastModel(KevoreeXmiHelper.instance$.loadStream(getClass().getClassLoader().getResourceAsStream("models/OneOtherComponent.kev")));
        modelService.setLastModel(model);
        modelService.setLastModel(KevoreeXmiHelper.instance$.loadStream(getClass().getClassLoader().getResourceAsStream("models/ThreeComponents.kev")));
        modelService.setNodeName("node0");

        ComponentInstance memory = model.findNodesByID("node0").findComponentsByID("memory");
        ComponentInstance cpu = model.findNodesByID("node0").findComponentsByID("cpu");

        // fix timeAlive
        ComponentExecutionInfo memoryInfo = new ComponentExecutionInfo(memory, new SimpleModelID(0), System.currentTimeMillis());
        ComponentExecutionInfo cpuInfo = new ComponentExecutionInfo(memory, new SimpleModelID(0), System.currentTimeMillis() - 10);
        ComponentsInfoStorageMock.instance.defineOrReplaceInfo(memory, memoryInfo);
        ComponentsInfoStorageMock.instance.defineOrReplaceInfo(cpu, cpuInfo);

        modelRanker.modelUpdated();
        Assert.assertEquals(1, modelRanker.rank(memory, cpu));
    }
}
