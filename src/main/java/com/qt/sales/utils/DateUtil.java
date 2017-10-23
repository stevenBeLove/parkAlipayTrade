package com.qt.sales.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.util.StringUtils;

/**
 * 日期时间处理工具类 ClassName: DateUtil <br/>
 * date: 2016年6月1日 下午4:26:02 <br/>
 * 
 * @author Lance.WU
 * @since JDK 1.6 platform 1.0
 */
public final class DateUtil {

    /** 日期时间格式  */
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /** 日期 格式*/
    public static final String YYYYMMDD = "yyyyMMdd";

    /** 时间格式 */
    public static final String HHMMSS = "HHmmss";
    
    /***
     * 标注时间格式
     */
    public static final String STANDDATEFORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * getCurrDate:(获取当前日期). <br/>
     * 格式为：yyyyMMdd.<br/>
     * 
     * @author Lance.Wu <br/>
     * @return 返回结果：String <br/>
     * @since JDK 1.6 ServerFramework 1.0 <br/>
     */
    public static String getCurrDate() {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(new Date());
    }
    
    /**
     * getCurrDate:(获取当前日期). <br/>
     * 格式为：yyyyMMdd.<br/>
     * 
     * @author Lance.Wu <br/>
     * @return 返回结果：String <br/>
     * @since JDK 1.6 ServerFramework 1.0 <br/>
     */
    public static String getCurDate() {
        DateFormat df = new SimpleDateFormat("yyyyMM");
        return df.format(new Date());
    }

    /**
     * 获取当前日期时间
     * @return 日期和时间
     */
    public static String getCurrDateAndTime() {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(new Date());
    }
    /**
     * getCurrDate:(获取当前日期). <br/>
     * 格式为：自定义格式.<br/>
     * 
     * @author Lance.Wu <br/>
     * @param format
     *            自定义格式 <br/>
     * @return 返回结果：String <br/>
     * @since JDK 1.6 ServerFramework 1.0 <br/>
     */
    public static String getCurrDate(String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(new Date());
    }

    /**
     * getCurrDate:(获取当前日期). <br/>
     * 格式为：自定义格式.<br/>
     * 
     * @author Lance.Wu <br/>
     * @param l
     *            时间格式 <br/>
     * @param format
     *            自定义格式 <br/>
     * @return 返回结果：String <br/>
     * @since JDK 1.6 ServerFramework 1.0 <br/>
     */
    public static String getCurrDate(long l, String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(new Date(l));
    }

    /**
     * getCurrDate:(获取当前日期). <br/>
     * 格式为：自定义格式.<br/>
     * 
     * @author Lance.Wu <br/>
     * @param date
     *            时间 <br/>
     * @param format
     *            自定义格式 <br/>
     * @return 返回结果：String <br/>
     * @since JDK 1.6 ServerFramework 1.0 <br/>
     */
    public static String getCurrDate(Date date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * getCurrDate:(获取当前日期). <br/>
     * 格式为：yyyyMMdd.<br/>
     * 
     * @author Lance.Wu <br/>
     * @param dateStr
     *            时间字符串 <br/>
     * @return 返回结果：Date <br/>
     * @throws ParseException
     *             转换异常 <br/>
     * @since JDK 1.6 ServerFramework 1.0 <br/>
     */
    public static Date getCurrDateStr(String dateStr) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.parse(dateStr);
    }

    /**
     * getCurrTime:(获取当前日期). <br/>
     * 格式为：hhMMss.<br/>
     * 
     * @author Lance.Wu <br/>
     * @return 返回结果：String <br/>
     * @since JDK 1.6 ServerFramework 1.0 <br/>
     */
    public static String getCurrTime() {
        DateFormat df = new SimpleDateFormat("hhMMss");
        return df.format(new Date());
    }

    /**
     * getCurrTime:(获取当前日期). <br/>
     * 格式为：hhMMss.<br/>
     * 
     * @author Lance.Wu <br/>
     * @param format
     *            格式化 <br/>
     * @return 返回结果：String <br/>
     * @since JDK 1.6 ServerFramework 1.0 <br/>
     */
    public static String getCurrTime(String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(new Date());
    }

    /**
     * addDate:(计算时间格式). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param date
     *            时间 <br/>
     * @param num
     *            基数 <br/>
     * @param calendarType
     *            时间格式【Calendar:DATE 天数, DAY_OF_MONTH, YEAR,】 <br/>
     * @return 返回结果：int 返回天数 <br/>
     * @since JDK 1.6 ServerFramework 1.0 <br/>
     */
    public static Date addDate(Date date, int num, int calendarType) {
        Calendar sc = Calendar.getInstance();
        sc.setTime(date);
        sc.add(calendarType, num);
        return sc.getTime();
    }

    /**
     * 
     * 【方法名】    : (对日期进行加减运算). <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月7日 上午10:16:33 .<br/>
     * 【参数】： .<br/>
     * @param dateTime 日期字符串
     * @param day -1为dateTime减一天，+1为加一天，以此类推
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     * @throws ParseException 
     */
    public static String getAddDate(String dateTime, int day) throws ParseException{
        SimpleDateFormat sFmt = new SimpleDateFormat("yyyyMMdd");
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(sFmt.parse(dateTime));
        c.add(5, day); // 结束日期减少一天
        String endTime = sFmt.format(c.getTime());
        return endTime;
    }
    /**
     * addDate:(计算时间格式). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param date
     *            时间 <br/>
     * @param num
     *            基数 <br/>
     * @param calendarType
     *            时间格式【Calendar:DATE 天数, DAY_OF_MONTH, YEAR,】 <br/>
     * @return 返回结果：int 返回天数 <br/>
     * @throws ParseException
     *             转换失败
     * @since JDK 1.6 ServerFramework 1.0 <br/>
     */
    public static Date addDate(String date, int num, int calendarType) throws ParseException {
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
        Calendar sc = Calendar.getInstance();
        sc.setTime(sd.parse(date));
        sc.add(calendarType, num);
        return sc.getTime();
    }

    /**
     * addDate:(计算时间格式). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param date
     *            时间 <br/>
     * @param num
     *            基数 <br/>
     * @param calendarType
     *            时间格式【Calendar:DATE 天数, DAY_OF_MONTH, YEAR,】 <br/>
     * @param formart
     *            返回内容格式 <br/>
     * @return 返回结果：int 返回天数 <br/>
     * @since JDK 1.6 ServerFramework 1.0 <br/>
     */
    public static String addDate(Date date, int num, int calendarType, String formart) {
        Calendar sc = Calendar.getInstance();
        sc.setTime(date);
        sc.add(calendarType, num);
        SimpleDateFormat sd = new SimpleDateFormat(formart);
        return sd.format(sc);
    }

    /**
     * 
     * 【方法名】    : (这里用一句话描述这个方法的作用). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月9日 下午5:59:40 .<br/>
     * 【参数】： .<br/>
     * @param date Date对象
     * @param formatPattern 字符串
     * @return String类型.<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public static String format(Date date, String formatPattern) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(formatPattern).format(date);
    }
    
    /**
     * 
     * 【方法名】    : (和当前日期比较,true:比当前日期早). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月10日 下午2:23:12 .<br/>
     * 【参数】： .<br/>
     * @param beginDate String类型
     * @return boolean值.<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     * @throws ParseException 
     */
    public static boolean compareBefore(String beginDate) throws ParseException {
        SimpleDateFormat sFmt = new SimpleDateFormat("yyyyMMdd");
        Date begindate = sFmt.parse(beginDate);
        Date nowdate = new Date();
        return begindate.before(nowdate);
    }
    /**
     * 
     * 【方法名】    : (获取标准时间格式). <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月24日 下午6:05:19 .<br/>
     * 【参数】： .<br/>
     * @param date 时间字符串
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     * @throws ParseException 
     */
    public static String getStandDateFormat(String date) throws ParseException {
        if (StringUtils.isEmpty(date)) {
            return date;
        }
        SimpleDateFormat sFmt = new SimpleDateFormat(YYYYMMDDHHMMSS);
        Date dates = sFmt.parse(date);
        SimpleDateFormat standFormat = new SimpleDateFormat(STANDDATEFORMAT);
        return standFormat.format(dates);
    }

}
