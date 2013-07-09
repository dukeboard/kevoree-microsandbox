package org.resourceaccounting.utils;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/16/13
 * Time: 8:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Set<E> implements Serializable {
    private Object[] elements;

    private int count;

    public Set() {
        elements = new Object[100];
        count = 0;
    }

    public void add(E element) {
        for (int i = 0 ; i < count ; i++)
            if (elements[i].equals(element))
                return;
        if (count == elements.length) {
            Object[] tmp = new Object[elements.length << 1];
            System.arraycopy(elements, 0, tmp, 0, count);
            elements = tmp;
        }
        elements[count++] = element;
    }

    public int size() {
        return count;
    }

    public E getElement(int i) {
        return (E)elements[i];
    }

    public int find(E element) {
        for (int i = 0 ; i < count ; i++)
            if (elements[i].equals(element))
                return i;
        return -1;
    }

    public void remove(E element) {
        int index = find(element);
        if (index != -1) {
            for (int i = index ; i < count - 1 ; i++)
                elements[i] = elements[i+1];
            count --;
        }
    }

    public void clear() {
        count = 0;
    }
}
