package com.bage.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bage.javaconfig.basic.AppConfig;
import com.bage.javaconfig.basic.MyService;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
			
		// 1.12. Java-based container configuration
		
		// 1.12.1. Basic concepts: @Bean and @Configuration
		// 详见 com.bage.javaconfig.basic.AppConfig，基本的配置;
		
		// 1.12.2. 初始化容器，启动容器
		   
		// 1 
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//        MyService myService = ctx.getBean(MyService.class);
//        myService.doStuff();
		
        // 2 
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//		  ctx.register(AppConfig.class, OtherConfig.class);
//        ctx.register(AdditionalConfig.class);
//        ctx.refresh();
//        MyService myService = ctx.getBean(MyService.class);
//        myService.doStuff();
		
		// 3
//		 	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//	        ctx.scan("com.bage.javaconfig");
//	        ctx.refresh();
//	        MyService myService = ctx.getBean(MyService.class);
//	        myService.doStuff();


		   ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		   MyService myService = ctx.getBean(MyService.class);
		   myService.doStuff();
		   
		   // Support for web applications with AnnotationConfigWebApplicationContext
		   // 详见web.xml ,但是存在一些问题，待修正
		   
		   // 1.12.3. 对 @Bean 注解的使用
		   // @Bean annotation in a @Configuration-annotated or in a @Component-annotated class.
		   // 详见 com.bage.javaconfig.basic.AppConfig，基本的配置;
		   
		   // 1.12.4. 使用@Configuration注解
		   // 详见 com.bage.javaconfig.basic.AppConfig，基本的配置;
		   
	}

}
