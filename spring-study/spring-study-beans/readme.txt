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
      
1.9.8. @PostConstruct and @PreDestroy
## 2017-10-24 23:21  
        