package com.qt.sales.realm;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.qt.shiro.entity.UrlFilter;
import com.qt.shiro.service.UrlFilterService;
import com.qt.shiro.service.UserService;

/**
 * 
 * 类名: CommonAuthFilter <br/>
 * 方法：TODO(权限过滤)<br/>
 * 创建者: zhangyinghui. <br/>
 * 添加时间: 2016年8月31日 下午2:30:09 <br/>
 * 版本：
 * 
 * @since JDK 1.6 chart 1.0
 */
public class CommonAuthFilter extends AuthorizationFilter {

    @Autowired
    private UserService userService;
    
    @Autowired
    private UrlFilterService  urlFilterService;
    
    
    public CommonAuthFilter() {
    }

    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        String requestURI = WebUtils.getPathWithinApplication(WebUtils.toHttp(servletRequest));
        // Subject subject = this.getSubject(servletRequest, servletResponse);
        // //超级管理员无阻
        // if(subject.hasRole("adminrole")) return true;
        // //通过subject判断用户有没有些url权限
        // return subject.isPermitted(requestURI);
        String uri = requestURI.substring(1);
        Subject subject = SecurityUtils.getSubject();
        
        
        
        List<String> list = (List<String>) subject.getSession().getAttribute("exclusiveList");
        if (!StringUtils.isEmpty(list)) {
            if (list.contains(uri)) {
                return false;
            }
        }
        if (!StringUtils.isEmpty(list)) {
            for (String dateUrl : list) {
                String regEx = "^" + dateUrl + ".*";
                if (validate(uri, regEx)) {
                    return false;
                }
            }
        }
        //根据权限过滤Url
        Set<String> roles = userService.findRoles(subject.getPrincipal().toString());
        for (String s : roles) {
            System.out.println(s);
        }
        List<UrlFilter> urlFilterList = urlFilterService.findAll();
        for (UrlFilter url : urlFilterList) {
            System.out.println(url.getUrl());
        }
        return true;
    }

    private boolean validate(String str, String regEx) {
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        // 字符串是否与正则表达式相匹配
        return matcher.matches();
    }
}
