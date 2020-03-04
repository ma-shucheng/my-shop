package com.shuke.my.shop.web.admin.web.controller;

import com.shuke.my.shop.domain.TbContentCategory;
import com.shuke.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * 
 * <p>
 * 内容分类管理
 * </p>
 * 
 * @author shuke
 * @version v1.0.0
 * @since 2020-03-04 11:50:02
 * @see com.shuke.my.shop.web.admin.web.controller
 *
 */
@Controller
@RequestMapping(value = "content/category")
public class ContentCategoryController {
    @Autowired
    private TbContentCategoryService tbContentCategoryService;
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model) {
        List<TbContentCategory> tbContentCategories = tbContentCategoryService.selectAll();
        model.addAttribute("tbContentCategories", tbContentCategories);
        return "content_category_list";
    }
    @RequestMapping(value = "demo",method = RequestMethod.GET)
    public String demo(Model model) {
        List<TbContentCategory> tbContentCategories = tbContentCategoryService.selectAll();
        model.addAttribute("tbContentCategories", tbContentCategories);
        return "demo";
    }
}
