package Chapter_13;

import ToolKit.Circle2D;
import ToolKit.GeometricObject;
import ToolKit.MyRectangle2D;

/**
 * Chapter 13 Exercise 7:
 *
 *      (The Colorable interface)
 *      Design an interface named Colorable with a void method named howToColor().
 *      Every class of a colorable object must imple- ment the Colorable interface.
 *      Design a class named Square that extends GeometricObject and implements Colorable.
 *      Implement howToColor to display the message Color all four sides.
 *      Draw a UML diagram that involves Colorable, Square, and GeometricObject.
 *      Write a test program that creates an array of five GeometricObjects.
 *      For each object in the array, display its area and invoke its howToColor method
 *      if it is colorable.
 *
 * Created by Luiz Arantes Sa on 9/10/14.
 */
public class Exercise_07 {

    public static void main(String[] args) {

        GeometricObject[] geoShapes = new GeometricObject[5];
        geoShapes[0] = new MyRectangle2D();
        geoShapes[1] = new Circle2D();
        geoShapes[2] = new Square();
        geoShapes[3] = new MyRectangle2D(0, 0, 10, 5);
        geoShapes[4] = new Square(0,0,25);

        for (int i = 0; i < geoShapes.length; i++) {

            System.out.println("shape #" + (i + 1) + " area = " + geoShapes[i].getArea());
            if (geoShapes[i] instanceof Colorable) {
                System.out.println("How to color: "+((Colorable)geoShapes[i]).howToColor());
            }
        }

    }

}

class Square extends GeometricObject implements Colorable {

    private double x;
    private double y;
    private double side;

    Square() {
        this(0,0,10);
    }

    Square(double x, double y, double side) {
        this.x = x;
        this.y = y;
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return side * 4;
    }

    @Override
    public String howToColor() {
        return "Color all four sides.";
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}

interface Colorable {

    String howToColor();
}
