/** 
 * 包名: package com.qt.sso.web.controller; <br/> 
 * 添加时间: 2017年4月16日 下午6:50:56 <br/> 
 */
package com.qt.sso.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** 
 * 类名: AccountController <br/> 
 * 作用：账号表<br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2017年4月16日 下午6:50:56 <br/> 
 * 版本： JDK 1.6 SalesPlatform 1.0
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    
    @RequestMapping(value = "/accountUrl", method=RequestMethod.GET)
    public String getAccountUrl(String clientId){
        StringBuffer bf = new StringBuffer();
        //http://localhost/oauth2.0/authorize?response_type=code&client_id=shenji&
        //redirect_uri=http%3A%2F%2Fshenji.imobpay.com%2FoauthBack&selectedAccountNo=admin
        return "redirect:/"+bf.toString(); 
    }
    
    
}

