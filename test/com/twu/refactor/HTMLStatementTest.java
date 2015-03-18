package com.twu.refactor;

import junit.framework.TestCase;

import static com.twu.refactor.MoviePriceCategory.CHILDREN;
import static com.twu.refactor.MoviePriceCategory.NEW_RELEASE;
import static com.twu.refactor.MoviePriceCategory.REGULAR;

public class HTMLStatementTest extends TestCase {
    private Customer dinsdale = new Customer("Dinsdale Pirhana");
    private HTMLStatement dinsdalesStatement;

    private Movie python = new Movie("Monty Python and the Holy Grail", REGULAR);
    private Movie ran = new Movie("Ran", REGULAR);
    private Movie la = new Movie("LA Confidential", NEW_RELEASE);
    private Movie trek = new Movie("Star Trek 13.2", NEW_RELEASE);
    private Movie wallace = new Movie("Wallace and Gromit", CHILDREN);

    public void setUp (){
        dinsdalesStatement = new HTMLStatement(dinsdale);
        dinsdale.addRental(new Rental (python, 3));
        dinsdale.addRental(new Rental (ran, 1));
        dinsdale.addRental(new Rental (la, 2));
        dinsdale.addRental(new Rental (trek, 1));
        dinsdale.addRental(new Rental (wallace, 6));
    }

    public void testToString() {
        System.out.println(dinsdalesStatement.toString());
    }

}