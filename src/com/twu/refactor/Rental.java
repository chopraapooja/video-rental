package com.twu.refactor;

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
        double amount = 0d;
        switch (this.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                amount += 2;
                if (this.getDaysRented() > 2)
                    amount += (this.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                amount += this.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                amount += 1.5;
                if (this.getDaysRented() > 3)
                    amount += (this.getDaysRented() - 3) * 1.5;
                break;

        }
        return amount;
    }

    int getBonusOn() {
        int bonus = 0;
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE)
                && getDaysRented() > 1)
            bonus++;
        return bonus;
    }
}