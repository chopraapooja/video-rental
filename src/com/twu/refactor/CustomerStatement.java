package com.twu.refactor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by poojar on 3/18/2015.
 */
public class CustomerStatement {
    CustomerSummary cSummary;
    public CustomerStatement(CustomerSummary customerSummary) {
        this.cSummary = customerSummary;
    }
    @Override
    public String toString() {
        return getHeader()+getMovieRentSummary()+getFooter();
    }

    protected String getHeader() {
        return "Rental Record for "+cSummary.getName()+"\n";
    }

    protected String getMovieRentSummary() {
        String summary = "";
        final String MOVIE_RENT = "\tTITLE\tRENT\n";
        for (Rental thisRental : cSummary.getRentalList()) {
            String movieTitle = thisRental.getMovie().getTitle();
            Double amt = thisRental.getAmount();
            summary = summary + MOVIE_RENT.replace("TITLE", movieTitle).replace("RENT", amt.toString());
        }
        return summary;
    }

    private String getFooter() {
        double totalAmount = cSummary.getTotalAmt();
        String result = "";
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(cSummary.getFrequentRenterPoints())
                + " frequent renter points";
        return result;
    }
}
