package com.shuke.my.shop.web.admin.web.controller;

import com.shuke.my.shop.commons.constants.ConstantUtils;
import com.shuke.my.shop.domain.TbUser;
import com.shuke.my.shop.web.admin.service.TbUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping(value = "main",method = RequestMethod.GET)
    public String main(HttpServletRequest req) {
        TbUser user = (TbUser) req.getSession().getAttribute(ConstantUtils.SESSION_USER);
        //记录登录信息放入会话
        req.getSession().setAttribute(ConstantUtils.SESSION_USER, user);
        return "main";
    }

}
