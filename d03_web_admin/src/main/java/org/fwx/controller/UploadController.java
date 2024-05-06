package org.fwx.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName UploadController
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/27 9:20
 * @Version 1.0
 */
@Slf4j
@Controller
public class UploadController {

    @GetMapping("/form_layouts")
    public String  form_layouts(){
        return "/form/form_layouts";
    }

    /**
     * 处理用户头像和照片上传的请求。
     *
     * @param email 用户的电子邮箱地址。
     * @param username 用户的用户名。
     * @param headerImg 用户的头像图片文件。
     * @param photos 用户的其他照片数组。
     * @return 返回一个字符串指示操作页面跳转到"main"。
     * @throws IOException 如果在文件操作过程中发生错误。
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        // 记录上传请求的日志
        log.info("上传的信息：email={},username={},headerImg={},photos={}",email,username,headerImg.getSize(),photos.length);

        // 创建上传文件的目标目录
        File file = new File("./upload");
        String absolutePath = file.getAbsolutePath();
        if (!file.exists()){
            file.mkdirs();
        }

        // 上传头像图片
        if (headerImg.getSize() > 0) {
            headerImg.transferTo(new File(absolutePath,headerImg.getOriginalFilename()));
        }

        // 上传其他照片
        if (photos.length > 0){
            for (MultipartFile photo : photos) {
                photo.transferTo(new File(absolutePath,photo.getOriginalFilename()));
            }
        }

        return "main";
    }

}
