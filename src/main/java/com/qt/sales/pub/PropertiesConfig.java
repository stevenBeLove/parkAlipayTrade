/** 
 * 包名: package com.qt.sales.pub; <br/> 
 * 添加时间: 2016年11月3日 下午4:47:20 <br/> 
 */
package com.qt.sales.pub;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类名: Config <br/>
 * 作用：TODO(读取配置文件)<br/>
 * 创建者: zhangyinghui. <br/>
 * 添加时间: 2016年11月3日 下午4:47:20 <br/>
 * 版本： JDK 1.6 SalesPlatform 1.0
 */
public class PropertiesConfig {

    /**
     * log类
     */
    private static Logger     logger     = LoggerFactory.getLogger(PropertiesConfig.class);
    /**
     * 配置文件路径
     */
    private static String     configFile = "/shiroConfig/config.properties";

    /**
     * 配置项
     */
    private static Properties prop       = null;

    /**
     * 
     * 【方法名】    : (通过key值获取内容). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月3日 下午5:23:33 .<br/>
     * 【参数】： .<br/>
     * @param key key值
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    public static String getPropertyValue(String key) {
        initData();
        return (String) prop.get(key);
    }

  /**
   * 
   * 【方法名】    : (载入配置文件). <br/> 
   * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
   * 【作者】: yinghui zhang .<br/>
   * 【时间】： 2016年11月3日 下午5:24:14 .<br/>
   * 【参数】： .<br/> .<br/>
   * <p>
   * 修改记录.<br/>
   * 修改人:  yinghui zhang 修改描述： .<br/>
   * <p/>
   */
    private static void initData() {
        if (prop == null) {
            prop = new Properties();
            InputStream in = PropertiesConfig.class.getClassLoader().getResourceAsStream(configFile);
            try {
                prop.load(in);
            } catch (IOException e) {
                logger.error("关闭输入流异常！");
            } finally {
                if (in != null) {
                    try {
                        in.close();
                        in = null;
                    } catch (IOException e) {
                        logger.error("关闭输入流异常！");
                    }
                }
            }
        }
    }

}
