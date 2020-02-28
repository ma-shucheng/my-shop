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
}
