package com.bage.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn(value="numberGuess")
public class FieldValueTestBean {
	
	 @Value("#{ numberGuess.randomNumber }")
	 // @Value annotation can be placed on fields, methods and method/constructor parameters to specify a default value
     private String defaultLocale;

	 //  @Value("#{ numberGuess.randomNumber }") 等价于上面
     public void setDefaultLocale(String defaultLocale) {
             this.defaultLocale = defaultLocale;
     }

     public String getDefaultLocale() {
             return this.defaultLocale;
     }

	@Override
	public String toString() {
		return "FieldValueTestBean [defaultLocale=" + defaultLocale + "]";
	}
     
     
}
