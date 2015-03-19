package com.twu.refactor;

import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import static com.twu.refactor.MoviePriceCategory.CHILDREN;
import static com.twu.refactor.MoviePriceCategory.NEW_RELEASE;
import static com.twu.refactor.MoviePriceCategory.REGULAR;

public class HTMLStatementTest extends TestCase {
    private static final String GOLD_PATH = "test/data";
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

    public void testToString() throws IOException {
        equalsFile("1st Output", "output.html", dinsdalesStatement.toString());
    }

    protected void equalsFile(String message, String fileName, String actualValue) throws IOException {
        BufferedReader file = new BufferedReader (new FileReader(GOLD_PATH + '/' + fileName));
        BufferedReader actualStream = new BufferedReader (new StringReader(actualValue));
        String thisFileLine = null;
        while  ((thisFileLine = file.readLine()) != null) {
            assertEquals ("in file: " + fileName, thisFileLine, actualStream.readLine());
        }
    }

}