package org.fwx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName RestfullController
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/23 18:08
 * @Version 1.0
 */
@RestController
public class RestfullController {

    /**
     * 处理用户相关的GET请求。
     * <p>
     * 该方法不需要接收任何参数，也不返回任何业务数据，仅在控制台输出一条信息。
     */
    @GetMapping("/user")
    public String get(){
       return "restfull get";
    }

    @PostMapping("/user")
    public String post(){
        return "restfull post";
    }

    @PutMapping("/user")
    public String put(){
        return "restfull put";
    }

    @DeleteMapping("/user")
    public String delete(){
        return "restfull delete";
    }
}
