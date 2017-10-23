/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2016年11月2日 上午9:39:24 <br/> 
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
import com.qt.sales.model.InstitutionsFenRunIssueVO;
import com.qt.sales.service.InstitutionsFenRunIssueService;
import com.qt.sales.utils.ResultList;

/**
 * 
 * <pre>
 * 【类型】: InstitutionsFenRunIssueController <br/> 
 * 【作用】: 机构返佣分润. <br/>  
 * 【时间】：2016年11月7日 上午11:39:35 <br/> 
 * 【作者】：fuyu <br/> 
 * </pre>
 */
@Controller
@RequestMapping("/institutionsFenRunIssue")
public class InstitutionsFenRunIssueController extends BaseController {


    /**
     * 
     */
    @Resource
    private InstitutionsFenRunIssueService institutionsFenRunIssueService;

    /**
     * 
     * 【方法名】    : 跳转至机构返佣分润查询页面 <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午11:39:52 .<br/>
     * 【参数】： .<br/>
     * @param model 
     * @return model.<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    @RequestMapping(value = "/listPage", method = RequestMethod.GET)
    public String fansCustomerJnlsList(Model model) {
        return "institutionsFenRunIssue/institutionsFenRunIssueList";
    }

 /**
  * 
  * 【方法名】    : 机构返佣分润列表查询. <br/> 
  * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
  * 【作者】: fuyu .<br/>
  * 【时间】： 2016年11月7日 上午11:40:22 .<br/>
  * 【参数】： .<br/>
  * @param pageSize 
  * @param offset 
  * @param institutionsFenRunIssueVO 
  * @param request 
  * @param response 
  * @param model 
  * @throws Exception  .<br/>
  * <p>
  * 修改记录.<br/>
  * 修改人: fuyu 修改描述： .<br/>
  * <p/>
  */
    @RequestMapping(value = "/list")
    public void getPayAwardJnls(@RequestParam(value = "limit", required = true) int pageSize, @RequestParam(value = "offset", required = true) int offset,
            InstitutionsFenRunIssueVO institutionsFenRunIssueVO, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
        if (offset == 0) {
            institutionsFenRunIssueVO.setStart(0);
            institutionsFenRunIssueVO.setEnd(pageSize + offset);
        } else {
            institutionsFenRunIssueVO.setStart(offset);
            institutionsFenRunIssueVO.setEnd(offset + pageSize);
        }
        int totalRowCount = institutionsFenRunIssueService.InstitutionsFenRunIssueCount(institutionsFenRunIssueVO);
        List<InstitutionsFenRunIssueVO> list = institutionsFenRunIssueService.getInstitutionsFenRunIssueList(institutionsFenRunIssueVO);
        ResultList res = new ResultList();
        res.setRows(list);
        res.setTotal(totalRowCount);
        outPrint(resultToJson(res), response);
    }

  /**
   * 
   * 【方法名】    : 机构返佣分润导出. <br/> 
   * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
   * 【作者】: fuyu .<br/>
   * 【时间】： 2016年11月7日 上午11:40:57 .<br/>
   * 【参数】： .<br/>
   * @param institutionsFenRunIssueVO 
   * @param pageSize 
   * @param offset 
   * @param response  .<br/>
   * <p>
   * 修改记录.<br/>
   * 修改人: fuyu 修改描述： .<br/>
   * <p/>
   */
    @RequestMapping("/institutionsFenRunIssueExportExcel")
    public void payActivityLoginToExcel(InstitutionsFenRunIssueVO institutionsFenRunIssueVO, @RequestParam(value = "limit", required = true) int pageSize,
            @RequestParam(value = "offset", required = true) int offset, HttpServletResponse response) {
        if (offset == 0) {
            institutionsFenRunIssueVO.setStart(0);
            institutionsFenRunIssueVO.setEnd(pageSize + offset);
        } else {
            institutionsFenRunIssueVO.setStart(offset);
            institutionsFenRunIssueVO.setEnd(offset + pageSize);
        }
        List<List<String>> valueList = new ArrayList<List<String>>();
        List<InstitutionsFenRunIssueVO> list = institutionsFenRunIssueService.getInstitutionsFenRunIssueList(institutionsFenRunIssueVO);
        for (InstitutionsFenRunIssueVO vo : list) {
            List<String> entity = new ArrayList<String>();
            entity.add(vo.getLocalDate());
            entity.add(vo.getAgencyName());
            entity.add(vo.getMonthProfit());
            valueList.add(entity);
        }
        ExportExcelUtil.exportExcel("institutionsFenRun", getTitle(), valueList, response);
    }
    
    /**
     * 
     * 【方法名】    : (获取表头). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月18日 下午9:23:56 .<br/>
     * 【参数】： .<br/>
     * @return .<br/>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    private List<String> getTitle(){
        List<String>   title = new ArrayList<String>();
        title.add("分佣月份");
        title.add("隶属机构");
        title.add("当月分润");
        return title;
    }

}
