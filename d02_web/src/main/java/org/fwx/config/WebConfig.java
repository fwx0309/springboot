package org.fwx.config;

import org.fwx.bean.Pet;
import org.fwx.converter.MyConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Myconfig
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/23 20:51
 * @Version 1.0
 */

@Configuration(proxyBeanMethods = false)    // 没有和ioc容器中其它组件关联时，设置为false可以加快容器启动速度
// 开启矩阵变量功能，方式2 implements WebMvcConfigurer 重写 configurePathMatch 方法
public class WebConfig /*implements WebMvcConfigurer*/ {

    /**
     * 开启矩阵变量功能，方式1 自己注册一个 WebMvcConfigurer bean
     * 创建并返回一个WebMvcConfigurer实例，用于自定义Spring MVC的路径匹配配置。
     * @return WebMvcConfigurer - 一个实现了WebMvcConfigurer接口的对象，用于配置Spring MVC路径匹配行为。
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer(){
            /**
             * 该函数用于配置路径匹配的方式。它通过创建一个UrlPathHelper实例，
             * 并将其设置为不移除;后面的内容来启用矩阵变量功能。然后，将该UrlPathHelper实例设置为PathMatchConfigurer的属性。
             * @param configurer
             */
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                // 不移除；后面的内容。矩阵变量功能就可以生效
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            /**
             * 注册自定义的转换器(这里用于矩阵数据转换)，用于将字符串转换为Pet对象。
             */
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {
                    @Override
                    public Pet convert(String source) {
                        if(!source.isEmpty()){
                            String[] split = source.split(",");
                            Pet pet = new Pet();
                            pet.setName(split[0]);
                            pet.setAge(Integer.parseInt(split[1]));
                            return pet;
                        }
                        return null;
                    }
                });
            }


            /**
             * 扩展消息转换器列表。
             * 该方法通过向提供的消息转换器列表中添加一个新的自定义转换器（MyConverter）来扩展消息转换器的能力。
             *
             * @param converters 一个包含当前消息转换器的列表，该列表将被添加一个新的MyConverter实例。
             */
            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                // 向消息转换器列表中添加自定义转换器
                converters.add(new MyConverter());
            }

            /**
             * 自定义内容协商策略。
             * 该方法重写configureContentNegotiation方法，用于配置如何通过请求参数或请求头来确定客户端所需的内容格式。
             * @param configurer ContentNegotiationConfigurer的实例，用于配置内容协商。
             */
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                // 创建一个HashMap用于映射媒体类型别名到对应的MediaType对象
                HashMap<String, MediaType> hashMap = new HashMap<>();
                hashMap.put("json", MediaType.APPLICATION_JSON);
                hashMap.put("xml", MediaType.APPLICATION_XML);
                hashMap.put("my", MediaType.parseMediaType("application/x-my"));

                // 配置基于请求参数的内容协商策略
                ParameterContentNegotiationStrategy parameterContentNegotiationStrategy = new ParameterContentNegotiationStrategy(hashMap);
                // 设置请求参数的名称，默认为format
                // parameterContentNegotiationStrategy.setParameterName("format");

                // 配置基于请求头的内容协商策略
                HeaderContentNegotiationStrategy headerContentNegotiationStrategy = new HeaderContentNegotiationStrategy();

                // 将上述两种策略组合并应用
                // 这里需要注意，如果同时使用了这两种策略，那么请求参数和请求头中同时存在时，优先使用请求参数 parameterContentNegotiationStrategy。！！！
                configurer.strategies(Arrays.asList(parameterContentNegotiationStrategy,headerContentNegotiationStrategy));
            }

        };
    }


    /**
     * 开启矩阵变量功能，方式2
     * @param configurer
     */
    /*@Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }*/
}
