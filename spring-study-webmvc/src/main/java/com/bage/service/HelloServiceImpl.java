package com.bage.service;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceImpl implements HelloService {
	
	/* (non-Javadoc)
	 * @see com.bage.service.HelloService#sayHello(java.lang.String)
	 */
	public String sayHello(String text){
		
		return "hello, " + text;
	}

}
