/** 
 * 包名: package com.qt.shiro.web.controller; <br/> 
 * 添加时间: 2016年10月27日 上午11:39:52 <br/> 
 */
package com.qt.sales.web;

import java.util.Calendar;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qt.sales.model.Announcement;
import com.qt.sales.model.AnnouncementExample;
import com.qt.sales.model.Appuser;
import com.qt.sales.service.AnnouncementService;
import com.qt.sales.utils.DateUtil;
import com.qt.sales.utils.LogPay;
import com.qt.sales.utils.ResultList;
import com.qt.shiro.entity.User;
import com.qt.shiro.web.bind.annotation.CurrentUser;

/**
 * 
 * <pre>
 * 【类型】: AnnouncementController <br/> 
 * 【作用】: 系统公告. <br/>  
 * 【时间】：2016年11月7日 上午10:02:55 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
@Controller
@RequestMapping("/announcement")
public class AnnouncementController extends BaseController {
    /**
     * 
     */
    @Resource
    private AnnouncementService announcementService;


    /**
     * 
     * 【方法名】 : 跳转系统公告查询页面 <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午10:03:21 .<br/>
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
    public String announcementList(Model model) {
        return "announcement/announcementList";
    }

    /**
     * 
     * 【方法名】 : 跳转系统公告新增页面. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午10:03:48 .<br/>
     * 【参数】： .<br/>
     * 
     * @param model 
     * @param appuser 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/announcementAdd", method = RequestMethod.GET)
    public String showAddForm(Model model, Appuser appuser) {
        return "announcement/announcementAdd";
    }

    /**
     * 
     * 【方法名】 : 跳转系统公告修改页面. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午10:04:17 .<br/>
     * 【参数】： .<br/>
     * 
     * @param id 
     * @param model 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/announcementUpdate/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
        try {
            model.addAttribute("announcement", announcementService.selectByPrimaryKey(id));
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
            model.addAttribute("danger", "失败!" + e.getMessage());
        }
        return "announcement/announcementEdit";
    }

    /**
     * 
     * 【方法名】 : 跳转至公告审核页面. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月8日 上午11:06:51 .<br/>
     * 【参数】： .<br/>
     * 
     * @param id 
     * @param model 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/announcementAudit/{id}", method = RequestMethod.GET)
    public String showAuditForm(@PathVariable("id") String id, Model model) {
        try {
            model.addAttribute("announcement", announcementService.selectByPrimaryKey(id));
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
            model.addAttribute("danger", "失败!" + e.getMessage());
        }
        return "announcement/announcementAudit";
    }

    /**
     * 
     * 【方法名】 : 系统公告查询List. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午10:04:43 .<br/>
     * 【参数】： .<br/>
     * 
     * @param pageSize int
     * @param offset int
     * @param announcement string
     * @param response response
     * @throws Exception .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/list")
    public void list(@RequestParam(value = "limit", required = true) int pageSize, @RequestParam(value = "offset", required = true) int offset, Announcement announcement, HttpServletResponse response)
        throws Exception {
        AnnouncementExample example = new AnnouncementExample();
        if (offset == 0) {
            example.setStart(0);
            example.setEnd(pageSize + offset);
        } else {
            example.setStart(offset);
            example.setEnd(offset + pageSize);
        }
        com.qt.sales.model.AnnouncementExample.Criteria cr = example.createCriteria();
        if (!StringUtils.isEmpty(announcement.getEffectTime())) {
            StringBuffer buffer = new StringBuffer();
            String effectDateTimestr = announcement.getEffectTime();
            String effectDateTime = buffer.append(effectDateTimestr).append("000000").toString();
            cr.andEffectTimeGreaterThanOrEqualTo(effectDateTime);
        }
        if (!StringUtils.isEmpty(announcement.getDisabledTime())){
            StringBuffer buffer1 = new StringBuffer();
            String disabledDateTimestr = announcement.getDisabledTime();
            String disabledDateTime = buffer1.append(disabledDateTimestr).append("240000").toString();
            cr.andDisabledTimeLessThanOrEqualTo(disabledDateTime);
        }
           
        if (!StringUtils.isEmpty(announcement.getStatus())) {
            cr.andStatusEqualTo(announcement.getStatus());
        }
        example.setOrderByClause(" CREATEDT desc");
        int totalRowCount = announcementService.countByExample(example);
        List<Announcement> list = announcementService.selectByExample(example);
        for (Announcement announcement2 : list) {
            if (announcement2.getTitle().length() > 7) {
                announcement2.setTitleSub(announcement2.getTitle().substring(0, 7) + "...");
            } else {
                announcement2.setTitleSub(announcement2.getTitle());
            }
            if (announcement2.getNoticeContent().length() > 7) {
                announcement2.setNoticeContentSub(announcement2.getNoticeContent().substring(0, 7) + "...");
            } else {
                announcement2.setNoticeContentSub(announcement2.getNoticeContent());
            }
        }
        
        ResultList res = new ResultList();
        res.setRows(list);
        res.setTotal(totalRowCount);
        outPrint(resultToJson(res), response);
    }

    /**
     * 
     * 【方法名】 : 系统公告新增方法. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午10:05:11 .<br/>
     * 【参数】： .<br/>
     * 
     * @param announcement 
     * @param loginUser 
     * @param redirectAttributes 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(Announcement announcement, @CurrentUser User loginUser, RedirectAttributes redirectAttributes) {
        try {
            
            Calendar calendar = Calendar.getInstance();
            
            int nowSecond = calendar.get(Calendar.SECOND); //得到秒数
            
            //设置生效时间数据库格式
            String effectDate= announcement.getEffectTime().replaceAll("-", "");
            String effectTime=effectDate.replace(" ", "");
            String effectDateTime=effectTime.replace(":", "");
            String effectDateTime1=  effectDateTime+=nowSecond;
            announcement.setEffectTime(effectDateTime1);
            //设置失效时间数据库格式
            String disabledDate= announcement.getDisabledTime().replaceAll("-", "");
            String disabledTime=disabledDate.replace(" ", "");
            String disabledDateTime=disabledTime.replace(":", "");
            String disabledDateTime1= disabledDateTime+=nowSecond;
            announcement.setDisabledTime(disabledDateTime1);
            // 设置创建时间
            announcement.setCreatedt(DateUtil.getCurrDateAndTime());
            // 设置当前创建人
            announcementService.insert(announcement);
            redirectAttributes.addFlashAttribute("success", "新增成功");
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
            redirectAttributes.addFlashAttribute("danger", "新增失败!" + e.getMessage());
        }
        return "redirect:listPage";
    }

    /**
     * 
     * 【方法名】 : 系统公告删除方法. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午10:05:32 .<br/>
     * 【参数】： .<br/>
     * 
     * @param id 
     * @param announcement 
     * @param response 
     *            .<br/>
     *            <p>
     *            修改记录.<br/>
     *            修改人: fuyu 修改描述： .<br/>
     *            <p/>
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable("id") String id, Announcement announcement, HttpServletResponse response) {
        try {
            announcement.setCreatedt(DateUtil.getCurrDateAndTime());
            announcement.setStatus("00");
            announcementService.updateByPrimaryKeySelective(announcement);
            outPrint("{'success':'true'}", response);
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
    }

    /**
     * 
     * 【方法名】 : 公告消息修改. <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 上午10:06:50 .<br/>
     * 【参数】： .<br/>
     * 
     * @param announcement 
     * @param redirectAttributes 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/updateAnnouncement", method = RequestMethod.POST)
    public String update(Announcement announcement, RedirectAttributes redirectAttributes) {
        try {
            Calendar calendar = Calendar.getInstance();
            int nowSecond = calendar.get(Calendar.SECOND); //得到秒数
            if(announcement.getEffectTime().indexOf("-")!=-1){
                //设置生效时间数据库格式
                String effectDate= announcement.getEffectTime().replaceAll("-", "");
                String effectTime=effectDate.replace(" ", "");
                String effectDateTime=effectTime.replace(":", "");
               
                String effectDateTime1=  effectDateTime+=nowSecond;
                announcement.setEffectTime(effectDateTime1);
            }
            if(announcement.getDisabledTime().indexOf("-")!=-1){
                //设置失效时间数据库格式
                String disabledDate= announcement.getDisabledTime().replaceAll("-", "");
                String disabledTime=disabledDate.replace(" ", "");
                String disabledDateTime=disabledTime.replace(":", "");
                String disabledDateTime1= disabledDateTime+=nowSecond;
                announcement.setDisabledTime(disabledDateTime1);
            }
            // 设置当前创建时间

            
            announcement.setCreatedt(DateUtil.getCurrDateAndTime());

            announcementService.updateByPrimaryKeySelective(announcement);
            redirectAttributes.addFlashAttribute("success", "修改成功");
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
            redirectAttributes.addFlashAttribute("danger", "修改失败!" );
        }
        return "redirect:listPage";
    }

    /**
     * 
     * 【方法名】 : 公告消息审核. <br/>
     * 【注意】: .<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月8日 上午11:33:24 .<br/>
     * 【参数】： .<br/>
     * 
     * @param announcement  
     * @param redirectAttributes 
     * @return .<br/>
     *         <p>
     *         修改记录.<br/>
     *         修改人: fuyu 修改描述： .<br/>
     *         <p/>
     */
    @RequestMapping(value = "/auditAnnouncement", method = RequestMethod.POST)
    public String audit(Announcement announcement, RedirectAttributes redirectAttributes) {
        try {
            // 设置当前创建时间
            announcement.setCreatedt(DateUtil.getCurrDateAndTime());
            announcementService.updateByPrimaryKeySelective(announcement);
            redirectAttributes.addFlashAttribute("msg", "审核成功");
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
            redirectAttributes.addFlashAttribute("danger", "失败" + e.getMessage());
        }
        return "redirect:listPage";
    }

}
