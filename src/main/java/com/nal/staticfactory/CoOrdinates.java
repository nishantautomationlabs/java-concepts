package com.nal.staticfactory;

/**
 * Created by Nishant on 02-11-2018.
 */
public class CoOrdinates {

    private double xCoordinate;
    private double yCoordinate;

    public CoOrdinates(double xCoordinate, double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public static final CoOrdinates fromXY(double x, double y)
    {
        return new CoOrdinates(x, y);
    }

    public static final CoOrdinates fromPolar(double dist, double angle)
    {
        return new CoOrdinates(dist * Math.cos(angle), dist * Math.sin(angle));
    }
}
