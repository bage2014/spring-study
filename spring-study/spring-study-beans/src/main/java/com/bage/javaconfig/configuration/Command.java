package com.bage.javaconfig.configuration;

public class Command {

	private Object state;
	
	public void setState(Object state) {
		this.state = state;
	}

	public Object execute() {
		return state;
	}

}
