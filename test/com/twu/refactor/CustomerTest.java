package com.twu.refactor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import static com.twu.refactor.MoviePriceCategory.*;

import junit.framework.TestCase;

public class CustomerTest extends TestCase {

	private static final String GOLD_PATH = "test/data";

    private Customer dinsdale = new Customer("Dinsdale Pirhana");
    private CustomerStatement stmt_of_dinsdale;

    private Movie python = new Movie("Monty Python and the Holy Grail", REGULAR);
	private Movie ran = new Movie("Ran", REGULAR);
	private Movie la = new Movie("LA Confidential", NEW_RELEASE);
	private Movie trek = new Movie("Star Trek 13.2", NEW_RELEASE);
	private Movie wallace = new Movie("Wallace and Gromit", CHILDREN);

    public void setUp (){
       stmt_of_dinsdale = new CustomerStatement(dinsdale.getStatement());
       dinsdale.addRental(new Rental(python, 3));
       dinsdale.addRental(new Rental(ran, 1));
       dinsdale.addRental(new Rental(la, 2));
       dinsdale.addRental(new Rental(trek, 1));
       dinsdale.addRental(new Rental(wallace, 6));
   }

    public void testEmpty() throws Exception {
    	dinsdale = new Customer("Dinsdale Pirhana");
        stmt_of_dinsdale = new CustomerStatement(dinsdale);
        equalsFile("1st Output", "outputEmpty", stmt_of_dinsdale.toString());
    }
    public void testCustomer() throws Exception {
        equalsFile("1st Output", "output1", stmt_of_dinsdale.toString());
    }

    public void testChange() throws Exception {
    	la.setPriceCategory(REGULAR);
        equalsFile("1st Output", "outputChange", stmt_of_dinsdale.toString());
    }

    protected void equalsFile(String message, String fileName, String actualValue) throws IOException{
        BufferedReader file = new BufferedReader (new FileReader (GOLD_PATH + '/' + fileName));
        BufferedReader actualStream = new BufferedReader (new StringReader (actualValue));
        String thisFileLine = null;
        while  ((thisFileLine = file.readLine()) != null) {
            assertEquals ("in file: " + fileName, thisFileLine, actualStream.readLine());
        }
    }
}