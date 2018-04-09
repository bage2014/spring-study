package com.xyz.myapp;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.bage.Logger;

@Component("myappSystemArchitectureOrdered")
@Aspect
public class SystemArchitectureOrdered {

	@Pointcut("execution(public * com.xyz.myapp.dao.DataAccessClass.method(..))")
	public void dataAccessOperation() {
		
	}
	
	@After("dataAccessOperation()")
	public void dataAccessOperationAfter1(){
		Logger.log("com.xyz.myapp.SystemArchitectureOrdered.dataAccessOperationAfter1() is work ");
	}
	@After("dataAccessOperation()")
	public void dataAccessOperationAfter2(){
		Logger.log("com.xyz.myapp.SystemArchitectureOrdered.dataAccessOperationAfter2() is work ");
	}
	
}
