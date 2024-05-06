package org.fwx.service;

import org.fwx.bean.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author Fwx
 * @Date 2024/5/2 16:43
 * @Version 1.0
 */
public interface UserService {
    User findById(Integer id);
}
