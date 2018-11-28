package com.bage;

import org.springframework.expression.AccessException;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;

public class MyBeanResolver implements BeanResolver {

	public Object resolve(EvaluationContext context, String beanName) throws AccessException {
		return new Foo();
	}

}
class Foo{
	
}
