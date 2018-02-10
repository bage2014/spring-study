package com.bage.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Example {

	// Before advice
	@Before("com.xyz.myapp.SystemArchitecture.dataAccessOperation()") // Before advice is declared in an aspect using the @Before annotation
    public void doAccessCheckBefore() {
			// ...
    }
	
	@Before("execution(* com.xyz.myapp.dao.*.*(..))") // using an in-place pointcut expression
    public void doAccessCheckBeforeInplace() { 
            // ...
    }
	
	
	// After returning advice
	@AfterReturning("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
    public void doAccessCheckAfterReturning() {
            // ...
    }
	
	@AfterReturning(
            pointcut="com.xyz.myapp.SystemArchitecture.dataAccessOperation()",
            returning="retVal")
    public void doAccessCheckAfterReturning(Object retVal) { // Sometimes you need access in the advice body to the actual value that was returned
            // ...
    }
	
	
	// After throwing advice
	@AfterThrowing("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
    public void doRecoveryActionsAfterThrowing() {
            // ...
    }
	
	@AfterThrowing(
            pointcut="com.xyz.myapp.SystemArchitecture.dataAccessOperation()",
            throwing="ex")
    public void doRecoveryActionsAfterThrowing(Exception ex) { 	// Often you want the advice to run only when exceptions of a given type are thrown
													// DataAccessException 改为 Exception
            // ...
    }
	
	
	// After (finally) advice
	@After("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
    public void doReleaseLockAfter() {
            // ...
    }
	
	
	// Around advice
	@Around("com.xyz.myapp.SystemArchitecture.businessService()")
    public Object doBasicProfilingAround(ProceedingJoinPoint pjp) throws Throwable {
            // start stopwatch
            Object retVal = pjp.proceed();
            // stop stopwatch
            return retVal;
    }
	
	
}
