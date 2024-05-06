package org.fwx.data;

import org.fwx.bean.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @ClassName DatasourceTest
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/28 12:48
 * @Version 1.0
 */
@SpringBootTest
public class DatasourceTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void test() {
        List<Customer> customers = jdbcTemplate.query("select id,name,email,birth from customers", new BeanPropertyRowMapper<>(Customer.class));
        System.out.println("customers = " + customers);
    }
}
