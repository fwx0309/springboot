package org.fwx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName RequestAttributeController
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/23 20:28
 * @Version 1.0
 */
@Controller
public class RequestAttributeController {

    @GetMapping("/requestAttribute")
    public String requestAttribute(HttpServletRequest request) {
        request.setAttribute("msg","成功...");
        return "forward:success";
    }

    @GetMapping("/success")
    @ResponseBody
    public String success(@RequestAttribute("msg") String msg, HttpServletRequest request) {
        Object msg1 = request.getAttribute("msg");
        return msg + " " + msg1;
    }
}
