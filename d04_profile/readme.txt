1、Profile功能 org.fwx.controller.ProfileController
    ● 默认配置文件  application.yaml；任何时候都会加载
    ● 指定环境配置文件  application-{env}.yaml
    ● 激活指定环境
      ○ 配置文件激活
      ○ 命令行激活：java -jar xxx.jar --spring.profiles.active=prod  --person.name=haha
        ■ 修改配置文件的任意值，命令行优先
    ● 默认配置与环境配置同时生效
    ● 同名配置项，profile配置优先

2、外部化配置
    1、外部配置源
    常用：Java属性文件、YAML文件、环境变量、命令行参数；

    2、配置文件查找位置
    (1) classpath 根路径
    (2) classpath 根路径下config目录
    (3) jar包当前目录
    (4) jar包当前目录的config目录
    (5) /config子目录的直接子目录(linux!!!)

    3、配置文件加载顺序：
    1. 　当前jar包内部的application.properties和application.yml
    2. 　当前jar包内部的application-{profile}.properties 和 application-{profile}.yml
    3. 　引用的外部jar包的application.properties和application.yml
    4. 　引用的外部jar包的application-{profile}.properties 和 application-{profile}.yml