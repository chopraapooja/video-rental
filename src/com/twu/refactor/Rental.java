package com.twu.refactor;

import javax.swing.text.html.HTML;

import static com.twu.refactor.MoviePriceCategory.*;

public class Rental {

    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getAmount() {
        return getMovie().getCostFor(daysRented);
    }

    public int getBonus() {
        int bonus = 1;
        boolean isUnderScheme = (getMovie().getPriceCategory() == NEW_RELEASE) && getDaysRented() > 1;
        return isUnderScheme ? bonus+1 : bonus;
    }

    int getBonusOn() {
        int bonus = 0;
        if ((getMovie().getPriceCategory() == NEW_RELEASE)
                && getDaysRented() > 1)
            bonus++;
        return bonus;
    }
}
