package com.qt.sso.web.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qt.sales.utils.LogPay;
import com.qt.sso.entity.Client;
import com.qt.sso.entity.UploadParam;
import com.qt.sso.service.ClientService;

/**
 * <pre>
 * 【类型】: ClientController <br/> 
 * 【时间】：2016年12月30日 下午6:33:06 <br/> 
 * 【作者】：yinghui zhang <br/>
 * </pre>
 */
@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;
    
    @RequestMapping(value = "/myApplist", method = RequestMethod.GET)
    public String myApplist(Model model) {
        model.addAttribute("clientList", clientService.findAll());
        return "myApp/myAppList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("clientList", clientService.findAll());
        return "client/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("op", "新增");
        return "client/edit";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Client client, RedirectAttributes redirectAttributes) {
        clientService.createClient(client);
        redirectAttributes.addFlashAttribute("msg", "新增成功");
        return "redirect:/client";
    }
    
    @RequestMapping(value = "/uploadIcon", method = RequestMethod.POST)
    @ResponseBody
    public UploadParam uploadIcon(@RequestParam(value = "iconFileUpload", required = false) MultipartFile iconFileUpload, 
            RedirectAttributes redirectAttributes, HttpServletRequest request, ModelMap model) {
        if (iconFileUpload.isEmpty()) {
            redirectAttributes.addFlashAttribute("danger", "添加数据!");
        }
        String fileUrl = "";
        try {
            String path = request.getSession().getServletContext().getRealPath("upload");  
            String fileName = iconFileUpload.getOriginalFilename();  
            File targetFile = new File(path, fileName);  
            if(!targetFile.exists()){  
                targetFile.mkdirs();  
            }  
            //保存  
            try {  
                iconFileUpload.transferTo(targetFile);
                fileUrl = "/upload/"+fileName;
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        } catch (Exception e) {
            LogPay.error(e.getMessage(), e);
        }
        UploadParam para = new UploadParam();
        para.setUrl(fileUrl);
        return para;
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("client", clientService.findOne(id));
        model.addAttribute("op", "修改");
        return "client/edit";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(Client client, RedirectAttributes redirectAttributes) {
        clientService.updateClient(client);
        redirectAttributes.addFlashAttribute("msg", "修改成功");
        return "redirect:/client";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String showDeleteForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("client", clientService.findOne(id));
        model.addAttribute("op", "删除");
        return "client/edit";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        clientService.deleteClient(id);
        redirectAttributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/client";
    }

}
