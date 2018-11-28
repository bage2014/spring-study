package com.bage.annotation.autowired.setter;

import org.springframework.beans.factory.annotation.Autowired;

import com.bage.annotation.required.MovieFinder;

public class SimpleMovieLister {
	
	private MovieFinder movieFinder;

    @Autowired
    public void setMovieFinder(MovieFinder movieFinder) {
            this.movieFinder = movieFinder;
    }

	public MovieFinder getMovieFinder() {
		return movieFinder;
	}
    
}
