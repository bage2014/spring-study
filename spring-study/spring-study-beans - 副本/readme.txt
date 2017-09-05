
#上下文：

AnnotationConfigApplicationContext：
从一个或多个基于Java的配置类中加载Spring应用上下文。

AnnotationConfigWebApplicationContext：
从一个或多个基于Java的配置类中加载Spring Web应用上下文。

ClassPathXmlApplicationContext：
从类路径下的一个或多个XML配置文件中加载上下文定义，把应用上下文的定义文件作为类资源
。
FileSystemXmlapplicationcontext：
从文件系统下的一个或多个XML配置文件中加载上下文定义。

XmlWebApplicationContext：
从Web应用下的一个或多个XML配置文件中加载上下文定义。

#生命周期：
1．Spring对bean进行实例化；
2．Spring将值和bean的引用注入到bean对应的属性中；
3．如果bean实现了BeanNameAware接口，Spring将bean的ID传递给setBean-Name()方法；
4．如果bean实现了BeanFactoryAware接口，Spring将调用setBeanFactory()方法，将BeanFactory容器实例传入；
5．如果bean实现了ApplicationContextAware接口，Spring将调用setApplicationContext()方法，将bean所在的应用上下文的引用传入进来；
6．如果bean实现了BeanPostProcessor接口，Spring将调用它们的post-ProcessBeforeInitialization()方法；
7．如果bean实现了InitializingBean接口，Spring将调用它们的after-PropertiesSet()方法。类似地，如果bean使用init-method声明了初始化方法，该方法也会被调用；
8．如果bean实现了BeanPostProcessor接口，Spring将调用它们的post-ProcessAfterInitialization()方法；
9．此时，bean已经准备就绪，可以被应用程序使用了，它们将一直驻留在应用上下文中，直到该应用上下文被销毁；
10．如果bean实现了DisposableBean接口，Spring将调用它的destroy()接口方法。同样，如果bean使用destroy-method声明了销毁方法，该方法也会被调用。
