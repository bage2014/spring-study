package com.bage.example;

import org.springframework.stereotype.Component;

@Component("businessClass")
public class BusinessClass {

	public void doSomething(){
		System.out.println("com.bage.example.BusinessClass.doSomething() is work");
	}
	
}
