package com.bage.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.bage.Logger;

/**
 * <br> execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)	
 * <br> The full AspectJ pointcut language supports additional pointcut designators that are not supported in Spring. 
 * <br> These are: call, get, set, preinitialization, staticinitialization, initialization, handler, adviceexecution, withincode, cflow, cflowbelow, if, @this, and @withincode. 
 * <br> Use of these pointcut designators in pointcut expressions interpreted by Spring AOP will result in an IllegalArgumentException being thrown.
 * <br> 另：Pointcut expressions can be combined using '&&', '||' and '!'. (XML 要把 && 换成 and)	
 * 
 * @author bage
 *
 */
@Component
@Aspect // Declaring a pointcut
public class SystemArchitecture {

		@Pointcut("execution(* transfer(..))")// the pointcut expression
		private void anyOldTransfer() {}// the pointcut signature
		@Before("anyOldTransfer()")
		public void anyOldTransferBefore(){
			Logger.log("Pointcut com.bage.pointcut.SystemArchitecture.anyOldTransfer() is work ");
		}
		
		
		// Combining pointcut expressions
		@Pointcut("execution(public * *(..))")
		private void anyPublicOperation() {}
		@Before("anyPublicOperation()")
		public void anyPublicOperationBefore(){
			Logger.log("Pointcut com.bage.pointcut.SystemArchitecture.anyPublicOperation() is work ",false);
		}
		
		@Pointcut("within(com.xyz.someapp.trading..*)")
		private void inTrading() {}
		@Before("inTrading()")
		public void inTradingBefore(){
			Logger.log("Pointcut com.bage.pointcut.SystemArchitecture.inTrading() is work ");
		}
		
		@Pointcut("anyPublicOperation() && inTrading()")
		private void tradingOperation() {}
		@Before("tradingOperation()")
		public void tradingOperationBefore(){
			Logger.log("Pointcut com.bage.pointcut.SystemArchitecture.tradingOperation() is work ");
		}
		
		
		
		// Sharing common pointcut definitions
        /**
         * A join point is in the web layer if the method is defined
         * in a type in the com.xyz.someapp.web package or any sub-package
         * under that.
         */
        @Pointcut("within(com.xyz.someapp.web..*)")
        public void inWebLayer() {}
        @Before("inWebLayer()")
		public void inWebLayerBefore(){
			Logger.log("Pointcut com.bage.pointcut.SystemArchitecture.inWebLayer() is work ");
		}
        /**
         * A join point is in the service layer if the method is defined
         * in a type in the com.xyz.someapp.service package or any sub-package
         * under that.
         */
        @Pointcut("within(com.xyz.someapp.service..*)")
        public void inServiceLayer() {}

        /**
         * A join point is in the data access layer if the method is defined
         * in a type in the com.xyz.someapp.dao package or any sub-package
         * under that.
         */
        @Pointcut("within(com.xyz.someapp.dao..*)")
        public void inDataAccessLayer() {}

        /**
         * A business service is the execution of any method defined on a service
         * interface. This definition assumes that interfaces are placed in the
         * "service" package, and that implementation types are in sub-packages.
         *
         * If you group service interfaces by functional area (for example,
         * in packages com.xyz.someapp.abc.service and com.xyz.someapp.def.service) then
         * the pointcut expression "execution(* com.xyz.someapp..service.*.*(..))"
         * could be used instead.
         *
         * Alternatively, you can write the expression using the 'bean'
         * PCD, like so "bean(*Service)". (This assumes that you have
         * named your Spring service beans in a consistent fashion.)
         */
        @Pointcut("execution(* com.xyz.someapp..service.*.*(..))")
        public void businessService() {}

        /**
         * A data access operation is the execution of any method defined on a
         * dao interface. This definition assumes that interfaces are placed in the
         * "dao" package, and that implementation types are in sub-packages.
         */
        @Pointcut("execution(* com.xyz.someapp.dao.*.*(..))")
        public void dataAccessOperation() {}

        
        
        // The pointcuts defined in such an aspect can be referred to anywhere that you need a pointcut expression. For example, to make the service layer transactional, you could write:
        /*
        	<aop:config>
        	        <aop:advisor
        	                pointcut="com.xyz.someapp.SystemArchitecture.businessService()"
        	                advice-ref="tx-advice"/>
        	</aop:config>

        	<tx:advice id="tx-advice">
        	        <tx:attributes>
        	                <tx:method name="*" propagation="REQUIRED"/>
        	        </tx:attributes>
        	</tx:advice>
        	
        */
        
        
        
}
