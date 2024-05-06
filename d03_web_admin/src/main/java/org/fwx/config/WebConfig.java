package org.fwx.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.fwx.interceptor.LoginInterceptor;
import org.fwx.interceptor.UrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebConfig
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/26 23:40
 * @Version 1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private UrlCountInterceptor urlCountInterceptor;
    /**
     * 添加登录拦截器到拦截器注册表中。
     * 这个方法会将一个自定义的LoginInterceptor实例添加到拦截器链中，
     * 并定义哪些请求路径应该被这个拦截器拦截，同时排除一些不需要拦截的路径。
     *
     * @param registry 拦截器注册表，用于添加和管理拦截器。
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加LoginInterceptor拦截器，拦截所有请求，但排除登录页面和静态资源请求
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") // 指定拦截所有路径
                .excludePathPatterns("/","/login","/css/**","/js/**","/images/**","/fonts/**","/favicon.ico","/error/**","/druid/**","/actuator/**"); // 排除不需要拦截的路径

        // 添加
        registry.addInterceptor(urlCountInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/js/**","/images/**","/fonts/**","/favicon.ico","/error/**","/druid/**","/actuator/**");
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        // 开启 count 的 join 优化,只针对部分 left join

        //这是分页拦截器
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        paginationInnerInterceptor.setOverflow(true);
        paginationInnerInterceptor.setMaxLimit(500L);
        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);
        return mybatisPlusInterceptor;
    }

}
