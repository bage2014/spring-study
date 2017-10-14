package com.bage.annotation.qualifiers.generics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="movieRecommenderGenerics")
public class MovieRecommender {

	@Autowired
	private Store<String> s1; // <String> qualifier, injects the stringStore bean

	@Autowired
	private Store<Integer> s2; // <Integer> qualifier, injects the integerStore bean

	@Autowired
	private List<Store<Integer>> s;	// Inject all Store beans as long as they have an <Integer> generic
									// Store<String> beans will not appear in this list

	public Store<String> getS1() {
		return s1;
	}

	public void setS1(Store<String> s1) {
		this.s1 = s1;
	}

	public Store<Integer> getS2() {
		return s2;
	}

	public void setS2(Store<Integer> s2) {
		this.s2 = s2;
	}

	public List<Store<Integer>> getS() {
		return s;
	}

	public void setS(List<Store<Integer>> s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return "MovieRecommender [s1=" + s1 + ", s2=" + s2 + ", s=" + s + "]";
	}
	
}
