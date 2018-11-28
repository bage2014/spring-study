package com.bage.annotation.beanannotation;

public class TestBean {

	private String source;
	private TestBean spouse;
	private int country;
	
	public TestBean() {
		super();
	}

	public TestBean(String source, TestBean spouse, int country) {
		super();
		this.source = source;
		this.spouse = spouse;
		this.country = country;
	}

	public TestBean(String source) {
		this.source = source;
	}

	public TestBean(String source, int country) {
		this.source = source;
		this.country = country;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public TestBean getSpouse() {
		return spouse;
	}

	public void setSpouse(TestBean spouse) {
		this.spouse = spouse;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "TestBean [source=" + source + ", spouse=" + spouse + ", country=" + country + "]";
	}

	public void setCountry(String country) {
		this.country = 100;
		
	}
	

}
