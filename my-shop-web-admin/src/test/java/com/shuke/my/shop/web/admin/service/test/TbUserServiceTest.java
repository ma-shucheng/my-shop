package com.shuke.my.shop.web.admin.service.test;

import com.shuke.my.shop.domain.TbUser;
import com.shuke.my.shop.web.admin.dao.TbUserDao;
import com.shuke.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {
    @Autowired
    private TbUserService tbUserService;

    @Test
    public void testSelectAll() {
        List<TbUser> tbUsers = tbUserService.selectAll();
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }

    @Test
    public void testInsert(){
        TbUser tbUser = new TbUser();
        tbUser.setUsername("shuke");
        tbUser.setEmail("admin@qq.com");
        tbUser.setPassword(DigestUtils.md5DigestAsHex("admin".getBytes()));
        tbUser.setPhone("123456");
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());

        tbUserService.insert(tbUser);
    }
    @Test
    public void testDelte(){
        tbUserService.delete((long) 41);
    }
    @Test
    public void  testGetById() {
        TbUser tbUser = tbUserService.getById((long) 16);
        System.out.println(tbUser);
    }
    @Test
    public void  testLogin() {
        TbUser tbUser = tbUserService.login("admin@qq.com","admin");
        System.out.println(tbUser);
    }

    @Test
    public void testUpdate() {
        TbUser tbUser = tbUserService.getById(22L);
        tbUser.setUsername("shuke");
        tbUserService.update(tbUser);
    }
    @Test
    public void testSelectByName() {
        List<TbUser> tbUsers = tbUserService.getByUsername("uni");
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }
}
