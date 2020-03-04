package com.shuke.my.shop.web.admin.dao;

import com.shuke.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentDao {
    /**
     * 查询用户数据表
     * @return
     */
    public List<TbContent> selectAll();

    public void insert(TbContent tbContent);

    public void delete(Long id);

    public TbContent getById(Long id);

    public void update(TbContent tbContent);



    /**
     * 搜索用户信息
     * @param tbContent
     * @return
     */
    List<TbContent> search(TbContent tbContent);

    /**
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);
}
