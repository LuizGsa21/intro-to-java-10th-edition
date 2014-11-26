package Chapter_12;

import ToolKit.Triangle;
import ToolKit.Triangle.IllegalTriangleException;

/**
 * Chapter 12 Exercise 5:
 *
 *      (IllegalTriangleException)
 *      Programming Exercise 11.1 defined the Triangle class with three sides.
 *      In a triangle, the sum of any two sides is greater than the other side.
 *      The Triangle class must adhere to this rule. Create the IllegalTriangleException class,
 *      and modify the constructor of the Triangle class to throw an IllegalTriangleException
 *      object if a triangle is created with sides that violate the rule
 *
 *
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_05 {

    public static void main(String[] args) {

        Triangle t1;
        try {
            t1 = new Triangle(1, 1, 2000);
        } catch (IllegalTriangleException e) {
            e.printStackTrace();
        }

    }

}
