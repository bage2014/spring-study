package com.bage;

import com.bage.validation.Person;

public class Main {

	public static void main(String[] args) {
		
		Person p = new Person();
		p.setAge(-5);
		System.out.println(p);
		
		//Converter s = new ConverterFactory().getConverter(String.class);
		
	}
	
}
