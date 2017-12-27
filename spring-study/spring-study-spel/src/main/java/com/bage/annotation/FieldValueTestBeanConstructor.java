package com.bage.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn(value="numberGuess")
public class FieldValueTestBeanConstructor {
	
     private String defaultLocale;

     @Autowired // 这个是必须的
     public void setDefaultLocale(@Value("#{ numberGuess.randomNumber }") String defaultLocale) {
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
