package com.toryang.sampledemo.utils;

import java.util.Hashtable;

/**
 * Created by toryang on 16/4/26.
 */
public class Log {
    private final static boolean logFlag = true;

    public final static String tag = "[AppName]";
    private final static int logLevel = android.util.Log.VERBOSE;
    private static Hashtable<String, Log> sLoggerTable = new Hashtable<String, Log>();
    private String mClassName;

    private static Log YLog;

    private static final String YC = "@yc_Util ";

    private Log(String name) {
        mClassName = name;
    }

    /**
     * @param className
     * @return
     */
    @SuppressWarnings("unused")
    private static Log getLogger(String className) {
        Log classLogger = (Log) sLoggerTable.get(className);
        if (classLogger == null) {
            classLogger = new Log(className);
            sLoggerTable.put(className, classLogger);
        }
        return classLogger;
    }

    /**
     * Purpose:Mark user two
     *
     * @return
     */
    public static Log YLog() {
        if (YLog == null) {
            YLog = new Log(YC);
        }
        return YLog;
    }

    /**
     * Get The Current Function Name
     *
     * @return
     */
    private String getFunctionName() {
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        if (sts == null) {
            return null;
        }
        for (StackTraceElement st : sts) {
            if (st.isNativeMethod()) {
                continue;
            }
            if (st.getClassName().equals(Thread.class.getName())) {
                continue;
            }
            if (st.getClassName().equals(this.getClass().getName())) {
                continue;
            }
            return mClassName + "[ " + Thread.currentThread().getName() + ": "
                    + st.getFileName() + ":" + st.getLineNumber() + " "
                    + st.getMethodName() + " ]";
        }
        return null;
    }

    /**
     * The Log Level:i
     *
     * @param str
     */
    public void i(Object str) {
        if (logFlag) {
            if (logLevel <= android.util.Log.INFO) {
                String name = getFunctionName();
                if (name != null) {
                    android.util.Log.i(tag, name + " - " + str);
                } else {
                    android.util.Log.i(tag, str.toString());
                }
            }
        }

    }

    /**
     * The Log Level:d
     *
     * @param str
     */
    public void d(Object str) {
        if (logFlag) {
            if (logLevel <= android.util.Log.DEBUG) {
                String name = getFunctionName();
                if (name != null) {
                    android.util.Log.d(tag, name + " - " + str);
                } else {
                    android.util.Log.d(tag, str.toString());
                }
            }
        }
    }

    /**
     * The Log Level:V
     *
     * @param str
     */
    public void v(Object str) {
        if (logFlag) {
            if (logLevel <= android.util.Log.VERBOSE) {
                String name = getFunctionName();
                if (name != null) {
                    android.util.Log.v(tag, name + " - " + str);
                } else {
                    android.util.Log.v(tag, str.toString());
                }
            }
        }
    }

    /**
     * The Log Level:w
     *
     * @param str
     */
    public void w(Object str) {
        if (logFlag) {
            if (logLevel <= android.util.Log.WARN) {
                String name = getFunctionName();
                if (name != null) {
                    android.util.Log.w(tag, name + " - " + str);
                } else {
                    android.util.Log.w(tag, str.toString());
                }
            }
        }
    }

    /**
     * The Log Level:e
     *
     * @param str
     */
    public void e(Object str) {
        if (logFlag) {
            if (logLevel <= android.util.Log.ERROR) {
                String name = getFunctionName();
                if (name != null) {
                    android.util.Log.e(tag, name + " - " + str);
                } else {
                    android.util.Log.e(tag, str.toString());
                }
            }
        }
    }

    /**
     * The Log Level:e
     *
     * @param ex
     */
    public void e(Exception ex) {
        if (logFlag) {
            if (logLevel <= android.util.Log.ERROR) {
                android.util.Log.e(tag, "error", ex);
            }
        }
    }

    /**
     * The Log Level:e
     *
     * @param log
     * @param tr
     */
    public void e(String log, Throwable tr) {
        if (logFlag) {
            String line = getFunctionName();
            android.util.Log.e(tag, "{Thread:" + Thread.currentThread().getName() + "}"
                    + "[" + mClassName + line + ":] " + log + "\n", tr);
        }
    }
}
