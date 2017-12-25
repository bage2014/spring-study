package com.bage.compilation;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class MyMessage {

	private String payload ;
	
	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public Object work() {
		SpelParserConfiguration config = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE,
			    this.getClass().getClassLoader());
		SpelExpressionParser parser = new SpelExpressionParser(config);
		Expression expr = parser.parseExpression("payload");
		MyMessage message = new MyMessage();
		expr.setValue(message, "payloadValue");
		Object payload = expr.getValue(message);
		return payload;
	}
	
}
