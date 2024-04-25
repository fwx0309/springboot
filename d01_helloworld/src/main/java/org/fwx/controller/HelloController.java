package org.fwx.controller;

import org.fwx.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/22 14:49
 * @Version 1.0
 */
@RestController
public class HelloController {

    @Autowired
    Person person;

    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }



    @RequestMapping("/person")
    public Person person(){

        String userName = person.getUserName();
        System.out.println(userName);
        return person;
    }
}
