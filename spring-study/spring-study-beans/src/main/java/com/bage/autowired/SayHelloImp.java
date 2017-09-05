package com.bage.autowired;

import org.springframework.stereotype.Service;

@Service
public class SayHelloImp implements SayHello {

	/* (non-Javadoc)
	 * @see com.bage.autowired.SayHello#sayHello(java.lang.String)
	 */
	public String sayHello(String text){
		return "hello ," + text;
	}
}
