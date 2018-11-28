package com.bage.annotation;

import org.springframework.stereotype.Service;

@Service // 默认名字 sayHelloImp
public class SayHelloImp implements SayHello {

	/* (non-Javadoc)
	 * @see com.bage.autowired.SayHello#sayHello(java.lang.String)
	 */
	public String sayHello(String text){
		return "hello ," + text;
	}
}
