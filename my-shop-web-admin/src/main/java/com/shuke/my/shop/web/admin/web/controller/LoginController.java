package com.shuke.my.shop.web.admin.web.controller;


import com.shuke.my.shop.commons.constants.ConstantUtils;
import com.shuke.my.shop.domain.User;
import com.shuke.my.shop.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录页
     * @return
     */
    @RequestMapping(value = {"","login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"login"}, method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String loginPwd, HttpServletRequest httpServletRequest) {
        User user = userService.login(email, loginPwd);

        //登录失败
        if (user == null) {
            return login();
        }

        //登录失败
        else  {
            //记录登录信息放入会话
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER,user);
            return "redirect:/main";
        }
    }
}
