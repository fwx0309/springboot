package org.fwx.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @ClassName Worker
 * @Description TODO
 * @Author Fwx
 * @Date 2024/5/6 22:41
 * @Version 1.0
 */
@Profile("test")
@Data
@Component
@ConfigurationProperties(prefix = "person")
public class Worker implements PersonInterface{
    private String name;
    private Integer age;
}
