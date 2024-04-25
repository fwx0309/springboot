package org.fwx.config;


import org.fwx.bean.Pet;
import org.fwx.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.filter.CharacterEncodingFilter;


/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、包扫描+组件标注注解的方式：@ComponentScan + 注解(@Controller,@Service,@Repository,@Component),局限性在于只有我们自己写的类才能使用此种方式
 * 3、Configuration 配置类本身也是组件
 *      proxyBeanMethods：代理bean的方法
 *          Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 *          Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 *          组件依赖必须使用Full模式默认。其他默认是否Lite模式
 *
 * 4、@Import({User.class, DBHelper.class})
 *      给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
 *
 *
 * 5、@ImportResource("classpath:beans.xml")导入Spring的配置文件，
 *
 * 6、@EnableConfigurationProperties
 */

@Import({User.class, Pet.class})            //给容器中添加组件的一种方式
@Configuration(proxyBeanMethods = false)    //告诉SpringBoot这是一个配置类 == 配置文件
//@ConditionalOnBean(name = "tom")          //按需配置的条件
@ConditionalOnMissingBean(name = "tom")     //按需配置的条件
@ImportResource("classpath:beans.xml")
//@EnableConfigurationProperties(Car.class)
//1、开启Car配置绑定功能
//2、把这个Car这个组件自动注册到容器中
public class MyConfig {


    /**
     * Full:外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     * @return
     */

    @Bean //给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
    public User user01(){
        User zhangsan = new User("zhangsan", 18);
        //user组件依赖了Pet组件
        //zhangsan.setPet(tomcatPet());
        return zhangsan;
    }

    @Bean("tom22")
    public Pet tomcatPet(){
        return new Pet("tomcat",11d);
    }


    // 如果自己定义编码过滤器，则会覆盖SpringBoot默认的编码过滤器
    /*@Bean
    public CharacterEncodingFilter filter(){
        return null;
    }*/
}
