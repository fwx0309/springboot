package org.fwx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@ServletComponentScan("org.fwx.servlet")  // 方式一、扫描Servlet组件
@MapperScan("org.fwx.mapper")
@SpringBootApplication
public class D03WebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(D03WebAdminApplication.class, args);
    }

}
