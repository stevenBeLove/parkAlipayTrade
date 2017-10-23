package com.qt.sales.utils;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtilSelf {
	
	/**
	 * 
	 * 方法名： replaceBlank.<br/>
	 * 方法作用:TODO(去除字符串中的空格、回车、换行符、制表符).<br/>
	 *
	 * 创建者：zhangyinghui.<br/>
	 * 创建日期：2016年8月24日.<br/>
	 * 创建时间：下午8:05:32.<br/>
	 * 参数者异常：@param str
	 * 参数者异常：@return .<br/>
	 * 返回值： @return 返回结果：String.<br/>
	 * 其它内容： JDK 1.6 chart 1.0.<br/>
	 */
	 public static String replaceBlank(String str) {
	        String dest = "";
	        if (str!=null) {
	            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
	            Matcher m = p.matcher(str);
	            dest = m.replaceAll("");
	        }
	        return dest;
	 }
	 
	 /**
	  * 
	  * 方法名： getFormatValue.<br/>
	  * 方法作用:TODO(格式化数字).<br/>
	  *
	  * 创建者：zhangyinghui.<br/>
	  * 创建日期：2016年8月25日.<br/>
	  * 创建时间：上午11:03:20.<br/>
	  * 参数者异常：@param value
	  * 参数者异常：@return .<br/>
	  * 返回值： @return 返回结果：String.<br/>
	  * 其它内容： JDK 1.6 chart 1.0.<br/>
	  */
	public static String formatNumber(String value,boolean isFormat){
		 if(value ==null || "".equals(value)||"null".equals(value)){
			 return "";
		 }else if(isFormat){
		  double x = Double.parseDouble(value)*0.01;
		  DecimalFormat df = new DecimalFormat("###,###.00");
		  String xs = df.format(x);
		  if(xs.startsWith(".")){
			  xs = "0"+xs;
		  }
		  return xs;
		}else{
			return value;
		}
	 }
	/**
	 * 
	 * 方法名： formatNumber.<br/>
	 * 方法作用:TODO(简单描述).<br/>
	 *
	 * 创建者：zhangyinghui.<br/>
	 * 创建日期：2016年8月29日.<br/>
	 * 创建时间：下午3:14:54.<br/>
	 * 参数者异常：@param value
	 * 参数者异常：@param isFormat
	 * 参数者异常：@return .<br/>
	 * 返回值： @return 返回结果：String.<br/>
	 * 其它内容： JDK 1.6 chart 1.0.<br/>
	 */
	public static String formatNumberOriginal(String value,boolean isFormat){
		 if(value ==null || "".equals(value)||"null".equals(value)){
			 return "";
		 }else if(isFormat){
		  double x = Double.parseDouble(value);
		  DecimalFormat df = new DecimalFormat("###,###");
		  String xs = df.format(x);
		  if(xs.startsWith(".")){
			  xs = "0"+xs;
		  }
		  return xs;
		}else{
			return value;
		}
	 }
	/**
	 * 
	 * 方法名： isNotNullOrEmpty.<br/>
	 * 方法作用:TODO(验证是否为空).<br/>
	 *
	 * 创建者：zhangyinghui.<br/>
	 * 创建日期：2016年8月26日.<br/>
	 * 创建时间：下午3:59:19.<br/>
	 * 参数者异常：@param s
	 * 参数者异常：@return .<br/>
	 * 返回值： @return 返回结果：boolean.<br/>
	 * 其它内容： JDK 1.6 chart 1.0.<br/>
	 */
	  public static boolean isNotNullOrEmpty(String s) {
		  return s != null && !"".equals(s);
	    }
	
}
