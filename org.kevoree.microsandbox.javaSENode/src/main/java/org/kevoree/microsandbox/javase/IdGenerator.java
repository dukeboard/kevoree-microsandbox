package org.kevoree.microsandbox.javase;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 9/9/13
 * Time: 2:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class IdGenerator{

    private static IdGenerator singleton = new IdGenerator();

    private int nextId = 1;

    private IdGenerator() {}

    public static IdGenerator instance() {
        return singleton;
    }

    public synchronized int next() {
        return nextId++;
    }
}
