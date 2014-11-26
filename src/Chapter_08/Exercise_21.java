package Chapter_08;

import java.util.Scanner;

/**
 * Chapter 8 Exercise 21:
 *
 *      (Central city)
 *      Given a set of cities, the central city is the city that has the
 *      shortest total distance to all other cities. Write a program that
 *      prompts the user to enter the number of the cities and the locations
 *      of the cities (coordinates), and finds the central city and its total
 *      distance to all other cities.
 *
 * Created by Luiz Arantes Sa on 8/31/14.
 */
public class Exercise_21 {

    // index info: 0 = x | 1 = y | 2 = total distance to all other cities
    // for simplicity
    static final int X = 0;
    static final int Y = 1;
    static final int DISTANCE = 2;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of cities: ");
        int numOfCities = input.nextInt();
        double[][] points = new double[numOfCities][3];

        System.out.print("Enter the coordinates of the cities:\n");
        for (int i = 0; i < points.length; i++)
            for (int j = 0; j < points[i].length - 1; j++)
                points[i][j] = input.nextDouble();

        double[] central = getCentralPoint(points);

        System.out.printf("The central city is at (%.1f, %.1f)\n", central[X], central[Y]);
        System.out.printf("The total distance to all other cities is %.2f", central[DISTANCE]);
    }

    /** Compute the distance between two points (x1, y1) and (x2, y2)*/
    public static double distance(
            double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    public static double[] getCentralPoint(double[][] points) {

        for (int i = 0; i < points.length; i++) {

            for (int j = 0; j < points.length; j++) {

                if (j != i) {
                    points[i][DISTANCE] += distance(points[i][X], points[i][Y], points[j][X],points[j][Y]);
                }

            }
        }

        // find point with least total distance
        // and return central point
        double[] central = points[0];
        for (int i = 1; i < points.length; i++) {

            if (points[i][DISTANCE] < central[DISTANCE]) {
                central = points[i];
            }
        }

        return central;

    }


}
