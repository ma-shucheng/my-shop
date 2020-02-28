package com.shuke.my.shop.web.admin.service;

import com.shuke.my.shop.domain.TbUser;

import java.util.List;

public interface TbUserService {
    /**
     * 返回用户登录信息
     * @return
     */
    public List<TbUser> selectAll();
}
