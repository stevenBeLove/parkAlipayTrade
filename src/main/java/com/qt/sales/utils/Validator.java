package com.qt.sales.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
 
	/**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^((1[0-9][0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
 
    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD = "((11|12|13|14|15|21|22|23|31|32|33|34|35|36|37|41|42|43|44|45|46|50|51|52|53|54|61|62|63|64|65)[0-9]{4})" +  
                                        "(([1|2][0-9]{3}[0|1][0-9][0-3][0-9][0-9]{3}" +  
                                        "[Xx0-9])|([0-9]{2}[0|1][0-9][0-3][0-9][0-9]{3}))";
    
    public static final String  REGOA = "^/.*/\\*\\*$";
    
    /**
     * 校验身份证
     * 
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCardRegular(String idCard) {
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }
 
    /**
     * 校验手机号
     * 
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobileNumber(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }
    /**
     * 校验手机号
     * 
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
	    String re1="(\\d+)";
	    String re2="(\\*)";	
	    String re3="(\\*)";	
	    String re4="(\\*)";	
	    String re5="(\\*)";	
	    String re6="(\\d+)";	
	    String re7="(\\d)";	
	    String re8="(\\d)";	
	    Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7+re8,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
	    Matcher m = p.matcher(mobile);
	    return m.matches();
    }
 
    /**
     * 校验身份证
     * 
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String idCard) {
    	String re1="(\\d)";	
        String re2="(\\d)";	
        String re3="(\\d)";	
        String re4="(\\d)";	
        String re5="(\\d)";	
        String re6="(\\d)";	
        String re7="((?:(?:[1]{1}\\d{1}\\d{1}\\d{1})|(?:[2]{1}\\d{3}))(?:[0]?[1-9]|[1][012])(?:(?:[0-2]?\\d{1})|(?:[3][01]{1})))(?![\\d])";	// YYYYMMDD 1
        String re8="(\\*)";	
        String re9="(\\*)";	
        String re10="(\\d)";	
        String re11="(.)";	
        Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7+re8+re9+re10+re11,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(idCard);
    	return m.matches();
    }
 
  
 
    /**
     * 
     * 方法名： isIPAddr.<br/>
     * 适用条件:TODO(简单描述).<br/> 
     *
     * 创建者：zhangyinghui.<br/>
     * 创建日期：2016年8月19日.<br/>
     * 创建时间：上午11:49:56.<br/>
     * 参数者异常：@param ipAddr
     * 参数者异常：@return .<br/>
     * 返回值： @return 返回结果：boolean.<br/>
     * 其它内容： JDK 1.6 chart 1.0.<br/>
     */
    public static boolean isCustomerId(String customerId) {
    	String re1="(A)";	
        String re2="(\\d+)";	
        Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(customerId);
        return m.matches();
    }
    
    public static boolean isMatchWildcard(String url){
        // 编译正则表达式
        Pattern pattern = Pattern.compile(REGOA);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        // 字符串是否与正则表达式相匹配
        return matcher.matches();
    }
    
    public static void main(String[] args) {
        
       // 要验证的字符串
        String str = "user/user";
        
        String strOa = "/oa/**";
        
        String regOa = "^/.*/\\*\\*$";
        // 邮箱验证规则
        String regEx = "^user.*";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regOa);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(strOa);
        // 字符串是否与正则表达式相匹配
        boolean rs = matcher.matches();
        System.out.println(rs);
        
    }
    
    
    
}
