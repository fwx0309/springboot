package org.fwx.service.impl;

import org.fwx.bean.Customer;
import org.fwx.service.CustomerService;
import org.fwx.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CustomerServiceImpl
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/29 8:43
 * @Version 1.0
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> findAll() {
        return customerMapper.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        Customer customer = customerMapper.findById(id);
        return customer;
    }
}
