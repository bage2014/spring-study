package com.bage.literalexpressions;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Example {

	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();
		// evals to "Hello World"
		String helloWorld = (String) parser.parseExpression("'Hello World'").getValue();
		System.out.println(helloWorld);
		double avogadrosNumber = (Double) parser.parseExpression("6.0221415E+23").getValue();

		// evals to 2147483647
		int maxValue = (Integer) parser.parseExpression("0x7FFFFFFF").getValue();

		boolean trueValue = (Boolean) parser.parseExpression("true").getValue();

		Object nullValue = parser.parseExpression("null").getValue();
	}
	
}
