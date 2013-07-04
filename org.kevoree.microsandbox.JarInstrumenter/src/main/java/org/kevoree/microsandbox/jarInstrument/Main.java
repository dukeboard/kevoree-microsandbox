package org.kevoree.microsandbox.jarInstrument;

import org.kevoree.microsandbox.core.instrumentation.InstrumenterCommand;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/14/13
 * Time: 11:39 PM
 * <p/>
 * <p/>
 * You can use this program to instrument a jar file
 */
public class Main {

    public static void main(String[] args) {



        if (args.length < 1) {
            System.err.printf("Usage: java -jar JarInstrumenter.jar [jar file] ([outputjar file])\n");
            System.exit(1);
        }
        File f = new File(args[0]);
        if (!f.exists()) {
            System.err.printf("File %s does not exist\n", args[0]);
            System.exit(2);
        }


        File targetFile = new File("rtNew.jar");
        if(args.length >= 2){
            targetFile = new File(args[1]);
        }

        //File f = new File("/Library/Java/Home/bundle/Home/bundle/Classes/classes.jar");

        boolean onlyProxies = false;
        if (args.length == 2) {
            onlyProxies = Boolean.parseBoolean(args[1]);
        }
        performInstrumentation(f, onlyProxies,targetFile);
    }

    public static void performInstrumentation(File f, boolean onlyProxies, File targetFile) {

        JarFile jar = null;
        try {
            InstrumenterCommand cmd = new InstrumenterCommand();

            jar = new JarFile(f);
            JarOutputStream outputStream = new JarOutputStream(new FileOutputStream(targetFile));

            // instrument as many classes as
            if (!onlyProxies) {
                HashMap<String, Node> map = new HashMap<String, Node>(1000);

                Enumeration<JarEntry> entryEnumeration = jar.entries();
                while (entryEnumeration.hasMoreElements()) {
                    try {
                        JarEntry entry = entryEnumeration.nextElement();
                        if (entry.getName().endsWith(".class")) {
                            String clazz = entry.getName().substring(0, entry.getName().length() - 6);
                            putInRecursiveWay(clazz, map, jar, cmd);
                        }
                    } catch(ZipException e){
                       e.printStackTrace();
                    }
                }

                Node objectClass = map.get("java/lang/Object");
                objectClass.included = true;
                int c = 0;

                // adding direct subclasses of Object
                for (int i = 0; i < objectClass.children.size(); i++) {
                    String clazz = objectClass.children.get(i).className;
                    if (shouldHasPrincipalIdField(clazz)) {

                        objectClass.children.get(i).included = true;
                        boolean applyMemoryAccounting = shouldAccountMemoryConsumption(clazz);
                        instrumentClass(jar,
                                outputStream,
                                jar.getEntry(clazz + ".class"),
                                cmd,
                                false);
                        //System.out.printf("Root %d : %s\n", c++, clazz);
                    }
                }

                // adding classes that should have principalId but inherit from a forbidden class
                for (Node node : map.values()) {
                    if (node.included)
                        continue;
                    if (node.parent != objectClass
                            && !shouldHasPrincipalIdField(node.parent.className)
                            && shouldHasPrincipalIdField(node.className)) {
                        boolean applyMemoryAccounting = node.className.startsWith("java/util/");
                        node.included = true;
                        instrumentClass(jar,
                                outputStream,
                                jar.getEntry(node.className + ".class"),
                                cmd,
                                false);
                        //                    System.out.printf("Root %d : %s\n", c++ , node.className);
                    }
                }

                // adding rest of classes
                for (Node node : map.values())
                    if (!node.included && shouldAccountMemoryConsumption(node.className)) {

                        instrumentClassForMemoryAccountingOnly(jar, outputStream,
                                jar.getEntry(node.className + ".class"),
                                cmd);
                        node.included = true;
                        //                    System.out.printf("Root %d : %s\n", c++, node.className);
                    }

            }

            createMyIntegerClass(jar, outputStream, cmd);
            modifySocketClasses(jar, outputStream, cmd);
            modifyFileClasses(jar, outputStream, cmd);


//            for (int i = 0 ; i < ExtraInstrumentationRules.extras.size(); i++)
//                instrumentClass(jar, outputStream, jar.getEntry(ExtraInstrumentationRules.extras.get(i) + ".class"),cmd);

            outputStream.close();

        } catch (IOException e) {

            e.printStackTrace();

            System.err.printf("File %s is invalid jar file\n", f);
            System.exit(3);
        } finally {
            if (jar != null)
                try {
                    jar.close();
                } catch (IOException e) {
                }
        }

    }

    private static boolean shouldHasPrincipalIdField(String clazz) {
        return !(clazz.startsWith("java/lang/"))
                && !(clazz.startsWith("java/security"))
//        && !(clazz.startsWith("sun/launcher/"))
                ;
    }

    private static boolean shouldAccountMemoryConsumption(String clazz) {
        return (clazz.startsWith("java"))
                && !(
                clazz.startsWith("java/lang/")
                        || clazz.startsWith("java/security/")
        )
                && !(
                clazz.equals("java/net/SocketInputStream")
                        || clazz.equals("java/net/SocketOutputStream")
                        || clazz.equals("java/lang/Integer")
        );
    }

    /**
     * Build a forest with all the classes in Jar file. All nodes in the forest are
     * in the hash map
     *
     * @param clazz Class to include in the forest
     * @param map   Where to put all parent classes of clazz
     * @param jar   All classes
     * @param cmd   Way to find a super class
     * @throws IOException
     */
    private static void putInRecursiveWay(String clazz,
                                          HashMap<String,
                                                  Node> map,
                                          JarFile jar,
                                          InstrumenterCommand cmd) throws IOException {

        if (clazz.equals("java/lang/Object")) {
            if (!map.containsKey(clazz))
                map.put(clazz, new Node(clazz));
            return;
        }


        JarEntry entry = jar.getJarEntry(clazz + ".class");
        if (entry != null) {
            String superClass = cmd.getSuperClass(jar.getInputStream(entry));
            if (superClass != null) {
                if (!map.containsKey(superClass)) {
                    putInRecursiveWay(superClass, map, jar, cmd);
                }
                Node parent = map.get(superClass);
                if (parent != null)
                    map.put(clazz, parent.addChild(clazz));
            }
        }
    }

    /**
     * Add a new entry to the jar file output
     *
     * @param outputStream
     * @param classEntry
     * @param code
     * @throws IOException
     */
    private static void createEntryInOutput(JarOutputStream outputStream, String classEntry, byte[] code) throws IOException {
        try {
            ZipEntry newV = new ZipEntry(classEntry);
            outputStream.putNextEntry(newV);
            outputStream.write(code);
            outputStream.closeEntry();
        } catch(Exception e){
             e.printStackTrace();
        }
    }

    /**
     * Instrument a class by adding a field (ide of resource principal) and
     * a finalize method (modifying the existent one). The finalize method reports
     * object finalization with Integer.__reportAboutMemory__
     * <p/>
     * Assumptions:
     * This method can only be called with classes that inherit in a direct way
     * from Object.
     * If a class do not inherit from Object and has a finalize method then such a
     * method calls the finalize method of the super class.
     * Todo : The above assumption is not valid
     *
     * @param jar
     * @param outputStream
     * @param stringClass
     * @param cmd
     * @throws IOException
     */
    private static void instrumentClass(JarFile jar,
                                        JarOutputStream outputStream,
                                        ZipEntry stringClass,
                                        InstrumenterCommand cmd,
                                        boolean applyMemoryAccounting) throws IOException {
        byte[] result = cmd.instrument(jar.getInputStream(stringClass), applyMemoryAccounting);
        createEntryInOutput(outputStream, stringClass.getName(), result);
    }

    private static void instrumentClassForMemoryAccountingOnly(JarFile jar,
                                                               JarOutputStream outputStream,
                                                               ZipEntry stringClass,
                                                               InstrumenterCommand cmd) throws IOException {
        byte[] result = cmd.instrumentForMemoryAccounting(jar.getInputStream(stringClass));
        createEntryInOutput(outputStream, stringClass.getName(), result);
    }

    /**
     * Modify the Integer class by adding several static methods. I selected the
     * Integer Class as proxy to the resource monitor just because. Using a proxy
     * avoid dependencies in JDK RT. At runtime I only need to instrument the  app
     * itself and the class Integer.
     *
     * @param jar
     * @param outputStream
     * @param cmd
     * @throws IOException
     */
    private static void createMyIntegerClass(JarFile jar,
                                             JarOutputStream outputStream,
                                             InstrumenterCommand cmd) throws IOException {
        byte[] result = cmd.createIntegerClass(jar.getInputStream(jar.getEntry("java/lang/Integer.class")));
        createEntryInOutput(outputStream, "java/lang/Integer.class", result);
    }

    /**
     * Modify the classes in JDK RT that have something to do with network access
     * The modification is the addition of calls to Integer.__reportNetworkRead__
     * and Integer.__reportNetworkWrite__
     *
     * @param jar
     * @param outputStream
     * @param cmd
     * @throws IOException
     */
    private static void modifySocketClasses(JarFile jar, JarOutputStream outputStream, InstrumenterCommand cmd) throws IOException {
        String socketRead = "java/net/SocketInputStream" + ".class";
        byte[] result = cmd.modifyingNetworkClass(jar.getInputStream(jar.getEntry(socketRead)));
        createEntryInOutput(outputStream, socketRead, result);

        String socketWrite = "java/net/SocketOutputStream" + ".class";
        result = cmd.modifyingNetworkClass(jar.getInputStream(jar.getEntry(socketWrite)));
        createEntryInOutput(outputStream, socketWrite, result);
    }

    /**
     * Modify the classes in JDK RT that have something to do with file access.
     * The modification is the addition of calls to Integer.__reportFileRead__
     * and Integer.__reportFileWrite__
     *
     * @param jar
     * @param outputStream
     * @param cmd
     * @throws IOException
     */
    private static void modifyFileClasses(JarFile jar, JarOutputStream outputStream, InstrumenterCommand cmd) throws IOException {
        String fileRead = "java/io/FileInputStream" + ".class";
        byte[] result = cmd.modifyingFileAccessClass(jar.getInputStream(jar.getEntry(fileRead)));
        createEntryInOutput(outputStream, fileRead, result);

        String fileWrite = "java/io/FileOutputStream" + ".class";
        result = cmd.modifyingFileAccessClass(jar.getInputStream(jar.getEntry(fileWrite)));
        createEntryInOutput(outputStream, fileWrite, result);
    }
}
