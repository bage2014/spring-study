package com.bage.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
    public void onStartup(ServletContext container) {
            ServletRegistration.Dynamic registration = container.addServlet("example", new DispatcherServlet());
            registration.setLoadOnStartup(1);
            registration.addMapping("/example/*");
    }

}
