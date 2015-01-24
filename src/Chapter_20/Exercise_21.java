package Chapter_20;

import ToolKit.Circle;
import ToolKit.GeometricObject;
import ToolKit.Rectangle;

import java.util.Arrays;
import java.util.Comparator;

/**
 * (Use Comparator)
 * Write the following generic method using selection sort and a comparator.
 * public static <E> void selectionSort(E[] list, Comparator<? super E> comparator)
 * Write a test program that creates an array of 10 GeometricObjects and invokes this
 * method using the GeometricObjectComparator introduced in Listing 20.4 to sort the elements.
 * Display the sorted elements. Use the following statement to create the array.
 * GeometricObject[] list =
 *      {new Circle(5), new Rectangle(4, 5),
 *      new Circle(5.5), new Rectangle(2.4, 5),
 *      new Circle(0.5), new Rectangle(4, 65),
 *      new Circle(4.5), new Rectangle(4.4, 1),
 *      new Circle(6.5), new Rectangle(4, 5)};
 * Created by Luiz Arantes Sa on 1/23/15.
 */
public class Exercise_21 {

    public static void main(String[] args) {
        GeometricObject[] list = {
                new Circle(5), new Rectangle(4, 5),
                new Circle(5.5), new Rectangle(2.4, 5),
                new Circle(0.5), new Rectangle(4, 65),
                new Circle(4.5), new Rectangle(4.4, 1),
                new Circle(6.5), new Rectangle(4, 5)
        };


        System.out.println("Before sort");
        for (GeometricObject o : list) {
            System.out.println(o.getArea());
        }


        selectionSort(list, new Comparator<GeometricObject>() {
            @Override
            public int compare(GeometricObject o1, GeometricObject o2) {
                double a1 = o1.getArea();
                double a2 = o2.getArea();
                if (a1 > a2)
                    return 1;
                if (a1 == a2)
                    return 0;
                else
                    return -1;
            }
        });

        System.out.println("After sort");
        for (GeometricObject o : list) {
            System.out.println(o.getArea());
        }

    }

    public static <E> void selectionSort(E[] array, Comparator<? super E> comparator) {

        for (int i = 0; i < array.length - 1; i++) {

            E currentMin = array[i];
            int minIndex = i;
            for (int k = i + 1; k < array.length; k++) {
                if (comparator.compare(array[k], currentMin) < 0) {
                    currentMin = array[k];
                    minIndex = k;
                }
            }

            if (minIndex != i) {
                array[minIndex] = array[i];
                array[i] = currentMin;
            }
        }
    }

}
