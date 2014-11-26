package ToolKit;

import javafx.scene.shape.Circle;

/**
 * Chapter 10 Exercise 11:
 *
 *      My class for Chapter 10 Exercise 11.
 *
 * Created by Luiz Arantes Sa on 9/2/14.
 */
public class Circle2D  extends GeometricObject {

    private double x;
    private double y;
    private double radius;

    public Circle2D(Circle c) {
        this(c.getCenterX(), c.getCenterY(), c.getRadius());
    }
    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle2D() {
        this(0, 0, 1);
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

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {

        return 2 * radius * Math.PI;

    }



    public boolean contains(Circle2D circle2D) {
        double distance = getPoint().distance(circle2D.x, circle2D.y);

        if (distance <= Math.abs(this.radius - circle2D.radius)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean c1ContainsC2(Circle c1, Circle c2) {
        Circle2D cir1 = new Circle2D(c1);
        Circle2D cir2 =new Circle2D(c2);

        return cir1.contains(cir2);
    }

    public static boolean c1OverlapsC2(Circle c1, Circle c2) {
        Circle2D cir1 = new Circle2D(c1);
        Circle2D cir2 =new Circle2D(c2);

        if (cir1.contains(cir2) || cir2.contains(cir1)) return false;

        return cir1.overlaps(cir2);
    }

    public boolean overlaps(Circle2D circle2D) {
        double distance = getPoint().distance(circle2D.x, circle2D.y);

        if (distance  <= this.radius + circle2D.radius)
            return true;
        else
            return false;

    }

    private MyPoint getPoint() {
        return new MyPoint(this.x, this.y);
    }

    @Override
    public String toString() {
        return "Circle2D{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
    }

    public boolean contains(double x, double y) {

        double distance = getPoint().distance(x, y);

        if (distance <= radius) return true;
        else return false;
    }
}
