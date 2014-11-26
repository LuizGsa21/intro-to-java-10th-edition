package Chapter_01;

/**
 * Chapter 1 Exercise 9:
 *
 *      (Area and perimeter of a rectangle) Write a program that displays the area and perimeter
 *       of a rectangle with the width of 4.5 and height of 7.9
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_09 {

    public static void main(String[] strings) {

        final double width = 4.5;
        final double height = 7.9;

        double area = width * height;

        System.out.printf("%.1f * %.1f = %.2f", width, height, area);
    }
}
