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

    public List<TbUser> getByUsername(String username);
}
