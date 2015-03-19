package com.twu.refactor;

import java.util.ArrayList;

/**
 * Created by poojar on 3/19/2015.
 */
public interface CustomerSummary {
    public String getName();
    public ArrayList<Rental> getRentalList();
    public int getFrequentRenterPoints();
    public Double getTotalAmt();
}
