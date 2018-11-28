package com.bage.javaconfig.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdditionalConfig {

        @Bean
        public MyService myService() {
                return new MyServiceImpl();
        }

}

//@Configuration(value="javaAppConfig")
//@ComponentScan(basePackages={"com.bage.javaconfig"})
//public class AppConfig {
//
//}
