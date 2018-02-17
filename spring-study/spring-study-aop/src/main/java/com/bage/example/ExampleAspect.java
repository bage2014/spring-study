package com.bage.example;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component // 也要加上
public class ExampleAspect {

	@Pointcut("execution(* *.doSomething())")
	public void pointcut(){
		
	}
	
	@Before("pointcut()")
	public void before(){
		System.out.println("com.bage.example.ExampleAspect.before() is work");
	}
	
	@After("com.bage.example.ExampleAspect.pointcut()")
	public void after(){
		System.out.println("com.bage.example.ExampleAspect.after() is work");
	}
	
}
