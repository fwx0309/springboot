package org.fwx.service.impl;

import org.fwx.bean.User;
import org.fwx.mapper.UserMapper;
import org.fwx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Fwx
 * @Date 2024/5/2 16:44
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findById(Integer id) {
        return userMapper.selectById(id);
    }
}
