package com.shuke.my.shop.web.admin.service;

import com.shuke.my.shop.domain.TbContentCategory;

import java.util.List;

public interface TbContentCategoryService {
    List<TbContentCategory> selectAll();

    /**
     * 根据父级节点查询子节点
     * @param pid
     * @return
     */
    List<TbContentCategory> selectByPid(Long pid);
}
