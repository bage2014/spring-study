package com.bage.annotation.autowired.mix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bage.annotation.autowired.CustomerPreferenceDao;
import com.bage.annotation.autowired.MovieCatalog;

@Component(value="movieRecommenderMix")
public class MovieRecommender {

    private final CustomerPreferenceDao customerPreferenceDao;

    @Autowired
    private MovieCatalog movieCatalog;

    @Autowired
    public MovieRecommender(CustomerPreferenceDao customerPreferenceDao) {
            this.customerPreferenceDao = customerPreferenceDao;
    }

	public MovieCatalog getMovieCatalog() {
		return movieCatalog;
	}

	public void setMovieCatalog(MovieCatalog movieCatalog) {
		this.movieCatalog = movieCatalog;
	}

	public CustomerPreferenceDao getCustomerPreferenceDao() {
		return customerPreferenceDao;
	}

}
