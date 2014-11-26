package Chapter_13;

import ToolKit.GeometricObject;

/**
 * Chapter 13 Exercise 10:
 *
 *      (Enable MyRec2 comparable)
 *      Rewrite the MyRec2 class in Listing 13.3 to extend GeometricObject
 *      and implement the Comparable interface. Override the equals method in
 *      the Object class. Two MyRec2 objects are equal if their areas are the same.
 *      Draw the UML diagram that involves MyRec2, GeometricObject, and Comparable.
 *
 * Created by Luiz Arantes Sa on 9/10/14.
 */
public class Exercise_10 {

    public static void main(String[] args) {

        Rectangle rec1 = new Rectangle(10,10);
        Rectangle rec2 = new Rectangle(10, 10);
        System.out.println(rec1.equals(rec2));
        System.out.println(rec1.compareTo(rec2));
    }

    private static class Rectangle extends GeometricObject {
        private double width;
        private double height;

        public Rectangle() {
        }

        public Rectangle(
                double width, double height) {
            this.width = width;
            this.height = height;
        }

        public Rectangle(
                double width, double height, String color, boolean filled) {
            this.width = width;
            this.height = height;
            setColor(color);
            setFilled(filled);
        }

        /** Return width */
        public double getWidth() {
            return width;
        }

        /** Set a new width */
        public void setWidth(double width) {
            this.width = width;
        }

        /** Return height */
        public double getHeight() {
            return height;
        }

        /** Set a new height */
        public void setHeight(double height) {
            this.height = height;
        }

        /** Return area */
        public double getArea() {
            return width * height;
        }

        /** Return perimeter */
        public double getPerimeter() {
            return 2 * (width + height);
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof Rectangle && getArea() == ((Rectangle) o).getArea();
        }
    }
}


