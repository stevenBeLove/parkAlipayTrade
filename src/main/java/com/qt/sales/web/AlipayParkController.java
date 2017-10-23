/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2017年10月14日 下午4:39:40 <br/> 
 */
package com.qt.sales.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** 
 * 类名: AlipayParkController <br/> 
 * 作用：停车支付<br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2017年10月14日 下午4:39:40 <br/> 
 * 版本： JDK 1.6 sharpPark 1.0
 */
@Controller
@RequestMapping("/alipayPark")
public class AlipayParkController  extends BaseController {

    /**
     * 跳转到列表页
     * @param model
     *            实体类
     * @return 页面路径
     */
    @RequestMapping(value = "/alipay", method = RequestMethod.GET)
    public String showList(Model model) {
        return "alipayPark/view";
    }
    
}

