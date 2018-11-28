package com.bage.annotation.qualifiers.plaindescriptive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bage.annotation.qualifiers.MovieCatalog;

@Component(value="movieRecommenderQualPlaindescriptive")
public class MovieRecommender {

	@Autowired
    @Qualifier(value="movieCatalogSun1")
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
