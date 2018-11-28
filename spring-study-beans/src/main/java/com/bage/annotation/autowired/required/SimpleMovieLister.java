package com.bage.annotation.autowired.required;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="simpleMovieListerRequired")
public class SimpleMovieLister {
	private MovieFinder movieFinder;

    @Autowired(required=false)
    public void setMovieFinder(MovieFinder movieFinder) {
            this.movieFinder = movieFinder;
    }

	public MovieFinder getMovieFinder() {
		return movieFinder;
	}

	@Override
	public String toString() {
		return "SimpleMovieLister [movieFinder=" + movieFinder + "]";
	}
    
}
