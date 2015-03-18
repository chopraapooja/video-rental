package com.twu.refactor;

import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import java.util.Map;

/**
 * Created by poojar on 3/18/2015.
 */
public class HTMLStatement extends Statement {
    private Customer customer;
    public HTMLStatement(Customer customer) {
        super(customer);
    }
    @Override
    public String toString() {
        Html html = Html.createTag("html");
        Html body = html.tag("body");
        body.tag("h3").innerText(super.getHeader());
        Html table = body.tag("table");
        Map<String, Double> movieRentSummary = getMovieRentSummary();
        for(Object title : movieRentSummary.keySet()) {
            Double rent = movieRentSummary.get(title);
            String movieTitle = (String) title;
            Html tr = table.tag("tr");
            tr.tag("td").innerText(movieTitle);
            tr.tag("td").innerText(rent.toString());
        }
        body.tag("b").innerText("Amount owed is " + String.valueOf(getTotalAmt()));
        body.tag("br");
        body.tag("b").innerText("You earned " + String.valueOf(this.getFrequentRenterPoints())
                + " frequent renter points");
        return html.toString();
    }

    @Override
    protected String getHeader() {
        return "<H3>"+super.getHeader()+"</H3><br/>";
    }

}
