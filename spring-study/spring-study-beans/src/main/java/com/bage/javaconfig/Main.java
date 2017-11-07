package com.bage.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bage.javaconfig.basic.AdditionalConfig;
import com.bage.javaconfig.basic.AppConfig;
import com.bage.javaconfig.basic.MyService;
import com.bage.javaconfig.basic.OtherConfig;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
			
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
		
	}

}
