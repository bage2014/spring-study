package com.bage.annotation.beanannotation;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
public class FactoryMethodComponent {

	private static int i;

	@Bean(value="testBean")
	@Qualifier("public") // || @Scope, @Lazy, and custom qualifier annotations.
	public TestBean publicInstance() {
		return new TestBean("publicInstance");
	}

	// use of a custom qualifier and autowiring of method parameters
	@Bean
	@Qualifier("protected") 
	protected TestBean protectedInstance(@Qualifier("public") TestBean spouse,
			@Value("#{privateInstance.country}") String country) {
		TestBean tb = new TestBean("protectedInstance", 1);
		tb.setSpouse(spouse);
		tb.setCountry(country);
		return tb;
	}

	@Bean
	@Qualifier("private") 
	private TestBean privateInstance() {
		return new TestBean("privateInstance", i++);
	}

	@Bean
	@RequestScope
	@Qualifier("requestScoped") 
	public TestBean requestScopedInstance() {
		return new TestBean("requestScopedInstance", 3);
	}

	@Bean @Scope("prototype")
	@Qualifier("prototype") 
    public TestBean prototypeInstance(InjectionPoint injectionPoint) { // As of Spring Framework 4.3
            return new TestBean("prototypeInstance for " + injectionPoint.getMember());
    }
	
	public void doWork() {
		// Component method implementation omitted
		System.out.println(publicInstance());
		System.out.println(protectedInstance(publicInstance(), "country_protectedInstance"));
		System.out.println(privateInstance());
		System.out.println(requestScopedInstance());
		//System.out.println(prototypeInstance(injectionPoint));
	}

}
