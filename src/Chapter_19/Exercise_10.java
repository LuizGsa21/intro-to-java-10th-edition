package Chapter_19;

import java.util.ArrayList;

/**
 * (Largest element in ArrayList)
 * Write the following method that returns the largest element in an ArrayList:
 *
 *  public static <E extends Comparable<E>> E max(ArrayList<E> list)
 *
 * Created by Luiz Arantes Sa on 12/17/14.
 */
public class Exercise_10 {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(max(list));
        
    }

    public static <E extends Comparable<E>> E max(ArrayList<E> list) {
        E max = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            }
        }

        return max;
    }
}
