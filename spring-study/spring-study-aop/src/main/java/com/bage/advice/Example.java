package com.bage.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.bage.Logger;

@Component
@Aspect
public class Example {

	// Before advice
	@Before("com.xyz.myapp.SystemArchitecture.dataAccessOperation()") // Before advice is declared in an aspect using the @Before annotation
    public void doAccessCheckBefore() {
			//  Logger.log("com.bage.advice.Example.doAccessCheckBefore() is work");
    }
	
	@Before("execution(* com.xyz.myapp.dao.*.*(..))") // using an in-place pointcut expression
    public void doAccessCheckBeforeInplace() { 
            // 	Logger.log("com.bage.advice.Example.doAccessCheckBeforeInplace() is work");
    }
	
	
	// After returning advice
	@AfterReturning("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
    public void doAccessCheckAfterReturning() {
           // Logger.log("com.bage.advice.Example.doAccessCheckAfterReturning() is work");
    }
	
	@AfterReturning(
            pointcut="com.xyz.myapp.SystemArchitecture.dataAccessOperation()",
            returning="retVal")
    public void doAccessCheckAfterReturning(Object retVal) { // Sometimes you need access in the advice body to the actual value that was returned
        	// Logger.log("com.bage.advice.Example.doAccessCheckAfterReturning() is work:" + retVal);
    }
	
	
	// After throwing advice
	// 人为模拟 throw new Exception();
	@AfterThrowing("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
    public void doRecoveryActionsAfterThrowing() {
		// Logger.log("com.bage.advice.Example.doRecoveryActionsAfterThrowing() is work:");
    }
	
	@AfterThrowing(
            pointcut="com.xyz.myapp.SystemArchitecture.dataAccessOperation()",
            throwing="ex")
    public void doRecoveryActionsAfterThrowing(Exception ex) { 	// Often you want the advice to run only when exceptions of a given type are thrown
													// DataAccessException 改为 Exception
		// Logger.log("com.bage.advice.Example.doRecoveryActionsAfterThrowing("+ex+") is work:");
    }
	
	
	// After (finally) advice
	@After("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
    public void doReleaseLockAfter() {
		// Logger.log("com.bage.advice.Example.doReleaseLockAfter() is work");
    }
	
	
	// please note that around advice is required to declare a first parameter of type ProceedingJoinPoint
	// Around advice
	@Around("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
    public Object doBasicProfilingAround(ProceedingJoinPoint pjp) throws Throwable {
            // start stopwatch
			// Logger.log("com.bage.advice.Example.doBasicProfilingAround(ProceedingJoinPoint pjp) start stopwatch is work");

            Object retVal = pjp.proceed();
            // stop stopwatch
			// Logger.log("com.bage.advice.Example.doBasicProfilingAround(ProceedingJoinPoint pjp) stop stopwatch is work");

            return retVal;
    }
	
	// Passing parameters to advice
	@Before("com.xyz.myapp.SystemArchitecture.dataAccessOperation() && args(str,..)")
	public void validateAccountArgs(String str) {
	        // ...
			// The args(account,..) part of the pointcut expression serves two purposes: firstly, it restricts matching to only those method executions where the method takes at least one parameter, and the argument passed to that parameter is an instance of Account; secondly, it makes the actual Account object available to the advice via the account parameter.
			// Logger.log("com.bage.advice.Example.validateAccountArgs(String str)：" + str );	
	}
	
	// Another way of writing this is to declare a pointcut that "provides" the obj object
	@Pointcut("com.xyz.myapp.SystemArchitecture.dataAccessOperation() && args(obj,..)")
	private void accountDataAccessOperationArgs2(Object obj) {}
	@Before("accountDataAccessOperationArgs2(obj)")
	public void validateAccountArgs2(Object obj) {
	        // ...
	}
	// Another way of writing this is to declare a pointcut that "provides" the Account object
	
}