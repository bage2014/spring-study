package com.bage.annotation.namingcomponents;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("namingcomponentsAppConfig")
@ComponentScan(basePackages = "com.bage.annotation.namingcomponents", 
	nameGenerator = MyNameGenerator.class) // 配置自定义命名规则
public class AppConfig {

}
