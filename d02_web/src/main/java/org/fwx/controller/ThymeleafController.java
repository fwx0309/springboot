package org.fwx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName ThymeleafController
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/25 19:38
 * @Version 1.0
 */
@Controller
public class ThymeleafController {

    @GetMapping("/thymeleaf")
    public String success(Model model){
        model.addAttribute("msg","hello success");
        model.addAttribute("urlbaidu","http://www.baidu.com");
        model.addAttribute("internal","/internal");
        return "success";
    }

    @GetMapping("/internal")
    public String internal(){
        return "success";
    }

}
