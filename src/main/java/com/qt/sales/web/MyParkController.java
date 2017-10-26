/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2016年10月21日 下午1:51:47 <br/> 
 */
package com.qt.sales.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qt.sales.model.Customer;
import com.qt.sales.utils.LogPay;

/**
 * 类名: FansAgencyController <br/>
 * 作用：停车管理<br/>
 * 创建者: zhangyinghui. <br/>
 * 添加时间: 2016年10月21日 下午1:51:47 <br/>
 * 版本： JDK 1.6 sales 1.0
 */
@Controller
@RequestMapping("/alipayPark")
public class MyParkController extends BaseController {

    
    @RequestMapping(value = "/notify", method = RequestMethod.GET)
    public String showList(Model model) {
        return "park/notify";
    }
    
    
//    @RequestMapping(value = "/showCustomerView/{customerId}/{payTerminalId}", method = RequestMethod.GET)
//    public String showAgencyView(@PathVariable("customerId") String customerId, @PathVariable("payTerminalId") String payTerminalId, Model model) {
//        try {
//            Customer cust = new Customer();
//            cust.setCustomerid(customerId);
//            cust.setPayTerminalId(payTerminalId);
//            Customer customer = customerService.selectCustoemrByPrimaryKey(cust);
//            model.addAttribute("customer", customer);
//            
//            model.addAttribute("customerListOne", customerService.selectCustoemrByPrimaryKeyResult(customer.getParentCustomerid()));
//            model.addAttribute("customerListTwo", customerService.selectCustoemrByPrimaryKeyResult(customer.getTwoCustomerid()));
//            model.addAttribute("customerListTop", customerService.selectCustoemrByPrimaryKeyResult(customer.getTopCustomerid()));
//        } catch (Exception e) {
//            LogPay.error(e.getMessage(), e);
//            model.addAttribute("danger", "加载失败!");
//        }
//        return "customer/customerView";
//    }

}
