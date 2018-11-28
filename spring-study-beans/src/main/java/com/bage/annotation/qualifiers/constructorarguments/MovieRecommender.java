package com.bage.annotation.qualifiers.constructorarguments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bage.annotation.qualifiers.MovieCatalog;

@Component(value="movieRecommenderQualConstructorarguments")
public class MovieRecommender {
	
	private MovieCatalog movieCatalog;

    private CustomerPreferenceDao customerPreferenceDao;

    @Autowired
    public void prepare(@Qualifier("movieCatalogSun2")MovieCatalog movieCatalog,
                    CustomerPreferenceDao customerPreferenceDao) {
            this.movieCatalog = movieCatalog;
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

	public void setCustomerPreferenceDao(CustomerPreferenceDao customerPreferenceDao) {
		this.customerPreferenceDao = customerPreferenceDao;
	}

	@Override
	public String toString() {
		return "MovieRecommender [movieCatalog=" + movieCatalog + ", customerPreferenceDao=" + customerPreferenceDao
				+ "]";
	}
    
}
