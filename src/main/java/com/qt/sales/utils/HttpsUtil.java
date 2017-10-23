package com.qt.sales.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * 
 * ClassName: HttpsUtil <br/>
 * date: 2016年8月30日 下午3:12:54 <br/>
 * 
 * @author madman
 * @version
 * @since JDK 1.6 PayTACard 1.0
 */
@SuppressWarnings("all")
public class HttpsUtil {

    /**
     * 忽视证书HostName
     */
    private static HostnameVerifier ignoreHostnameVerifier         = new HostnameVerifier() {
                                                                       public boolean verify(String s, SSLSession sslsession) {
                                                                           System.out.println("WARNING: Hostname is not matched for cert.");
                                                                           return true;
                                                                       }
                                                                   };

    /**
     * Ignore Certification
     */
    private static TrustManager     ignoreCertificationTrustManger = new X509TrustManager() {

                                                                       private X509Certificate[] certificates;

                                                                       public void checkClientTrusted(X509Certificate certificates[], String authType) throws CertificateException {
                                                                           if (this.certificates == null) {
                                                                               this.certificates = certificates;
                                                                               System.out.println("init at checkClientTrusted");
                                                                           }
                                                                       }

                                                                       public void checkServerTrusted(X509Certificate[] ax509certificate, String s) throws CertificateException {
                                                                           if (this.certificates == null) {
                                                                               this.certificates = ax509certificate;
                                                                               System.out.println("init at checkServerTrusted");
                                                                           }
                                                                       }

                                                                       public X509Certificate[] getAcceptedIssuers() {
                                                                           return null;
                                                                       }
                                                                   };

    /**
     * 
     * getMethod:(http是请求). <br/>
     * 
     * @author madman f
     * @param urlString
     *            g
     * @param postData
     *            f
     * @return
     * @return 返回结果：String
     * @since JDK 1.6 PayTACard 1.0
     */
    public static String getMethod(String urlString, String postData) {

        ByteArrayOutputStream buffer = new ByteArrayOutputStream(512);
        String result = "";
        DataOutputStream out = null;
        BufferedReader reader = null;
        HttpsURLConnection connection = null;
        try {
            URL url = new URL(null, urlString, new sun.net.www.protocol.https.Handler());

            /*
             * use ignore host name verifier
             */
            HttpsURLConnection.setDefaultHostnameVerifier(ignoreHostnameVerifier);
            connection = (HttpsURLConnection) url.openConnection();

            // Prepare SSL Context
            TrustManager[] tm = { ignoreCertificationTrustManger };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());

            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            connection.setSSLSocketFactory(ssf);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            connection.connect();
            out = new DataOutputStream(connection.getOutputStream());

            out.write(postData.getBytes("UTF-8"));
            out.flush();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            reader.close();

        } catch (Exception ex) {
            LogPay.error("getMethod方法异常" + ex.getMessage(), ex);
        } finally {
            try {
                if (out != null) {
                    out.close();
                    LogPay.info("out已关闭");
                }
            } catch (Exception e) {
                LogPay.error(e.getMessage(), e);
            }
            try {
                if (reader != null) {
                    reader.close();
                    LogPay.info("reader已关闭");
                }
            } catch (Exception e) {
                LogPay.error(e.getMessage(), e);
            }
            try {
                if (connection != null) {
                    connection.disconnect();
                    LogPay.info("connection已经断开");
                }
            } catch (Exception e) {
                LogPay.error(e.getMessage(), e);
            }
        }
        return result;
    }

	/**
	 * 
	 * main:(这里用一句话描述这个方法的作用). <br/>
	 * 
	 * @author madman
	 * @param args
	 *            f
	 * @since JDK 1.6 PayTACard 1.0
	 */
	
	public static void main(String[] args) {
		String urlString = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx5cfa9748673eec09&secret=337911ab814c183b446d3bbe45cad5f7";
		String output = new String(HttpsUtil.getMethod(urlString, ""));
		System.out.println(output);
	}
}