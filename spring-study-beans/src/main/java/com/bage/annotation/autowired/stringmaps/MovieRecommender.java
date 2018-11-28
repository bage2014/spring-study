package com.bage.annotation.autowired.stringmaps;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bage.annotation.autowired.MovieCatalog;

@Component(value="movieRecommenderMaps")
public class MovieRecommender {

	private Map<String, MovieCatalog> movieCatalogs;

    @Autowired
    public void setMovieCatalogs(Map<String, MovieCatalog> movieCatalogs) {
            this.movieCatalogs = movieCatalogs;
    }

	public Map<String, MovieCatalog> getMovieCatalogs() {
		return movieCatalogs;
	}

	@Override
	public String toString() {
		return "MovieRecommender [movieCatalogs=" + movieCatalogs + "]";
	}

}
