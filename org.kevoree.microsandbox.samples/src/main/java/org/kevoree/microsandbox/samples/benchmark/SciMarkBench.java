package org.kevoree.microsandbox.samples.benchmark;

import org.kevoree.annotation.*;
import org.kevoree.api.Context;
import org.kevoree.api.Port;
import org.kevoree.microsandbox.samples.benchmark.scimark2.Constants;
import org.kevoree.microsandbox.samples.benchmark.scimark2.Random;
import org.kevoree.microsandbox.samples.benchmark.scimark2.kernel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;


/**
 * Created with IntelliJ IDEA.
 * User: duke
 * Date: 26/08/12
 * Time: 21:32
 */
@ComponentType
@Library(name = "JavaSE")
public class SciMarkBench implements Runnable {

    @Param(defaultValue = "false", optional = true)
    boolean large;

    @KevoreeInject
    Context context;

    @Output(optional = true)
    Port result;

    @Input
    public void trigger(Object msg) {
        pool.submit(this);
    }

    ExecutorService pool = null;

    int FFT_size = Constants.FFT_SIZE;
    int SOR_size = Constants.SOR_SIZE;
    int Sparse_size_M = Constants.SPARSE_SIZE_M;
    int Sparse_size_nz = Constants.SPARSE_SIZE_nz;
    int LU_size = Constants.LU_SIZE;

    public void updateParams() {
        if (large) {
            FFT_size = Constants.LG_FFT_SIZE;
            SOR_size = Constants.LG_SOR_SIZE;
            Sparse_size_M = Constants.LG_SPARSE_SIZE_M;
            Sparse_size_nz = Constants.LG_SPARSE_SIZE_nz;
            LU_size = Constants.LG_LU_SIZE;
        } else {
            FFT_size = Constants.FFT_SIZE;
            SOR_size = Constants.SOR_SIZE;
            Sparse_size_M = Constants.SPARSE_SIZE_M;
            Sparse_size_nz = Constants.SPARSE_SIZE_nz;
            LU_size = Constants.LU_SIZE;
        }
    }

    @Start
    public void start() {
        updateParams();
        pool = Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                Thread t = new Thread(runnable,"SciMark" + context.getInstanceName());
                t.setPriority(Thread.MAX_PRIORITY);
                return t;
            }
        });

        pool.submit(this);

    }

    @Stop
    public void stop() {
        pool.shutdownNow();
        pool = null;
    }

    @Update
    public void update() {
        stop();
        start();
    }

    @Override
    public void run() {

        if (result.getConnectedBindingsSize() > 0) {
            result.send("Bench started");
        }

        StringBuffer resultBuffer = new StringBuffer();

        // default to the (small) cache-contained version
        double min_time = Constants.RESOLUTION_DEFAULT;
        // run the benchmark
        double res[] = new double[6];
        Random R = new Random(Constants.RANDOM_SEED);

        res[1] = kernel.measureFFT(FFT_size, min_time, R);
        res[2] = kernel.measureSOR(SOR_size, min_time, R);
        res[3] = kernel.measureMonteCarlo(min_time, R);
        res[4] = kernel.measureSparseMatmult(Sparse_size_M,
                Sparse_size_nz, min_time, R);
        res[5] = kernel.measureLU(LU_size, min_time, R);


        res[0] = (res[1] + res[2] + res[3] + res[4] + res[5]) / 5;


        // print out results

        resultBuffer.append("SciMark 2.0a");
        resultBuffer.append("\n");

        resultBuffer.append("Composite Score: " + res[0]);
        resultBuffer.append("\n");
        resultBuffer.append("FFT (" + FFT_size + "): ");
        if (res[1] == 0.0) {
            resultBuffer.append(" ERROR, INVALID NUMERICAL RESULT!");
            resultBuffer.append("\n");
        } else {
            resultBuffer.append(res[1]);
            resultBuffer.append("\n");
        }
        resultBuffer.append("SOR (" + SOR_size + "x" + SOR_size + "): "
                + "  " + res[2]);
        resultBuffer.append("\n");
        resultBuffer.append("Monte Carlo : " + res[3]);
        resultBuffer.append("\n");
        resultBuffer.append("Sparse matmult (N=" + Sparse_size_M +
                ", nz=" + Sparse_size_nz + "): " + res[4]);
        resultBuffer.append("\n");
        resultBuffer.append("LU (" + LU_size + "x" + LU_size + "): ");
        if (res[5] == 0.0) {
            resultBuffer.append(" ERROR, INVALID NUMERICAL RESULT!");
            resultBuffer.append("\n");
        } else {
            resultBuffer.append(res[5]);
            resultBuffer.append("\n");
        }
        // print out System info
        resultBuffer.append("\n");
        resultBuffer.append("java.vendor: " +
                System.getProperty("java.vendor"));
        resultBuffer.append("\n");
        resultBuffer.append("java.version: " +
                System.getProperty("java.version"));
        resultBuffer.append("\n");
        resultBuffer.append("os.arch: " +
                System.getProperty("os.arch"));
        resultBuffer.append("\n");
        resultBuffer.append("os.name: " +
                System.getProperty("os.name"));
        resultBuffer.append("\n");
        resultBuffer.append("os.version: " +
                System.getProperty("os.version"));
        resultBuffer.append("\n");

        result.send(result.toString());

    }
}
