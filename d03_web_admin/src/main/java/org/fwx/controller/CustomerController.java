package org.fwx.controller;

import org.fwx.bean.Customer;
import org.fwx.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CustomerController
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/29 8:44
 * @Version 1.0
 */
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @ResponseBody
    @GetMapping("/customer")
    public String getAll(){
        return customerService.findAll().toString();
    }

    @ResponseBody
    @GetMapping("/customer/{id}")
    public String findById(@PathVariable("id") Integer id){
        Customer customer = customerService.findById(id);
        return customer.toString();
    }
}
