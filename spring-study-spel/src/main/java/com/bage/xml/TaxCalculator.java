package com.bage.xml;

public class TaxCalculator {

	private String defaultLocale;

	public String getDefaultLocale() {
		return defaultLocale;
	}

	public void setDefaultLocale(String defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

	@Override
	public String toString() {
		return "TaxCalculator [defaultLocale=" + defaultLocale + "]";
	}
	
}
