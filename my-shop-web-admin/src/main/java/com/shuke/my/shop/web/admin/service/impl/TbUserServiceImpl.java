package com.shuke.my.shop.web.admin.service.impl;

import com.shuke.my.shop.domain.TbUser;
import com.shuke.my.shop.web.admin.dao.TbUserDao;
import com.shuke.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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
}
