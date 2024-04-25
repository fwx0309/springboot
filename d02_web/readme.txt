1、静态资源访问            spring.banner.image.location
2、webjars               pom.xml
3、网站小图标             src/main/resources/static/favicon.ico
4、restfull请求方式      spring.mvc.hiddenmethod.filter.enabled

5、mvc 请求参数
    @PathVariable、@RequestHeader、@RequestParam、@CookieValue、@RequestBody、@MatrixVariable(org.fwx.config.WebConfig->WebMvcConfigurer->configurePathMatch)

6、自定义请求参数类型转换 org.fwx.config.WebConfig->WebMvcConfigurer->addFormatters

7、内容协商，自定义内容协商。根据客户端接收能力不同，返回不同媒体类型的数据。
    添加xml的pom
    HeaderContentNegotiation：请求header匹配
    用于ParameterContentNegotiation：请求参数匹配

    1)扩展消息转换器列表，用于HeaderContentNegotiation中的自定义扩展功能。 org.fwx.config.WebConfig->WebMvcConfigurer->extendMessageConverters

    2)自定义内容协商策略。用于ParameterContentNegotiation、HeaderContentNegotiation中的自定义扩展功能。    org.fwx.config.WebConfig->WebMvcConfigurer->configureContentNegotiation

    测试controller：org.fwx.controller.ResponseController.getPerson
