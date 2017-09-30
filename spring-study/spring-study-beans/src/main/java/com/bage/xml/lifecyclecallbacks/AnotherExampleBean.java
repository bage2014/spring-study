package com.bage.xml.lifecyclecallbacks;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 *  The container calls afterPropertiesSet() for the former and destroy() for the latter to allow the bean to perform certain actions upon initialization and destruction of your beans
 *  <br>还可以使用 @PostConstruct和@PreDestroy`注解
 * @author bage
 *
 */
public class AnotherExampleBean implements InitializingBean,DisposableBean  {
	
	/**
	 * come from InitializingBean class
	 */
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(" AnotherExampleBean.afterPropertiesSet() is work ");
	}

	/**
	 * come from DisposableBean class
	 */
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(" AnotherExampleBean.destroy() is work ");
	}
	
	/**
	 * custom init method
	 */
	public void init() {
		System.out.println(" AnotherExampleBean.init() is work ");
	}
	
	/**
	 * custom destroy method
	 */
	public void cleanup() {
		System.out.println(" AnotherExampleBean.cleanup() is work ");
	}
	
}
