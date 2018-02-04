package com.bage;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;

// 如果xml没有配置，可以使用@Aspect注解
public class NotVeryUsefulAspect {

	@Pointcut("execution(* transfer(..))")// the pointcut expression
	private void anyOldTransfer() { // the pointcut signature
		System.out.println("execution(* transfer(..)) is called ");
	}
	
	@After("com.bage.SystemArchitecture.dataAccessOperation()")
    public void doReleaseLock() {
		System.out.println("com.bage.SystemArchitecture.dataAccessOperation() is called ");
    }

}
