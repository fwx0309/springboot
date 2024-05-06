package org.fwx.controller;

import org.fwx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Fwx
 * @Date 2024/5/2 16:46
 * @Version 1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/user/{id}")
    public String findById(@PathVariable("id") Integer id){
        return userService.findById(id).toString();
    }
}
