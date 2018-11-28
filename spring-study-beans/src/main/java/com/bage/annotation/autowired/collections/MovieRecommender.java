package com.bage.annotation.autowired.collections;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bage.annotation.autowired.MovieCatalog;

@Component(value = "movieRecommenderCollections")
public class MovieRecommender {

	private Set<MovieCatalog> movieCatalogs;

	@Autowired
	public void setMovieCatalogs(Set<MovieCatalog> movieCatalogs) {
		this.movieCatalogs = movieCatalogs;
	}

	public Set<MovieCatalog> getMovieCatalogs() {
		return movieCatalogs;
	}

	@Override
	public String toString() {
		return "MovieRecommender [movieCatalogs=" + movieCatalogs + "]";
	}

}
