package com.bage.annotation.standardannotations;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component(value="standardannotationsSimpleMovieLister")
public class SimpleMovieLister {
	 private StandardannotationsMovieFinder movieFinder;

     @Inject // Instead of @Autowired, @javax.inject.Inject may be used as follows:
     //@Named(value="standardannotationsMovieFinder")
     public void setMovieFinder(StandardannotationsMovieFinder movieFinder) {
             this.movieFinder = movieFinder;
     }

     public void listMovies() {
             // this.movieFinder.findMovies(...);
    	 System.out.println(movieFinder);
     }
}
