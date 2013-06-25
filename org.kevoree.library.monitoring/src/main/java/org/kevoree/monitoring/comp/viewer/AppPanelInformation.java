package org.kevoree.monitoring.comp.viewer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.DomainOrder;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
* Created with IntelliJ IDEA.
* User: inti
* Date: 4/27/13
* Time: 2:06 PM
* To change this template use File | Settings | File Templates.
*/
class AppPanelInformation extends JPanel {

//    ITrace2D traceCPU;
//    ITrace2D traceMemory;

    long initial = System.currentTimeMillis() / 1000;

    long lastCPU = 0;

    MyXYdata datasetCPU;
    MyXYdata datasetMemory;
    MyXYdata datasetNetwork;

    JFreeChart chartCPU;
    JFreeChart chartMem;
    JFreeChart chartNetwork;

    class MySerie implements Comparable {
        static final int max = 120;
        double[] x = new double[max];
        double[] y = new double[max];
        int start = 0;
        int end = 0;
        int count = 0;

        String name;

        MySerie(String name) {
            this.name = name;
        }

        double getX(int index) {
            int i = (start + index) % max;
            return x[i];
        }

        double getY(int index) {
            int i = (start + index) % max;
            return y[i];
        }

        void addPoint(double x, double y) {
            if (count < max) {
                this.x[end] = y;
                this.y[end] = x;
                end = (end + 1) % max;
                count++;
            }
            else {
                start = (start + 1) % max;
                this.x[end] = y;
                this.y[end] = x;
                end = (end + 1) % max;
            }
        }

        public int compareTo(Object obj) {
            return name.compareTo(obj.toString());
        }

        @Override
        public String toString() {
            return name;
        }
    }

    class MyXYdata implements  XYDataset {


        ArrayList<MySerie> series;

        private DatasetGroup dataGroup = new DatasetGroup("0");

        private LinkedList<DatasetChangeListener> listeners = new LinkedList<DatasetChangeListener>();

        MyXYdata(String[] names) {
            series = new ArrayList<MySerie>();
            if (names == null) return;
            for (String string : names)
                series.add(new MySerie(string));
        }

        public DomainOrder getDomainOrder() {
            return DomainOrder.ASCENDING;
        }

        public int getItemCount(int i) {
            return series.get(i).count;
        }

        public Number getX(int serieIndex, int index) {
            return series.get(serieIndex).getX(index);

        }

        public double getXValue(int serieIndex, int index) {
            return series.get(serieIndex).getX(index);
        }

        public Number getY(int serieIndex, int index) {
            return series.get(serieIndex).getY(index);
        }

        public double getYValue(int serieIndex, int index) {
            return series.get(serieIndex).getY(index);
        }

        public int getSeriesCount() {
            return series.size();
        }

        public Comparable getSeriesKey(int i) {
            return series.get(i);
        }

        public int indexOf(Comparable comparable) {
            return series.indexOf(comparable);
        }

        public void addPoint(int serieIndex, double x, double y) {
            series.get(serieIndex).addPoint(x,y);

            for (DatasetChangeListener l : listeners)
                l.datasetChanged(new DatasetChangeEvent(this, this));
        }

        public void addChangeListener(DatasetChangeListener datasetChangeListener) {
            listeners.add(datasetChangeListener);
        }

        public void removeChangeListener(DatasetChangeListener datasetChangeListener) {
            listeners.remove(datasetChangeListener);
        }

        public DatasetGroup getGroup() {
            return dataGroup;
        }

        public void setGroup(DatasetGroup datasetGroup) {
            this.dataGroup = datasetGroup;
        }
    }


    AppPanelInformation(String appName, long initialCPU){
        this.lastCPU = initialCPU;
        this.setLayout(new GridLayout(1, 2));
        this.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED), new TitledBorder(appName)));

        datasetCPU = new MyXYdata(new String[]{"CPU"});
        chartCPU = ChartFactory.createXYLineChart("", "Executed Instructions" , "Time",
                datasetCPU, PlotOrientation.HORIZONTAL, false, false, false);
        NumberAxis na = new NumberAxis("Time");
        na.setAutoRange(true);
        na.setAutoRangeIncludesZero(false);
        chartCPU.getXYPlot().setRangeAxis(0,na);
        this.add(new ChartPanel(chartCPU));

        datasetMemory = new MyXYdata(new String[]{"Memory"});
        chartMem = ChartFactory.createXYLineChart("", "Memory Bytes" , "Time",
                datasetMemory, PlotOrientation.HORIZONTAL, false, false, false);
        na = new NumberAxis("Time");
        na.setAutoRange(true);
        na.setAutoRangeIncludesZero(false);
        chartMem.getXYPlot().setRangeAxis(0,na);
        this.add(new ChartPanel(chartMem));

        datasetNetwork = new MyXYdata(new String[]{"Sent", "Received"});
        chartNetwork = ChartFactory.createXYLineChart("", "Bytes" , "Time",
                datasetNetwork, PlotOrientation.HORIZONTAL, false, false, false);
        na = new NumberAxis("Time");
        na.setAutoRange(true);
        na.setAutoRangeIncludesZero(false);
        chartNetwork.getXYPlot().setRangeAxis(0,na);
        this.add(new ChartPanel(chartNetwork));
    }

    public void setCpu(long l) {
        long inStep = l - lastCPU;
        lastCPU = l;
        datasetCPU.addPoint(0, System.currentTimeMillis() / 1000 - initial, inStep);
        chartCPU.fireChartChanged();
    }

    public void setMemory(long l) {
        datasetMemory.addPoint(0, System.currentTimeMillis()/ 1000 - initial, l);
        chartMem.fireChartChanged();
    }

    public void setBytesSent(long l) {
        datasetNetwork.addPoint(0, System.currentTimeMillis()/ 1000 - initial, l);
        chartNetwork.fireChartChanged();
    }

    public void setBytesReceived(long l) {
        datasetNetwork.addPoint(1, System.currentTimeMillis()/ 1000 - initial, l);
        chartNetwork.fireChartChanged();
    }
}
