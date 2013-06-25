package org.resourceaccounting.binderinjector;


public class ExtraInstrumentationRules {

    public final static String MONITOR_CLASS_NAME = "org/resourceaccounting/binder/ResourceCounter";

    public static boolean isInstrumentable(String className) {

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
        if ( className.startsWith("org/jacoco/") )
            return false;
        if (className.startsWith("org/")) {
            return !(className.startsWith("resourceaccounting/", 4) || className.startsWith("objectweb/asm", 4));
        }
        if (className.startsWith("org/kevoree/monitoring"))
            return false;
        return true;
    }

    public static boolean isMemoryAccountable(String className) {

        return !(className.startsWith("java/lang/"))
                && !(className.startsWith("java/security"));
    }
}