package com.bage.annotation.qualifiers.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bage.annotation.qualifiers.MovieCatalog;

@Component(value="movieRecommenderCustom")
public class MovieRecommender {
	
	@Autowired
	@GenreQualifier("Comedy")
	private MovieCatalog movieCatalog;
	
	@Autowired
	@GenreQualifier("Comedy2")
	private MovieCatalog movieCatalog2;

	@Autowired
	@NoValueQualifier
	private MovieCatalog movieCatalog3;
	
	@Autowired
	@AttributesQualifier(format=Format.VHS, genre="Action")
	private MovieCatalog movieCatalog4;
	
	public MovieCatalog getMovieCatalog() {
		return movieCatalog;
	}

	public void setMovieCatalog(MovieCatalog movieCatalog) {
		this.movieCatalog = movieCatalog;
	}

	public MovieCatalog getMovieCatalog2() {
		return movieCatalog2;
	}

	public void setMovieCatalog2(MovieCatalog movieCatalog2) {
		this.movieCatalog2 = movieCatalog2;
	}

	public MovieCatalog getMovieCatalog3() {
		return movieCatalog3;
	}

	public void setMovieCatalog3(MovieCatalog movieCatalog3) {
		this.movieCatalog3 = movieCatalog3;
	}

	public MovieCatalog getMovieCatalog4() {
		return movieCatalog4;
	}

	public void setMovieCatalog4(MovieCatalog movieCatalog4) {
		this.movieCatalog4 = movieCatalog4;
	}

	@Override
	public String toString() {
		return "MovieRecommender [movieCatalog=" + movieCatalog + ", movieCatalog2=" + movieCatalog2
				+ ", movieCatalog3=" + movieCatalog3 + ", movieCatalog4=" + movieCatalog4 + "]";
	}

}
