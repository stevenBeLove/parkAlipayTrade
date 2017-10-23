/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2016年11月3日 上午9:54:11 <br/> 
 */
package com.qt.sales.web;

import java.io.File;
//zhangyinghui@192.168.1.51:10002/Qtpay_ImobPlatform_Group/SalesPlatform
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qt.sales.exception.QTException;
import com.qt.sales.model.TerminalManagementVO;
import com.qt.sales.service.TerminalManagementService;
import com.qt.sales.utils.DateUtil;
import com.qt.sales.utils.Format;
import com.qt.sales.utils.LogPay;
import com.qt.sales.utils.ResultList;

/**
 * 
 * <pre>
 * 【类型】: TerminalManagementController <br/> 
 * 【作用】: 终端信息管理. <br/>  
 * 【时间】：2016年11月10日 下午5:38:28 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
@Controller
@RequestMapping("/terminalManagement")
public class TerminalManagementController extends BaseController {


    /**
     * 
     */
    @Resource
    private TerminalManagementService terminalManagementService;

    /**
     * 
     * 【方法名】 : 跳转至终端管理页面. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月10日 下午5:38:39 .<br/>
     * 【参数】： .<br/>
     * 
     * @param model 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/listPage", method = RequestMethod.GET)
    public String terminalManagementList(Model model) {
        return "terminalManagement/terminalManagementList";
    }

    /**
     * 
     * 【方法名】 : 终端管理查询. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月10日 下午5:38:53 .<br/>
     * 【参数】： .<br/>
     * 
     * @param pageSize 
     * @param offset 
     * @param terminalManagementVO 
     * @param request 
     * @param response 
     * @param model 
     * @throws Exception .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/list")
    public void getPayAwardJnls(@RequestParam(value = "limit", required = true) int pageSize, @RequestParam(value = "offset", required = true) int offset, TerminalManagementVO terminalManagementVO,
            HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
        if (offset == 0) {
            terminalManagementVO.setStart(0);
            terminalManagementVO.setEnd(pageSize + offset);
        } else {
            terminalManagementVO.setStart(offset);
            terminalManagementVO.setEnd(offset + pageSize);
        }
        int totalRowCount = terminalManagementService.TerminalManagementCount(terminalManagementVO);
        List<TerminalManagementVO> list = terminalManagementService.getTerminalManagementList(terminalManagementVO);
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
    
   
  

    /**
     * 
     * 【方法名】 : 终端解绑. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月10日 下午5:39:05 .<br/>
     * 【参数】： .<br/>
     * 
     * @param termId 
     * @param terminalManagementVO 
     * @param redirectAttributes  
     * @param response 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/terminalUnbundling/{termId}", method = RequestMethod.GET)
    @ResponseBody
    public AjaxReturnInfo terminalUnbundling(@PathVariable("termId") String termId, TerminalManagementVO terminalManagementVO) {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        try {
            TerminalManagementVO terminalManagement = terminalManagementService.TerminalManagementOne(terminalManagementVO);
            // 终端解绑：新增至历史tb_his_fans_payterminal
            int countHis = terminalManagementService.hisTerminalManagementOne(terminalManagement);
            if (countHis > 0) {
                ajaxinfo.setSuccess("false");
                ajaxinfo.setMessage("新增失败!&nbsp;&nbsp;重复添加数据");
            } else {
                Subject subject = SecurityUtils.getSubject();
                terminalManagement.setUnbuildDate(DateUtil.getCurrDateAndTime());
                terminalManagement.setUnbuildId((String)subject.getPrincipal());
                terminalManagement.setTermActivation("0");
                terminalManagementService.insertHisTerminal(terminalManagement);
            }
            // 并删除tb_fans_payterminal记录
            terminalManagementService.deleteTerminalManagement(terminalManagement);
            /*// tb_fans_paypsam branchid 置为00000000，psamstatus为1
            terminalManagementService.updatePaypsam(terminalManagement);*/
            ajaxinfo.setSuccess("true");
            ajaxinfo.setMessage("解绑成功！");
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
            ajaxinfo.setSuccess("false");
            ajaxinfo.setMessage("解绑失败!");
        }
        return ajaxinfo;
    }

    /**
     * 
     * 【方法名】 : 打开导入终端信息页面. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月10日 下午5:39:20 .<br/>
     * 【参数】： .<br/>
     * 
     * @param model 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/showUploadView", method = RequestMethod.GET)
    public String showUploadView(Model model) {

        return "terminalManagement/uploadExcel";
    }

    /**
     * 
     * 【方法名】 : 导入终端信息. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月10日 下午5:39:35 .<br/>
     * 【参数】： .<br/>
     * 
     * @param excelFile MultipartFile文件流
     * @param request 请求
     * @param model ModelMap参数
     * @param redirectAttributes 重定向参数
     * @return String.<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @SuppressWarnings("deprecation")
    @RequestMapping(value = "/uploadTerminalExcel", method = RequestMethod.POST)
    public String uploadTerminalExcel(@RequestParam(value = "excelFile", required = false) MultipartFile excelFile, RedirectAttributes redirectAttributes, HttpServletRequest request, ModelMap model) {
        if (excelFile.isEmpty()) {
            redirectAttributes.addFlashAttribute("danger", "添加数据!");
        }
        try {
            String relpath = this.getClass().getClassLoader().getResource("/").getPath()+"/upload/";
            File file = new File(relpath);
            if (!file.exists() && !file.isDirectory()) {
                file.mkdir();
            }
            String path = relpath + excelFile.getOriginalFilename();
            terminalManagementService.paseExcelFile(excelFile, path);
            redirectAttributes.addFlashAttribute("success", "导入成功");
        }catch (QTException e) {
            LogPay.error(e.getMessage(), e.getRespMsg());
            redirectAttributes.addFlashAttribute("danger", e.getRespMsg());
        }catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
        return "redirect:listPage";
    }

}
