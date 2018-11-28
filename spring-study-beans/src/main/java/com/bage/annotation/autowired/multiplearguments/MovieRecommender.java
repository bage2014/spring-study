package com.bage.annotation.autowired.multiplearguments;

import org.springframework.beans.factory.annotation.Autowired;

import com.bage.annotation.autowired.CustomerPreferenceDao;
import com.bage.annotation.autowired.MovieCatalog;

public class MovieRecommender {

    private MovieCatalog movieCatalog;

    private CustomerPreferenceDao customerPreferenceDao;

    @Autowired
    public void prepare(MovieCatalog movieCatalog,
                    CustomerPreferenceDao customerPreferenceDao) {
            this.movieCatalog = movieCatalog;
            this.customerPreferenceDao = customerPreferenceDao;
    }

	@Override
	public String toString() {
		return "MovieRecommender [movieCatalog=" + movieCatalog + ", customerPreferenceDao=" + customerPreferenceDao
				+ "]";
	}
    
}
