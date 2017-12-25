package com.bage.xml;

import java.util.Locale;

public class TaxCalculator {

	private Locale defaultLocale;

	public Locale getDefaultLocale() {
		return defaultLocale;
	}

	public void setDefaultLocale(Locale defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

	@Override
	public String toString() {
		return "TaxCalculator [defaultLocale=" + defaultLocale + "]";
	}
	
}
