package org.sbelei.archietectide.utils;

/**
 * Since I'm not sure about logging mechanisms in Eclipse RCP, I'm using my loger as a facade
 * @author Serhii Belei
 *
 */
public class WbsLogger {

    public static final WbsLogger LOG = new WbsLogger();

    public void logException(String message, Exception e) {
        System.err.println(message);
        e.printStackTrace(System.err);
    }

    public void logError(String message) {
        System.err.println(message);
    }
}
