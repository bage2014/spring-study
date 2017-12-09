package com.bage.javaconfig;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;

import com.bage.javaconfig.Composing.AccountRepository;
import com.bage.javaconfig.Composing.SystemTestConfig;
import com.bage.javaconfig.Composing.TransferService;
import com.bage.javaconfig.basic.AppConfig;
import com.bage.javaconfig.basic.Foo;
import com.bage.javaconfig.basic.MyService;
import com.bage.javaconfig.configuration.AsyncCommand;
import com.bage.javaconfig.configuration.CommandManager;
import com.bage.javaconfig.profile.JndiDataConfig;
import com.bage.javaconfig.profile.StandaloneDataConfig;
import com.bage.javaconfig.profile.methodlevel.Dao;
import com.bage.javaconfig.propertySource.TestBean;

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
           
           // Profile // 没有完全按照官网
           // 类级别
           AnnotationConfigApplicationContext ctxx = new AnnotationConfigApplicationContext();
           ctxx.getEnvironment().setActiveProfiles(new String[]{"production"});
           ctxx.register(StandaloneDataConfig.class, JndiDataConfig.class);
           ctxx.refresh();
           DataSource dataSource = ctxx.getBean("profileDataSource",DataSource.class);
           System.out.println(dataSource);
           // 方法级别
           ctxx = new AnnotationConfigApplicationContext();
           //ctxx.getEnvironment().setActiveProfiles("production");// or development
           ctxx.register(com.bage.javaconfig.profile.methodlevel.AppConfig.class);
           ctxx.refresh();
           Dao methodlevelDao =  (Dao) ctxx.getBean("methodlevelDao");
           methodlevelDao.todo();
           // xml 配置
           String beansFilePathStr[] = {
   				"classpath:com/bage/javaconfig/profile/xml/development.xml", // src目录
   				"classpath:com/bage/javaconfig/profile/xml/production.xml",
   				"classpath:com/bage/javaconfig/profile/xml/default.xml",
           };
	        ClassPathXmlApplicationContext context =
	   		        new ClassPathXmlApplicationContext(beansFilePathStr);
	   		//context.getEnvironment().setActiveProfiles("development");
	   		context.getEnvironment().setActiveProfiles("default");
	           // ctxx.register(SomeConfig.class, StandaloneDataConfig.class, JndiDataConfig.class);
	   		context.refresh();
	   		System.out.println(context.getBean("baseTestDao"));  
	   		
	   		// 1.13.2. PropertySource abstraction
	   		Environment env = ctx.getEnvironment();
	   		boolean containsFoo = env.containsProperty("foo");
	   		System.out.println("Does my environment contain the 'foo' property? " + containsFoo);
	   		
	   		MutablePropertySources sources = ((ConfigurableEnvironment) env).getPropertySources();
	   		System.out.println(sources.size());
	   		
	   		// 方法级别
	        ctxx = new AnnotationConfigApplicationContext();
	        ctxx.register(com.bage.javaconfig.propertySource.AppConfig.class);
	        ctxx.refresh();
	        System.out.println(ctxx.getEnvironment().getProperty("name"));
	        // 注入属性
	        System.out.println(ctxx.getBean("propertySourceTestBean"));
	        // 或者
	        ((TestBean)ctxx.getBean("propertySourceTestBean")).setName(env.getProperty("testbean.name"));
	        // @PropertySource("classpath:/com/${my.placeholder:default/path}/app.properties")
	        ctxx = new AnnotationConfigApplicationContext();
	        ctxx.register(com.bage.javaconfig.propertySource.AppConfig2.class);
	        ctxx.refresh();
	        System.out.println(ctxx.getEnvironment().getProperty("name"));
	        System.out.println(ctxx.getEnvironment().getProperty("my.placeholder"));
	        // xml配置：<import resource="com/bank/service/${customer}-config.xml"/>
	        
	        // Registering a LoadTimeWeaver
	        // TODO
	        // 失败，详情参考： com.bage.javaconfig.loadtimeweaver.LoadTimeWeaverAppConfig
	
	        // 1.15. Additional Capabilities of the ApplicationContext
	        
	        // MessageSource
	        MessageSource resources = new ClassPathXmlApplicationContext("classpath:com/bage/javaconfig/messageSource/messageSource.xml");
	        System.out.println(resources.getMessage("message", null, "Default", null));
	
	        ApplicationContext ctxxs = new ClassPathXmlApplicationContext("classpath:com/bage/javaconfig/messageSource/messageSource.xml");
	        System.out.println(ctxxs.getEnvironment().getProperty("message"));
	        // TODO 未完成
	        
	}

}
