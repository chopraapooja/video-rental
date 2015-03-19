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

}
