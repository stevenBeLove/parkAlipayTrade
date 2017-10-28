/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2016年9月27日 下午1:29:46 <br/> 
 */
package com.qt.sales.utils;

import java.util.Properties;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/** 
 * 类名: PropertyPlaceholderConfigurerExt <br/> 
 * 作用：TODO(简单一句话描述)<br/> 
 * 方法：TODO(简单描述方法)<br/> 
 * 创建者: zyh12345. <br/> 
 * 添加时间: 2016年9月27日 下午1:29:46 <br/> 
 * 版本： JDK 1.6 chart 1.0
 */
public class PropertyPlaceholderConfigurerExt extends PropertyPlaceholderConfigurer {
    
    /**
     * 配置文件
     */
    private static Properties properties;
    
    /**
     * 描述：对数据密码进行加密码.<br/>
     * 创建人：Lance.Wu .<br/>
     * 创建时间：2016年6月1日 下午5:24:52 .<br/>
     * 
     * @param beanFactory
     *            文件工厂.<br/>
     * @param props
     *            属性文件.<br/>
     */
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) {
        this.properties = props;
        String key = props.getProperty("common.proDesEncryptKey");
        String pwd = props.getProperty("parkpay.db.password");
        key = MD5.md5(key);
        key = (key + key).substring(0, 48);
        String dec = dec(key, pwd);
        props.setProperty("parkpay.db.password", dec);
        super.processProperties(beanFactory, props);
    }

    /**
     * dec:(解密). <br/>
     * 
     * @author Lance.Wu <br/>
     * @param key
     *            密钥 <br/>
     * @param content
     *            密文内容 <br/>
     * @return 返回结果：String <br/>
     * @since JDK 1.6 PayIFramework 1.0 <br/>
     */
    private static String dec(String key, String content) {
        
        DesEncrypt des = new DesEncrypt();
        des.setKey(Hex.fromString(key));
        int s1len = content.length() / 2;
        if (s1len % 8 != 0) {
            int fill = ((s1len / 8) + 1) * 16;
            content = Tools.rightFill(content, fill, "0");
        }
        byte[] get3DesDesCode = des.get3DesDesCode(Hex.fromString(content));
        return new String(get3DesDesCode).trim();
    }
    
    
    /**
     * 
     * dec:(加密). <br/>
     * @author Lance.Wu <br/>
     * @param key 密钥
     * @param content  密文内容
     * @return 返回结果：String <br/>
     * @since JDK 1.6 PayIFramework 1.0 <br/>
     */
    private static String encryption(String key, String content) {
        content = Hex.toString(content.getBytes());
        DesEncrypt des = new DesEncrypt();
        des.setKey(Hex.fromString(key));
        int s1len = content.length() / 2;
        
        if (s1len % 8 != 0) {
            int fill = ((s1len / 8) + 1) * 16;
            content = Tools.rightFill(content, fill, "0");
        }
        byte[] bye = des.get3DesEncCode(Hex.fromString(content));
        return Hex.toString(bye).trim();
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return properties .<br/>
     */
    public static Properties getProperties() {
        return properties;
    }

    
//    public static void main(String[] args) {
//      String key = MD5.md5("qtpay111");
//      key = (key + key).substring(0, 48); 
//      //解密
//      String pwd = PropertyPlaceholderConfigurerExt.dec(key,"5C3F9CB08C076D49");
//      System.out.println("解密后为"+pwd);
//      
//      //加密
//      String origpwd = PropertyPlaceholderConfigurerExt.encryption(key,"qtpay");
//      System.out.println("加密后为"+origpwd);
//    }
    
    
}

