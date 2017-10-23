package com.qt.sales.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.qt.shiro.entity.User;
import com.qt.shiro.service.PasswordHelper;
import com.qt.shiro.service.UserService;

@Controller
public class AnonController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordHelper passwordHelper;


    /**
     * 
     * 【方法名】    : (这里用一句话描述这个方法的作用). <br/> 
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/> 
     * 【作者】: yinghui zhang .<br/>
     * 【时间】： 2016年10月24日 下午8:27:35 .<br/>
     * 【参数】：@param  param 设置值.  <br/>
     * @param id
     * @param model
     * @return .<br/>
     * <p>
     * 修改记录.<br/>
     * 修改人: yinghui zhang 修改描述：创建新方法 .<br/>
     * <p/>
     */

    @RequestMapping(value = "/reqPassword/{id}", method = RequestMethod.GET)
    public String reqPassword(@PathVariable("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "changePwd";
    }

    @ResponseBody
    @RequestMapping(value = "/chgpwd")
    public JSONObject chgpwd(@RequestParam(value = "id", required = true) String id, @RequestParam(value = "oldPwd", required = true) String oldPwd,
            @RequestParam(value = "newPwd", required = true) String newPwd, @RequestParam(value = "sureNewPwd", required = true) String sureNewPwd, HttpServletRequest rep)throws Exception {

        User user = (User) userService.findOne(Long.parseLong(id));
        JSONObject data = new JSONObject();

        String userPwd_encryption_before = user.getPassword().toLowerCase();
        user.setPassword(oldPwd);
        passwordHelper.encryptPassword(user);
        String oldPwd_encryption_after = user.getPassword().toLowerCase();

        if (!userPwd_encryption_before.equals(oldPwd_encryption_after)) {
            data.put("msg", "原始密码输入错误,请重新输入.");
            return data;
        }
        if (!newPwd.equals(sureNewPwd)) {
            data.put("msg", "新密码两次输入不一致,请重新输入.");
            return data;
        }
        try {
            userService.changePassword(Long.parseLong(id), newPwd);
            data.put("msg", "成功");
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            data.put("msg", "未能成功修改,请重试.");
        }
        return data;
    }
    
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }


}
