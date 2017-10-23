/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2016年10月21日 下午1:51:47 <br/> 
 */
package com.qt.sales.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qt.sales.common.CommonEnums.AgencyScaleStatus;
import com.qt.sales.common.CommonEnums.FlowNodeStatus;
import com.qt.sales.common.RSConsts;
import com.qt.sales.exception.QTException;
import com.qt.sales.model.BusinessType;
import com.qt.sales.model.BusinessTypeExample;
import com.qt.sales.model.FansAgency;
import com.qt.sales.model.FansAgencyExample;
import com.qt.sales.model.FansAgencyScale;
import com.qt.sales.model.FansAgencyScaleExample;
import com.qt.sales.model.Qt1tblAgency;
import com.qt.sales.model.Qt1tblAgencyExample;
import com.qt.sales.model.SelectFansAgency;
import com.qt.sales.model.SelectModel;
import com.qt.sales.service.FansAgencyScaleService;
import com.qt.sales.service.FansAgencyService;
import com.qt.sales.service.Qt1tblAgencyService;
import com.qt.sales.utils.DateUtil;
import com.qt.sales.utils.LogPay;
import com.qt.sales.utils.ResultList;

/**
 * 类名: FansAgencyController <br/>
 * 作用：TODO(分销商控制层)<br/>
 * 创建者: zhangyinghui. <br/>
 * 添加时间: 2016年10月21日 下午1:51:47 <br/>
 * 版本： JDK 1.6 sales 1.0
 */
@Controller
@RequestMapping("/agency")
public class FansAgencyController extends BaseController {

    /**
     * 机构service接口
     */
    @Resource
    private FansAgencyService fansAgencyService;

    /**
     *老机构service接口 
     */
    @Resource
    private Qt1tblAgencyService qt1tblAgencyService;
    
    /**
     *分销商经营模式 
     */
    @Resource
    private FansAgencyScaleService fansAgencyScaleService;
    

    /**
     * 跳转到列表页
     * @param model
     *            实体类
     * @return 页面路径
     */
    @RequestMapping(value = "/listPage", method = RequestMethod.GET)
    public String showList(Model model) {
        return "agency/agencyList";
    }
    
    /**
     * 跳转到机构待审核列表页
     * @param model
     *            实体类
     * @return 页面路径
     */
    @RequestMapping(value = "/listPageforApproval", method = RequestMethod.GET)
    public String listPageforApproval(Model model) {
        return "agency/agencyListApproval";
    }

    /**
     * 跳转到编辑页
     * @param model
     *            实体类
     * @return 编辑页
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        model.addAttribute("action", "insert");
        model.addAttribute("op", "新增");
        model.addAttribute("fansAgency", new FansAgency());
        return "agency/agencyEdit";
    }

    /**
     * 保存方法
     * 
     * @param fanceAgency
     *            实体类
     * @param redirectAttributes
     *            重定向对象
     * @return 地址
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(FansAgency fanceAgency, RedirectAttributes redirectAttributes) {
        try {
            //验证三要素
            JSONObject validateJson = fansAgencyService.validateFourElement(fanceAgency.getAccountno(), fanceAgency.getName(), fanceAgency.getIdCardNum());
            if (!(RSConsts.RESP_CODE_00_SUCCESS.equals(validateJson.get("P_MSG_CODE")) && RSConsts.RESP_3ELEMENT_FALG.equals(validateJson.get("VERFLAG")))) {
//                redirectAttributes.addFlashAttribute("danger", "新增失败!三要素认证失败信息为："+validateJson.get("P_MSG_TEXT"));
                redirectAttributes.addFlashAttribute("danger", "新增失败，四要素验证失败！");
                return "redirect:create";
            }
            FansAgency agency = null;
            if (!StringUtils.isEmpty(fanceAgency.getAgencyId())) {
                agency = fansAgencyService.selectByPrimaryKey(fanceAgency.getAgencyId());
            }
            if (!StringUtils.isEmpty(agency)) {
                redirectAttributes.addFlashAttribute("danger", "新增失败!&nbsp;&nbsp;重复添加数据!");
                return "redirect:create";
            } else {
                fanceAgency.setIsspecial("0");
                fanceAgency.setStatus(FlowNodeStatus.waiting_configure.getVal());
                fanceAgency.setDatetime(DateUtil.getCurrDateAndTime());
                fansAgencyService.insert(fanceAgency);
                redirectAttributes.addFlashAttribute("msg", "新增成功！");
            }
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
        return "redirect:listPage";
    }
    
    /**
     * 
     * 【方法名】    : (验证三要素). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月8日 上午10:09:48 .<br/>
     * 【参数】： .<br/>
     * @param fanceAgency FansAgency对象
     * @return AjaxReturnInfo对象
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     * 验证成功：{"P_MSG_CODE":"0000","P_MSG_TEXT":"验证成功","VERFLAG":"0"}
     * 非法卡号：{"P_MSG_CODE":"9108","P_MSG_TEXT":"非法卡号"}
     * 四要素不匹配：{"P_MSG_CODE":"9941","P_MSG_TEXT":"四要素不匹配","VERFLAG":"1"}
     * 
     */
    @RequestMapping(value = "/validateTreeElement", method = RequestMethod.POST)
    @ResponseBody
    public AjaxReturnInfo validateTreeElement(FansAgency fanceAgency) {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        try {
            //验证三要素
            JSONObject validateJson = fansAgencyService.validateFourElement(fanceAgency.getAccountno(), fanceAgency.getName(), fanceAgency.getIdCardNum());
            if (!(RSConsts.RESP_CODE_00_SUCCESS.equals(validateJson.get("P_MSG_CODE")) && RSConsts.RESP_3ELEMENT_FALG.equals(validateJson.get("VERFLAG")))) {
                ajaxinfo.setSuccess("false");
                ajaxinfo.setMessage("四要素认证失败："+validateJson.get("P_MSG_TEXT"));
            } else {
                ajaxinfo.setSuccess("true");
                ajaxinfo.setMessage("四要素认证成功："+validateJson.get("P_MSG_TEXT"));
            }
        } catch (QTException e) {
            LogPay.error(e.getMessage(), e);
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
        return ajaxinfo;
    }
    /**
     * 加载更新页面
     * @param anencyId 机构Id
     * @param model Model
     * @return 更新页面
     */
    @RequestMapping(value = "/update/{anencyId}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("anencyId") String anencyId, Model model) {
        model.addAttribute("action", "updateFansAgency");
        try {
            model.addAttribute("fanceAgency", fansAgencyService.selectByPrimaryKey(anencyId));
            model.addAttribute("qt1Agency", qt1tblAgencyService.selectByPrimaryKey(anencyId));
            model.addAttribute("op", "修改");
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
        return "agency/agencyEdit";
    }
    
    /**
     * 加载机构详情页面
     * @param anencyId 机构Id
     * @param model model
     * @return 更新页面
     */
    @RequestMapping(value = "/showAgencyView/{anencyId}", method = RequestMethod.GET)
    public String showAgencyView(@PathVariable("anencyId") String anencyId, Model model) {
        try {
            model.addAttribute("fanceAgency", fansAgencyService.selectByPrimaryKey(anencyId.trim()));
            model.addAttribute("qt1Agency", qt1tblAgencyService.selectByPrimaryKey(anencyId.trim()));
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
        return "agency/agencyView";
    }

    /**
     * 更新
     * @param fanceAgency 机构对象
     * @param redirectAttributes redirectAttributes
     * @return redirect:listPage
     */
    @RequestMapping(value = "/updateFansAgency", method = RequestMethod.POST)
    public String update(FansAgency fanceAgency, RedirectAttributes redirectAttributes) {
        try {
            //验证三要素
            JSONObject validateJson = fansAgencyService.validateFourElement(fanceAgency.getAccountno(), fanceAgency.getName(), fanceAgency.getIdCardNum());
            if (!(RSConsts.RESP_CODE_00_SUCCESS.equals(validateJson.get("P_MSG_CODE")) && RSConsts.RESP_3ELEMENT_FALG.equals(validateJson.get("VERFLAG")))) {
                redirectAttributes.addFlashAttribute("danger", "修改失败，四要素验证失败！");
                return "redirect:listPage";
            }
            fanceAgency.setStatus(FlowNodeStatus.waiting_process.getVal());
            fanceAgency.setDatetime(DateUtil.getCurrDateAndTime());
            fansAgencyService.updateByPrimaryKey(fanceAgency);
            redirectAttributes.addFlashAttribute("msg", "修改成功");
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
        return "redirect:listPage";
    }
    
    /**
     * 
     * 【方法名】    : ( 删除机构). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月8日 下午2:37:17 .<br/>
     * 【参数】： .<br/>
     * @param anencyId 机构Id
     * @return AjaxReturnInfo对象.<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    @RequestMapping(value = "/delete/{anencyId}", method = RequestMethod.GET)
    @ResponseBody
    public AjaxReturnInfo delete(@PathVariable("anencyId") String anencyId) {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        try {
            FansAgency fansAgency = fansAgencyService.selectByPrimaryKey(anencyId.trim());
            if (!StringUtils.isEmpty(fansAgency)) {
                if (FlowNodeStatus.approved.getVal().equals(fansAgency.getStatus())) {
                    ajaxinfo.setSuccess("false");
                    ajaxinfo.setMessage("删除失败！审核通过的机构不允许删除！");
                } else {
                    fansAgencyService.deleteByPrimaryKey(anencyId);
                    ajaxinfo.setSuccess("true");
                    ajaxinfo.setMessage("删除成功！");
                }
            }
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
        return ajaxinfo;
    }

    /**
     * 查询老机构数据
     * 
     * @param param
     * @param request
     *            request
     * @param response
     *            response
     * @param param
     *            参数
     * @throws Exception
     *             异常类
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public void select(String param, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (StringUtils.isEmpty(request.getParameter("param"))){
            return;
        }
        //非空判断
        LogPay.info("request.getParameter(param)======"+request.getParameter("param"));
        String textValue = new String(request.getParameter("param").getBytes("ISO-8859-1"), "UTF-8");
        LogPay.info("textValue======"+textValue);
        String value = java.net.URLDecoder.decode(textValue,   "utf-8");  
        LogPay.info("URLDecoder.decode(textValue)======"+value);
        Qt1tblAgencyExample example = new Qt1tblAgencyExample();
        int offset = 0;
        int pageSize = 15;
        if (offset == 0) {
            example.setStart(0);
            example.setEnd(pageSize + offset);
        } else {
            example.setStart(offset);
            example.setEnd(offset + pageSize);
        }
        com.qt.sales.model.Qt1tblAgencyExample.Criteria cr = example.createCriteria();
        com.qt.sales.model.Qt1tblAgencyExample.Criteria cr2 = example.createCriteria();
        if (!StringUtils.isEmpty(value)) {
            cr.andAgencyIdLike("%" + value + "%");
            cr2.andCompanynameLike("%" + value + "%");
            example.or(cr2);
        }
        List<Qt1tblAgency> list = qt1tblAgencyService.selectByExample(example);
        SelectModel modelList = new SelectModel("", list);
        outPrint(objectPaseJson(modelList), response);
    }

    /**
     * 查询上级机构
     * 
     * @param param
     *            参数
     * @param request
     *            request
     * @param response
     *            response
     * @throws Exception
     *             异常
     */
    @RequestMapping(value = "/selectParentId", method = RequestMethod.GET)
    public void selectParentId(String param, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (StringUtils.isEmpty(request.getParameter("param"))){
            return;
        }
        String textValue = new String(request.getParameter("param").getBytes("ISO-8859-1"), "UTF-8");
        String value = java.net.URLDecoder.decode(textValue,   "utf-8"); 
        FansAgencyExample example = new FansAgencyExample();
        int offset = 0;
        int pageSize = 15;
        if (offset == 0) {
            example.setStart(0);
            example.setEnd(pageSize + offset);
        } else {
            example.setStart(offset);
            example.setEnd(offset + pageSize);
        }
        com.qt.sales.model.FansAgencyExample.Criteria cr = example.createCriteria();
        com.qt.sales.model.FansAgencyExample.Criteria cr2 = example.createCriteria();
        if (!StringUtils.isEmpty(value)) {
            cr.andAgencyIdLike("%" + value + "%");
            cr.andStatusEqualTo(FlowNodeStatus.approved.getVal());
            cr2.andAgencyNameLike("%" + value + "%");
            cr2.andStatusEqualTo(FlowNodeStatus.approved.getVal());
            example.or(cr2);
        }
        List<FansAgency> list = fansAgencyService.selectByExample(example);
        SelectFansAgency modelList = new SelectFansAgency("", list);
        outPrint(objectPaseJson(modelList), response);
    }
    

    /**
     * 搜索查询机构信息
     * 
     * @param param
     *            参数
     * @param request
     *            request
     * @param response
     *            response
     * @throws Exception
     *             异常
     */
    @RequestMapping(value = "/selectListSelectAgency", method = RequestMethod.GET)
    public void selectListSelectAgency(String param, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (StringUtils.isEmpty(request.getParameter("param"))){
            return;
        }
        String textValue = new String(request.getParameter("param").getBytes("ISO-8859-1"), "UTF-8");
        String value = java.net.URLDecoder.decode(textValue,   "utf-8"); 
        FansAgencyExample example = new FansAgencyExample();
        int offset = 0;
        int pageSize = 15;
        if (offset == 0) {
            example.setStart(0);
            example.setEnd(pageSize + offset);
        } else {
            example.setStart(offset);
            example.setEnd(offset + pageSize);
        }
        com.qt.sales.model.FansAgencyExample.Criteria cr = example.createCriteria();
        com.qt.sales.model.FansAgencyExample.Criteria cr2 = example.createCriteria();
        if (!StringUtils.isEmpty(value)) {
            cr.andAgencyIdLike("%" + value + "%");
            cr2.andAgencyNameLike("%" + value + "%");
            example.or(cr2);
        }
        List<FansAgency> list = fansAgencyService.selectByExample(example);
        SelectFansAgency modelList = new SelectFansAgency("", list);
        outPrint(objectPaseJson(modelList), response);
    }

    /**
     * 查询机构列表
     * 
     * @param pageSize
     *            页数
     * @param offset
     *            每页多少条
     * @param fansAgency
     *            代理商
     * @param response
     *            response
     * @throws Exception
     *             异常
     */
    @RequestMapping(value = "/list")
    public void list(@RequestParam(value = "limit", required = true) int pageSize, @RequestParam(value = "offset", required = true) int offset, FansAgency fansAgency, HttpServletResponse response)
        throws Exception {
        FansAgencyExample example = new FansAgencyExample();
        if (offset == 0) {
            example.setStart(0);
            example.setEnd(pageSize + offset);
        } else {
            example.setStart(offset);
            example.setEnd(offset + pageSize);
        }
        com.qt.sales.model.FansAgencyExample.Criteria cr = example.createCriteria();
        if (!StringUtils.isEmpty(fansAgency.getAgencyId())) {
            cr.andAgencyIdEqualTo(fansAgency.getAgencyId().trim());
        }

        if (!StringUtils.isEmpty(fansAgency.getAgencyName())) {
            cr.andAgencyNameLike("%"+fansAgency.getAgencyName()+"%");
        }
        if (!StringUtils.isEmpty(fansAgency.getStatus())) {
            cr.andStatusEqualTo(fansAgency.getStatus());
        }
        example.setOrderByClause(" datetime desc");
        int totalRowCount = fansAgencyService.countByExample(example);
        List<FansAgency> list = fansAgencyService.selectByExample(example);
        ResultList res = new ResultList();
        res.setRows(list);
        res.setTotal(totalRowCount);
        outPrint(resultToJson(res), response);
    }
    

    /**
     * 
     * 【方法名】    : (跳转到返佣查询页面). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月27日 下午5:21:37 .<br/>
     * 【参数】： .<br/>
     * @param anencyId Id
     * @param model 实体类
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    @RequestMapping(value = "/createScale/{anencyId}", method = RequestMethod.GET)
    public String showCreateScaleForm(@PathVariable("anencyId") String anencyId, Model model) {
        try {
            SimpleDateFormat sFmt = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, 1); // 增加一天
            model.addAttribute("enddate", sFmt.format(c.getTime()));
            model.addAttribute("fanceAgency", fansAgencyService.selectByPrimaryKey(anencyId));

            // 三级分销业务类型
            BusinessTypeExample be = new BusinessTypeExample();
            com.qt.sales.model.BusinessTypeExample.Criteria cr = be.createCriteria();
            cr.andBusinessScenarioLike("%三级分销%");
            List<BusinessType> busList = fansAgencyScaleService.selectBusinessTypeByExample(be);
            model.addAttribute("busList", busList);

            //分佣信息
            FansAgencyScaleExample example = new FansAgencyScaleExample();
            com.qt.sales.model.FansAgencyScaleExample.Criteria cr2 = example.createCriteria();
            cr2.andAgencyIdEqualTo(anencyId);
            example.setOrderByClause(" ");
            List<FansAgencyScale> scaleList = fansAgencyScaleService.selectByExample(example);
            model.addAttribute("scaleList", scaleList);
            
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
        return "agency/scaleList";
    }
    
    /**
     * 
     * 【方法名】    : (查询分佣详情). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月31日 下午4:21:53 .<br/>
     * 【参数】： .<br/>
     * @param anencyId String
     * @param model Model
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    @RequestMapping(value = "/showScaleView/{anencyId}", method = RequestMethod.GET)
    public String showScaleView(@PathVariable("anencyId") String anencyId, Model model) {
        try {
            model.addAttribute("fanceAgency", fansAgencyService.selectByPrimaryKey(anencyId));
            //分佣信息
            FansAgencyScaleExample example = new FansAgencyScaleExample();
            com.qt.sales.model.FansAgencyScaleExample.Criteria cr2 = example.createCriteria();
            cr2.andAgencyIdEqualTo(anencyId);
            List<FansAgencyScale> scaleList = fansAgencyScaleService.selectByExample(example);
            model.addAttribute("scaleList", scaleList);
            
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
        return "agency/scaleView";
    }

    /**
     * 
     * 【方法名】 : (保存分佣信息). <br/>
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月28日 下午3:44:45 .<br/>
     * 【参数】： .<br/>
     * 
     * @param jsonValue
     *            json字符串
     * @param agencyId  机构id            
     * @param redirectAttributes
     *            传递的属性
     * @return 返回路径
     * @throws Exception .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: yinghui zhang 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/saveAgencyScale", method = RequestMethod.POST)
    public String saveAgencyScale(String jsonValue, String agencyId, RedirectAttributes redirectAttributes) throws Exception {
        int countUpdate = 0;
        FansAgency fansAgency = fansAgencyService.selectByPrimaryKey(agencyId.trim());
        try {
            String jsonStr = "[" + jsonValue.substring(0, jsonValue.length() - 1) + "]";
            JSONArray json = JSONArray.parseArray(jsonStr);
            List<FansAgencyScale> scaleList = new ArrayList<FansAgencyScale>();
            Iterator it = json.listIterator();
            while (it.hasNext()) {
                JSONObject obj = (JSONObject) it.next();
                FansAgencyScale scaleObj = toFansAgencyScaleObj(obj);
                if (scaleObj.isPageAdd()) {
                    scaleList.add(scaleObj);
                }
            }
            // 验证是否重复添加
            if (validateRepeatBusinessType(scaleList)) {
                throw new QTException("失败!同一类型的参数一次只能添加一种!");
            } else {
                for (FansAgencyScale fansAgencyScale : scaleList) {
                    int count = isRepeatFansAgencyScale(fansAgencyScale);
                    if (count == 1) {
                        throw new QTException("添加失败!不能重复添加同种交易类型待生效的记录！");
                    }
                    //比较上级的起始分佣比
                    fansAgencyScaleService.compareMycost(fansAgencyScale);
                }
                for (FansAgencyScale fansAgencyScale : scaleList) {
                    fansAgencyScaleService.insert(fansAgencyScale);
                    countUpdate++;
                }
                if (countUpdate > 0) {
                  //更新状态为待审核
                    fansAgency.setStatus(FlowNodeStatus.waiting_process.getVal());
                    fansAgencyService.updateByPrimaryKey(fansAgency);
                    redirectAttributes.addFlashAttribute("msg", "添加成功!");
                } else {
                    throw new QTException("添加失败!无符合入库条件的记录！");
                }
            }
            // 更新创建机构创建时间
            fansAgency.setDatetime(DateUtil.getCurrDateAndTime());
            fansAgencyService.updateByPrimaryKeySelective(fansAgency);
        } catch (QTException e) {
            LogPay.error(e.getRespMsg(), e);
            redirectAttributes.addFlashAttribute("danger", "失败" + e.getRespMsg());
            return "redirect:/agency/createScale/"+agencyId;
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
            return "redirect:/agency/createScale/"+agencyId;
        }
        return "redirect:listPage";
    }

    /**
     * 
     * 【方法名】    : (验证一次只能添加一种类型). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月4日 下午4:30:04 .<br/>
     * 【参数】： .<br/>
     * @param scaleList List<FansAgencyScale>集合
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    private boolean validateRepeatBusinessType(List<FansAgencyScale> scaleList) {
        List<String> repList = new ArrayList<String>();
        for (FansAgencyScale fansAgencyScale : scaleList) {
            if (repList.contains(fansAgencyScale.getBusinessType())) {
                return true;
            } else {
                repList.add(fansAgencyScale.getBusinessType());
            }
        }
        return false;
    }
    
    
    /**
     * 
     * 【方法名】    : (判断待生效的参数配置). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月28日 下午3:25:11 .<br/>
     * 【参数】： .<br/>
     * @param scaleObj FansAgencyScale 对象
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     * @throws Exception 
     */
    private int isRepeatFansAgencyScale(FansAgencyScale scaleObj) throws Exception {
        FansAgencyScaleExample example = new FansAgencyScaleExample();
        com.qt.sales.model.FansAgencyScaleExample.Criteria cr = example.createCriteria();
        cr.andAgencyIdEqualTo(scaleObj.getAgencyId());
        cr.andBusinessTypeEqualTo(scaleObj.getBusinessType());
        SimpleDateFormat sFmt = new SimpleDateFormat("yyyyMMdd");
        Date nowDate = new Date();
        cr.andBegindateGreaterThan(sFmt.format(nowDate));
        return fansAgencyScaleService.countByExample(example);
    }
    
    /**
     * 
     * 【方法名】    : (JSONObject 对象转 FansAgencyScale). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月28日 下午3:50:50 .<br/>
     * 【参数】： .<br/>
     * @param obj 
     * @return .<br/>
     * @throws Exception 异常
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    private FansAgencyScale toFansAgencyScaleObj(JSONObject obj)throws Exception{
        FansAgencyScale agencyScale = new FansAgencyScale();
        agencyScale.setAgencyId((String) obj.get("agencyId"));
        agencyScale.setBusinessName((String) obj.get("businessType"));
        agencyScale.setBusinessType(getBusinessType((String) obj.get("businessType")));
        agencyScale.setMycost(Long.parseLong((String) obj.get("mycost")));
        agencyScale.setFinalRate(Long.parseLong((String) obj.get("finalRate")));
        agencyScale.setSecondRate(Long.parseLong((String) obj.get("secondRate")));
        agencyScale.setNextRate(Long.parseLong((String) obj.get("nextRate")));
        agencyScale.setBegindate((String) obj.get("begindate"));
        agencyScale.setUserid((String) obj.get("userid"));
        agencyScale.setDatetime(DateUtil.getCurrDateAndTime());
        agencyScale.setPageAdd("是".equals(obj.get("pageAdd"))?true:false);
        return agencyScale;
    }
    
    /**
     * 
     * 【方法名】    : (根据产品类型TxT查找类型Id). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月28日 上午10:56:48 .<br/>
     * 【参数】： .<br/>
     * @param typeName 类型名称
     * @throws Exception 异常
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    private String getBusinessType(String typeName)throws Exception {
        String type = "";
        BusinessTypeExample be = new BusinessTypeExample();
        com.qt.sales.model.BusinessTypeExample.Criteria cr = be.createCriteria();
        cr.andBusinessScenarioLike("%三级分销%");
        List<BusinessType> busList = fansAgencyScaleService.selectBusinessTypeByExample(be);
        for (BusinessType businessType : busList) {
            if (businessType.getBusinessName().equals(typeName)) {
                type = businessType.getBusinessType();
                break;
            }
        }
        return type;
    }

    /**
     * 
     * 【方法名】 : (删除分佣信息). <br/>
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月28日 下午7:22:48 .<br/>
     * 【参数】： .<br/>
     * 
     * @param scaleId
     *            主键Id
     * @return AjaxReturnInfo 对象
     *         <p>
     *         修改记录.<br/>
     *         修改人: yinghui zhang 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/deleteAgencyScale/{scaleId}", method = RequestMethod.GET)
    @ResponseBody
    public AjaxReturnInfo deleteAgencyScale(@PathVariable("scaleId") String scaleId) {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        try {
            FansAgencyScale scale = fansAgencyScaleService.selectByPrimaryKey(scaleId);
            if (scale == null) {
                ajaxinfo = new AjaxReturnInfo();
                ajaxinfo.setSuccess("true");
                ajaxinfo.setMessage("删除成功！");
            } else {
                ajaxinfo = fansAgencyScaleService.deleteFansAgencyScale(scaleId);
            }

        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
        return ajaxinfo;
    }
    
    
    
    /**
     * 
     * 【方法名】    : (加载更新页面). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月29日 上午11:27:17 .<br/>
     * 【参数】： .<br/>
     * @param id 主键Id
     * @param model 属性
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    @RequestMapping(value = "/{id}/showUpdateScaleForm", method = RequestMethod.GET)
    public String showUpdateScaleForm(@PathVariable("id") String id, Model model) {
        try {
            model.addAttribute("fansAgencyScale", fansAgencyScaleService.selectByPrimaryKey(id));
            SimpleDateFormat sFmt = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, 1); // 增加一天
            model.addAttribute("enddate", sFmt.format(c.getTime()));
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
        return "agency/scaleEdit";
    } 
    
    /**
     * 
     * 【方法名】 : (更新分润信息). <br/>
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月29日 下午4:05:42 .<br/>
     * 【参数】： .<br/>
     * 
     * @param fansAgencyScale
     *            FansAgencyScale
     * @return AjaxReturnInfo对象
     * @throws Exception .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: yinghui zhang 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/updateScaleForm", method = RequestMethod.POST)
    @ResponseBody
    public AjaxReturnInfo updateScaleForm(FansAgencyScale fansAgencyScale) throws Exception {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        try {
            SimpleDateFormat sFmt = new SimpleDateFormat("yyyyMMdd");
            FansAgencyScale scale = fansAgencyScaleService.selectByPrimaryKey(fansAgencyScale.getId());
            Date begindate = sFmt.parse(scale.getBegindate());
            Date nowdate = new Date();
            // 已经过期，不允许修改
            if (begindate.before(nowdate)) {
                ajaxinfo.setSuccess("false");
                ajaxinfo.setMessage("生效日期已过，配置不允许修改!");
            } else {
                FansAgencyScale oldScale = fansAgencyScaleService.selectMaxBegindateScale(fansAgencyScale);
                if (!StringUtils.isEmpty(oldScale)) {
                    GregorianCalendar c = new GregorianCalendar();
                    c.setTime(begindate);
                    c.add(5, -1); // 结束日期减少一天
                    String endTime = sFmt.format(c.getTime());
                    oldScale.setEnddate(endTime);
                    fansAgencyScaleService.updateByPrimaryKey(oldScale);
                }
                // 更新
                fansAgencyScale.setAuditStatus(AgencyScaleStatus.notApproved.getVal());
                fansAgencyScaleService.updateByPrimaryKeySelective(fansAgencyScale);
                //更新状态为待审核
                FansAgency agency = fansAgencyService.selectByPrimaryKey(scale.getAgencyId());
                agency.setStatus(FlowNodeStatus.waiting_process.getVal());
                fansAgencyService.updateByPrimaryKey(agency);
                
                ajaxinfo.setSuccess("true");
                ajaxinfo.setMessage("修改成功!");

            }
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
        return ajaxinfo;
    }
    
    
    /**
     * 
     * 【方法名】 : (机构审核). <br/>
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月31日 下午6:22:42 .<br/>
     * 【参数】： .<br/>
     * 
     * @param agencyId
     *            String
     * @return AjaxReturnInfo
     * @throws Exception .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: yinghui zhang 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/approvalAgencyScale/{agencyId}", method = RequestMethod.GET)
    @ResponseBody
    public AjaxReturnInfo approvalAgencyScale(@PathVariable("agencyId") String agencyId) throws Exception {
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        try {
            ajaxinfo = fansAgencyService.updateAgencyApprove(agencyId);
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
            ajaxinfo.setSuccess("false");
            ajaxinfo.setMessage("审核失败!");
        }
        return ajaxinfo;

    }
    
    /**
     * 
     * 【方法名】    : (跳转到审核拒绝页面). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月1日 上午10:30:09 .<br/>
     * 【参数】： .<br/>
     * @param agencyId String
     * @param model Model
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    @RequestMapping(value = "/deniedApproval/{agencyId}", method = RequestMethod.GET)
    public String deniedApproval(@PathVariable("agencyId") String agencyId, Model model) {
        try {
            model.addAttribute("fanceAgency", fansAgencyService.selectByPrimaryKey(agencyId.trim()));
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
        return "agency/deniedApproval";
    } 
    /**
     * 
     * 【方法名】    : (审核驳回). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月1日 上午11:36:03 .<br/>
     * 【参数】： .<br/>
     * @param agency FansAgency
     * @return AjaxReturnInfo.<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    @RequestMapping(value = "/deniedAgencyScale", method = RequestMethod.POST)
    @ResponseBody
    public AjaxReturnInfo deniedAgencyScale(FansAgency agency){
        AjaxReturnInfo ajaxinfo = new AjaxReturnInfo();
        try {
            ajaxinfo = fansAgencyService.updateAgencyDeniedWithAgency(agency);
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
        return ajaxinfo;
        
    }
    
    

}
