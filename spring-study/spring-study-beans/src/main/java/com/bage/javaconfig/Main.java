package com.bage.javaconfig;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bage.javaconfig.Composing.AccountRepository;
import com.bage.javaconfig.Composing.SystemTestConfig;
import com.bage.javaconfig.Composing.TransferService;
import com.bage.javaconfig.basic.AppConfig;
import com.bage.javaconfig.basic.Foo;
import com.bage.javaconfig.basic.MyService;
import com.bage.javaconfig.configuration.AsyncCommand;
import com.bage.javaconfig.configuration.CommandManager;

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
		   
		   
		   // Support for web applications with AnnotationConfigWebApplicationContext
		   // 详见web.xml ,但是存在一些问题，待修正
		   
		   // 1.12.3. 对 @Bean 注解的使用
		   // @Bean annotation in a @Configuration-annotated or in a @Component-annotated class.
		   // 详见 com.bage.javaconfig.basic.AppConfig，基本的配置 和 readme.txt;
		   MyService myService = ctx.getBean(MyService.class);
		   myService.doStuff();
		   
		   // 1.12.4. 使用@Configuration注解
		   // 详见 com.bage.javaconfig.basic.AppConfig，基本的配置;
		   Foo foo = ctx.getBean(Foo.class);
		   System.out.println(foo.toString());
		   // Lookup method injection
		   AsyncCommand AayncCommand = ctx.getBean(AsyncCommand.class);
		   System.out.println(AayncCommand);
		   AayncCommand = ctx.getBean(AsyncCommand.class);
		   System.out.println(AayncCommand);
		   CommandManager commandManager = ctx.getBean(CommandManager.class);
		   System.out.println(commandManager);
		   commandManager = ctx.getBean(CommandManager.class);
		   System.out.println(commandManager);
		   // Further information about how Java-based configuration works internally
		   Object clientService = ctx.getBean("clientService1");
		   System.out.println(clientService);
		   clientService = ctx.getBean("clientService2");
		   System.out.println(clientService);
		   
		   // 1.12.5. Composing Java-based configurations
		   // Using the @Import annotation
		   // ApplicationContext ctxImport = new AnnotationConfigApplicationContext(ConfigB.class);
		   // Injecting dependencies on imported @Bean definitions
		   ctx = new AnnotationConfigApplicationContext(SystemTestConfig.class);
	       TransferService transferService = ctx.getBean(TransferService.class);
	       System.out.println(transferService);
	       // Conditionally include @Configuration classes or @Bean methods
	       // 未实现
	       
	       // Combining Java and XML configuration
	       ApplicationContext ctt = new ClassPathXmlApplicationContext("classpath:/com/bage/javaconfig/combining/system-test-config.xml");
           AccountRepository combiningAccountRepository = ctt.getBean("combiningAccountRepository",AccountRepository.class);
           System.out.println(combiningAccountRepository);
           ctt = new AnnotationConfigApplicationContext(com.bage.javaconfig.importresource.AppConfig.class);
           DataSource importresourceDataSource = ctt.getBean("importresourceDataSource",DataSource.class);
           System.out.println(importresourceDataSource);
           
           
           
           
	}

}
