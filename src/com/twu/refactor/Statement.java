package com.twu.refactor;

import java.util.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by poojar on 3/18/2015.
 */
public class Statement {
    private final Customer customer;
    public Statement(Customer customer) {
        this.customer = customer;
    }
    protected String getName() {
        return customer.getName();
    }
    protected Double getTotalAmt() {
        double totalAmount = 0d;
        for (Rental thisRental : customer.getRentalList()) {
            totalAmount += thisRental.getAmount();
        }
        return  totalAmount;
    }
    protected Map<String, Double> getMovieRentSummary() {
        Map<String, Double> summary = new HashMap<String, Double>();
        for (Rental thisRental : customer.getRentalList()) {
            String movieTitle = thisRental.getMovie().getTitle();
            Double amt = thisRental.getAmount();
            summary.put(movieTitle, amt);
        }
        return summary;
    }
    protected int getFrequentRenterPoints() {
        int totalPoints = 0;
        for (Rental thisRental : customer.getRentalList()) {
            totalPoints += thisRental.getBonus();
        }
        return  totalPoints;
    }
}
