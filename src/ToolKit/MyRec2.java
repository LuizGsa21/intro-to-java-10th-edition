package ToolKit;

/**
 * Chapter 9 Exercise 1:
 *
 *      My class for Chapter 9 Exercise 1
 *
 * Created by Luiz Arantes Sa on 9/1/14.
 */
public class MyRec2 {

    private double width;
    private double height;

    public MyRec2() {
        this.width = 1.0;
        this.height = 1.0;
    }

    public MyRec2(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /** return area **/
    public double getArea() {
        return this.width * this.height;
    }
    /** return perimeter **/
    public double getPerimeter() {
        return this.width * 2 + this.height * 2;
    }

}
