package com.bage;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bage.example.BusinessClass;

public class Main {
	
	public static void main(String[] args) {
		
		
		// test 
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();
		
		// example
		// 切面配置参考： com.bage.example.ExampleAspect
		BusinessClass businessClass = (BusinessClass) context.getBean("businessClass");
		businessClass.doSomething();
		
		// 5.2.1. Enabling @AspectJ Support
		// 参考：/spring-study-aop/src/main/java/com/bage/AppConfig.java
		
		// 5.2.2. Declaring an aspect
		// 或者：To enable @AspectJ support with XML based configuration use the aop:aspectj-autoproxy element： <aop:aspectj-autoproxy/>
		
		// 5.2.3. Declaring a pointcut
		// your classpath must include the AspectJ run-time Java archive
		// 参考: com.bage.NotVeryUsefulAspect
		
		// 5.2.4. Declaring advice
		
	}
	
}
