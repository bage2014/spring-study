package com.bage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.bage.domain.JavaConfigBean;

@Configuration
@ImportResource("classpath:/com/bage/config/appConfig.xml")
public class AppConfig {
	
	@Bean
	public JavaConfigBean instanceJavaConfigBean(){
		return new JavaConfigBean();
	}
	
}
