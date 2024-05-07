package org.fwx.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName Person
 * @Description TODO
 * @Author Fwx
 * @Date 2024/5/6 22:27
 * @Version 1.0
 */
@Data
@ToString
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
    private Integer age;
}
