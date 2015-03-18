package com.twu.refactor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by poojar on 3/18/2015.
 */
public class MoviePriceCategoryTest {
    static final double DELTA = 0.1d;
    @Test
    public void CHILDREN_category_should_give_correct_rent_for_1_day() {
        int noOfDays = 1;
        double expectedCost = 1.5d;
        double cost = MoviePriceCategory.CHILDREN.getCostFor(noOfDays);
        assertEquals(expectedCost, cost, DELTA);
    }
    @Test
    public void NEW_RELEASE_category_should_give_correct_rent_for_1_day() {
        int noOfDays = 1;
        double expectedCost = 3d;
        double cost = MoviePriceCategory.NEW_RELEASE.getCostFor(noOfDays);
        assertEquals(expectedCost, cost, DELTA);
    }
    @Test
    public void REGULAR_category_should_give_correct_rent_for_1_day() {
        int noOfDays = 1;
        double expectedCost = 2d;
        double cost = MoviePriceCategory.REGULAR.getCostFor(noOfDays);
        assertEquals(expectedCost, cost, DELTA);
    }
    @Test
    public void CHILDREN_category_should_give_correct_rent_for_2_days() {
        int noOfDays = 2;
        double expectedCost = 1.5d;
        double cost = MoviePriceCategory.CHILDREN.getCostFor(noOfDays);
        assertEquals(expectedCost, cost, DELTA);
    }
    @Test
    public void CHILDREN_category_should_give_correct_rent_for_4_days() {
        int noOfDays = 4;
        double expectedCost = 3.0;
        double cost = MoviePriceCategory.CHILDREN.getCostFor(noOfDays);
        assertEquals(expectedCost, cost, DELTA);
    }
    @Test
    public void NEW_RELEASE_category_should_give_correct_rent_for_4_days() {
        int noOfDays = 4;
        double expectedCost = 12.0;
        double cost = MoviePriceCategory.NEW_RELEASE.getCostFor(noOfDays);
        assertEquals(expectedCost, cost, DELTA);
    }
    @Test
    public void REGULAR_category_should_give_correct_rent_for_4_days() {
        int noOfDays = 4;
        double expectedCost = 5.0;
        double cost = MoviePriceCategory.REGULAR.getCostFor(noOfDays);
        assertEquals(expectedCost, cost, DELTA);
    }
}