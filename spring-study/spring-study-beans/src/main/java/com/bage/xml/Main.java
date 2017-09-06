package com.bage.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bage.xml.Innerclass.OuterClass.InnerClass;
import com.bage.xml.argument.ExampleBean;
import com.bage.xml.base.Demo;
import com.bage.xml.base.Example;
import com.bage.xml.base.Hello;
import com.bage.xml.circulardependencies.Bar;
import com.bage.xml.dependency.Foo;
import com.bage.xml.instance.ClientService;
import com.bage.xml.shortcut.ShortcutExampleBean;
import com.bage.xml.value.ValueInit;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		String beansFilePathStr[] = {
				"classpath:template.xml", // src目录
				"beans-in-resource.xml",// resources目录下
				"classpath:com/bage/xml/in-package.xml"  // 包下的配置文件
		};
		
		// 加载 spring 容器
		ApplicationContext context =
		        new ClassPathXmlApplicationContext(beansFilePathStr); 
		// beans.xml == classpath:beans.xml 等价
		
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
		
		
		
	}
}
