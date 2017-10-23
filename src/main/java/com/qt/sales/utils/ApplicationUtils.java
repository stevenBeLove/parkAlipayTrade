/** 
 * 包名: package com.qt.sales.utils; <br/> 
 * 添加时间: 2016年11月18日 下午8:24:35 <br/> 
 */
package com.qt.sales.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 类名: SpringUtils <br/>
 * 作用：TODO(简单一句话描述)<br/>
 * 创建者: zhangyinghui. <br/>
 * 添加时间: 2016年11月18日 下午8:24:35 <br/>
 * 版本： JDK 1.6 SalesPlatform 1.0
 */
public class ApplicationUtils {

    /**
     * 
     * 【方法名】 : (ApplicationUtils工具类). <br/>
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月18日 下午9:28:55 .<br/>
     * 【参数】： .<br/>
     * 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: yinghui zhang 修改描述： .<br/>
     *         <p/>
     */
    public static HttpServletRequest getRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        } catch (Exception e) {
            return null;
        }

    }
}
