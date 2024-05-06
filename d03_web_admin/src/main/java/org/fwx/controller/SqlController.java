package org.fwx.controller;

import org.fwx.bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName SqlController
 * @Description 测试druid监控
 * @Author Fwx
 * @Date 2024/4/28 20:59
 * @Version 1.0
 */
@Controller
public class SqlController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @ResponseBody
    @GetMapping("/sql")
    public String testDruidView() {
        List<Customer> query = jdbcTemplate.query("select id,name,email,birth from customers", new BeanPropertyRowMapper<>(Customer.class));
        return query.toString();
    }
}
