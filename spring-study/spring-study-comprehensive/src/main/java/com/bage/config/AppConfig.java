package com.bage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bage.domain.JavaConfigBean;

@Configuration
public class AppConfig {

	@Bean
	public JavaConfigBean instanceJavaConfigBean(){
		return new JavaConfigBean();
	}
}
