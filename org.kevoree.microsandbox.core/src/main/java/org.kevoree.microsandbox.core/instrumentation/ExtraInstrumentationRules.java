package org.kevoree.microsandbox.core.instrumentation;


import org.resourceaccounting.binder.ResourceCounter;

public class ExtraInstrumentationRules {

    public final static String MONITOR_CLASS_NAME = ResourceCounter.class.getCanonicalName().replace('.','/');

    public static boolean isInstrumentable(String className) {

        if (className.startsWith("org/kevoree/microsandbox/samples"))
            return true;

        if (className.startsWith("java")
                || className.startsWith("sun")
                || className.startsWith("com/sun/")
                || className.startsWith("com/oracle/")
                || className.startsWith("org/xml/sax")
                || className.startsWith("org/w3c/dom")
                || className.startsWith("org/jcp/")
                || className.startsWith("org/omg/")
                || className.startsWith("org/ietf/"))
            return false;
        if (className.startsWith("org/kevoree/monitoring")
                || className.startsWith("org/kevoree/microsandbox")
                || className.startsWith("org/resourceaccounting/")
                || className.startsWith("org/objectweb/asm")
                || className.startsWith("org/jacoco/")
                )
            return false;
        return true;
    }

    public static boolean isMemoryAccountable(String className) {

        return !(className.startsWith("java/lang/"))
                && !(className.startsWith("java/security"));
    }
}