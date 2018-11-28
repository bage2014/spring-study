package com.bage.annotation.resource;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component(value="movieRecommenderResource")
public class MovieRecommender {

	 @Resource
     private CustomerPreferenceDao resourceCustomerPreferenceDao;

     public MovieRecommender() {
     }

	public CustomerPreferenceDao getResourceCustomerPreferenceDao() {
		return resourceCustomerPreferenceDao;
	}

	public void setResourceCustomerPreferenceDao(CustomerPreferenceDao resourceCustomerPreferenceDao) {
		this.resourceCustomerPreferenceDao = resourceCustomerPreferenceDao;
	}

	@Override
	public String toString() {
		return "MovieRecommender [resourceCustomerPreferenceDao=" + resourceCustomerPreferenceDao + "]";
	}
	
}
