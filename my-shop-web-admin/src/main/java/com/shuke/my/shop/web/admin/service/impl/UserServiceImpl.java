package com.shuke.my.shop.web.admin.service.impl;

import com.shuke.my.shop.domain.User;
import com.shuke.my.shop.web.admin.dao.UserDao;
import com.shuke.my.shop.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
//    UserDao userDao = new UserDaoImpl();

    @Autowired
    UserDao userDao;

    public User login(String email, String loginPwd) {
        return userDao.login(email,loginPwd);
    }

    public Boolean remME(String remMe, String email, String loginPwd) {
        return userDao.remME(remMe,email,loginPwd);
    }

    public Boolean autoSign(String autoSign, String email, String loginPwd) {
        return userDao.autoSign(autoSign,email,loginPwd);
    }

}
