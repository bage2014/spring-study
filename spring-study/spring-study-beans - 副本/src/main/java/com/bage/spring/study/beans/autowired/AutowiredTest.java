package com.bage.spring.study.beans.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes=MyConfiguration.class)
public class AutowiredTest {

	@Autowired
	private HelloBean hello;
	
	public static void main(String[] args) {
		new AutowiredTest().testautowired();
	}
	
	public void testautowired(){
		System.out.println(hello);
	}
	
}
