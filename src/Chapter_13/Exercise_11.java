package Chapter_13;

import ToolKit.Octagon;

/**
 * Chapter 13 Exercise 11:
 *
 *      (The Octagon class)
 *      Write a class named Octagon that extends GeometricObject and implements
 *      the Comparable and Cloneable inter- faces. Assume that all eight sides
 *      of the octagon are of equal length. The area can be computed using the
 *      following formula:
 *      area = (2 + 4/22)* side * side
 *      Draw the UML diagram that involves Octagon, GeometricObject, Comparable, and Cloneable.
 *      Write a test program that creates an Octagon object with side value 5
 *      and displays its area and perimeter. Create a new object using the clone method
 *      and compare the two objects using the compareTo method.
 *
 * Created by Luiz Arantes Sa on 9/10/14.
 */
public class Exercise_11 {

    public static void main(String[] args) {
        Octagon oc1 = new Octagon(10);
        Octagon oc2 = (Octagon)oc1.clone();

        System.out.println("compareTo: " + (oc1.compareTo(oc2) == 0));
        System.out.println("equals: " + oc1.equals(oc2));
        System.out.println("Have the same reference? " + (oc1 == oc2));
    }
}
