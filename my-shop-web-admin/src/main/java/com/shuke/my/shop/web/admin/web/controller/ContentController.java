package com.shuke.my.shop.web.admin.web.controller;

import com.shuke.my.shop.commons.constants.ConstantUtils;
import com.shuke.my.shop.commons.dto.BaseResult;
import com.shuke.my.shop.domain.TbContent;
import com.shuke.my.shop.web.admin.service.TbContentService;
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


/**
 *
 * <p>
 * 内容管理
 * </p>
 *
 * @author shuke
 * @version v1.0.0
 * @since 2020-03-04 22:00:30
 * @see com.shuke.my.shop.web.admin.web.controller
 *
 */
@Controller
@RequestMapping(value = "content")
public class ContentController {
    @Autowired
    private TbContentService tbContentService;

    @ModelAttribute
    public TbContent getTbContent(Long id) {
        TbContent tbContent = null;
        //id不为空则返回tbContent
        if (id != null) {
            tbContent = tbContentService.getById(id);
        }
        //为空则重新创建tbContent,为了不使前端映射显示空指令异常
        else {
            tbContent = new TbContent();
        }
        return tbContent;
    }
    /**
     * 跳转到用户列表
     *
     * @param
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String table(Model model) {
        List<TbContent> tbContents = tbContentService.selectAll();
        model.addAttribute("tbContents", tbContents);
        return "content_list";
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "content_form";
    }

    /**
     * 保存内容信息
     * @param tbContent
     * @param model {@code 保存失败在本页面发送的信息}
     * @param redirectAttributes {@code 保存成功在跳转页面发送的信息}
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbContent tbContent, Model model, RedirectAttributes redirectAttributes) {
        //保存成功
        BaseResult baseResult = tbContentService.save(tbContent);
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            redirectAttributes.addFlashAttribute(ConstantUtils.SESSION_BASERESULT,baseResult);
            return "redirect:/content/list";
        }
        //保存失败
        else {
            model.addAttribute(ConstantUtils.SESSION_BASERESULT, baseResult);
            return "content_form";
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
        List<TbContent> tbContents = tbContentService.search(keyword);
        model.addAttribute("tbContents", tbContents);
        return "list";
    }


    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public String delete() {
        return "redirect:/content/list";
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
            tbContentService.deleteMulti(idsArray);
            baseResult = BaseResult.success("删除数据成功");
        }
        //删除数据失败
        else {
            baseResult = BaseResult.fail("删除数据失败");
        }
        return baseResult;
    }
}
