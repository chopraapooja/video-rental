package com.twu.refactor;

/**
 * Created by poojar on 3/18/2015.
 */
public enum MoviePriceCategory {
    CHILDREN(1.5d, 3, 1.5d), NEW_RELEASE(0d, 0, 3d), REGULAR(2d, 2, 1.5d);

    private double upfrontCost;
    private int upfrontValidity;
    private double overdueCost;

    MoviePriceCategory(double upfrontCost, int upfrontValidity, double overdueCost) {
        this.upfrontCost = upfrontCost;
        this.upfrontValidity = upfrontValidity;
        this.overdueCost = overdueCost;
    }

    public double getCostFor(int noOfDays) {
        double cost = upfrontCost;
        if(noOfDays > upfrontValidity) {
            cost += (noOfDays-upfrontValidity)*overdueCost;
        }
        return cost;
    }
}
