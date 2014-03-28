package org.kevoree.microsandbox.cgroupNode.components;

import org.kevoree.log.Log;

import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

/**
 * Created by inti on 3/11/14.
 */
class CRIUStrategy implements SlaveRuntimeDeployer {

    @Override
    public boolean deploy(String nodeName, String fileName) {
        DatagramSocket socket = null;
        try {
            // restore virtual machine
            ProcessBuilder builder = new ProcessBuilder("/home/inti/tests/executingInCRIU/restore.sh",
                    nodeName);

//            if (!Files.exists(Paths.get(nodeName))) {
//                Files.createDirectory(Paths.get(nodeName));
//            }
            builder = builder.directory(new File("/home/inti/tests/executingInCRIU"));

            long ll = System.nanoTime();

            Process process = builder.
                    redirectOutput(ProcessBuilder.Redirect.INHERIT).
                    redirectError(ProcessBuilder.Redirect.INHERIT).start();

            process.waitFor();

            ll = System.nanoTime() - ll;
            System.out.println("Time " + ll/1000000);

            int port = Integer.parseInt(nodeName.replace("virtualNode","")) + 9875;

            socket = new DatagramSocket();
//            socket.setSoTimeout(100);
            byte[] buf = String.format("%s\n%s", nodeName, fileName).getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length,
                    InetAddress.getByName("localhost"), port);
            byte[] buf2 = new byte[10];
            DatagramPacket packet2 = new DatagramPacket(buf2, buf2.length);
//            while (true) {
                socket.send(packet);
                try {
                    socket.receive(packet2);
                    Log.info("Slave {} wake up", nodeName);
//                    break; // hehe: ugly but I saved one line of code
                }
                catch (SocketTimeoutException exception) {
                    exception.printStackTrace();
                }
//            }
            socket.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}
