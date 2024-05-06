package org.fwx.service;

import org.fwx.bean.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CustomerService
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/29 8:42
 * @Version 1.0
 */

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Integer id);
}
