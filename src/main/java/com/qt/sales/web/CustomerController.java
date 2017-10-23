/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2016年10月17日 下午2:11:49 <br/> 
 */
package com.qt.sales.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qt.sales.model.Customer;
import com.qt.sales.service.CustomerService;
import com.qt.sales.utils.Format;
import com.qt.sales.utils.LogPay;
import com.qt.sales.utils.ResultList;

/**
 * 类名: AgencyController <br/>
 * 作用：TODO(用户Controller层)<br/>
 * 创建者: yinghui zhang. <br/>
 * 添加时间: 2016年10月17日 下午2:11:49 <br/>
 * 版本： JDK 1.6 distribution 1.0
 */
@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController {

    
    /**
     * 用户业务实现
     */
    @Resource
    private CustomerService customerService;

    /**
     * 
     * @param model
     *            实体类
     * @return 页面路径
     */
    @RequestMapping(value = "/listPage", method = RequestMethod.GET)
    public String showList(Model model) {
        return "customer/customerList";
    }

    /**
     * 
     * 【方法名】    : (查询客户列表). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月2日 上午9:31:06 .<br/>
     * 【参数】： .<br/>
     * @param pageSize int
     * @param offset int 
     * @param customer Customer
     * @param response  HttpServletResponse
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    @RequestMapping(value = "/list")
    public void list(@RequestParam(value = "limit", required = true) int pageSize, @RequestParam(value = "offset", required = true) int offset, Customer customer, HttpServletResponse response)
        throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (offset == 0) {
            map.put("start", 0);
            map.put("end", pageSize + offset);
        } else {
            map.put("start", offset);
            map.put("end", offset + pageSize);
        }
        if (!StringUtils.isEmpty(customer.getCustomerid())) {
            map.put("customerid", customer.getCustomerid());
        }

        if (!StringUtils.isEmpty(customer.getMobile())) {
            map.put("mobile", customer.getMobile());
        }

        if (!StringUtils.isEmpty(customer.getCustomerName())) {
            map.put("username", customer.getCustomerName());
        }

        if (!StringUtils.isEmpty(customer.getPayTerminalId())) {
            map.put("termid", customer.getPayTerminalId());
        }

        int totalRowCount = customerService.countByCustomerExample(map);
        List<Customer> list = customerService.selectByCustomerExample(map);
        if (list!=null) {
            for (Customer temp : list) {
                // 分佣人手机号加密
                temp.setCustomerName(Format.mosaic(temp.getCustomerName(), "1"));
                temp.setMobile(Format.mosaic(temp.getMobile(), "2"));
                temp.setParentMobile(Format.mosaic(temp.getParentMobile(), "2"));
                temp.setTwoMobile(Format.mosaic(temp.getTwoMobile(), ""));
            }
        }
        ResultList res = new ResultList();
        res.setRows(list);
        res.setTotal(totalRowCount);
        outPrint(resultToJson(res), response);
    }

    /**
     * 
     * 【方法名】    : (加载客户详情). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月25日 下午3:55:40 .<br/>
     * 【参数】： .<br/>
     * @param customerId 客户Id
     * @param payTerminalId 终端编号Id
     * @param model Model对象
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    @RequestMapping(value = "/showCustomerView/{customerId}/{payTerminalId}", method = RequestMethod.GET)
    public String showAgencyView(@PathVariable("customerId") String customerId, @PathVariable("payTerminalId") String payTerminalId, Model model) {
        try {
            Customer cust = new Customer();
            cust.setCustomerid(customerId);
            cust.setPayTerminalId(payTerminalId);
            Customer customer = customerService.selectCustoemrByPrimaryKey(cust);
            model.addAttribute("customer", customer);
            
            model.addAttribute("customerListOne", customerService.selectCustoemrByPrimaryKeyResult(customer.getParentCustomerid()));
            model.addAttribute("customerListTwo", customerService.selectCustoemrByPrimaryKeyResult(customer.getTwoCustomerid()));
            model.addAttribute("customerListTop", customerService.selectCustoemrByPrimaryKeyResult(customer.getTopCustomerid()));
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
            model.addAttribute("danger", "加载失败!");
        }
        return "customer/customerView";
    }
   
    /**
     * 
     * 【方法名】    : (这里用一句话描述这个方法的作用). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月25日 下午5:40:02 .<br/>
     * 【参数】： .<br/>
     * @param customerId 客户Id
     * @param model Model
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    @RequestMapping(value = "/showCustomerViewWithId/{customerId}", method = RequestMethod.GET)
    public String showCustomerViewWithId(@PathVariable("customerId") String customerId, Model model) {
        try {
            Customer customer = customerService.selectCustoemrByPrimaryKeyById(customerId);
            model.addAttribute("customer", customer);
            model.addAttribute("customerListOne", customerService.selectCustoemrByPrimaryKeyResult(customer.getParentCustomerid()));
            model.addAttribute("customerListTwo", customerService.selectCustoemrByPrimaryKeyResult(customer.getTwoCustomerid()));
            model.addAttribute("customerListTop", customerService.selectCustoemrByPrimaryKeyResult(customer.getTopCustomerid()));
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
            model.addAttribute("danger", "加载失败!");
        }
        return "customer/customerView";
    }
}
