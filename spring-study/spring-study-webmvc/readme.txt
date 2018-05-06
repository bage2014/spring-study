

https://docs.spring.io/spring/docs/5.0.0.RC3/spring-framework-reference/web.html#spring-web



This part of the reference documentation covers Spring Framework’s support for the presentation tier (and specifically web-based presentation tiers) including support for WebSocket-style messaging in web applications.

1. Web MVC framework

1.1. Introduction to Spring Web MVC framework
The Spring Web model-view-controller (MVC) framework is designed around a DispatcherServlet that dispatches requests to handlers, with configurable handler mappings, view resolution, locale, time zone and theme resolution as well as support for uploading files. The default handler is based on the @Controller and @RequestMapping annotations, offering a wide range of flexible handling methods. With the introduction of Spring 3.0, the @Controller mechanism also allows you to create RESTful Web sites and applications, through the @PathVariable annotation and other features.

1.2. The DispatcherServlet
Figure 1. The request processing workflow in Spring Web MVC (high level)
Figure 2. Typical context hierarchy in Spring Web MVC
Figure 3. Single root context in Spring Web MVC

使用例子：
.xml配置：
<!-- 
	需要 web.xml的example-servlet.xml 相关配置, 
	不启用com.bage.initializer.MyWebApplicationInitializer 
	不启用 com.bage.initializer.WebAppInitializer
	 -->
.no web.xml 配置
<!-- 不需要 web.xml的example-servlet.xml 相关配置, 
	启用com.bage.initializer.MyWebApplicationInitializer 
	不启用 com.bage.initializer.WebAppInitializer
	 -->
.java 配置 + WebAppInitializer
<!-- 
	不需要 web.xml的example-servlet.xml 相关配置, 
	不启用com.bage.initializer.MyWebApplicationInitializer 
	启用 com.bage.initializer.WebAppInitializer
	-->

1.2.1. Special Bean Types In the WebApplicationContext

1.2.2. Default DispatcherServlet Configuration

1.3. Implementing Controllers
To enable autodetection of such annotated controllers, you add component scanning to your configuration

Path Patterns
## TODO

Note that to enable the use of matrix variables, you must set the removeSemicolonContent property of RequestMappingHandlerMapping to false. By default it is set to true.

1.3.3. Defining @RequestMapping handler methods
## 2018-04-16 22:26



Advising controllers with @ControllerAdvice and @RestControllerAdvice
## 2018-04-20 21:44
Check out the @ControllerAdvice documentation for more details.

@JsonView、Jackson JSONP Support
## TODO

1.3.5. Testing Controllers

1.5. Resolving views
<bean id="viewResolver"
                class="org.springframework.web.servlet.view.UrlBasedViewResolver">
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <property name="suffix" value=".jsp"/>
</bean>



1.7. Building URIs

1.11. Handling exceptions
## 2018-04-22 20:25

1.11.6. Customizing the Default Servlet Container Error Page
web.xml 配置：
<error-page>
        <location>/error</location>
</error-page>


1.13.1. The Controller ControllerClassNameHandlerMapping

1.13.2. The Model ModelMap (ModelAndView)

1.14.2. HTTP caching support for static resources

1.14.3. Support for the Cache-Control, ETag and Last-Modified response headers in Controllers


Java-based Spring configuration:
##TODO

1.16.1. Enabling the MVC Java Config or the MVC XML Namespace
## 2018-04-24 22:07

1.16.9. Serving of Resources
void com.bage.initializer.WebAppConfig.addResourceHandlers(ResourceHandlerRegistry registry)
== <mvc:resources mapping="/resources/**" location="/public-resources/"/>

2.5.1. View resolvers


3.3. Global CORS configuration
void com.bage.initializer.WebAppConfig.addCorsMappings(CorsRegistry registry)
xml:
<mvc:cors>

        <mvc:mapping path="/api/**"
                allowed-origins="http://domain1.com, http://domain2.com"
                allowed-methods="GET, PUT"
                allowed-headers="header1, header2, header3"
                exposed-headers="header1, header2" allow-credentials="false"
                max-age="123" />

        <mvc:mapping path="/resources/**"
                allowed-origins="http://domain1.com" />

</mvc:cors>



