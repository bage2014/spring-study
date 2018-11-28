package com.bage.annotation.autowired.constructors;

import org.springframework.beans.factory.annotation.Autowired;

import com.bage.annotation.autowired.CustomerPreferenceDao;

public class MovieRecommender {
	
	private final CustomerPreferenceDao customerPreferenceDao;

    @Autowired
    public MovieRecommender(CustomerPreferenceDao customerPreferenceDao) {
            this.customerPreferenceDao = customerPreferenceDao;
    }

	public CustomerPreferenceDao getCustomerPreferenceDao() {
		return customerPreferenceDao;
	}

}
