package com.shuke.my.shop.web.admin.service.impl;

import com.shuke.my.shop.commons.dto.BaseResult;
import com.shuke.my.shop.commons.validator.BeanValidator;
import com.shuke.my.shop.domain.TbContent;
import com.shuke.my.shop.web.admin.dao.TbContentDao;
import com.shuke.my.shop.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    TbContentDao tbContentDao;
    @Override
    public List<TbContent> selectAll() {
        return tbContentDao.selectAll();
    }

    @Override
    public void insert(TbContent tbContent) {
        tbContentDao.insert(tbContent);
    }

    @Override
    public void delete(Long id) {
        tbContentDao.delete(id);
    }

    @Override
    public TbContent getById(Long id) {
        return tbContentDao.getById(id);
    }

    @Override
    public void update(TbContent tbContent) {
        tbContentDao.update(tbContent);
    }

    @Override
    public BaseResult save(TbContent tbContent) {
        String validator = BeanValidator.validator(tbContent);
        //验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        //验证通过
        else {
            tbContent.setUpdated(new Date());
            //编辑用户
            if (tbContent.getId() != null) {
                tbContentDao.update(tbContent);
            }
            //新增用户
            else {
                tbContentDao.insert(tbContent);
            }
            return BaseResult.success("保存内容信息成功");
        }
    }

    @Override
    public BaseResult checkTbContent(TbContent tbContent) {
        BaseResult baseResult = BaseResult.success();
        //非空验证
        if (StringUtils.isBlank(tbContent.getContent())) {
            baseResult = BaseResult.fail("内容不能为空，请重新输入");
        }  else if (StringUtils.isBlank(tbContent.getPic())) {
            baseResult = BaseResult.fail("pic不能为空，请重新输入");
        } else if (StringUtils.isBlank(tbContent.getTitleDesc())) {
            baseResult = BaseResult.fail("标题desc不能为空，请重新输入");
        } else if (StringUtils.isBlank(tbContent.getPic2())) {
            baseResult = BaseResult.fail("pic2不能为空，请重新输入");
        } else if (StringUtils.isBlank(tbContent.getSubTitle())) {
            baseResult = BaseResult.fail("子标题不能为空，请重新输入");
        } else if (StringUtils.isBlank(tbContent.getTitle())) {
            baseResult = BaseResult.fail("标题不能为空，请重新输入");
        } else if (StringUtils.isBlank(tbContent.getUrl())) {
            baseResult = BaseResult.fail("URL不能为空，请重新输入");
        }
        return baseResult;
    }

    @Override
    public List<TbContent> search(String keyword) {
        TbContent tbContent = new TbContent();

            tbContent.setTitle(keyword);

            tbContent.setSubTitle(keyword);

            tbContent.setUrl(keyword);


        List<TbContent> tbContents = tbContentDao.search(tbContent);

        return tbContents;
    }

    @Override
    public void deleteMulti(String[] ids) {
        tbContentDao.deleteMulti(ids);
    }
}