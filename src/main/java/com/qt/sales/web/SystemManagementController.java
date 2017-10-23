/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2016年11月4日 上午11:04:07 <br/> 
 */
package com.qt.sales.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qt.sales.model.SystemParameter;
import com.qt.sales.service.SystemManagementService;
import com.qt.sales.utils.DateUtil;
import com.qt.sales.utils.LogPay;
import com.qt.sales.utils.ResultList;
import com.qt.shiro.entity.User;
import com.qt.shiro.web.bind.annotation.CurrentUser;

/**
 * 
 * <pre>
 * 【类型】: SystemManagementController <br/> 
 * 【作用】: 系统参数 <br/>  
 * 【时间】：2016年11月7日 上午11:59:09 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
@Controller
@RequestMapping("/systemManagement")
public class SystemManagementController extends BaseController {


    /**
     * 
     */
    @Resource
    private SystemManagementService systemManagementService;

    /**
     * 
     * 【方法名】 : 跳转系统参数查询页面 <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:59:23 .<br/>
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
    public String systemManagementList(Model model) {
        return "systemParameter/systemParameterList";
    }

    /**
     * 
     * 【方法名】 : 跳转系统参数新增页面. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:59:43 .<br/>
     * 【参数】： .<br/>
     * 
     * @param model 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/systemParameterAdd", method = RequestMethod.GET)
    public String systemManagementAdd(Model model) {
        return "systemParameter/systemParameterAdd";
    }

    /**
     * 
     * 【方法名】 : 跳转系统参数修改页面. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午12:00:06 .<br/>
     * 【参数】： .<br/>
     * 
     * @param id 
     * @param systemParameter 
     * @param model 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/systemParameterUpdate/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") String id, SystemParameter systemParameter, Model model) {
        model.addAttribute("systemParameter", systemManagementService.SystemParameterOne(systemParameter));
        return "systemParameter/systemParameterEdit";
    }

    /**
     * 
     * 【方法名】 :系统参数查询List. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午12:00:24 .<br/>
     * 【参数】： .<br/>
     * 
     * @param pageSize 
     * @param offset 
     * @param systemParameter 
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
    public void getPayAwardJnls(@RequestParam(value = "limit", required = true) int pageSize, @RequestParam(value = "offset", required = true) int offset, SystemParameter systemParameter,
            HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
        if (offset == 0) {
            systemParameter.setStart(0);
            systemParameter.setEnd(pageSize + offset);
        } else {
            systemParameter.setStart(offset);
            systemParameter.setEnd(offset + pageSize);
        }
        int totalRowCount = systemManagementService.SystemManagementCount(systemParameter);
        List<SystemParameter> list = systemManagementService.getSystemManagementList(systemParameter);
        ResultList res = new ResultList();
        res.setRows(list);
        res.setTotal(totalRowCount);
        outPrint(resultToJson(res), response);
    }

    /**
     * 
     * 【方法名】 : 新增系统参数 <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午12:00:41 .<br/>
     * 【参数】： .<br/>
     * 
     * @param systemParameter 
     * @param loginUser 
     * @param redirectAttributes 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(SystemParameter systemParameter, @CurrentUser User loginUser, RedirectAttributes redirectAttributes) {
        try {
            SystemParameter systemParameterList = systemManagementService.SystemParameterOne(systemParameter);

            if (!StringUtils.isEmpty(systemParameterList)) {
                redirectAttributes.addFlashAttribute("danger", "新增失败!&nbsp;&nbsp;重复添加数据!");
            } else {
                // 设置创建时间
                systemParameter.setCreateDate(DateUtil.getCurrDateAndTime());
                systemParameter.setStatus("1");
                systemManagementService.insertSystemParameter(systemParameter);
                redirectAttributes.addFlashAttribute("success", "新增成功");
            }

        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
            redirectAttributes.addFlashAttribute("danger", "新增失败!" + e.getMessage());
        }
        return "redirect:listPage";
    }

    /**
     * 
     * 【方法名】 : 修改系统参数. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月4日 下午6:06:15 .<br/>
     * 【参数】： .<br/>
     * 
     * @param systemParameter 
     * @param loginUser 
     * @param redirectAttributes 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/updateSystemParameter", method = RequestMethod.POST)
    public String systemParameterUpdate(SystemParameter systemParameter, @CurrentUser User loginUser, RedirectAttributes redirectAttributes) {
        try {
            // 设置创建时间
            systemParameter.setCreateDate(DateUtil.getCurrDateAndTime());
            systemManagementService.updateSystemParameter(systemParameter);
            redirectAttributes.addFlashAttribute("success", "修改成功");
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
            redirectAttributes.addFlashAttribute("danger", "修改失败!" + e.getMessage());
        }
        return "redirect:listPage";
    }

    /**
     * 
     * 【方法名】 : 删除系统参数. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月4日 下午6:06:18 .<br/>
     * 【参数】： .<br/>
     * 
     * @param id 
     * @param systemParameter 
     * @param response 
     *            .<br/>
     *            <p>
     *            修改记录.<br/>
     *            修改人: fuyu 修改描述： .<br/>
     *            <p/>
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable("id") String id, SystemParameter systemParameter, HttpServletResponse response) {
        try {
            // 设置创建时间
            systemParameter.setCreateDate(DateUtil.getCurrDateAndTime());
            systemManagementService.deleteSystemParameter(systemParameter);
            outPrint("{'success':'true'}", response);
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
    }

}
