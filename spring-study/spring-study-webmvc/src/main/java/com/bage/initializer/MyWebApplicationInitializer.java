package com.bage.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

        @Override
        protected Class<?>[] getRootConfigClasses() {
                return null;
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
                return new Class[] { MyWebConfig.class };
        }

        @Override
        protected String[] getServletMappings() {
                return new String[] { "/" };
        }

        // If using XML-based Spring configuration, you should extend directly from AbstractDispatcherServletInitializer:
//        @Override
//        protected WebApplicationContext createServletApplicationContext() {
//                XmlWebApplicationContext cxt = new XmlWebApplicationContext();
//                cxt.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");
//                return cxt;
//        }
}