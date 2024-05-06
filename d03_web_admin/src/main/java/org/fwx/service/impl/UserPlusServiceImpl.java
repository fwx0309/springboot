package org.fwx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fwx.bean.User;
import org.fwx.mapper.UserMapper;
import org.fwx.service.UserPlusService;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserPlusServiceImpl
 * @Description TODO
 * @Author Fwx
 * @Date 2024/5/3 21:07
 * @Version 1.0
 */
@Service
public class UserPlusServiceImpl extends ServiceImpl<UserMapper, User> implements UserPlusService {

}
