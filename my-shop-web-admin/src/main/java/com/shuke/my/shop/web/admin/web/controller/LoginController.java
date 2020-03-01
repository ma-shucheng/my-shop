package com.shuke.my.shop.web.admin.web.controller;


import com.shuke.my.shop.commons.constants.ConstantUtils;
import com.shuke.my.shop.commons.utils.CookieUtils;
import com.shuke.my.shop.domain.TbUser;
import com.shuke.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.shuke.my.shop.commons.constants.ConstantUtils.COM_SHUKE_LOGINFO;


@Controller
public class LoginController {

    @Autowired
    private TbUserService tbUserService;

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * 登录页
     *
     * @return
     */
    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"login"}, method = RequestMethod.POST)
    public String login(@RequestParam(required = false) String remMe,@RequestParam(required = true) String email, @RequestParam(required = true) String loginPwd, HttpServletRequest req,HttpServletResponse resp) {
        TbUser user = tbUserService.login(email, loginPwd);

        logger.info("创建对象记住我、邮箱、密码分别为：{}  {}  {}",remMe,email,loginPwd);
        //如果点击记住我,将用户名和密码信息存入Cookie
        if (remMe != null) {
            CookieUtils.setCookie(req, resp, COM_SHUKE_LOGINFO, String.format("%s:%s", email, loginPwd), 7 * 24 * 60 * 60);
        }
        //如果没有点击，则删除Cookie缓存
        else {
            CookieUtils.setCookie(req, resp, COM_SHUKE_LOGINFO, null, 0);
        }

        //登录失败
        if (user == null) {
            req.setAttribute("message", "用户名或密码错误");
            logger.info("发送错误消息");
            return login();
        }

        //登录成功
        else {
            logger.info("页面成功跳转");
            req.setAttribute("message", null);
            //记录登录信息放入会话
            req.getSession().setAttribute(ConstantUtils.SESSION_USER, user);
            return "redirect:/main";
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest req, HttpServletResponse resp) {
        String[] logInfo = CookieUtils.getCookieValue(req, COM_SHUKE_LOGINFO).split(":");
        //如果缓存不为空则给前端赋值
        if (!StringUtils.isEmpty(logInfo[0])) {
            req.setAttribute("email",logInfo[0]);
            req.setAttribute("loginPwd",logInfo[1]);
            req.setAttribute("remMe",true);
        }
        //如果为空则给前端赋空值
        else {
            req.setAttribute("remMe",false);
        }
        req.getSession().invalidate();
        return login();
    }

}
