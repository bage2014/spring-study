package com.bage.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bage.javaconfig.basic.SimpleMovieLister;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
			
		ApplicationContext cxt = new ClassPathXmlApplicationContext(); 
		SimpleMovieLister simpleMovieLister = cxt.getBean("simpleMovieLister", SimpleMovieLister.class);
		System.out.println(simpleMovieLister);
		
		
		
	}

}
