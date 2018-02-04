package com.bage;

import org.springframework.stereotype.Component;

@Component("demoBean")
public class DemoBean {

	public void transfer() {
		System.out.println("com.bage.DemoBean.transfer() is called ");
	}
}
