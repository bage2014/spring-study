package com.bage.xml;

public class NumberGuess {

	private int randomNumber ;

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
