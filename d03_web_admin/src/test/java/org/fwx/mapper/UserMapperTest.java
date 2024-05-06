package org.fwx.mapper;

import org.fwx.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName UserMapperTest
 * @Description TODO
 * @Author Fwx
 * @Date 2024/5/2 16:31
 * @Version 1.0
 */
@SpringBootTest
public class UserMapperTest {

    @Autowired
    public UserMapper userMapper;
    @Test
    public void findById() {
        User user = userMapper.selectById(1);
        System.out.println("user = " + user);
    }
}
