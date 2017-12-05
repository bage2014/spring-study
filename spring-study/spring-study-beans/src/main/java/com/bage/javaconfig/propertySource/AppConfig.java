package com.bage.javaconfig.propertySource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@ComponentScan(basePackageClasses=TestBean.class)
@Configuration("propertySourceAppConfig")
@PropertySource("classpath:com/bage/javaconfig/propertySource/app.properties")
public class AppConfig {
	
	@Autowired
	Environment env;
	
}
