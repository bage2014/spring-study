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
       
       
循环依赖：       
One possible solution is to edit the source code of some classes to be configured by setters rather than constructors. Alternatively, avoid constructor injection and use setter injection only. In other words, although it is not recommended, you can configure circular dependencies with setter injection.      
       
## 2017-09-06 0:56       
       
       
        