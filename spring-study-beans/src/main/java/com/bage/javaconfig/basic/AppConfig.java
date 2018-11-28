package com.bage.javaconfig.basic;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration("basicAppConfig")
@ComponentScan(basePackages = "com.bage.javaconfig")
public class AppConfig {

	// @Bean
	// @Bean(name = "myFoo") //Customizing bean naming
	@Bean(initMethod = "init", destroyMethod = "cleanup") // Receiving lifecycle callbacks
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // Specifying bean scope
	// ConfigurableBeanFactory.SCOPE_SINGLETON
	// ConfigurableBeanFactory.SCOPE_PROTOTYPE
	// WebApplicationContext.SCOPE_REQUEST
	// WebApplicationContext.SCOPE_SESSION
	// WebApplicationContext.SCOPE_GLOBAL_SESSION
	// WebApplicationContext.SCOPE_APPLICATION
	// proxyMode=ScopedProxyMode.DEFAULT
	// proxyMode=ScopedProxyMode.INTERFACES
	// proxyMode=ScopedProxyMode.NO
	// proxyMode=ScopedProxyMode.TARGET_CLASS
	// @Bean(name = { "dataSource", "subsystemA-dataSource", "subsystemB-dataSource" }) //Bean aliasing
	// @Description("Provides a basic example of a bean") // Bean description
	public MyService myService() {
		return new MyServiceImpl();
	}

	@Bean
    public Foo foo() {
            return new Foo(bar());
    }
	@Bean
    public Bar bar() {
            return new Bar();
    }
}

