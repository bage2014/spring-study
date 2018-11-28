package com.xyz.myapp;

import org.springframework.stereotype.Service;

@Service("myappServiceClass")
public class ServiceClass {
	
	public String method(String helloText) throws Exception{
		System.out.println("com.xyz.someapp.service.ServiceClass.method("+helloText+") is work" );
		// throw new Exception();
		return helloText;
		
	}
	
}
