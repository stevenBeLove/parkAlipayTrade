/** 
 * 包名: package com.qt.sales.web; <br/> 
 * 添加时间: 2016年11月7日 下午2:38:52 <br/> 
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.qt.sales.model.LoginsLogVO;
import com.qt.sales.service.LoginsLogService;
import com.qt.sales.utils.DateUtil;
import com.qt.sales.utils.ResultList;

/**
 * 
 * <pre>
 * 【类型】: LoginsLogController <br/> 
 * 【作用】: 登录日志 <br/>  
 * 【时间】：2016年11月7日 下午2:38:57 <br/> 
 * 【作者】：fuyu <br/>
 * </pre>
 */
@Controller
@RequestMapping("/loginsLog")
public class LoginsLogController{


    /**
     * 
     */
    @Resource
    private LoginsLogService loginsLogService;

    /**
     * 
     * 【方法名】 : 跳转登录日志页面 <br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月7日 下午2:41:11 .<br/>
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
    public String loginsLogList(Model model) {
        return "loginsLog/loginsLogList";
    }

    /**
     * 
     * 【方法名】    : 查询登录日志. <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: fuyu .<br/>
     * 【时间】： 2016年11月8日 下午5:26:44 .<br/>
     * 【参数】： .<br/>
     * @param pageSize 
     * @param offset 
     * @param loginsLogVO 
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
    @ResponseBody
    public ResultList getLoginsLog(@RequestParam(value = "limit", required = true) int pageSize, @RequestParam(value = "offset", required = true) int offset, LoginsLogVO loginsLogVO,
            HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
        if (offset == 0) {
            loginsLogVO.setStart(0);
            loginsLogVO.setEnd(pageSize + offset);
        } else {
            loginsLogVO.setStart(offset);
            loginsLogVO.setEnd(offset + pageSize);
        }
        int totalRowCount = loginsLogService.LoginsLogCount(loginsLogVO);
        List<LoginsLogVO> list = loginsLogService.getLoginsLogList(loginsLogVO);
        for (LoginsLogVO login : list) {
            login.setLoginDate(DateUtil.getStandDateFormat(login.getLoginDate()));
        }
        ResultList res = new ResultList();
        res.setRows(list);
        res.setTotal(totalRowCount);
        return res;
    }


}
