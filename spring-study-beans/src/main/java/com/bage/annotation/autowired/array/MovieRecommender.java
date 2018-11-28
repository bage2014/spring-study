package com.bage.annotation.autowired.array;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bage.annotation.autowired.MovieCatalog;

@Component(value="movieRecommenderArray")
public class MovieRecommender {

	@Autowired
    private MovieCatalog[] movieCatalogs;

	public MovieCatalog[] getMovieCatalogs() {
		return movieCatalogs;
	}

	public void setMovieCatalogs(MovieCatalog[] movieCatalogs) {
		this.movieCatalogs = movieCatalogs;
	}

	@Override
	public String toString() {
		return "MovieRecommender [movieCatalogs=" + Arrays.toString(movieCatalogs) + "]";
	}
	
}
