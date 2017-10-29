package com.qt.shiro.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qt.sales.model.FansAgencyExample;
import com.qt.sales.utils.ResultList;
import com.qt.shiro.entity.User;
import com.qt.shiro.service.OrganizationService;
import com.qt.shiro.service.PasswordHelper;
import com.qt.shiro.service.RoleService;
import com.qt.shiro.service.UserService;

/**
 * <p>
 * User: Zhang yinghui
 */
@Controller
@RequestMapping("/user")
public class UserController{

    @Autowired
    private UserService userService;

    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordHelper passwordHelper;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model)throws Exception {
        return "user/userList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        setCommonData(model);
        model.addAttribute("user", new User());
        model.addAttribute("op", "新增");
        return "user/edit";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(User user, RedirectAttributes redirectAttributes) {
        try {
            userService.createUser(user);
            redirectAttributes.addFlashAttribute("msg", "新增成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("msg", "新增失败");
        }

        return "redirect:/user";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") Long id, Model model)throws Exception {
        setCommonData(model);
        model.addAttribute("user", userService.findOne(id));
        model.addAttribute("op", "修改");
        return "user/edit";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(User user, RedirectAttributes redirectAttributes) {
        try {
            userService.updateUser(user);
            redirectAttributes.addFlashAttribute("msg", "修改成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("msg", "修改失败");
        }

        return "redirect:/user";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String showDeleteForm(@PathVariable("id") Long id, Model model)throws Exception {
        setCommonData(model);
        model.addAttribute("user", userService.findOne(id));
        model.addAttribute("op", "删除");
        return "user/edit";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            userService.deleteUser(id);
            redirectAttributes.addFlashAttribute("msg", "删除成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("msg", "删除失败");
        }
        return "redirect:/user";
    }

    @RequestMapping(value = "/{id}/changePassword", method = RequestMethod.GET)
    public String showChangePasswordForm(@PathVariable("id") Long id, Model model)throws Exception {
        model.addAttribute("user", userService.findOne(id));
        model.addAttribute("op", "修改密码");
        return "user/changePassword";
    }

    @RequestMapping(value = "/{id}/changePassword", method = RequestMethod.POST)
    public String changePassword(@PathVariable("id") Long id, String newPassword, RedirectAttributes redirectAttributes) {
        try {
            userService.changePassword(id, newPassword);
            redirectAttributes.addFlashAttribute("msg", "修改密码成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("msg", "修改密码失败");
        }
        return "redirect:/user";
    }

    private void setCommonData(Model model) {
        model.addAttribute("organizationList", organizationService.findAll());
        model.addAttribute("roleList", roleService.findAll());
    }
    
    /**
     * 查询人员列表
     * 
     * @param pageSize
     *            页数
     * @param offset
     *            每页多少条
     * @param user
     *           用户信息
     * @param response
     *            response
     * @throws Exception
     *             异常
     */
    @RequestMapping(value = "/userPagelist")
    @ResponseBody
    public ResultList list(@RequestParam(value = "limit", required = true) int pageSize, @RequestParam(value = "offset", required = true) int offset, User user, HttpServletResponse response)
        throws Exception {
        FansAgencyExample example = new FansAgencyExample();
        if (offset == 0) {
            example.setStart(0);
            example.setEnd(pageSize + offset);
        } else {
            example.setStart(offset);
            example.setEnd(offset + pageSize);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", example.getStart());
        map.put("end", example.getEnd());
        if (!StringUtils.isEmpty(user.getNickname())) {
            map.put("nickname", user.getNickname());
        }
        
        if (!StringUtils.isEmpty(user.getUsername())) {
            map.put("username", user.getUsername());
        }
        List<User> list = userService.findAll(map);
        int totalRowCount = userService.findAllCount(map);
        ResultList res = new ResultList();
        res.setRows(list);
        res.setTotal(totalRowCount);
        return res;
    }
    

}
