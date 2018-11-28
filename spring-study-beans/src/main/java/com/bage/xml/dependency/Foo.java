package com.bage.xml.dependency;

public class Foo {

	private Bar bar;
	private Baz baz;
	
    public Foo(Bar bar, Baz baz) {
    	this.bar = bar;
    	this.baz = baz;
    }

	@Override
	public String toString() {
		return "Foo [bar=" + bar + ", baz=" + baz + "]";
	}

}
