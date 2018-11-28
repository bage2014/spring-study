package com.bage.annotation;

import org.springframework.stereotype.Component;

@Component
public class NumberGuess {

	private int randomNumber = 123 ;

	public int getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(int randomNumber) {
		this.randomNumber = randomNumber;
	}

	@Override
	public String toString() {
		return "NumberGuess [randomNumber=" + randomNumber + "]";
	}
	
}
