package com.twu.refactor;

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
    protected int getFrequentRenterPoints() {
        int totalPoints = 0;
        for (Rental thisRental : customer.getRentalList()) {
            totalPoints += thisRental.getBonus();
        }
        return  totalPoints;
    }
}
