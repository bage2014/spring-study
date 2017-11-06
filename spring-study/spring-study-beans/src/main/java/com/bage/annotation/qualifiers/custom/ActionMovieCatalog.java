package com.bage.annotation.qualifiers.custom;

import org.springframework.stereotype.Component;

// @Component
// @Qualifier("annotationsActionMovieCatalog")
@Component(value="customActionMovieCatalog")
public class ActionMovieCatalog {
	
	@GenreQualifier(value = "customActionMovie")
	private ActionMovie ActionMovie;

	@Override
	public String toString() {
		return "ActionMovieCatalog [ActionMovie=" + ActionMovie + "]";
	}
	
	
}
