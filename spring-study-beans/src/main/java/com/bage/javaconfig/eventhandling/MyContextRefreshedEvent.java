package com.bage.javaconfig.eventhandling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;

public class MyContextRefreshedEvent extends ContextRefreshedEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyContextRefreshedEvent(ApplicationContext source) {
		super(source);
		System.out.println("MyContextRefreshedEvent");

	}
	
	

}
