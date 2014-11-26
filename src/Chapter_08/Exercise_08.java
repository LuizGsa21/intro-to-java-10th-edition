package Chapter_08;

import ToolKit.Kit;

import java.util.Scanner;

/**
 * Chapter 8 Exercise 8:
 *
 *      (All closest pairs of points)
 *      Revise Listing 8.3, FindNearestPoints.java, to display all closest pairs of points
 *      with the same minimum distance.
 *
 * Created by Luiz Arantes Sa on 8/29/14.
 */
public class Exercise_08 {

    private static final int EMPTY = -999999999;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of points: ");
        int numberOfPoints = input.nextInt();

        // Create an array to store points
        double[][] points = new double[numberOfPoints][2];
        System.out.print("Enter " + numberOfPoints + " points: ");
        for (int i = 0; i < points.length; i++) {
            points[i][0] = input.nextDouble();
            points[i][1] = input.nextDouble();
        }

        // minimumDistanceIndexes
        int[][] mDisIndex = new int[numberOfPoints][2];
        final int mX = 0; // minimumDistanceIndexes index
        final int mY = 1; // minimumDistanceIndexes index
        int trackMinCount = 0;

        //  0 0 1 1 -1 -1 2 2 -2 -2 -3 -3 -4 -4 5 5
        // Compute distance for every two points
        double shortestDistance = 999999999;
        for (int i = 0; i < points.length; i++) {
            double minDistance = 0;
            for (int j = i + 1; j < points.length; j++) {
                double distance = distance(points[i][0], points[i][1],
                        points[j][0], points[j][1]); // Find distance
                // DEBUG: displaying distances
                //System.out.println("Shortest Distance = " + shortestDistance + " new distance = " +distance);

                if (shortestDistance > distance) {
                    clearIndexes(mDisIndex);
                    trackMinCount = 1;
                    mDisIndex[i][mX] = i;
                    mDisIndex[i][mY] = j;

                    shortestDistance = distance; // Update shortestDistance
                } else if (shortestDistance == distance) {
                    mDisIndex[i][mX] = i;
                    mDisIndex[i][mY] = j;
                    trackMinCount++;
                    //System.out.println(mDisIndex[i][mX] + " = x");
                   //System.out.println(mDisIndex[i][mY] + " = y");
                }
            }
        }

        int p1 = 0;
        int p2  = 0;
        for (int i = 0; i < trackMinCount; i++) {

                if (mDisIndex[i][mX] != EMPTY) {
                    p1 = mDisIndex[i][mX];
                    p2 = mDisIndex[i][mY];
                    System.out.println("The closest two points are " +
                            "(" + points[p1][0] + ", " + points[p1][1] + ") and (" +
                            points[p2][0] + ", " + points[p2][1] + ")");
            }

        }

    }

    public static void clearIndexes(int[][] indexes) {

        for (int i = 0; i < indexes.length; i++) {
            for (int k = 0; k < indexes[0].length; k++) {
                indexes[i][k] = EMPTY;
            }
        }
    }

    /** Compute the distance between two points (x1, y1) and (x2, y2)*/
    public static double distance(
            double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}
