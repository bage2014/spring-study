package com.bage;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bage.example.BusinessClass;
import com.xyz.myapp.SystemArchitecture;
import com.xyz.someapp.dao.DataAccessClass;
import com.xyz.someapp.dao.IDataAccess;
import com.xyz.someapp.service.IServiceBean;
import com.xyz.someapp.service.ServiceClass;
import com.xyz.someapp.trading.TradingClass;
import com.xyz.someapp.web.WebController1;
import com.xyz.someapp.web.WebController2;
import com.xyz.someapp.web.sub.WebControllerSub;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		
		// test 
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.register(com.xyz.someapp.AppConfig.class);
		context.register(com.xyz.myapp.AppConfig.class);
		
		context.refresh();
		
		// example
		// 切面配置参考： com.bage.example.ExampleAspect
		BusinessClass businessClass = (BusinessClass) context.getBean("businessClass");
		businessClass.doSomething();
		
		// 5.2.1. Enabling @AspectJ Support
		// 参考：/spring-study-aop/src/main/java/com/bage/AppConfig.java
		
		// 5.2.2. Declaring an aspect
		// 参考:/spring-study-aop/src/main/java/com/bage/aspect/NotVeryUsefulAspect.java
		// 或者：To enable @AspectJ support with XML based configuration use the aop:aspectj-autoproxy element： <aop:aspectj-autoproxy/>
		
		
		// 5.2.3. Declaring a pointcut
		// your classpath must include the AspectJ run-time Java archive
		// 参考: /spring-study-aop/src/main/java/com/bage/pointcut/SystemArchitecture.java
		businessClass.transfer(10);
		// anyPublicOperation 暂时被注释，会打印太多次了
		TradingClass tradingClass = context.getBean("tradingClass",TradingClass.class);
		tradingClass.trading();
		
		// in the com.xyz.someapp.web package or any sub-package
		WebController1 webController1 = context.getBean(WebController1.class);
		WebController2 webController2 = context.getBean(WebController2.class);
		WebControllerSub webControllerSub = context.getBean(WebControllerSub.class);
		webController1.method11();
		webController1.method12();
		webController2.method21();
		webController2.method22();
		webControllerSub.methodSub1();
		webControllerSub.methodSub2();

		// in the com.xyz.someapp.service package or any sub-package
		context.getBean(ServiceClass.class).method();
			
		// in the com.xyz.someapp.dao package or any sub-package
		context.getBean(DataAccessClass.class).method();
		
		// TODO
		context.getBean(IServiceBean.class).method();

		// TODO
		context.getBean(IDataAccess.class).method();
		
		
		// 5.2.4. Declaring advice
		// 外包类下的pointcut
		context.getBean(com.xyz.myapp.ServiceClass.class).method("hello world");
		// ordered // 默认以 方法名字典序执行
		System.out.println("---------------- ordered --------------------");
		context.getBean(com.xyz.myapp.dao.DataAccessClass.class).method();
		
		
		//context.getBean(SystemArchitecture.class).businessService();
		// TODO void com.bage.advice.Example.doAccessCheckAfterReturning(Object retVal)
		
	}
	
}
