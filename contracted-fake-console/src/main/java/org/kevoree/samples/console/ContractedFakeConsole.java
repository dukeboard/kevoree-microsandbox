package org.kevoree.samples.console;

import org.kevoree.annotation.*;
import org.kevoree.api.Context;
import org.kevoree.api.ModelService;
import org.kevoree.api.Port;
import org.kevoree.log.Log;
import org.kevoree.microsandbox.api.contract.CPUContracted;
import org.kevoree.microsandbox.api.contract.MemoryContracted;
import org.kevoree.microsandbox.api.contract.impl.CPUMemoryThroughputContractedImpl;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.jar.JarFile;

import com.google.gson.*;


@ComponentType
public class ContractedFakeConsole extends CPUMemoryThroughputContractedImpl {

    @KevoreeInject
    Context context;
    @KevoreeInject
    ModelService modelService;

    Random r = new Random();

    @Output
    Port output;

    Gson gson = new Gson/*Builder().setPrettyPrinting().create*/();
    BagOfPrimitives obj = new BagOfPrimitives();

    class BagOfPrimitives {
        private int value1 = 1;
        private String value2 = "abc";
        private transient int value3 = 3;
        BagOfPrimitives() {
            // no-args constructor
        }
    }

    BagOfPrimitives2 obj2 = new BagOfPrimitives2();

    class BagOfPrimitives2 {
        private int value1 = 1;
        private String value2 = "abc";
        private transient int value3 = 3;
        BagOfPrimitives2() {
            // no-args constructor
        }
    }

    BagOfPrimitives3 obj3 = new BagOfPrimitives3();

    class BagOfPrimitives3 {
        private int value1 = 1;
        private String value2 = "abc";
        private transient int value3 = 3;
        BagOfPrimitives3() {
            // no-args constructor
        }
    }

    @Start
    public void start() {
//        getClassesForPackage("org.kevoree.samples.console");

        String json = gson.toJson(obj);

        BagOfPrimitives obj2 = gson.fromJson(json, BagOfPrimitives.class);
        System.out.println(json + " " + obj2);

//        System.out.println(json + " ");
    }

    @Stop
    public void stop() {

    }

    @Input
    public void input(final Object obj) {

        Log.debug("ContractedFakeConsole {} received {}", context.getInstanceName(), obj);

        int n = Integer.parseInt(obj.toString());
        int tmp = n;

        if (r.nextBoolean() && output.getConnectedBindingsSize() > 0)
            output.send(tmp);
        // find prime factors
        int i = 2;
        while (n > 1) {
            if (n % i == 0) {
                n = n/i;
            }
            else {
                i++; // no the best solution but who cares
            }
        }
//        System.out.println(getName() + " " + n);
        if (r.nextBoolean() && output.getConnectedBindingsSize() > 0)
            output.send(n);
    }
}