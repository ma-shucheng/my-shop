package com.shuke.my.shop.web.admin.web.controller;

import com.shuke.my.shop.commons.constants.ConstantUtils;
import com.shuke.my.shop.commons.dto.BaseResult;
import com.shuke.my.shop.domain.TbUser;
import com.shuke.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private TbUserService tbUserService;


    @ModelAttribute
    public TbUser getTbUser(Long id) {
        TbUser tbUser = null;
        //id不为空则返回tbUser
        if (id != null) {
            tbUser = tbUserService.getById(id);
        }
        //为空则重新创建tbUser,为了不使前端映射显示空指令异常
        else {
            tbUser = new TbUser();
        }
        return tbUser;
    }
    /**
     * 跳转到用户列表
     *
     * @param
     * @return
     */
    @RequestMapping(value = "table", method = RequestMethod.GET)
    public String table(Model model) {
        List<TbUser> tbUsers = tbUserService.selectAll();
        model.addAttribute("tbUsers", tbUsers);
        return "table";
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "form";
    }

    /**
     * 保存用户信息
     * @param tbUser
     * @param model {@code 保存失败在本页面发送的信息}
     * @param redirectAttributes {@code 保存成功在跳转页面发送的信息}
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbUser tbUser, Model model,RedirectAttributes redirectAttributes) {
        //保存成功
        BaseResult baseResult = tbUserService.save(tbUser);
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            redirectAttributes.addFlashAttribute(ConstantUtils.SESSION_BASERESULT,baseResult);
            return "redirect:/user/table";
        }
        //保存失败
        else {
            model.addAttribute(ConstantUtils.SESSION_BASERESULT, baseResult);
            return "form";
        }
    }

    /**
     * 搜索
     * @param keyword
     * @param model
     * @return
     */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    public String search(String keyword,Model model) {
        List<TbUser> tbUsers = tbUserService.search(keyword);
        model.addAttribute("tbUsers", tbUsers);
        return "table";
    }


    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public String delete() {
        return "redirect:/user/table";
    }
    /**
     * 返回用户信息
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idsArray = ids.split(",");
            tbUserService.deleteMulti(idsArray);
            baseResult = BaseResult.success("删除数据成功");
        }
        //删除数据失败
        else {
            baseResult = BaseResult.fail("删除数据失败");
        }
        return baseResult;
    }

}
