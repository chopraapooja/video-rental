package com.twu.refactor;

public class Movie {
//	public static final int  CHILDRENS = 2;
//	public static final int  REGULAR = 0;
//	public static final int  NEW_RELEASE = 1;

    MoviePriceCategory category;
	private String title;
	private MoviePriceCategory priceCategory;

	public Movie(String title, MoviePriceCategory priceCategory) {
		this.title = title;
		this.priceCategory = priceCategory;
	}

	public MoviePriceCategory getPriceCategory() {
		return priceCategory;
	}

	public void setPriceCode(MoviePriceCategory arg) {
    	priceCategory = arg;
	}

	public String getTitle () {
		return title;
	}
}

