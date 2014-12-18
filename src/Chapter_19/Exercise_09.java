package Chapter_19;

import java.util.ArrayList;

/**
 * (Sort ArrayList)
 * Write the following method that sorts an ArrayList:
 *
 * public static <E extends Comparable<E>> void sort(ArrayList<E> list)
 *
 * Created by Luiz Arantes Sa on 12/17/14.
 */
public class Exercise_09 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        Exercise_08.shuffle(list);
        System.out.println(list);
        sort(list);
        System.out.println(list);

    }

    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {


        for (int i = 0; i < list.size() - 1; i++) {
            E currentMin = list.get(i);
            int min = i;
            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(j).compareTo(currentMin) < 0) {
                    currentMin = list.get(j);
                    min = j;
                }
            }

            if (min != i) {
                list.set(min, list.get(i));
                list.set(i, currentMin);
            }
        }
    }
    
}
