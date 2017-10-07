package com.bage.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bage.xml.Innerclass.OuterClass.InnerClass;
import com.bage.xml.argument.ExampleBean;
import com.bage.xml.autowiringcollaborators.byname.CumputerBean;
import com.bage.xml.base.Demo;
import com.bage.xml.base.Example;
import com.bage.xml.base.Hello;
import com.bage.xml.circulardependencies.Bar;
import com.bage.xml.containerextensionpoints.MyDataSource;
import com.bage.xml.dependency.Foo;
import com.bage.xml.dependson.ManagerBean;
import com.bage.xml.inheritedbean.InheritedTestBean;
import com.bage.xml.inheritedbean.InheritsWithDifferentClass;
import com.bage.xml.instance.ClientService;
import com.bage.xml.lazyinit.BaseBean;
import com.bage.xml.lifecyclecallbacks.AnotherExampleBean;
import com.bage.xml.scopes.singleton.DefaultAccountService;
import com.bage.xml.shortcut.ShortcutExampleBean;
import com.bage.xml.value.ValueInit;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		String beansFilePathStr[] = {
				"classpath:com/bage/xml/template.xml", // src目录
				"classpath:src.xml", // src目录
				"beans-in-resource.xml",// resources目录下
				"classpath:com/bage/xml/in-package.xml"  // 包下的配置文件
		};
		
		// 加载 spring 容器
		ApplicationContext context =
		        new ClassPathXmlApplicationContext(beansFilePathStr); 
//		ConfigurableApplicationContext context =
//				new ClassPathXmlApplicationContext(beansFilePathStr); //Shutting down the Spring IoC container gracefully in non-web applications
		// beans.xml == classpath:beans.xml 等价
		// add a shutdown hook for the above context...Shutting down the Spring IoC container gracefully in non-web applications
		// context.registerShutdownHook();
        
		// 获取一个基本bean
		Template template = context.getBean("template",Template.class);
		System.out.println(template);
		// 获取一个基本bean
		Example example = context.getBean("example",Example.class);
		System.out.println(example);
		Demo demo = context.getBean("demo",Demo.class);
		System.out.println(demo);
		Hello hello = context.getBean("hello",Hello.class);
		System.out.println(hello);
		
		
		// 获取一个静态bean
		ClientService clientService = context.getBean("clientService",ClientService.class);
		System.out.println(clientService);
		
		// 获取一个内部bean
		InnerClass innerClass = context.getBean("innerClass",InnerClass.class);
		innerClass.test();
		
		// 获取带有依赖的bean
		Foo foo = context.getBean("foo",Foo.class);
		System.out.println(foo);
		
		// 获取带参数的bean
		ExampleBean exampleBean = context.getBean("exampleBean1",ExampleBean.class);
		System.out.println(exampleBean);
		ExampleBean exampleBean2 = context.getBean("exampleBean2",ExampleBean.class);
		System.out.println(exampleBean2);
		ExampleBean exampleBean3 = context.getBean("exampleBean3",ExampleBean.class);
		System.out.println(exampleBean3);
		
		// 循环依赖
		Bar circularBar = context.getBean("circularBar",Bar.class);
		System.out.println(circularBar);
		
		// 赋值依赖
		ValueInit valueInit = context.getBean("valueInit",ValueInit.class);
		System.out.println(valueInit.toString());
		
		// 赋值简写依赖
		ShortcutExampleBean shortcutExampleBean = context.getBean("shortcutExampleBean",ShortcutExampleBean.class);
		System.out.println(shortcutExampleBean.toString());
		
		// 依赖依赖(静态资源)
		ManagerBean managerBean = context.getBean("managerBean",ManagerBean.class);
		System.out.println(managerBean);
		//System.out.println(managerBean.getBaseBean());
		
		// 懒加载(<!-- <beans default-lazy-init="true"> 全体类进行懒加载  -->   )
		BaseBean lazyinitBaseBean = context.getBean("lazyinitBaseBean",BaseBean.class);
		System.out.println(lazyinitBaseBean);
		
		// Autowiring collaborators
		// byname
		CumputerBean cumputerBean = context.getBean("cumputerBean",CumputerBean.class);
		System.out.println(cumputerBean);
		// bytype
		com.bage.xml.autowiringcollaborators.bytype.CumputerBean cumputerBean2 = context.getBean("cumputerBean2",com.bage.xml.autowiringcollaborators.bytype.CumputerBean.class);
		System.out.println(cumputerBean2);
		// constructor
		com.bage.xml.autowiringcollaborators.constructor.CumputerBean cumputerBean3 = context.getBean("cumputerBean3",com.bage.xml.autowiringcollaborators.constructor.CumputerBean.class);
		System.out.println(cumputerBean3);
		
		// Bean scopes
		// singleton 默认的 + 前面的都是单例模式( accountService1 == accountService2 )
		DefaultAccountService accountService1 = context.getBean("accountService",DefaultAccountService.class);
		System.out.println(accountService1);
		DefaultAccountService accountService2 = context.getBean("accountService",DefaultAccountService.class);
		System.out.println(accountService2);
		// prototype( accountService1 != accountService2 )
		com.bage.xml.scopes.prototype.DefaultAccountService prototypeAccountService1 = context.getBean("prototypeAccountService",com.bage.xml.scopes.prototype.DefaultAccountService.class);
		System.out.println(prototypeAccountService1);
		com.bage.xml.scopes.prototype.DefaultAccountService prototypeAccountService2 = context.getBean("prototypeAccountService",com.bage.xml.scopes.prototype.DefaultAccountService.class);
		System.out.println(prototypeAccountService2);
		
		// lifecycle callbacks
		AnotherExampleBean anotherExampleBean = context.getBean("anotherExampleBean",AnotherExampleBean.class);
		System.out.println(anotherExampleBean);
		
		
		// Bean definition inheritance
		InheritedTestBean inheritedTestBean = context.getBean("inheritedTestBean",InheritedTestBean.class);
		System.out.println(inheritedTestBean.toString());
		InheritsWithDifferentClass inheritsWithDifferentClass = context.getBean("inheritsWithDifferentClass",InheritsWithDifferentClass.class);
		System.out.println(inheritsWithDifferentClass.toString());
		
		// Customizing beans using a BeanPostProcessor
		// 只需要配置一下就好：<bean class="com.bage.xml.containerextensionpoints.InstantiationTracingBeanPostProcessor" />
		
		// Customizing configuration metadata with a BeanFactoryPostProcessor
		MyDataSource myDataSource = context.getBean("myDataSource",MyDataSource.class);
		System.out.println(myDataSource.toString());
		
	}
}
