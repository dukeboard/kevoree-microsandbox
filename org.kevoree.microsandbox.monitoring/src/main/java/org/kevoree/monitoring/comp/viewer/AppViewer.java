package org.kevoree.monitoring.comp.viewer;

import org.kevoree.monitoring.AbstractBehaviorObserver;
import org.resourceaccounting.ResourcePrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 4/27/13
 * Time: 2:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class AppViewer extends AbstractBehaviorObserver<AppPanelInformation> {

    JFrame f = new JFrame("");
    private MyModel fModel;

    public AppViewer() {
        super();
        f.getContentPane().setLayout(new BorderLayout());
        JList<DataPoint> jList = new JList<DataPoint>(fModel = new MyModel());
        jList.setCellRenderer(new MyCellRenderer());
        jList.setFixedCellHeight(200);
        jList.setFixedCellWidth(500);
        JScrollPane scrollPane = new JScrollPane(jList);
        f.add(scrollPane, BorderLayout.CENTER);
        f.setState(JFrame.MAXIMIZED_BOTH);
        f.setSize(640, 480);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                stop();
            }
        });
        f.setVisible(true);
    }

    @Override
    protected void updateAssociatedValue(ResourcePrincipal principal, AppPanelInformation v) {
        v.setCpu(principal.getExecutedInstructions());
        v.setMemory(principal.getAllocatedObjects());
        v.setBytesSent(principal.getBytesSent());
        v.setBytesReceived(principal.getBytesReceived());
        int index = fModel.getPrincipalIndex(principal);
        if (index != -1) {
            fModel.set(index, new DataPoint(principal,v));
        }
    }

    @Override
    protected AppPanelInformation getNewAssociatedValue(ResourcePrincipal principal) {
        AppPanelInformation p = new AppPanelInformation(principal.toString(), principal.getExecutedInstructions());
        fModel.addElement(new DataPoint(principal, p));
        return p;
    }

    @Override
    public void removeApp(ResourcePrincipal rp) {
        super.removeApp(rp);
        int index = fModel.getPrincipalIndex(rp);
        fModel.remove(index);
    }

    private class DataPoint {
        public ResourcePrincipal principal;
        public AppPanelInformation panel;

        private DataPoint(ResourcePrincipal principal, AppPanelInformation panel) {
            this.principal = principal;
            this.panel = panel;
        }
    }

    private class MyModel extends DefaultListModel<DataPoint> {

        public int getPrincipalIndex(ResourcePrincipal principal) {
            for (int i = 0 ; i < size() ; i++)
                if (get(i).principal.equals(principal))
                    return i;
            return -1;
        }
    }

    /**
     Display an icon and a string for each object in the list.
    */
    class MyCellRenderer implements ListCellRenderer<DataPoint> {

        // This is the only method defined by ListCellRenderer.
        // We just reconfigure the JLabel each time we're called.

        public Component getListCellRendererComponent(JList<? extends DataPoint> jList,
                                                      DataPoint dataPoint,
                                                      int i,
                                                      boolean b,
                                                      boolean b2) {
            AppPanelInformation p = dataPoint.panel;
            p.setEnabled(jList.isEnabled());
            return p;
        }
    }
}
