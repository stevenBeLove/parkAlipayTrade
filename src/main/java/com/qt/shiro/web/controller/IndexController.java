package com.qt.shiro.web.controller;

import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qt.sales.model.LoginsLogVO;
import com.qt.sales.service.LoginsLogService;
import com.qt.sales.utils.DateUtil;
import com.qt.sales.utils.LogPay;
import com.qt.shiro.Constants;
import com.qt.shiro.entity.Resource;
import com.qt.shiro.entity.User;
import com.qt.shiro.service.ResourceService;
import com.qt.shiro.service.UserService;
import com.qt.shiro.web.bind.annotation.CurrentUser;

/**
 * <p>
 * User: Zhang yinghui
 */
@Controller
@Scope("prototype")
public class IndexController {

    /**
     * Service
     */
    @Autowired
    private ResourceService  resourceService;
    /**
     * Service
     */
    @Autowired
    private UserService      userService;
    /**
     * LoginsLogService
     */
    @Autowired
    private LoginsLogService loginsLogService;

    /**
     * 
     * 【方法名】    : (跳转到首页). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月25日 上午10:20:11 .<br/>
     * 【参数】： .<br/>
     * @param loginUser 登录成功的User对象
     * @param model Model对象
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    @RequestMapping("/")
    public String index(@CurrentUser User loginUser, Model model) {
        Set<String> permissions = userService.findPermissions(loginUser.getUsername());
        Subject subject = SecurityUtils.getSubject();
        Set<String> roles = userService.findRoles(subject.getPrincipal().toString());
        List<Resource> menus = resourceService.findMenusOrig(permissions);
        model.addAttribute("menus", menus);
        model.addAttribute("id", loginUser.getId());
        if (subject.getSession().getAttribute(Constants.CURRENT_USER) == null) {
            try {
                // 登录日志 fuyu添加
                LoginsLogVO loginsLogVO = new LoginsLogVO();
                loginsLogVO.setUserName((String) subject.getPrincipal());
                loginsLogVO.setLoginDate(DateUtil.getCurrDateAndTime());
                loginsLogVO.setStatus("1");
                loginsLogService.insertLoginsLog(loginsLogVO);
            } catch (Exception e) {
                LogPay.error(e.getMessage(), e);
            }
        } 
        subject.getSession().setAttribute("roles", roles);
        subject.getSession().setAttribute(Constants.CURRENT_USER, loginUser);
        return "portal";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

}
