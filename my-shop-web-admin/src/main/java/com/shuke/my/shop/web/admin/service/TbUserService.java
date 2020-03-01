package com.shuke.my.shop.web.admin.service;

import com.shuke.my.shop.domain.TbUser;

import java.util.List;

public interface TbUserService {
    /**
     * 返回用户登录信息
     * @return
     */
    public List<TbUser> selectAll();

    public void insert(TbUser tbUser);

    public void delete(Long id);

    public TbUser getById(Long id);

    public void update(TbUser tbUser);

    public List<TbUser> getByUsername(String username);

    public TbUser login(String email, String password);
}
