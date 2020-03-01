package com.shuke.my.shop.web.admin.web.controller;

import com.shuke.my.shop.domain.TbUser;
import com.shuke.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private TbUserService tbUserService;
    /**
     * 跳转到用户列表
     * @param
     * @return
     */
    @RequestMapping(value = "table",method = RequestMethod.GET)
    public String table(Model model) {
        List<TbUser> tbUsers = tbUserService.selectAll();
        model.addAttribute("tbUsers", tbUsers);
        return "table";
    }
}
