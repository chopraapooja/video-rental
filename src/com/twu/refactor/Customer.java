package com.twu.refactor;

import java.util.ArrayList;

public class Customer {
	private String name;

    public ArrayList<Rental> getRentalList() {
        return rentalList;
    }

    private ArrayList<Rental> rentalList = new ArrayList<Rental>();
    private int frequentRenterPoints = 0;

    public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) { rentalList.add(arg); frequentRenterPoints++; }

	public String getName() {
		return name;
	}

	public String getStatement() {
        String header = "Rental Record for "+getName()+"\n";
        String movieRentSummary = getMovieRentalSummary();
        String footer = getFooterLines();
		return header + movieRentSummary + footer;
    }

    public String getMovieRentalSummary() {
        final String MOVIE_RENT = "\tTITLE\tRENT\n";
        String summary = "";
        for (Rental thisRental : rentalList) {
            String movieTitle = thisRental.getMovie().getTitle();
            String amt = String.valueOf(thisRental.getAmount());
            summary += MOVIE_RENT.replace("TITLE", movieTitle).replace("RENT", amt);
        }
        return summary;
    }

    public double getTotalRentialAmount() {
        double totalAmount = 0d;
        for (Rental thisRential : rentalList) {
            frequentRenterPoints += thisRential.getBonusOn();
            totalAmount += thisRential.getAmount();
        }
        return  totalAmount;
    }

    private String getFooterLines() {
        double totalAmount = getTotalRentialAmount();
        String result = "";
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }
}
