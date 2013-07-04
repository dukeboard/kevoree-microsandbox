package org.kevoree.microsandbox.api.communication;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 7/4/13
 * Time: 9:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class MonitoringReporterFactory {
    public static MonitoringReporter consoleReporter() {
        activeReporter = new ConsoleMonitoringReporter();
        return activeReporter;
    }

    private static MonitoringReporter activeReporter =null;

    public static MonitoringReporter reporter() {
        if (activeReporter == null) {
            activeReporter = new ComposeMonitoringReport();
            ((ComposeMonitoringReport)activeReporter).addReporter(consoleReporter());
        }
        return activeReporter;
    }
}
