package com.shuke.my.shop.web.admin.dao;

import com.shuke.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbUserDao {
    /**
     * 查询用户数据表
     * @return
     */
    public List<TbUser> selectAll();

    public void insert(TbUser tbUser);

    public void delete(Long id);

    public TbUser getById(Long id);

    public void update(TbUser tbUser);

    /**
     * 通过用户名查找用户信息
     * @param username
     * @return
     */
    public List<TbUser> getByUsername(String username);

    /**
     * 通过邮箱查找用户信息
     * @param email
     * @return
     */
    TbUser getByEmail(String email);

    /**
     * 搜索用户信息
     * @param tbUser
     * @return
     */
    List<TbUser> search(TbUser tbUser);
}
