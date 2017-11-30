package com.qt.sales.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.util.StringUtils;


/**
 * 
 * 类名: HttpRequestUtil
 * 方法：http请求工具类
 * 创建者: HuaiYu.Wen
 * 添加时间: 2016年4月20日 下午5:01:02
 * 版本： 
 * @since JDK 1.6 qtservices 1.0
 */
public class HttpRequestUtil {

    /** 
     * 定义编码格式 UTF-8 
     */
    public static final String URL_PARAM_DECODECHARSET_UTF8 = "UTF-8";

    /** 
     * 定义编码格式 GBK 
     */
    public static final String URL_PARAM_DECODECHARSET_GBK = "GBK";

    /**
     * 参数拼接字符
     */
    private static final String URL_PARAM_CONNECT_FLAG = "&";

    /**
     * 空字符串
     */
    private static final String EMPTY = "";

    /**
     * 
     */
    private static MultiThreadedHttpConnectionManager connectionManager = null;

    /**
     * 连接超时时间
     */
    private static int connectionTimeOut = 25000;

    /**
     * socket超时时间
     */
    private static int socketTimeOut = 25000;

    /**
     * 最大连接数
     */
    private static int maxConnectionPerHost = 20;

    /**
     * 
     */
    private static int maxTotalConnections = 20;

    /**
     * 
     */
    private static HttpClient client;

    static {
        connectionManager = new MultiThreadedHttpConnectionManager();
        connectionManager.getParams().setConnectionTimeout(connectionTimeOut);
        connectionManager.getParams().setSoTimeout(socketTimeOut);
        connectionManager.getParams().setDefaultMaxConnectionsPerHost(maxConnectionPerHost);
        connectionManager.getParams().setMaxTotalConnections(maxTotalConnections);
        client = new HttpClient(connectionManager);
    }

    /** 
     * POST方式提交数据 
     * @param url 
     *          待请求的URL 
     * @param map 
     *          要提交的数据 
     * @param enc 
     *          编码 
     * @return 
     *          响应结果 
     *          IO异常 
     */
    public static String urlPost(String url, Map<String, Object> map, String enc) {

        String response = EMPTY;
        PostMethod postMethod = null;
        try {
            postMethod = new PostMethod(url);
            postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
            postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
            // 将表单的值放入postMethod中
            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                String value = map.get(key).toString();
                postMethod.addParameter(key, value);
            }
            // 执行postMethod
            int statusCode = client.executeMethod(postMethod);
            if (statusCode == HttpStatus.SC_OK) {
                response = postMethod.getResponseBodyAsString();
            } else {
                LogPay.error("响应状态码 = " + postMethod.getStatusCode());
            }
        } catch (HttpException e) {
            LogPay.error("发生致命的异常，可能是协议不对或者返回的内容有问题", e);
            e.printStackTrace();
        } catch (IOException e) {
            LogPay.error("发生网络异常", e);
            e.printStackTrace();
        } finally {
            if (postMethod != null) {
                postMethod.releaseConnection();
                postMethod = null;
            }
        }

        return response;
    }

    /** 
     * GET方式提交数据 
     * @param url 
     *          待请求的URL 
     * @param params 
     *          要提交的数据 
     * @param enc 
     *          编码 
     * @return 
     *          响应结果 
     *          IO异常 
     */
    public static String urlGet(String url, Map<String, Object> params, String enc) {

        String response = EMPTY;
        GetMethod getMethod = null;
        StringBuffer strtTotalURL = new StringBuffer(EMPTY);

        if (strtTotalURL.indexOf("?") == -1) {
            strtTotalURL.append(url).append("?").append(getUrl(params, enc));
        } else {
            strtTotalURL.append(url).append("&").append(getUrl(params, enc));
        }
        LogPay.debug("GET请求URL = \n" + strtTotalURL.toString());

        try {
            getMethod = new GetMethod(strtTotalURL.toString());
            getMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
            // 执行getMethod
            int statusCode = client.executeMethod(getMethod);
            if (statusCode == HttpStatus.SC_OK) {
                response = getMethod.getResponseBodyAsString();
            } else {
                LogPay.debug("响应状态码 = " + getMethod.getStatusCode());
            }
        } catch (HttpException e) {
            LogPay.error("发生致命的异常，可能是协议不对或者返回的内容有问题", e);
            e.printStackTrace();
        } catch (IOException e) {
            LogPay.error("发生网络异常", e);
            e.printStackTrace();
        } finally {
            if (getMethod != null) {
                getMethod.releaseConnection();
                getMethod = null;
            }
        }

        return response;
    }

    /** 
     * 据Map生成URL字符串 
     * @param map 
     *          Map 
     * @param valueEnc 
     *          URL编码 
     * @return 
     *          URL 
     */
    private static String getUrl(Map<String, Object> map, String valueEnc) {

        if (null == map || map.keySet().size() == 0) {
            return EMPTY;
        }
        StringBuffer url = new StringBuffer();
        Set<String> keys = map.keySet();
        for (Iterator<String> it = keys.iterator(); it.hasNext();) {
            String key = it.next();
            if (map.containsKey(key)) {
                Object obj = map.get(key);
                String val = StringUtils.isEmpty(obj) ? EMPTY : obj.toString();
                String str = val != null ? val : EMPTY;
                try {
                    str = URLEncoder.encode(str, valueEnc);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                url.append(key).append("=").append(str).append(URL_PARAM_CONNECT_FLAG);
            }
        }
        String strURL = EMPTY;
        strURL = url.toString();
        if (URL_PARAM_CONNECT_FLAG.equals(EMPTY + strURL.charAt(strURL.length() - 1))) {
            strURL = strURL.substring(0, strURL.length() - 1);
        }

        return strURL;
    }

     public static void main(String[] args) {
         Map<String, Object> params = new HashMap<String, Object>();
         params.put("oauth_version", 2 + "");
         params.put("app_id", "200435782");
         params.put("company_id", "8fb5baa4d13376fbbef18b4a1bf757df");
         String data = HttpRequestUtil.urlPost("http://openapi.b.qq.com/api/user/list", params,"utf-8");
         System.out.println(data);
     }
}
