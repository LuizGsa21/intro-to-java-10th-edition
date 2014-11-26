package Chapter_01;

/**
 * Chapter 1 Exercise 8:
 *      (Area and perimeter of a circle) Write a program that displays the area and perimeter
 *      of a circle that has a radius of 5.5
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_08 {

    private static final double radius = 5.5;

    public static void main(String[] args) {

        double perimeter = 2 * radius * Math.PI;
        double area = radius * radius * Math.PI;

        System.out.println("Perimeter = " + perimeter);
        System.out.println("Area = " + area);
    }
}
