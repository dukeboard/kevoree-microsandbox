package org.kevoree.monitoring.ranking;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/26/13
 * Time: 3:52 PM
 *
 */
public class ComponentExecutionInfo {
    private int failuresInCurrentVersion;
    private int failuresInPreviousVersions;
    private double branchCoverage;
    private double instructionCoverage;
    private long timeUnderUse;

    private String componentName;

    public ComponentExecutionInfo(String componentName) {
        this.componentName = componentName;
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
}
