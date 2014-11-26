package ToolKit;

/**
 * Chapter 9 Exercise 9:
 *
 *      My class for Chapter 9 Exercise 9.
 *
 * Created by Luiz Arantes Sa on 9/2/14.
 */
public class RegularPolygon {

    private int mNumberOfSides;
    private double mSideLength;
    private double mCenterX;
    private double mCenterY;

    public RegularPolygon() {
        mNumberOfSides = 3;
        mSideLength = 1;
        mCenterX = 0;
        mCenterY = 0;

    }

    public RegularPolygon(int numberOfSides, double sideLength) {
        this();
        mSideLength = sideLength;
        mNumberOfSides = numberOfSides;

    }

    public RegularPolygon(int numberOfSides, double sideLength, double x, double y) {
        this(numberOfSides, sideLength);
        mCenterX = x;
        mCenterY = y;
    }

    public int getNumberOfSides() {
        return mNumberOfSides;
    }

    public void setNumberOfSides(int numberOfSides) {
        mNumberOfSides = numberOfSides;
    }

    public double getSideLength() {
        return mSideLength;
    }

    public void setSideLength(double sideLength) {
        mSideLength = sideLength;
    }

    public double getCenterY() {
        return mCenterY;
    }

    public void setCenterY(double centerY) {
        mCenterY = centerY;
    }

    public double getCenterX() {
        return mCenterX;
    }

    public void setCenterX(double centerX) {
        mCenterX = centerX;
    }

    public double getPerimeter(){

        return mNumberOfSides * mSideLength;
    }

    public double getArea() {

        return (mNumberOfSides * mSideLength * mSideLength) / (4.0 * Math.tan(Math.PI / mNumberOfSides));
    }

}
