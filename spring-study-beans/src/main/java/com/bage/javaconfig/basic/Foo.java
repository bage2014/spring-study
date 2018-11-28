package com.bage.javaconfig.basic;

public class Foo {

	private Bar bar;
	
	public Foo(Bar bar) {
		this.bar = bar;
	}

	@Override
	public String toString() {
		return "Foo [bar=" + bar + "]";
	}
	
}
