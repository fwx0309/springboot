package org.fwx.controller;

import org.fwx.bean.Person;
import org.fwx.bean.PersonInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProfileController
 * @Description TODO
 * @Author Fwx
 * @Date 2024/5/6 22:12
 * @Version 1.0
 */
@RestController
public class ProfileController {

    @Value("${person.name:controller}")
    private String name;

    @Autowired
    private Person person;

    @Autowired
    private PersonInterface personInterface;

    @GetMapping("/test")
    public String test(){
        return name;
    }

    @GetMapping("/test2")
    public String test2(){
        return person.toString();
    }

    @GetMapping("/test3")
    public String test3(){
        return personInterface.getClass().toString();
    }
}
