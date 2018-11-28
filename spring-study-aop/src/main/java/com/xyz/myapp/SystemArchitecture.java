package com.xyz.myapp;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.bage.Logger;

@Component("myappSystemArchitecture")
@Aspect
public class SystemArchitecture {

	@Pointcut("execution(public * com.xyz.myapp.ServiceClass.method(..))")
	public void dataAccessOperation() {
		
	}
	
	@After("dataAccessOperation()")
	public void dataAccessOperationAfter(){
		Logger.log("com.xyz.myapp.SystemArchitecture.dataAccessOperationAfter() is work ");
	}
	
}
