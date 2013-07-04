package org.resourceaccounting.utils;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/16/13
 * Time: 9:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyList<E> {
    private Object[] elements;

    private int count;

    public MyList() {
        elements = new Object[100];
        count = 0;
    }

    public void add(E element) {
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

    public E get(int i) {
        return (E)elements[i];
    }

    public int indexOf(E element) {
        for (int i = 0 ; i < count ; i++)
            if (elements[i].equals(element))
                return i;
        return -1;
    }

    public void remove(E element) {
        int index = indexOf(element);
        if (index != -1) {
            for (int i = index ; i < count - 1 ; i++)
                elements[i] = elements[i+1];
            count --;
        }
    }

    public void removeIndex(int index) {
        if (index != -1) {
            for (int i = index ; i < count - 1 ; i++)
                elements[i] = elements[i+1];
            count --;
        }
    }

    public void push(E element) {
        add(element);
    }

    public E peek() throws RuntimeException {
        if (count > 0) {
            return (E)elements[count - 1];
        }
        throw new RuntimeException("Error in MyList.peek");
    }
}
