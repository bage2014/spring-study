package com.bage.javaconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration(value="javaAppConfig")
@ComponentScan(basePackages={"com.bage.javaconfig"})
public class AppConfig {

}
