package com.bage.annotation.primary.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MovieConfiguration {

        @Bean
        public MovieCatalog firstMovieCatalog() { 
        	// TODO 
        	return new MovieCatalogFirst();
        }

        @Bean
        @Primary
        public MovieCatalog secondMovieCatalog() { 
        	// TODO
        	return new MovieCatalogSecond();
        }

}