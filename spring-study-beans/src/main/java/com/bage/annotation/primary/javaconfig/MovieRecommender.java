package com.bage.annotation.primary.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="movieRecommenderPriJavaconfig")
public class MovieRecommender {

	@Autowired
    private MovieCatalog movieCatalog;

	public MovieCatalog getMovieCatalog() {
		return movieCatalog;
	}

	public void setMovieCatalog(MovieCatalog movieCatalog) {
		this.movieCatalog = movieCatalog;
	}

	@Override
	public String toString() {
		return "MovieRecommender [movieCatalog=" + movieCatalog + "]";
	}
	
}
