/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2016年11月15日 下午1:48:16 <br/> 
 */
package com.qt.sales.web;

import java.io.BufferedOutputStream;
import java.io.IOException;
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
import com.qt.sales.model.BusinessType;
import com.qt.sales.model.BusinessTypeExample;
import com.qt.sales.model.InstitutionsFenRunIssueVO;
import com.qt.sales.service.FansAgencyScaleService;
import com.qt.sales.service.InstitutionsFenRunRecordService;
import com.qt.sales.utils.Format;
import com.qt.sales.utils.LogPay;
import com.qt.sales.utils.ResultList;

/**
 * 
 * <pre>
 * 【类型】: InstitutionsFenRunRecordController <br/> 
 * 【作用】:机构分润记录 <br/>  
 * 【时间】：2016年11月15日 下午1:48:21 <br/> 
 * 【作者】：fuyu <br/> 
 * </pre>
 */
@Controller
@RequestMapping("/institutionsFenRunRecord")
public class InstitutionsFenRunRecordController extends BaseController{
    
    
    /**
     * 
     */
    @Resource
    private InstitutionsFenRunRecordService institutionsFenRunRecordService;
    
    /**
     * 分销商经营模式
     */
    @Resource
    private FansAgencyScaleService  fansAgencyScaleService;
    
    /**
     * 
     * 【方法名】    : 跳转至机构分润记录查询. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月15日 下午3:30:22 .<br/>
     * 【参数】： .<br/>
     * @param model 
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    @RequestMapping(value = "/listPage", method = RequestMethod.GET)
    public String institutionsFenRunRecordList(Model model) {
        try {
            // 三级分销业务类型
            BusinessTypeExample be = new BusinessTypeExample();
            com.qt.sales.model.BusinessTypeExample.Criteria cr = be.createCriteria();
            cr.andBusinessScenarioLike("%三级分销%");
            List<BusinessType> busList = fansAgencyScaleService.selectBusinessTypeByExample(be);
            model.addAttribute("busList", busList);
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
        return "institutionsFenRunRecord/institutionsFenRunRecordList";
    }
    
    /**
     * 
     * 【方法名】    : 机构分润记录查询 <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月15日 下午7:10:35 .<br/>
     * 【参数】： .<br/>
     * @param pageSize 
     * @param offset 
     * @param institutionsFenRunIssueVO 
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
    public void getPayAwardJnls(@RequestParam(value = "limit", required = true) int pageSize, @RequestParam(value = "offset", required = true) int offset,
            InstitutionsFenRunIssueVO institutionsFenRunIssueVO, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
        if (offset == 0) {
            institutionsFenRunIssueVO.setStart(0);
            institutionsFenRunIssueVO.setEnd(pageSize + offset);
        } else {
            institutionsFenRunIssueVO.setStart(offset);
            institutionsFenRunIssueVO.setEnd(offset + pageSize);
        }
        int totalRowCount = institutionsFenRunRecordService.InstitutionsFenRunRecordCount(institutionsFenRunIssueVO);
        List<InstitutionsFenRunIssueVO> list = institutionsFenRunRecordService.getInstitutionsFenRunRecordList(institutionsFenRunIssueVO);
        if (list!=null) {
            for (InstitutionsFenRunIssueVO temp : list) {
                // 客户
                temp.setCustomername(Format.mosaic(temp.getCustomername(), "1"));
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
     * 【方法名】    : (这里用一句话描述这个方法的作用). <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月16日 上午9:49:55 .<br/>
     * 【参数】： .<br/>
     * @param pageSize 
     * @param offset 
     * @param institutionsFenRunIssueVO 
     * @param response .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: fuyu 修改描述： .<br/>
     * <p/>
     */
    @RequestMapping("/institutionsFenRunIssueExportExcel")
    public void payActivityLoginToExcel(@RequestParam(value = "limit", required = true) int pageSize, @RequestParam(value = "offset", required = true) int offset, InstitutionsFenRunIssueVO institutionsFenRunIssueVO,
            HttpServletResponse response) {

        if (offset == 0) {
            institutionsFenRunIssueVO.setStart(0);
            institutionsFenRunIssueVO.setEnd(pageSize + offset);
        } else {
            institutionsFenRunIssueVO.setStart(offset);
            institutionsFenRunIssueVO.setEnd(offset + pageSize);
        }

        List<List<String>> valueList = new ArrayList<List<String>>();
        List<InstitutionsFenRunIssueVO>  voList = institutionsFenRunRecordService.getInstitutionsFenRunRecordList(institutionsFenRunIssueVO);
        for (InstitutionsFenRunIssueVO instiVo : voList) {
            List<String> entity = new ArrayList<String>();
            entity.add(instiVo.getLocalLogno());
            entity.add(instiVo.getLocalDate());
            entity.add(instiVo.getAgencyId());
            entity.add(instiVo.getAgencyName());
            entity.add(instiVo.getBusinessName());
            entity.add(instiVo.getAmount());
            entity.add(instiVo.getCustomername());
            entity.add(instiVo.getMobile());
            entity.add(instiVo.getAgencyName());
            entity.add(instiVo.getSuperAgencyId());
            entity.add(instiVo.getRate());
            entity.add(instiVo.getMonthProfit());
            
            valueList.add(entity);
        }
        ExportExcelUtil.exportExcel("institutionsFenRun", getTitle(), valueList, response);
    }
    /**
     * 
     * 【方法名】    : (获取Title). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月18日 下午9:11:07 .<br/>
     * 【参数】： .<br/>
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    private List<String> getTitle(){
        List<String>   title = new ArrayList<String>();
        title.add("交易流水号");
        title.add("交易日期");
        title.add("隶属机构");
        title.add("隶属机构编号");
        title.add("交易类型");
        title.add("交易金额（元）");
        title.add("交易人");
        title.add("交易人手机号");
        title.add("可分润机构");
        title.add("可分润机构编号");
        title.add("分润比");
        title.add("分润金额");
        return title;
    }
    
}

