package com.shuke.my.shop.web.admin.service;

import com.shuke.my.shop.commons.dto.BaseResult;
import com.shuke.my.shop.domain.TbContent;

import java.util.List;

public interface TbContentService {
    /**
     * 返回用户登录信息
     * @return
     */
    public List<TbContent> selectAll();

    public void insert(TbContent tbContent);

    public void delete(Long id);

    public TbContent getById(Long id);

    public void update(TbContent tbContent);

    public BaseResult save(TbContent tbContent);

    public BaseResult checkTbContent(TbContent tbContent);

    public List<TbContent> search(String keyword);

    public void deleteMulti(String[] ids);
}

