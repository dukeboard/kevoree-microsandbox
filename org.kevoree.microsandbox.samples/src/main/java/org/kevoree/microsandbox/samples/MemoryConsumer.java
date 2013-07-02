package org.kevoree.microsandbox.samples;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.microsandbox.api.FullContractedComponent;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/18/13
 * Time: 5:47 PM
 * To change this template use File | Settings | File Templates.
 */
@DictionaryType({
        @DictionaryAttribute(name = "amount", defaultValue = "102400")
})
@ComponentType
public class MemoryConsumer extends AbstractComponentType
        implements FullContractedComponent {

    private int size;

    private class Th extends Thread {

        private class Node {
            Object value;
            Node next;

            private Node(Object value, Node next) {
                this.value = value;
                this.next = next;
            }
        }

        private Node head;

        private synchronized boolean isB() {
            return b;
        }

        private synchronized void setB(boolean b) {
            this.b = b;
        }

        boolean b;
        @Override
        public void run() {
            head = new Node(null, null);
            while (!isB()) {
                try {
                    Thread.sleep(200);
                    head = new Node(new int[size],head);
//                    int[] ar = new  int[1024024];

                } catch (InterruptedException e) {

                }
            }
        }
    }

    Th th;

    @Start
    public void startComponent() {
        size = Integer.valueOf(getDictionary().get("amount").toString());
        th = new Th();
        th.start();
    }

    @Stop
    public void stopComponent() {
        th.setB(true);
    }

    @Update
    public void updateComponent() {
        stopComponent();
        startComponent();
    }

}
