package com.shuke.my.shop.web.admin.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * <p>
 * 文件上传控制器
 * </p>
 *
 * @author shuke
 * @version v1.0.0
 * @since 2020-03-06 11:22:21
 * @see com.shuke.my.shop.web.admin.web.controller
 *
 */
@Controller
public class UploadController {
    private static final String UPLOAD_PATH = "/static/upload/";
    /**
     * 文件上传
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public Map<String,Object> upload(MultipartFile dropFile, MultipartFile editorFile,HttpServletRequest req) {
        Map<String, Object> result = new HashMap<>();

        //前端上传文件
        MultipartFile myFile = dropFile == null ? editorFile : dropFile;
        //文件名
        String fileName = myFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        //文件存放路径
        String filePath = req.getSession().getServletContext().getRealPath(UPLOAD_PATH);
        //文件存放路径
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
        //将文件写入目录
        file = new File(filePath, UUID.randomUUID()+fileSuffix);
        try {
            myFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Dropzone上传
        if (dropFile != null) {
            result.put("fileName", UPLOAD_PATH + file.getName());
        }
        //wangEditor上传
        else {
            //获取服务器地址
            String severPath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort();
            result.put("errno", 0);
            result.put("data", new String[]{severPath + UPLOAD_PATH + file.getName()});
        }
        return result;
    }
}
