package com.bage;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackageClasses=DemoBean.class)
@EnableAspectJAutoProxy
@ImportResource("com/bage/template.xml")
public class AppConfig {

}
