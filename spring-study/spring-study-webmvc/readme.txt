

https://docs.spring.io/spring/docs/5.0.0.RC3/spring-framework-reference/web.html#spring-web



This part of the reference documentation covers Spring Framework’s support for the presentation tier (and specifically web-based presentation tiers) including support for WebSocket-style messaging in web applications.

1. Web MVC framework

1.1. Introduction to Spring Web MVC framework
The Spring Web model-view-controller (MVC) framework is designed around a DispatcherServlet that dispatches requests to handlers, with configurable handler mappings, view resolution, locale, time zone and theme resolution as well as support for uploading files. The default handler is based on the @Controller and @RequestMapping annotations, offering a wide range of flexible handling methods. With the introduction of Spring 3.0, the @Controller mechanism also allows you to create RESTful Web sites and applications, through the @PathVariable annotation and other features.

1.2. The DispatcherServlet
Figure 1. The request processing workflow in Spring Web MVC (high level)
Figure 2. Typical context hierarchy in Spring Web MVC
Figure 3. Single root context in Spring Web MVC


1.2.1. Special Bean Types In the WebApplicationContext

1.2.2. Default DispatcherServlet Configuration

1.3. Implementing Controllers
To enable autodetection of such annotated controllers, you add component scanning to your configuration

Path Patterns
## TODO

Note that to enable the use of matrix variables, you must set the removeSemicolonContent property of RequestMappingHandlerMapping to false. By default it is set to true.

1.3.3. Defining @RequestMapping handler methods
## 2018-04-16 22:26









