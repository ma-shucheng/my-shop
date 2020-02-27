package com.shuke.my.shop.web.admin.dao;


import com.shuke.my.shop.domain.User;

public interface UserDao {
    public User login(String email, String loginpwd);
    public Boolean remME(String remMe, String email, String loginPwd);
    public Boolean autoSign(String autoSign, String email, String loginPwd);
}
