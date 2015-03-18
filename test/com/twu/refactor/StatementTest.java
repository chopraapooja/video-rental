package com.twu.refactor;

import junit.framework.TestCase;

import static com.twu.refactor.MoviePriceCategory.CHILDREN;
import static com.twu.refactor.MoviePriceCategory.NEW_RELEASE;
import static com.twu.refactor.MoviePriceCategory.REGULAR;

public class StatementTest extends TestCase {

    private Customer mickey = new Customer("Mickey");

    private Movie python = new Movie("Monty Python and the Holy Grail", REGULAR);
    private Movie ran = new Movie("Ran", REGULAR);
    private Movie la = new Movie("LA Confidential", NEW_RELEASE);
    private Movie trek = new Movie("Star Trek 13.2", NEW_RELEASE);
    private Movie wallace = new Movie("Wallace and Gromit", CHILDREN);

    public void setUp (){
        mickey.addRental(new Rental(python, 3));
        mickey.addRental(new Rental(ran, 1));
        mickey.addRental(new Rental(la, 2));
        mickey.addRental(new Rental(trek, 1));
        mickey.addRental(new Rental(wallace, 6));
    }
    public void testGetFrequentRenterPointsShouldGive0ForCustomerWithNoRentals() throws Exception {
        Customer mickey = new Customer("Mickey");
        Statement mickeyStatement = new Statement(mickey);
        int expectedPoints = 0;
        int points = mickeyStatement.getFrequentRenterPoints();
        assertEquals(expectedPoints, points);
    }
    public void testGetFrequentRenterPoints() throws Exception {
        Statement mickeyStatement = new Statement(mickey);
        int expectedPoints = 6;
        int points = mickeyStatement.getFrequentRenterPoints();
        assertEquals(expectedPoints, points);
    }
    public void testGetFrequentRenterPointsWhenCategoryChanged() {
        la.setPriceCategory(REGULAR);
        Statement mickeyStatement = new Statement(mickey);
        int expectedPoints = 5;
        int points = mickeyStatement.getFrequentRenterPoints();
        assertEquals(expectedPoints, points);
    }

}