package org.kevoree.monitoring.models;

import org.kevoree.ComponentInstance;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/26/13
 * Time: 3:52 PM
 *
 */
public class ComponentExecutionInfo {
    public String getName() {
        return componentName;
    }

    private class UsageInfo {
        int failures;
        double branchCoverage;
        double instructionCoverage;
        long deployedTime;

        private UsageInfo(int failures, double branchCoverage, double instructionCoverage, long deployedTime) {
            this.failures = failures;
            this.branchCoverage = branchCoverage;
            this.instructionCoverage = instructionCoverage;
            this.deployedTime = deployedTime;
        }
    }

    private Map<ModelID, UsageInfo> infoMap;

    private int failures;
    private int failuresInPreviousVersions;
    private double branchCoverage;
    private double instructionCoverage;

    /**
     *
     */
    private long initialDeployment;

    private String componentName;
    private String path;

    private ModelID lastModel;

    public ComponentExecutionInfo(ComponentInstance component, ModelID id,
                                  long initialDeployment) {
        this.componentName = component.getName();
        path = component.path();
        this.initialDeployment = initialDeployment;
        infoMap = new HashMap<ModelID, UsageInfo>(5);
        lastModel = id;
    }

    public double getBranchCoverage() {
        return branchCoverage;
    }

    public void setBranchCoverage(double branchCoverage) {
        this.branchCoverage = branchCoverage;
    }

    public double getInstructionCoverage() {
        return instructionCoverage;
    }

    public void setInstructionCoverage(double instructionCoverage) {
        this.instructionCoverage = instructionCoverage;
    }

    public void increaseFailures() {
        failures++;
    }

    public long timeAlive(long currentTime) {
        return currentTime - initialDeployment;
    }

    public void markNewVersion(ModelID id) {
        if (!id.isTheSameAs(lastModel)) {
//            System.out.printf("New version of %s has been installed. Previous %s, current %s\n", path, lastModel, id);
            long currentTime = System.currentTimeMillis();
            infoMap.put(lastModel, new UsageInfo(failures, branchCoverage, instructionCoverage, timeAlive(currentTime)));
            lastModel = id;
            initialDeployment = currentTime;
            branchCoverage = 0;
            instructionCoverage = 0;
            failuresInPreviousVersions += failures;
            failures = 0;
        }
    }
}
