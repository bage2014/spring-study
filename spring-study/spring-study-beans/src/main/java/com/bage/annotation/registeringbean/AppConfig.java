package com.bage.annotation.registeringbean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration(value="registeringbeanAppConfig")
@ComponentScan(basePackages={"com.bage.annotation.registeringbean"})
public class AppConfig {

}
