package com.qt.sales.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Http工具类
 * <p>
 * 提供一个通过get和post方式访问url的工具
 * 
 * @author 杜忠(Michael.Du)
 * @version 1.0
 * @since 1.5
 */

public class HttpHelper {

	/**
	 * 连接超时
	 */
	public static int ConnectTimeout = 30000;

	/**
	 * 读取超时
	 */
	public static int ReadTimeout = 30000;

	/**
	 * 输入字符编码
	 */
	public static String InEncoding = "UTF-8";

	/**
	 * 输出字符编码
	 */
	public static String OutEncoding = "GBK";

	/**
	 * 以默认字符集，get方式访问url。
	 * 
	 * @param url
	 *            要访问的url
	 * 
	 * @return String 服务返回的HTML文本
	 * @throws IOException
	 */
	public static String get(String url) throws IOException {
		return get(url, InEncoding);
	}

	/**
	 * 以指定字符集，get方式访问url。
	 * 
	 * @param url
	 *            要访问的url
	 * 
	 * @param encoding
	 *            输入的字符集
	 * 
	 * @return String 服务返回的HTML文本
	 * @throws IOException
	 */
	public static String get(String url, String encoding) throws IOException {
		String result = "";
		URL httpUrl;
		httpUrl = new URL(url);
		HttpURLConnection httpConn = (HttpURLConnection) httpUrl
				.openConnection();
		httpConn.setConnectTimeout(ConnectTimeout);
		httpConn.setReadTimeout(ReadTimeout);
		httpConn.connect();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				httpConn.getInputStream(), encoding));
		String line;
		while ((line = in.readLine()) != null) {
			result += line;
		}
		in.close();
		httpConn.disconnect();
		return result;
	}

	/**
	 * 以默认字符集，post方式访问url。
	 * 
	 * @param url
	 *            要访问的url
	 * 
	 * @param param
	 *            要传递的参数
	 * 
	 * @return String 服务返回的HTML文本
	 * @throws IOException 
	 */
	public static String post(String url, String param) throws IOException {
		return post(url, param, OutEncoding, InEncoding);
	}

	/**
	 * 以指定字符集，post方式访问url。
	 * 
	 * @param url
	 *            要访问的url
	 * 
	 * @param param
	 *            要传递的参数
	 * 
	 * @param OutEncoding
	 *            输出字符编码
	 * 
	 * @param InEncoding
	 *            输入字符编码
	 * 
	 * @return String 服务返回的HTML文本
	 * @throws IOException
	 */
	public static String post(String url, String param, String OutEncoding,
			String InEncoding) throws IOException {
		String result = "";
		URL httpurl = new URL(url);
		HttpURLConnection httpConn = (HttpURLConnection) httpurl
				.openConnection();
		httpConn.setConnectTimeout(ConnectTimeout);
		httpConn.setReadTimeout(ReadTimeout);
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		PrintWriter out = new PrintWriter(
				new BufferedWriter(new OutputStreamWriter(
						httpConn.getOutputStream(), OutEncoding)));
		out.print(param);
		out.flush();
		out.close();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				httpConn.getInputStream(), InEncoding));
		String line;
		while ((line = in.readLine()) != null) {
			result += line;
		}
		in.close();
		httpConn.disconnect();
		return result;
	}
}
