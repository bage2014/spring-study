package com.bage.javaconfig.propertySource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("propertySourceTestBean")
public class TestBean {

	@Value("${name}")
	private String name;

	@Override
	public String toString() {
		return "TestBean [name=" + name + "]";
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
