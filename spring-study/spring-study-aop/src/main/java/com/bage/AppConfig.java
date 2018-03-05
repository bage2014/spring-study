package com.bage;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackageClasses=BasePackageClass.class)
@EnableAspectJAutoProxy // 启用Spring Aop功能 
@ImportResource("com/bage/template.xml")
public class AppConfig {

}
