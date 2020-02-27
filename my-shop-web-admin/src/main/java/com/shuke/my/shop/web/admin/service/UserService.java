package com.shuke.my.shop.web.admin.service;

import com.shuke.my.shop.domain.User;

public interface UserService {
    public User login(String email, String loginPwd);
    public Boolean remME(String remMe, String email, String loginPwd);
    public Boolean autoSign(String autoSign, String email, String loginPwd);
}
