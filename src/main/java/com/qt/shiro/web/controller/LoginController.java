package com.qt.shiro.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qt.shiro.Constants;
import com.qt.shiro.entity.User;

/**
 * <p>
 * User: Zhang yinghui
 */
@Controller
public class LoginController {

    /**
     * 
     * 【方法名】    : (验证登录). <br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年11月25日 上午10:16:48 .<br/>
     * 【参数】： .<br/>
     * @param req HttpServletRequest对象
     * @param model Model对象
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人:  yinghui zhang 修改描述： .<br/>
     * <p/>
     */
    @RequestMapping(value = "/login")
    public String showLoginForm(HttpServletRequest req, Model model) {
        String exceptionClassName = (String) req.getAttribute("shiroLoginFailure");
        User user = (User) req.getSession().getAttribute(Constants.CURRENT_USER);
        if (user != null) {
            return "redirect:/";
        }
        String error = null;
        if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if (LockedAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户被锁定，请联系管理员!";
        } else if (exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        model.addAttribute("error", error);
        return "login";
    }

}
