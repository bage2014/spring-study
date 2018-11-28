package com.bage.annotation.qualifiers.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bage.annotation.qualifiers.MovieCatalog;

@Component(value="movieRecommenderQualxml")
public class MovieRecommender {

	@Autowired
    @Qualifier("movieCatalogSun4")
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
