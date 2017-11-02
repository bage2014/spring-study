package com.bage.annotation.lifecyclecallbacks;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component(value="cachingMovieLister")
public class CachingMovieLister {
	
	@PostConstruct
    public void populateMovieCache() {
		System.out.println("populates the movie cache upon initialization...");
            // populates the movie cache upon initialization...
    }

    @PreDestroy
    public void clearMovieCache() {
    	System.out.println("clears the movie cache upon destruction...");
            // clears the movie cache upon destruction...
    }
}
