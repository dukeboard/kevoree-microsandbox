package org.kevoree.microsandbox.monitoredNode.command;

import kotlin.Pair;
import org.kevoree.kcl.api.FlexyClassLoader;
import org.kevoree.kcl.impl.FlexyClassLoaderImpl;
import org.kevoree.kcl.impl.KlassLoadRequest;
import org.kevoree.log.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by inti on 22/09/14.
 */
public class MicrosandboxLoader extends FlexyClassLoaderImpl {

    private FlexyClassLoader to_remove;

    @Override
    public Class loadClass(String className) throws ClassNotFoundException {
        if (to_remove  != null) {
            Stack<Pair<Integer, FlexyClassLoaderImpl>> stack = new Stack<Pair<Integer, FlexyClassLoaderImpl>>();
            stack.add(new Pair(0, this));
            while (!stack.empty()) {
                Pair<Integer, FlexyClassLoaderImpl> ll = stack.pop();

                boolean b = false;

                for (FlexyClassLoader loader : ll.component2().getSubClassLoaders()) {
                    String ss = "";
                    for (int i = 0; i < ll.component1(); i++)
                        ss += '\t';
                    Log.debug("{} subloader {}", ss, loader);

                    if (loader == to_remove)
                        b = true;

                    stack.push(new Pair(ll.component1() + 1, (FlexyClassLoaderImpl) loader));
                }

                if (b)
                    ll.component2().getSubClassLoaders().remove(to_remove);
            }
        }
        return super.loadClass(className);
    }

    public void removeSubLoader(FlexyClassLoader flexyClassLoader) {
        to_remove = flexyClassLoader;
    }
}
