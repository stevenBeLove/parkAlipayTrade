//package com.qt.sales.realm;
//
//import java.util.List;
//import java.util.Set;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.subject.Subject;
//import org.apache.shiro.web.filter.authz.AuthorizationFilter;
//import org.apache.shiro.web.util.WebUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.StringUtils;
//
//import com.qt.sales.model.Meta_draw;
//import com.qt.sales.utils.Validator;
//import com.qt.shiro.entity.UrlFilter;
//import com.qt.shiro.service.UrlFilterService;
//import com.qt.shiro.service.UserService;
//
///**
// * 
// * 类名: CommonAuthFilter <br/>
// * 方法：TODO(Url过滤)<br/>
// * 创建者: zhangyinghui. <br/>
// * 添加时间: 2016年9月21日 下午2:30:09 <br/>
// * 版本：
// * 
// * @since JDK 1.6 chart 1.0
// */
//public class UrlRolesFilter extends AuthorizationFilter {
//
//    @Autowired
//    private UserService userService;
//    
//    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
//        String requestURI = WebUtils.getPathWithinApplication(WebUtils.toHttp(servletRequest));
//        Subject subject = SecurityUtils.getSubject();
//        //根据权限过滤Url
//        Set<String> roles = (Set<String>) subject.getSession().getAttribute("roles");
//        if(!StringUtils.isEmpty(roles)){
//          for (String role : roles) {
//             if(Meta_draw.matchUrlRole(requestURI,role)){
//                 return false;
//             }
//          }
//        }
//        return true;
//
//    }
//
//}
