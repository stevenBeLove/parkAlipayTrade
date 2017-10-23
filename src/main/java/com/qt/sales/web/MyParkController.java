/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2016年10月21日 下午1:51:47 <br/> 
 */
package com.qt.sales.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 类名: FansAgencyController <br/>
 * 作用：停车管理<br/>
 * 创建者: zhangyinghui. <br/>
 * 添加时间: 2016年10月21日 下午1:51:47 <br/>
 * 版本： JDK 1.6 sales 1.0
 */
@Controller
@RequestMapping("/parkPay")
public class MyParkController extends BaseController {

    
    @RequestMapping(value = "/carNum", method = RequestMethod.GET)
    public String showList(Model model) {
        return "myApp/myAppList";
    }
    

}
