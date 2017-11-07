package com.bage.javaconfig.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.bage.javaconfig")
public class WebMVCConfig {

        @Bean
        public MyService myService() {
                return new MyServiceImpl();
        }

}

