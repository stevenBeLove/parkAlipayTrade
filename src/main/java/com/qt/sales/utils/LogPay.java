/**
 *  <pre>	
 *  Project Name:PayCommomPlatform .</br>
 *  File: LogPay.java .</br>
 *  Package Name:com.pay.base.log .</br>
 *  Date      Author       Changes .</br>
 *  2016年5月18日   Lance.Wu     Create  .</br>
 *  Description: .</br>
 *  Copyright 2014-2015 YINGXIANG FINANCE Services Co.,Ltd. All rights reserved..</br>
 *  <pre>	
 */
package com.qt.sales.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * <pre>
 * ClassName: LogPay <br/> 
 * Function: 打印日志的方法包括：INFO,DEUBG,TRACE,ERROR. <br/> 
 * date: 2016年5月18日 下午12:27:23 <br/> 
 * 
 * @author Lance.Wu . <br/> 
 * @version   . <br/> 
 * @since JDK 1.6 PayCommomPlatform 1.0 . <br/>
 * </pre>
 */
public class LogPay {

    /** 日志对像 */
    private static final Logger LOGGER       = LoggerFactory.getLogger("com.pay");

    /** 是否登记日志 */
    public static boolean       isRunMonitor = false;

//    static {
//        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//        JoranConfigurator configurator = new JoranConfigurator();
//        configurator.setContext(lc);
//        lc.reset();
//        try {
//
//            String filePath = "";
//            /** 判断目录是否存在 */
//
//            /** 根据系统环境变量以文件 */
//            String usrdir = System.getProperty("user.dir").toString();
//            if (usrdir.endsWith("lib")) {
//                usrdir = usrdir.substring(0, usrdir.length() - 4);
//            }
//            StringBuffer sb = new StringBuffer(usrdir);
//            sb.append("/shiroConfig/logConfig.xml");
//
//            filePath = sb.toString();
//            File logFile = new File(sb.toString());
//
//            if (!logFile.exists()) {
//                /** 根据系统的文件路径取文件 */
//                URL url = LogPay.class.getClassLoader().getResource("");
//                if (url != null) {
//                    filePath = url.getPath() + "/shiroConfig/logConfig.xml";
//                }
//            }
//
//            logFile = new File(filePath);
//            if (!logFile.exists()) {
//                if (System.getProperty("LogPath") != null) {
//                    filePath = System.getProperty("LogPath");
//                }
//            }
//
//            logFile = new File(filePath);
//
//            if (!logFile.exists()) {
//                throw new JoranException("this file path is null : " + filePath);
//            }
//            configurator.doConfigure(logFile);
//            StatusPrinter.print(lc.getStatusManager());
//        } catch (JoranException e) {
//            LOGGER.error(e.getMessage(), e);
//        }
//
//    }

    /**
     * getLogger:(获取日志对像). <br/>
     * 
     * @author Lance.Wu <br/>
     * @return 返回结果：Logger <br/>
     * @since JDK 1.6 PayCommomPlatform 1.0 <br/>
     */
    public Logger getLogger() {
        return LOGGER;
    }

    /**
     * trace:(打印日志，级别为：info). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param msg
     *            错误信息 <br/>
     * @since JDK 1.6 PayCommomPlatform 1.0 <br/>
     */
    public static void info(String msg) {
        msg = checkMsg(msg);
        StringBuffer stringBuffer = new StringBuffer(__LINE__().toString());
        stringBuffer.append(msg.replaceAll("\n", "\r\n"));
        MDC.put("LINE", (numberOfStr(stringBuffer.toString(), "\n") - 1) + "");
        LOGGER.info(stringBuffer.toString());
        MDC.remove("LINE");
    }

    /**
     * trace:(打印日志，级别为：info). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param msg
     *            错误信息 <br/>
     * @param ifFlag
     *            异常信息 <br/>
     * @since JDK 1.6 PayCommomPlatform 1.0 <br/>
     */
    public static void info(String msg, String ifFlag) {
        msg = checkMsg(msg);
        StringBuffer stringBuffer = new StringBuffer(__LINE__().toString());
        stringBuffer.append(msg.replaceAll("\n", "\r\n"));
        MDC.put("LINE", (numberOfStr(stringBuffer.toString(), "\n") - 1) + "");
        MDC.put("IF", ifFlag);
        LOGGER.info(stringBuffer.toString());
        MDC.remove("IF");
        MDC.remove("LINE");
    }

    /**
     * trace:(打印日志，级别为：info). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param msg
     *            错误信息 <br/>
     * @param t
     *            异常 <br/>
     * @since JDK 1.6 PayCommomPlatform 1.0 <br/>
     */
    public static void info(String msg, Throwable t) {
        msg = checkMsg(msg);
        StringBuffer stringBuffer = new StringBuffer(__LINE__().toString());
        stringBuffer.append(msg.replaceAll("\n", "\r\n"));
        stringBuffer.append("\r\n");
        stringBuffer.append(getStackTrace(t));
        MDC.put("LINE", (numberOfStr(stringBuffer.toString(), "\n") - 1) + "");
        LOGGER.info(stringBuffer.toString());
        MDC.remove("LINE");

        // 异常处理
        processCheckErrorThread(t);
    }

    /**
     * trace:(打印日志，级别为：debug). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param msg
     *            错误信息 <br/>
     * @param t
     *            异常 <br/>
     * @param ifFlag
     *            异常信息 <br/>
     * @since JDK 1.6 PayCommomPlatform 1.0 <br/>
     */
    public static void info(String msg, Throwable t, String ifFlag) {
        msg = checkMsg(msg);
        StringBuffer stringBuffer = new StringBuffer(__LINE__().toString());
        stringBuffer.append(msg.replaceAll("\n", "\r\n"));
        stringBuffer.append("\r\n");
        stringBuffer.append(getStackTrace(t));
        MDC.put("LINE", (numberOfStr(stringBuffer.toString(), "\n") - 1) + "");
        MDC.put("IF", ifFlag);
        LOGGER.info(stringBuffer.toString());
        MDC.remove("IF");
        MDC.remove("LINE");

        // 异常处理
        processCheckErrorThread(t);
    }

    /**
     * trace:(打印日志，级别为：debug). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param msg
     *            错误信息 <br/>
     * @since JDK 1.6 PayCommomPlatform 1.0 <br/>
     */
    public static void debug(String msg) {
        msg = checkMsg(msg);
        StringBuffer stringBuffer = new StringBuffer(__LINE__().toString());
        stringBuffer.append(msg.replaceAll("\n", "\r\n"));
        MDC.put("LINE", (numberOfStr(stringBuffer.toString(), "\n") - 1) + "");
        LOGGER.debug(stringBuffer.toString());
        MDC.remove("LINE");
    }

    /**
     * trace:(打印日志，级别为：debug). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param msg
     *            错误信息 <br/>
     * @param ifFlag
     *            异常信息 <br/>
     * @since JDK 1.6 PayCommomPlatform 1.0 <br/>
     */
    public static void debug(String msg, String ifFlag) {
        msg = checkMsg(msg);
        StringBuffer stringBuffer = new StringBuffer(__LINE__().toString());
        stringBuffer.append(msg.replaceAll("\n", "\r\n"));
        MDC.put("LINE", (numberOfStr(stringBuffer.toString(), "\n") - 1) + "");
        MDC.put("IF", ifFlag);
        LOGGER.debug(stringBuffer.toString());
        MDC.remove("IF");
        MDC.remove("LINE");
    }

    /**
     * trace:(打印日志，级别为：debug). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param msg
     *            错误信息 <br/>
     * @param t
     *            异常 <br/>
     * @since JDK 1.6 PayCommomPlatform 1.0 <br/>
     */
    public static void debug(String msg, Throwable t) {
        msg = checkMsg(msg);
        StringBuffer stringBuffer = new StringBuffer(__LINE__().toString());
        stringBuffer.append(msg.replaceAll("\n", "\r\n"));
        stringBuffer.append("\r\n");
        stringBuffer.append(getStackTrace(t));
        MDC.put("LINE", (numberOfStr(stringBuffer.toString(), "\n") - 1) + "");
        LOGGER.debug(stringBuffer.toString());
        MDC.remove("LINE");

        // 异常处理
        processCheckErrorThread(t);
    }

    /**
     * trace:(打印日志，级别为：debug). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param msg
     *            错误信息 <br/>
     * @param t
     *            异常 <br/>
     * @param ifFlag
     *            异常信息 <br/>
     * @since JDK 1.6 PayCommomPlatform 1.0 <br/>
     */
    public static void debug(String msg, Throwable t, String ifFlag) {
        msg = checkMsg(msg);
        StringBuffer stringBuffer = new StringBuffer(__LINE__().toString());
        stringBuffer.append(msg.replaceAll("\n", "\r\n"));
        stringBuffer.append("\r\n");
        stringBuffer.append(getStackTrace(t));
        MDC.put("LINE", (numberOfStr(stringBuffer.toString(), "\n") - 1) + "");
        MDC.put("IF", ifFlag);
        LOGGER.debug(stringBuffer.toString());
        MDC.remove("IF");
        MDC.remove("LINE");

        // 异常处理
        processCheckErrorThread(t);
    }

    /**
     * trace:(打印日志，级别为：error). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param msg
     *            错误信息 <br/>
     * @since JDK 1.6 PayCommomPlatform 1.0 <br/>
     */
    public static void error(String msg) {
        msg = checkMsg(msg);
        StringBuffer stringBuffer = new StringBuffer(__LINE__().toString());
        stringBuffer.append(msg.replaceAll("\n", "\r\n"));
        MDC.put("LINE", (numberOfStr(stringBuffer.toString(), "\n") - 1) + "");
        LOGGER.error(stringBuffer.toString());
        MDC.remove("LINE");
    }

    /**
     * trace:(打印日志，级别为：error). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param msg
     *            错误信息 <br/>
     * @param ifFlag
     *            异常信息 <br/>
     * @since JDK 1.6 PayCommomPlatform 1.0 <br/>
     */
    public static void error(String msg, String ifFlag) {
        msg = checkMsg(msg);
        StringBuffer stringBuffer = new StringBuffer(__LINE__().toString());
        stringBuffer.append(msg.replaceAll("\n", "\r\n"));
        MDC.put("LINE", (numberOfStr(stringBuffer.toString(), "\n") - 1) + "");
        MDC.put("IF", ifFlag);
        LOGGER.error(stringBuffer.toString());
        MDC.remove("IF");
        MDC.remove("LINE");
    }

    /**
     * trace:(打印日志，级别为：error). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param msg
     *            错误信息 <br/>
     * @param t
     *            异常信息 <br/>
     * @since JDK 1.6 PayCommomPlatform 1.0 <br/>
     */
    public static void error(String msg, Throwable t) {
        msg = checkMsg(msg);
        StringBuffer stringBuffer = new StringBuffer(__LINE__().toString());
        stringBuffer.append(msg.replaceAll("\n", "\r\n"));
        stringBuffer.append("\r\n");
        stringBuffer.append(getStackTrace(t));
        MDC.put("LINE", (numberOfStr(stringBuffer.toString(), "\n") - 1) + "");
        LOGGER.error(stringBuffer.toString());
        MDC.remove("LINE");

        // 异常处理
        processCheckErrorThread(t);
    }

    /**
     * trace:(打印日志，级别为：error). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param msg
     *            错误信息 <br/>
     * @param t
     *            异常信息 <br/>
     * @param ifFlag
     *            字符串 <br/>
     * @since JDK 1.6 PayCommomPlatform 1.0 <br/>
     */
    public static void error(String msg, Throwable t, String ifFlag) {
        msg = checkMsg(msg);
        StringBuffer stringBuffer = new StringBuffer(__LINE__().toString());
        stringBuffer.append(msg.replaceAll("\n", "\r\n"));
        stringBuffer.append("\r\n");
        stringBuffer.append(getStackTrace(t));
        MDC.put("LINE", (numberOfStr(stringBuffer.toString(), "\n") - 1) + "");
        MDC.put("IF", ifFlag);
        LOGGER.error(stringBuffer.toString());
        MDC.remove("IF");
        MDC.remove("LINE");

        // 异常处理
        processCheckErrorThread(t);
    }

    /**
     * trace:(打印日志，级别为：trace). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param msg
     *            错误信息 <br/>
     * @since JDK 1.6 PayCommomPlatform 1.0 <br/>
     */
    public static void trace(String msg) {
        msg = checkMsg(msg);
        StringBuffer stringBuffer = new StringBuffer(__LINE__().toString());
        stringBuffer.append(msg.replaceAll("\n", "\r\n"));
        MDC.put("LINE", (numberOfStr(stringBuffer.toString(), "\n") - 1) + "");
        LOGGER.trace(stringBuffer.toString());
        MDC.remove("LINE");
    }

    /**
     * trace:(打印日志，级别为：trace). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param msg
     *            错误信息 <br/>
     * @param t
     *            异常信息 <br/>
     * @since JDK 1.6 PayCommomPlatform 1.0 <br/>
     */
    public static void trace(String msg, Throwable t) {
        msg = checkMsg(msg);
        StringBuffer stringBuffer = new StringBuffer(__LINE__().toString());
        stringBuffer.append(msg.replaceAll("\n", "\r\n"));
        stringBuffer.append("\r\n");
        stringBuffer.append(getStackTrace(t));
        MDC.put("LINE", (numberOfStr(stringBuffer.toString(), "\n") - 1) + "");
        LOGGER.trace(stringBuffer.toString());
        MDC.remove("LINE");

        // 异常处理
        processCheckErrorThread(t);
    }

    /**
     * processCheckErrorThread:(处理检查异常Error方法 - 发送与监控端). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param t
     *            异常<br/>
     * @since JDK 1.6 PayCommomPlatform 1.0 <br/>
     */
    public static void processCheckErrorThread(Throwable t) {
        if (isRunMonitor) {
//            Thread checkErrorThread = new Thread(new CheckErrorThread(t));
//            checkErrorThread.start();
        }
    }

    /**
     * numberOfStr:(获取行号). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param str
     *            字付串
     * @param con
     *            对像
     * @return 返回结果：int <br/>
     * @since JDK 1.6 PayCommomPlatform 1.0 <br/>
     */
    private static int numberOfStr(String str, String con) {
        String str1 = " " + str;
        return str1.split(con).length;

    }

    /**
     * getStackTrace:("获取异常信息"). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param t
     *            异常
     * @return 返回结果：String <br/>
     * @since JDK 1.6 PayCommomPlatform 1.0 <br/>
     */
    private static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            t.printStackTrace(pw);
            return sw.toString();
        } finally {
            try {
                pw.close();
                sw.close();
            } catch (IOException e) {
                LogPay.error(e.getMessage(), e);
            }
        }
    }

    /**
     * checkMsg:(内容转换). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param msg
     *            错误信息
     * @return 返回结果：String <br/>
     * @since JDK 1.6 PayCommomPlatform 1.0 <br/>
     */
    private static String checkMsg(String msg) {
        if (msg == null) {
            msg = "";
        }
        return msg;
    }

    /**
     * __LINE__:(获取日志信息). <br/>
     * 
     * @author Lance.Wu <br/>
     * @return <br/>
     * @since JDK 1.6 PayCommomPlatform 1.0 <br/>
     */
    private static StackTraceElement __LINE__() {
        return new java.lang.Exception().getStackTrace()[2];
    }

    /**
     * main:(测试类). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param args
     * <br/>
     * @since JDK 1.6 PayCommomPlatform 1.0 <br/>
     */
    public static void main(String[] args) {
        File f = new File("D:\\workspaceOsgi\\PayServicesUser/config/logConfig.xml");
        System.out.println(f.exists());
    }

}