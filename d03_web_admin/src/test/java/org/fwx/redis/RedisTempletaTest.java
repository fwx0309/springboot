package org.fwx.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @ClassName RedisTempletaTest
 * @Description TODO
 * @Author Fwx
 * @Date 2024/5/6 0:21
 * @Version 1.0
 */
@SpringBootTest
public class RedisTempletaTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void test(){
        ValueOperations<String, String> forValue = stringRedisTemplate.opsForValue();
        forValue.set("name","fwx");
        System.out.println(forValue.get("name"));
    }
}
