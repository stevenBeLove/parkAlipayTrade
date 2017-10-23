/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2016年11月1日 上午11:29:14 <br/> 
 */
package com.qt.sales.web;

import java.util.ArrayList;
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

import com.qt.sales.common.excel.ExportExcelUtil;
import com.qt.sales.model.PersonalCommissionVO;
import com.qt.sales.service.PersonalCommissionService;
import com.qt.sales.utils.Format;
import com.qt.sales.utils.ResultList;

/**
 * 
 * <pre>
 * 【类型】: PersonalCommissionController <br/> 
 * 【作用】: 个人返佣. <br/>  
 * 【时间】：2016年11月7日 上午11:05:53 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
@Controller
@RequestMapping("/personalCommission")
public class PersonalCommissionController extends BaseController {


    /**
     * 
     */
    @Resource
    private PersonalCommissionService personalCommissionService;

    /**
     * 
     * 【方法名】 :跳转至个人返佣查询页面. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:06:12 .<br/>
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
    public String fansCustomerJnlsList(Model model) {
        return "personalCommission/personalCommissionList";
    }

    /**
     * 
     * 【方法名】 : 查询个人返佣List. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:06:29 .<br/>
     * 【参数】： .<br/>
     * 
     * @param pageSize 
     * @param offset 
     * @param personalCommissionVO 
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
    public void getPayAwardJnls(@RequestParam(value = "limit", required = true) int pageSize, @RequestParam(value = "offset", required = true) int offset, PersonalCommissionVO personalCommissionVO,
            HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
        if (offset == 0) {
            personalCommissionVO.setStart(0);
            personalCommissionVO.setEnd(pageSize + offset);
        } else {
            personalCommissionVO.setStart(offset);
            personalCommissionVO.setEnd(offset + pageSize);
        }
        int totalRowCount = personalCommissionService.PersonalCommissionCount(personalCommissionVO);
        List<PersonalCommissionVO> list = personalCommissionService.getPersonalCommissionList(personalCommissionVO);
        if (list!=null) {
            for (PersonalCommissionVO temp : list) {
                temp.setCustomerName(Format.mosaic(temp.getCustomerName(), "1"));
                // 分佣人手机号加密
                temp.setMobile(Format.mosaic(temp.getMobile(), "2"));
            }
        }
        ResultList res = new ResultList();
        res.setRows(list);
        res.setTotal(totalRowCount);
        outPrint(resultToJson(res), response);
    }

    /**
     * 
     * 【方法名】 : 个人返佣结果集导出. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:06:48 .<br/>
     * 【参数】： .<br/>
     * 
     * @param pageSize 
     * @param offset 
     * @param personalCommissionVO 
     * @param response 
     *            .<br/>
     *            <p>
     *            修改记录.<br/>
     *            修改人: fuyu 修改描述： .<br/>
     *            <p/>
     */
    @RequestMapping("/personalCommissionExportExcel")
    public void personalCommissionToExcel(@RequestParam(value = "limit", required = true) int pageSize, @RequestParam(value = "offset", required = true) int offset,
            PersonalCommissionVO personalCommissionVO, HttpServletResponse response) {
        if (offset == 0) {
            personalCommissionVO.setStart(0);
            personalCommissionVO.setEnd(pageSize + offset);
        } else {
            personalCommissionVO.setStart(offset);
            personalCommissionVO.setEnd(offset + pageSize);
        }
        List<List<String>> valueList = new ArrayList<List<String>>();
        List<PersonalCommissionVO> list = personalCommissionService.getPersonalCommissionList(personalCommissionVO);
        for (PersonalCommissionVO vo : list) {
            List<String> entity = new ArrayList<String>();
            entity.add(vo.getLocalDate());
            entity.add(vo.getCustomerName());
            entity.add(vo.getMobile());
            entity.add(vo.getAgencyName());
            entity.add(vo.getMonthAmount());
            entity.add(vo.getFdAmount());
            entity.add(vo.getFdRealFee());
            entity.add(vo.getSfAmount());
            entity.add(vo.getSendType());
            entity.add(vo.getFsOrigDate());
            entity.add(vo.getStatus());
            valueList.add(entity);
        }
        ExportExcelUtil.exportExcel("personalCommission", getTitle(), valueList, response);
    }
    /**
     * 
     * 【方法名】    : (获取Title). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月18日 下午9:32:27 .<br/>
     * 【参数】： .<br/>
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    private List<String> getTitle(){
        List<String>   title = new ArrayList<String>();
        title.add("分佣月份");
        title.add("分佣人");
        title.add("分佣人手机号");
        title.add("所属机构");
        title.add("当月佣金");
        title.add("应发佣金");
        title.add("手续费用");
        title.add("实发佣金");
        title.add("发送形式");
        title.add("放送日期");
        title.add("状态");
        return title;
    }
    
    

}
