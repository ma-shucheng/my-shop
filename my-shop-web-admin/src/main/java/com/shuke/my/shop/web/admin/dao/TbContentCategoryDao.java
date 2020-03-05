package com.shuke.my.shop.web.admin.dao;

import com.shuke.my.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentCategoryDao {
    List<TbContentCategory> selectAll();

    /**
     * 根据父级节点查询子节点
     * @param pid
     * @return
     */
    List<TbContentCategory> selectByPid(Long pid);
}
