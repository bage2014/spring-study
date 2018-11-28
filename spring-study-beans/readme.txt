参考链接：
https://docs.spring.io/spring/docs/5.0.0.RC3/spring-framework-reference/core.html#beans-introduction
       
       
1.2. Container overview

1.2.1. Configuration metadata

1.2.2. Instantiating a container
启动容器：
1.2.3. Using the container


1.3. Bean overview

1.3.1. Naming beans

1.3.2. Instantiating beans
配置基本bean：
配置静态bean：


1.4. Dependencies
配置有依赖的bean：
		
配置获取带参数的bean：
       
内部类：   com.example.Foo$Bar
Notice the use of the $ character in the name to separate the nested class name from the outer class name.
       
       
循环依赖(用set方式可以避免)：       
One possible solution is to edit the source code of some classes to be configured by setters rather than constructors. Alternatively, avoid constructor injection and use setter injection only. In other words, although it is not recommended, you can configure circular dependencies with setter injection.      
       
## 2017-09-06 00:56     

设置各种值
The value of a map key or value, or a set value, can also again be any of the following elements:
bean | ref | idref | list | set | map | props | value | null  
      
1.4.3. Using depends-on 

1.4.4. Lazy-initialized beans

1.4.5. Autowiring collaborators

1.4.6. Method injection(不推荐，先进行跳过)
The preceding is not desirable, because the business code is aware of and coupled to the Spring Framework. Method Injection, a somewhat advanced feature of the Spring IoC container, allows this use case to be handled in a clean fashion.


1.5. Bean scopes

1.5.4. Request, session, application, and WebSocket scopes
## 2017-09-08 23:11   

Choosing the type of proxy to create //TODO
1.5.5. Custom scopes  //TODO
## 2017-09-28 22：00   


1.6. Customizing the nature of a bean

1.6.1. Lifecycle callbacks
Initialization callbacks
Destruction callbacks

Startup and shutdown callbacks //TODO

Shutting down the Spring IoC container gracefully in non-web applications

1.6.2. ApplicationContextAware and BeanNameAware //TODO


1.7. Bean definition inheritance

## 2017-09-30 22：22
1.8. Container Extension Points
1.8.1. Customizing beans using a BeanPostProcessor

1.8.2. Customizing configuration metadata with a BeanFactoryPostProcessor

1.8.3. Customizing instantiation logic with a FactoryBean //TODO


1.9. Annotation-based container configuration
一般使用 <context:component-scan base-package="com.bage.autowired" /> 来代替 <context:annotation-config />
如果xml和注解同时存在，注解优先级比较高

## 2017-10-08 22:10

1.9.1. @Required

1.9.2. @Autowired // TODO
## 2017-10-10 0:6
Autowired 注解的基本使用，包括setter方式、构造器、组合、数组集合、map、使用spring bean的使用

1.9.3. Fin-tuning annotation-based autowiring with @Primary
Autowired、Java Config、xml
## 2017-10-10 23:39

1.9.4. Fine-tuning annotation-based autowiring with qualifiers

You can create your own custom qualifier annotations. Simply define an annotation and provide the @Qualifier annotation within your definition:

## 2017-10-12 22:55
1.9.5. Using generics as autowiring qualifiers
## 2017-10-14 12:39        
        
1.9.6. CustomAutowireConfigurer 
// TODO // TODO     
 
1.9.7. @Resource       
 类似于 Autowired + Qualifier     
      
1.9.8. @PostConstruct and @PreDestroy 生命周期监控，单个bean
## 2017-10-24 23:21  


1.10. Classpath scanning and managed components
## 2017-11-02 23:53
Spring provides further stereotype annotations: @Component, @Service, and @Controller

1.10.1. @Component and further stereotype annotations

1.10.2. Meta-annotations

1.10.3. Automatically detecting classes and registering bean definitions

1.10.4. Using filters to customize scanning

1.10.5. Defining bean metadata within components
2017-11-03 22:12 

1.10.6. Naming autodetected components
2017-11-15 10:24
// TODO 将源码进行反编译改写，没有效果 // 进入了两次的generateBeanName方法

1.10.7. Providing a scope for autodetected components
// TODO MyScopeResolver 未实现

1.10.8. Providing qualifier metadata with annotations

1.10.9. Generating an index of candidate components
// 未实现
## 2017-11-06 23:31


1.11. Using JSR 330 Standard Annotations

1.11.1. Dependency Injection with @Inject and @Named
1.11.2. @Named and @ManagedBean: standard equivalents to the @Component annotation
1.11.3. Limitations of JSR-330 standard annotations //详见官网


1.12. Java-based container configuration

1.12.1. Basic concepts: @Bean and @Configuration

1.12.2. Instantiating the Spring container using AnnotationConfigApplicationContext
## 2017-11-07 23:30

Support for web applications with AnnotationConfigWebApplicationContext 
// TODO 当存在两个dispatcher时候访问不到

1.12.3. Using the @Bean annotation
Declaring a bean
Receiving lifecycle callbacks
Specifying bean scope
Customizing bean naming
Bean aliasing
Bean description

## 2017-11-09 23:32

1.12.4. Using the @Configuration annotation
Lookup method injection
Further information about how Java-based configuration works internally

1.12.5. Composing Java-based configurations
Using the @Import annotation
Injecting dependencies on imported @Bean definitions


## 2017-11-29 22:49
Conditionally include @Configuration classes or @Bean methods
// 未实现

Combining Java and XML configuration
XML-centric use of @Configuration classes
@Configuration class-centric use of XML with @ImportResource


1.13. Environment abstraction

1.13.1. Bean definition profiles

1.13.2. PropertySource abstraction

1.13.3. @PropertySource

## 2017-12-05 22:19
1.13.4. Placeholder resolution in statements

1.14. Registering a LoadTimeWeaver

1.15. Additional Capabilities of the ApplicationContext

1.15.1. Internationalization using MessageSource
## 2017-12-09 21：18

1.15.2. Standard and Custom Events
## 2017-12-11 21：55
## TODO 未完成
Annotation-based Event Listeners
Asynchronous Listeners


1.15.3. Convenient access to low-level resources
## 只有描述

1.15.4. Convenient ApplicationContext instantiation for web applications

1.15.5. Deploying a Spring ApplicationContext as a Java EE RAR file

1.16. The BeanFactory
## 尚未开始





        