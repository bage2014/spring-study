package com.xyz.myapp;

import org.springframework.stereotype.Service;

@Service("myappServiceClass")
public class ServiceClass {
	
	public void method(){
		System.out.println("com.xyz.someapp.service.ServiceClass.method() is work" );
	}
	
}
