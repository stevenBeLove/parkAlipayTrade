/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2016年10月31日 上午10:53:18 <br/> 
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
import com.qt.sales.model.BusinessType;
import com.qt.sales.model.BusinessTypeExample;
import com.qt.sales.model.FansCustomerJnls;
import com.qt.sales.service.FansAgencyScaleService;
import com.qt.sales.service.FansCustomerJnlsService;
import com.qt.sales.utils.Format;
import com.qt.sales.utils.LogPay;
import com.qt.sales.utils.ResultList;


/**
 * 
 * <pre>
 * 【类型】: FansCustomerJnlsController <br/> 
 * 【作用】: 交易流水. <br/>  
 * 【时间】：2016年11月7日 上午10:41:15 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
@Controller
@RequestMapping("/fansCustomerJnls")
public class FansCustomerJnlsController extends BaseController {

    
    /**
     * 
     */
    @Resource
    private FansCustomerJnlsService fansCustomerJnlsService;

    /**
     * 分销商经营模式
     */
    @Resource
    private FansAgencyScaleService  fansAgencyScaleService;

    /**
     * 
     * 【方法名】 : 跳转至交易流水查询页面. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午10:41:29 .<br/>
     * 【参数】： .<br/>
     * 
     * @param model 
     * @param businessType 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/listPage", method = RequestMethod.GET)
    public String fansCustomerJnlsList(Model model, BusinessType businessType) {
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
        return "fansCustomerJnls/fansCustomerJnls";
    }

    /**
     * 
     * 【方法名】 : 查询交易流水List. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午10:42:00 .<br/>
     * 【参数】： .<br/>
     * 
     * @param pageSize 
     * @param offset 
     * @param fansCustomerJnls 
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
    public void getPayAwardJnls(@RequestParam(value = "limit", required = true) int pageSize, @RequestParam(value = "offset", required = true) int offset, FansCustomerJnls fansCustomerJnls,
            HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
        if (offset == 0) {
            fansCustomerJnls.setStart(0);
            fansCustomerJnls.setEnd(pageSize + offset);
        } else {
            fansCustomerJnls.setStart(offset);
            fansCustomerJnls.setEnd(offset + pageSize);
        }
        int totalRowCount = fansCustomerJnlsService.fansCustomerJnlsCount(fansCustomerJnls);
        List<FansCustomerJnls> list = fansCustomerJnlsService.getFansCustomerJnlsList(fansCustomerJnls);
        if (list!=null) {
            for (FansCustomerJnls temp : list) {
                // 客户
                temp.setCustomerName(Format.mosaic(temp.getCustomerName(), "1"));
                temp.setMobile(Format.mosaic(temp.getMobile(), "2"));
                // 上一级
                temp.setParentcustomername(Format.mosaic(temp.getParentcustomername(), "1"));
                temp.setParentuserid(Format.mosaic(temp.getParentuserid(), "2"));
                // 上二级
                temp.setTwocustomername(Format.mosaic(temp.getTwocustomername(), "1"));
                temp.setTwouserid(Format.mosaic(temp.getTwouserid(), "2"));
                // 上三级
                temp.setTopcustomername(Format.mosaic(temp.getTopcustomername(), "1"));
                temp.setTopuserid(Format.mosaic(temp.getTopuserid(), "2"));
            }
        }
        ResultList res = new ResultList();
        res.setRows(list);
        res.setTotal(totalRowCount);
        outPrint(resultToJson(res), response);
    }

    /**
     * 
     * 【方法名】 : 交易流水导出. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午10:42:27 .<br/>
     * 【参数】： .<br/>
     * 
     * @param pageSize 
     * @param offset 
     * @param fansCustomerJnls 
     * @param response 
     *            .<br/>
     *            <p>
     *            修改记录.<br/>
     *            修改人: fuyu 修改描述： .<br/>
     *            <p/>
     */
    @RequestMapping("/fansCustomerJnlsExportExcel")
    public void payActivityLoginToExcel(@RequestParam(value = "limit", required = true) int pageSize, @RequestParam(value = "offset", required = true) int offset, FansCustomerJnls fansCustomerJnls,
            HttpServletResponse response) {

        if (offset == 0) {
            fansCustomerJnls.setStart(0);
            fansCustomerJnls.setEnd(pageSize + offset);
        } else {
            fansCustomerJnls.setStart(offset);
            fansCustomerJnls.setEnd(offset + pageSize);
        }
        List<List<String>> valueList = new ArrayList<List<String>>();
        List<FansCustomerJnls> fansList = fansCustomerJnlsService.getFansCustomerJnlsList(fansCustomerJnls);
        for (FansCustomerJnls customer : fansList) {
            List<String> entity = new ArrayList<String>();
            entity.add(customer.getFrid());
            entity.add(customer.getServcode());
            entity.add(customer.getLocaldate());
            entity.add(customer.getAgencyName());
            entity.add(customer.getBusinessName());

            entity.add(Format.replaceMoney(customer.getAmount()));
            entity.add(customer.getCustomerName());
            entity.add(customer.getMobile());

            entity.add(customer.getParentcustomername());
            entity.add(customer.getParentuserid());
            entity.add(Format.replaceMoney(customer.getParentRate()));
            entity.add(Format.replaceMoney(customer.getParentProfit()));

            entity.add(customer.getTwocustomername());
            entity.add(customer.getTwouserid());
            entity.add(Format.replaceMoney(customer.getTwoRate()));
            entity.add(Format.replaceMoney(customer.getTwoProfit()));

            entity.add(customer.getTopcustomername());
            entity.add(customer.getTopuserid());
            entity.add(Format.replaceMoney(customer.getTopRate()));
            entity.add(Format.replaceMoney(customer.getTopProfit()));

            valueList.add(entity);

        }
        ExportExcelUtil.exportExcel("payActivityLogin", getTitle(), valueList, response);
    }
    /**
     * 
     * 【方法名】    : (获取表头). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月18日 下午9:30:43 .<br/>
     * 【参数】： .<br/>
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    private List<String> getTitle(){
        List<String>   title = new ArrayList<String>();
        title.add("序号");
        title.add("交易流水号");
        title.add("交易日期");
        title.add("隶属机构");
        title.add("交易类型");
        title.add("交易金额");
        title.add("交易人");
        title.add("交易人手机号");
        title.add("上一级分佣人");
        title.add("上一级手机号");
        title.add("上一级分佣比");
        title.add("上一级分佣金额");
        title.add("上二级分佣人");
        title.add("上二级手机号");
        title.add("上二级分佣比");
        title.add("上二级分佣金额");
        title.add("上三级分佣人");
        title.add("上三级手机号");
        title.add("上三级分佣比");
        title.add("上三级分佣金额");
        return title;
    }

}
