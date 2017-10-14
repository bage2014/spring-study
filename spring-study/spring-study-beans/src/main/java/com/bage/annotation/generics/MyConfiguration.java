package com.bage.annotation.generics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

        @Bean
        public StringStore stringStore() {
                return new StringStore();
        }

        @Bean
        public IntegerStore integerStore() {
                return new IntegerStore();
        }

}
