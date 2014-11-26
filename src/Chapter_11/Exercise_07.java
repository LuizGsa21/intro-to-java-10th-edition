package Chapter_11;

import java.util.ArrayList;

/**
 * Chapter 11 Exercise 07:
 *
 *  (Shuffle ArrayList)
 *  Write the following method that shuffles the elements in an ArrayList of integers.
 *
 *  public static void shuffle(ArrayList<Integer> list)
 *
 * Created by Luiz Arantes Sa on 9/8/14.
 */
public class Exercise_07 {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        System.out.println(list);

        System.out.println("Shuffling list...");
        shuffle(list);
        System.out.println(list);
    }

    public static void shuffle(ArrayList<Integer> list) {

        // simple solution
        //Collections.shuffle(list);

        // manual shuffle
        for (int i = 0; i < list.size(); i++) {
            int randomIndex = (int) (Math.random() * list.size());
            int temp = list.get(randomIndex);
            list.set(randomIndex, list.get(i));
            list.set(i, temp);
        }

    }


}
