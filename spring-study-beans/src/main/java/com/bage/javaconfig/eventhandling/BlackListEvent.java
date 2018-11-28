package com.bage.javaconfig.eventhandling;

import org.springframework.context.ApplicationEvent;

public class BlackListEvent extends ApplicationEvent{

	private static final long serialVersionUID = 1L;

	public BlackListEvent(Object source) {
		super(source);
		System.out.println("BlackListEvent");

	}

	
}
