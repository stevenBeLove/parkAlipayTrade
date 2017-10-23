/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2016年11月12日 上午10:50:42 <br/> 
 */
package com.qt.sales.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qt.sales.model.TerminalManagementVO;
import com.qt.sales.service.TerminalManagementService;
import com.qt.sales.utils.Format;
import com.qt.sales.utils.ResultList;

/**
 * 
 * <pre>
 * 【类型】: HisTerminalManagementController <br/> 
 * 【作用】: 历史终端. <br/>  
 * 【时间】：2016年11月12日 上午10:50:49 <br/> 
 * 【作者】：fuyu <br/> 
 * </pre>
 */
@Controller
@RequestMapping("/hisTerminalManagement")
public class HisTerminalManagementController extends BaseController{
    

    /**
     * 
     */
    @Resource
    private TerminalManagementService terminalManagementService;
    
    /**
     * 
     * 【方法名】    : 跳转至历史终端查询页面. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月12日 上午11:00:46 .<br/>
     * 【参数】： .<br/>
     * @param model
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    @RequestMapping(value = "/listPage", method = RequestMethod.GET)
    public String terminalManagementList(Model model) {
        return "hisTerminalManagement/hisTerminalManagementList";
    }
    /**
     * 
     * 【方法名】    : 历史终端查询List. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月12日 上午10:25:23 .<br/>
     * 【参数】： .<br/>
     * @param pageSize 
     * @param offset
     * @param terminalManagementVO 
     * @param request 
     * @param response 
     * @param model 
     * @throws Exception .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    @RequestMapping(value = "/list")
    public void gethisTerminalManagement(@RequestParam(value = "limit", required = true) int pageSize, @RequestParam(value = "offset", required = true) int offset, TerminalManagementVO terminalManagementVO,
            HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
        if (offset == 0) {
            terminalManagementVO.setStart(0);
            terminalManagementVO.setEnd(pageSize + offset);
        } else {
            terminalManagementVO.setStart(offset);
            terminalManagementVO.setEnd(offset + pageSize);
        }
        int totalRowCount = terminalManagementService.hisTerminalManagementCount(terminalManagementVO);
        List<TerminalManagementVO> list = terminalManagementService.hisTerminalManagementList(terminalManagementVO);
        if (list!=null) {
            for (TerminalManagementVO temp : list) {
                // 分佣人手机号加密
                temp.setCustomerName(Format.mosaic(temp.getCustomerName(), "1"));
                temp.setMobile(Format.mosaic(temp.getMobile(), "2"));
                temp.setOrderName(Format.mosaic(temp.getOrderName(), "1"));
                temp.setOrderMobile(Format.mosaic(temp.getOrderMobile(), "2"));
            }
        }
        ResultList res = new ResultList();
        res.setRows(list);
        res.setTotal(totalRowCount);
        outPrint(resultToJson(res), response);
    }
}

