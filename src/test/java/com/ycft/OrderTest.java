/** 
 * 包名: package com.ycft; <br/> 
 * 添加时间: 2017年12月1日 下午4:14:09 <br/> 
 */
package com.ycft;

import com.qt.sales.model.OrderBean.billingTyper;

/** 
 * 类名: OrderTest <br/> 
 * 作用：TODO(简单一句话描述)<br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2017年12月1日 下午4:14:09 <br/> 
 * 版本： JDK 1.6 parkAlipayTrade 1.0
 */
public class OrderTest {

    public static void main(String[] args) {
        String type ="F";
        boolean re = type.equals(billingTyper.F.toString());
        System.out.println(billingTyper.F.toString());
    }
}

