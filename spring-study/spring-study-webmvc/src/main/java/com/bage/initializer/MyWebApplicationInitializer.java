package com.bage.initializer;

import javax.servlet.ServletContext;

import org.springframework.web.WebApplicationInitializer;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext container) {
//  		  ServletRegistration.Dynamic registration = container.addServlet("example", new DispatcherServlet());
//            registration.setLoadOnStartup(1);
//            registration.addMapping("/example/*");
    }

}
