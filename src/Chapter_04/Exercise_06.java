package Chapter_04;

/**
 * Chapter 4 Exercise 6:
 *
 *      (Random points on a circle)
 *      Write a program that generates three random points on a circle centered at (0, 0)
 *      with radius 40 and display three angles in a triangle formed by these three points
 *
 *      A random point on the circle can be generated using a random angle α
 *      x = r × cos(α) and y = r × sin(α)
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_06 {

    public static void main(String[] args) {

        // Generate a random angle a in radians between 0 and 2π
        double theta = Math.random() * 2 * Math.PI;
        double radius = 1.0;
        double x = radius * Math.cos(theta);
        double y = radius * Math.sin(theta);
        System.out.println("x = " + x + " " + " y = " + y);

    }
}
