package com.bage.xml.inheritedbean;

public class InheritedTestBean {

	protected String name;
	protected Integer age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "InheritedTestBean [name=" + name + ", age=" + age + "]";
	}
	
	
}
