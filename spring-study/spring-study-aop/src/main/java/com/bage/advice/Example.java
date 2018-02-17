package com.bage.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

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
	
	// please note that around advice is required to declare a first parameter of type ProceedingJoinPoint
	// Around advice
	@Around("com.xyz.myapp.SystemArchitecture.businessService()")
    public Object doBasicProfilingAround(ProceedingJoinPoint pjp) throws Throwable {
            // start stopwatch
            Object retVal = pjp.proceed();
            // stop stopwatch
            return retVal;
    }
	
	// Passing parameters to advice
	@Before("com.xyz.myapp.SystemArchitecture.dataAccessOperation() && args(account,..)")
	public void validateAccountArgs(Account account) {
	        // ...
			// The args(account,..) part of the pointcut expression serves two purposes: firstly, it restricts matching to only those method executions where the method takes at least one parameter, and the argument passed to that parameter is an instance of Account; secondly, it makes the actual Account object available to the advice via the account parameter.
	}
	
	// Another way of writing this is to declare a pointcut that "provides" the Account object
	@Pointcut("com.xyz.myapp.SystemArchitecture.dataAccessOperation() && args(account,..)")
	private void accountDataAccessOperationArgs2(Account account) {}
	@Before("accountDataAccessOperation(account)")
	public void validateAccountArgs2(Account account) {
	        // ...
	}
	// Another way of writing this is to declare a pointcut that "provides" the Account object
	
}

class Account{
	
}