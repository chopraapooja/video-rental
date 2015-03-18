package com.twu.refactor;

public class Movie {
	private String title;
	private MoviePriceCategory priceCategory;

	public Movie(String title, MoviePriceCategory priceCategory) {
		this.title = title;
		this.priceCategory = priceCategory;
	}

	public MoviePriceCategory getPriceCategory() {
		return priceCategory;
	}

	public void setPriceCategory(MoviePriceCategory arg) {
    	priceCategory = arg;
	}

	public String getTitle () {
		return title;
	}
}

