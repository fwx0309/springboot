1、登录和主页跳转
    org.fwx.controller.IndexController

2、抽取公告html页面
    src/main/resources/templates/common.html

3、表格显示
    org.fwx.controller.TableController

4、登录拦截器
    interceptor org.fwx.interceptor.LoginInterceptor

5、自定义异常
    定制错误处理逻辑
    ● 自定义错误页 src/main/resources/static/error
      ○ error/404.html   error/5xx.html；有精确的错误状态码页面就匹配精确，没有就找 4xx.html；如果都没有就触发白页

    ● @ControllerAdvice+@ExceptionHandler   org.fwx.exception.GlobalExceptionHandler.handleException
        ○ 处理全局异常；底层是 ExceptionHandlerExceptionResolver 支持的

    ● @ResponseStatus+自定义异常 ；   org.fwx.exception.ResponseStatusException
        ○ 底层是 ResponseStatusExceptionResolver ，把responsestatus注解的信息底层调用 response.sendError(statusCode, resolvedReason)；tomcat发送的/error

    ● Spring底层的异常：response.sendError   org.fwx.controller.IndexController.main
      ○ 如 参数类型转换异常；DefaultHandlerExceptionResolver 处理框架底层的异常。
      ○ response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());

    ● 自定义实现 HandlerExceptionResolver 处理异常；org.fwx.exception.CustomerHandlerExceptionResolver.resolveException
      ○ 可以作为默认的全局异常处理规则
      ○ @Order(value = Ordered.HIGHEST_PRECEDENCE)  // MIN_VALUE = -2147483648 优先级，数字越小优先级越高，比@ResponseStatus+自定义异常、@ControllerAdvice+@ExceptionHandler的优先级高

    ● ErrorViewResolver  实现自定义处理异常；
      ○ response.sendError 。error请求就会转给controller
      ○ 你的异常没有任何人能处理。tomcat底层 response.sendError。error请求就会转给controller
      ○ basicErrorController 要去的页面地址是 ErrorViewResolver

6、原生组件注入servlet、filter、listener
    注解方式
    register**bean方式：org.fwx.servlet.MyRegistConfig

7、数据访问mybatis
    @Mapper或@MapperScan("org/fwx/mapper")
    xml和注解，建议复杂的sql用xml

8、mybatis-plus
    ● MybatisPlusAutoConfiguration 配置类，MybatisPlusProperties 配置项绑定。mybatis-plus：xxx 就是对mybatis-plus的定制
    ● SqlSessionFactory 自动配置好。底层是容器中默认的数据源
    ● mapperLocations 自动配置好的。有默认值。classpath*:/mapper/**/*.xml；任意包的类路径下的所有mapper文件夹下任意路径下的所有xml都是sql映射文件。  建议以后sql映射文件，放在 mapper下
    ● 容器中也自动配置好了 SqlSessionTemplate
    ● @Mapper 标注的接口也会被自动扫描；建议直接 @MapperScan("com.atguigu.admin.mapper") 批量扫描就行
    yml日志配置

9、整合redis
    统计uri数量小功能：org.fwx.interceptor.UrlCountInterceptor

10、JUnit5
    ● @Test :表示方法是测试方法。但是与JUnit4的@Test不同，他的职责非常单一不能声明任何属性，拓展的测试将会由Jupiter提供额外测试
    ● @ParameterizedTest :表示方法是参数化测试，下方会有详细介绍
    ● @RepeatedTest :表示方法可重复执行，下方会有详细介绍
    ● @DisplayName :为测试类或者测试方法设置展示名称
    ● @BeforeEach :表示在每个单元测试之前执行
    ● @AfterEach :表示在每个单元测试之后执行
    ● @BeforeAll :表示在所有单元测试之前执行
    ● @AfterAll :表示在所有单元测试之后执行
    ● @Tag :表示单元测试类别，类似于JUnit4中的@Categories
    ● @Disabled :表示测试类或测试方法不执行，类似于JUnit4中的@Ignore
    ● @Timeout :表示测试方法运行如果超过了指定时间将会返回错误
    ● @ExtendWith :为测试类或测试方法提供扩展类引用

11、指标监控
    添加pom依赖，yml配置
    最常用的Endpoint
    ● Health：监控状况
    ● Metrics：运行时指标
    ● Loggers：日志记录