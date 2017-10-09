package com.bage.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bage.Template;

public class Main {

	public static void main(String[] args) {
		String beansFilePathStr[] = { "classpath:com/bage/autowired/template.xml" };

		// 加载 spring 容器
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(beansFilePathStr);
		// 获取一个基本bean
		Template template = context.getBean("template", Template.class);
		System.out.println(template);
		
		// 自动注入
		SayHelloImp sayHelloImp = context.getBean("sayHelloImp", SayHelloImp.class);
		System.out.println(sayHelloImp);
		
		
	}

}
