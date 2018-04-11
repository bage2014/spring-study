

https://docs.spring.io/spring/docs/5.0.0.RC3/spring-framework-reference/web.html#spring-web



This part of the reference documentation covers Spring Framework’s support for the presentation tier (and specifically web-based presentation tiers) including support for WebSocket-style messaging in web applications.

1. Web MVC framework

1.1. Introduction to Spring Web MVC framework
The Spring Web model-view-controller (MVC) framework is designed around a DispatcherServlet that dispatches requests to handlers, with configurable handler mappings, view resolution, locale, time zone and theme resolution as well as support for uploading files. The default handler is based on the @Controller and @RequestMapping annotations, offering a wide range of flexible handling methods. With the introduction of Spring 3.0, the @Controller mechanism also allows you to create RESTful Web sites and applications, through the @PathVariable annotation and other features.


