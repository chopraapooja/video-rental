package com.twu.refactor;

import junit.framework.TestCase;
import org.junit.Test;

public class HtmlTest extends TestCase {
    @Test
    public void test_toString_of_aTag() {
            Html html = Html.createTag("HTML");
            String expected = "<HTML></HTML>";
            assertTrue(expected.equals(html.toString()));
    }
    @Test
    public void test_toString_of_tag_having_innerText() {
            Html html = Html.createTag("HTML").innerText("Hello Mickey");
            String expected = "<HTML>Hello Mickey</HTML>";
            assertTrue(expected.equals(html.toString()));
    }
    @Test
    public void test_toString_of_tag_having_child_tags() {
            Html html = Html.createTag("HTML");
            html.tag("HEAD").tag("TITLE");
            html.tag("BODY").tag("DIV");
            String expected = "<HTML><HEAD><TITLE></TITLE></HEAD><BODY><DIV></DIV></BODY></HTML>";
            assertTrue(expected.equals(html.toString()));
    }


}