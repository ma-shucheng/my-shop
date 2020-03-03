package com.shuke.my.shop.web.admin.service.impl;

import com.shuke.my.shop.commons.dto.BaseResult;
import com.shuke.my.shop.commons.utils.RegexUtils;
import com.shuke.my.shop.domain.TbUser;
import com.shuke.my.shop.web.admin.dao.TbUserDao;
import com.shuke.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserDao tbUserDao;
    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }

    @Override
    public void insert(TbUser tbUser) { tbUserDao.insert(tbUser);}

    @Override
    public void delete(Long id) {
        tbUserDao.delete(id);
    }

    @Override
    public TbUser getById(Long id) {
        return tbUserDao.getById(id);
    }

    @Override
    public void update(TbUser tbUser) {
      tbUserDao.update(tbUser);
    }

    @Override
    public List<TbUser> getByUsername(String username) {

        return tbUserDao.getByUsername(username);
    }

    /**
     * 用户登录业务
     * @param email
     * @param password
     * @return 用户信息
     */
    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = tbUserDao.getByEmail(email);
        if (tbUser != null) {
            //加密判断
            if (DigestUtils.md5DigestAsHex(password.getBytes()).equals(tbUser.getPassword())) {
                return tbUser;
            }
        }
        return null;
    }

    /**
     * 验证用户信息通过，将数据加载进数据库
     * @param tbUser
     * @return
     */
    @Override
    public BaseResult save(TbUser tbUser) {
        BaseResult baseResult = checkTbUser(tbUser);
        if (baseResult.getStatus()==BaseResult.STATUS_SUCCESS) {
            tbUser.setUpdated(new Date());
            //编辑用户
            if (tbUser.getId() != null) {
                tbUserDao.update(tbUser);
            }
            //新增用户
            else {
                //密码需要加密
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                tbUserDao.insert(tbUser);
            }
            baseResult.setMessage("保存用户信息成功");
        }
        return baseResult;
    }

    /**
     * 客户信息的有效验证
     * @param tbUser
     */
    @Override
    public BaseResult checkTbUser(TbUser tbUser) {
        BaseResult baseResult = BaseResult.success();

        //非空验证
        if (StringUtils.isBlank(tbUser.getEmail())) {
           baseResult = BaseResult.fail("邮箱不能为空，请重新输入");
        } else if (!RegexUtils.checkEmail(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱不正确，请重新输入");
        } else if (StringUtils.isBlank(tbUser.getPassword())) {
            baseResult = BaseResult.fail("密码不能为空，请重新输入");
        } else if (StringUtils.isBlank(tbUser.getUsername())) {
            baseResult = BaseResult.fail("姓名不能为空，请重新输入");
        } else if (StringUtils.isBlank(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机号不能为空，请重新输入");
        } else if (!RegexUtils.checkMobile(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机号不正确，请重新输入");
        }
        return baseResult;
    }

    /**
     * 搜索业务
     * @param keyword
     * @return
     */
    @Override
    public List<TbUser> search(String keyword) {
        TbUser tbUser = new TbUser();
        if (RegexUtils.checkEmail(keyword)) {
            tbUser.setEmail(keyword);
        } else if (RegexUtils.checkMobile(keyword)) {
            tbUser.setPhone(keyword);
        }else{
            tbUser.setUsername(keyword);
        }
        List<TbUser> tbUsers = tbUserDao.search(tbUser);
        return tbUsers;
    }

    @Override
    public void deleteMulti(String[] ids) {
        tbUserDao.deleteMulti(ids);
    }
}