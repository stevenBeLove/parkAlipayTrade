/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2017年10月29日 下午4:20:02 <br/> 
 */
package com.qt.sales.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qt.sales.model.ParkBean;
import com.qt.sales.model.ParkBeanExample;
import com.qt.sales.service.ParkService;
import com.qt.sales.utils.LogPay;
import com.qt.sales.utils.ResultList;

/** 
 * 类名: ParkController <br/> 
 * 作用：TODO(简单一句话描述)<br/> 
 * 创建者: zhangyinghui. <br/> 
 * 添加时间: 2017年10月29日 下午4:20:02 <br/> 
 * 版本： JDK 1.6 parkAlipayTrade 1.0
 */
@Controller
@RequestMapping("/park")
public class ParkController {
    
    @Resource
    private ParkService parkService;

    /**
     * 跳转到列表页
     * @param model
     *            实体类
     * @return 页面路径
     */
    @RequestMapping(value = "/parkList", method = RequestMethod.GET)
    public String showList(Model model) {
        return "park/parkList";
    }
    
    
    /**
     * 查询人员列表
     * 
     * @param pageSize
     *            页数
     * @param offset
     *            每页多少条
     * @param user
     *           用户信息
     * @param response
     *            response
     * @throws Exception
     *             异常
     */
    @RequestMapping(value = "/parkPagelist")
    @ResponseBody
    public ResultList list(@RequestParam(value = "limit", required = true) int pageSize, @RequestParam(value = "offset", required = true) int offset, HttpServletResponse response)
        throws Exception {
        ParkBeanExample example = new ParkBeanExample();
        if (offset == 0) {
            example.setStart(0);
            example.setEnd(pageSize + offset);
        } else {
            example.setStart(offset);
            example.setEnd(offset + pageSize);
        }
        ParkBeanExample.Criteria cr = example.createCriteria();
//        if (!StringUtils.isEmpty(fansAgency.getAgencyId())) {
//            cr.andAgencyIdEqualTo(fansAgency.getAgencyId().trim());
//        }

//        if (!StringUtils.isEmpty(fansAgency.getAgencyName())) {
//            cr.andAgencyNameLike("%"+fansAgency.getAgencyName()+"%");
//        }
//        if (!StringUtils.isEmpty(fansAgency.getStatus())) {
//            cr.andStatusEqualTo(fansAgency.getStatus());
//        }
        example.setOrderByClause(" CREATE_DATETIME desc");
        int totalRowCount = parkService.countByExample(example);
        List<ParkBean> list = parkService.selectByExample(example);
        ResultList res = new ResultList();
        res.setRows(list);
        res.setTotal(totalRowCount);
        return res;
    }
    
    
    
}

