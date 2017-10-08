package com.bage.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bage.Template;

public class Main {

	@Autowired
	SayHello hello;

	public static void main(String[] args) {
		String beansFilePathStr[] = {
				"classpath:com/bage/autowired/template.xml"
		};
		
		// 加载 spring 容器
		ApplicationContext context =
		        new ClassPathXmlApplicationContext(beansFilePathStr); 
		// 获取一个基本bean
				Template template = context.getBean("template",Template.class);
				System.out.println(template);
	}

}
