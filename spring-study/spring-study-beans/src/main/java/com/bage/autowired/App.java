package com.bage.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

public class App {

	@Autowired
	 SayHello hello;
	
	public static void main(String[] args) {
		//System.out.println(hello);
		new App().test();
	}
	
	public void test(){
		String[] locations = {"applicationContextbeans.xml"};     
        ApplicationContext ctx =   
            new ClassPathXmlApplicationContext(locations); 
		System.out.println(hello);
	}
	
}
