package com.twu.refactor;

import java.util.Map;
import java.util.Set;

/**
 * Created by poojar on 3/18/2015.
 */
public class TextStatement extends Statement {

    public TextStatement(Customer customer) {
        super(customer);
    }
    @Override
    public String toString() {
        return getHeader()+getBody()+getFooter();
    }

    protected String getHeader() {
        return "Rental Record for "+this.getCustomerName()+"\n";
    }

    private String getBody() {
        final String MOVIE_RENT = "\tTITLE\tRENT\n";
        String summary = "";
        Map<String, Double> movieRentSummary = getMovieRentSummary();
        for(Object title : movieRentSummary.keySet()) {
            Double rent = movieRentSummary.get(title);
            String movieTitle = (String) title;
            summary = summary + MOVIE_RENT.replace("TITLE", movieTitle).replace("RENT", rent.toString());
        }
        return summary;
    }

    private String getFooter() {
        double totalAmount = this.getTotalAmt();
        String result = "";
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(this.getFrequentRenterPoints())
                + " frequent renter points";
        return result;
    }
}
