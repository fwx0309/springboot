package org.fwx.config;

import org.fwx.bean.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @ClassName Myconfig
 * @Description TODO
 * @Author Fwx
 * @Date 2024/5/6 22:45
 * @Version 1.0
 */
@Configuration
public class Myconfig {

    @Profile("prod")
    @Bean
    public Color red(){
        return new Color("red");
    }

    @Profile("test")
    @Bean
    public Color blue(){
        return new Color("blue");
    }
}
