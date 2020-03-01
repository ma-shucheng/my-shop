package com.shuke.my.shop.web.admin.web.controller;

import com.shuke.my.shop.commons.constants.ConstantUtils;
import com.shuke.my.shop.commons.dto.BaseResult;
import com.shuke.my.shop.domain.TbUser;
import com.shuke.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private TbUserService tbUserService;

    /**
     * 跳转到用户列表
     *
     * @param
     * @return
     */
    @RequestMapping(value = "table", method = RequestMethod.GET)
    public String table(Model model) {
        List<TbUser> tbUsers = tbUserService.selectAll();
        model.addAttribute("tbUsers", tbUsers);
        return "table";
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "form";
    }

    /**
     * 保存用户信息
     * @param tbUser
     * @param model {@code 保存失败在本页面发送的信息}
     * @param redirectAttributes {@code 保存成功在跳转页面发送的信息}
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbUser tbUser, Model model,RedirectAttributes redirectAttributes) {
        //保存成功
        BaseResult baseResult = tbUserService.save(tbUser);
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            redirectAttributes.addFlashAttribute(ConstantUtils.SESSION_BASERESULT,baseResult);
            return "redirect:/user/table";
        }
        //保存失败
        else {
            model.addAttribute(ConstantUtils.SESSION_BASERESULT, baseResult);
            return "form";
        }
    }
}
