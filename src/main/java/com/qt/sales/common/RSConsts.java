package com.qt.sales.common;

/**
 * 
 * 类名: RSConsts <br/> 
 * 创建者: Lance.Wu. <br/> 
 * 添加时间: 2016年1月18日 下午4:25:56 <br/> 
 * 版本： 
 * @since JDK 1.6 qtservices 1.0
 */
public abstract class RSConsts {
    // ------------------------------------------------------------------------------------------------------
    /** 响应码 */
    public static final String QZERR = "1"; // 请求成功
    /** 响应码 */
    public static final String RESP_CODE_00_SUCCESS = "0000"; // 请求成功
    /** 响应码 */
    public static final String RESP_CODE_01_ERR_TXN_ID = "0001"; // 未知交易码
    /** 响应码 */
    public static final String RESP_CODE_02_ERR_PARSE = "0002"; // 报文解析失败
    /** 响应码 */
    public static final String RESP_CODE_03_ERR_PRARM = "0003"; // 参数错误：缺少必须参数、或必须参数不合法
    /** 响应码 */
    public static final String RESP_CODE_04_ERR_NO_SESSION = "0004"; // 未建立会话
    /** 响应码 */
    public static final String RESP_CODE_05_ERR_FORMAT = "0005"; // 响应报文格式化异常
    /** 响应码 */
    public static final String RESP_CODE_06_ERR_NO_LOGIN = "0006"; // 未登录
    /** 响应码 */
    public static final String RESP_CODE_07_ERR_LOGIN_PWD = "0007"; // 登录失败：密码错误、或用户名不存在
    /** 响应码 */
    public static final String RESP_CODE_08_ERR_LOGIN_RE = "0008"; // 登录失败：重复登陆，同一用户，不同SID?
    /** 响应码 */
    public static final String RESP_CODE_09_ERR_TIME_OUT = "0009"; // 会话超时：请重新登录
    /** 响应码 */
    public static final String RESP_CODE_10_ERR_TOKEN = "0010"; // 非法TOKEN
    /** 响应码 */
    public static final String RESP_CODE_11_ERR_TOKEN = "0011"; // TOKEN超时
    /** 响应码 */
    public static final String RESP_CODE_12_ERR_SIGN = "0012"; // 验签失败
    /** 响应码 */
    public static final String RESP_CODE_13_ERR_PAY_PWD = "0013"; // 支付密码错误
    /** 响应码 */
    public static final String RESP_CODE_14_ERR_VERIFY_CODE = "0014"; // 验证码错误
    /** 响应码 */
    public static final String RESP_CODE_15_ERR_HOST = "0015"; // 主机异常
    /** 响应码 */
    public static final String RESP_CODE_16_ERR_QUITSESSION = "0016"; // 已退出安全会话
    /** 响应码 */
    public static final String RESP_CODE_17_ERR_BUSINESSEXCEPTION = "0017";               // 业务参数异常标识码
    /** 响应码 */
    public static final String RESP_CODE_97_RESP_FAIL = "0097"; // 请求已发送，
    /** 响应码 */
    // 对方未返回数据
    public static final String RESP_CODE_88_ERR_TXN = "0088"; // 交易失败
    /** 响应码 */
    public static final String RESP_CODE_98_ERR_CREATE = "0098"; // 服务还在建设当中，感谢您的使用.
    /** 响应码 */
    public static final String RESP_CODE_99_ERR_UNKNOW = "0099"; // 未知系统异常
    // 调用身份证系统返回码
    /** 响应码 */
    public static final String RESP_CODE_18_ERR_UNKNOW = "18"; // 验证身份证接口
    /**三要素验证标识**/
    public static final String RESP_3ELEMENT_FALG = "0"; 
  

}
