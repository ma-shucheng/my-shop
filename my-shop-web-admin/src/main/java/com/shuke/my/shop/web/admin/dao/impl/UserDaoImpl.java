package com.shuke.my.shop.web.admin.dao.impl;


import com.shuke.my.shop.domain.User;
import com.shuke.my.shop.web.admin.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

public class UserDaoImpl implements UserDao {

    private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    public User login(String email, String loginPwd) {
        User user = null;

        logger.info("接收到用户邮箱：{} 密码：{} ",email,loginPwd);

        if (email.equals("admin@qq.com")) {
            if (loginPwd.equals("admin")) {
                user = new User();
                user.setEmail("admin@qq.com");
                user.setLoginPwd("admin");
                user.setLoginId("shuke");
                logger.info("创建对象用户名、邮箱、密码分别为：{}  {}  {}",user.getLoginId(),user.getEmail(),user.getLoginPwd() );
            }
        }
        return user;
    }

    public Boolean remME(String remMe, String email, String loginPwd) {
        Boolean remFlag = false;
        if (remMe.equals("on")) {
            if (email.equals("admin@qq.com")) {
                if (loginPwd.equals("admin")) {
                    logger.info("可以记住我");
                    remFlag = true;
                }
            }
        }
        return remFlag;
    }

    public Boolean autoSign(String autoSign, String email, String loginPwd) {
        Boolean autoFlag = false;
        if (autoSign.equals("on")) {
            if (email.equals("admin@qq.com")) {
                if (loginPwd.equals("admin")) {
                    logger.info("可以自动登录");
                    autoFlag = true;
                }
            }
        }
        return autoFlag;
    }
}
