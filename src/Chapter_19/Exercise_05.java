package Chapter_19;

/**
 * (Maximum element in an array)
 * Implement the following method that returns the maximum element in an array.
 *
 * public static <E extends Comparable<E>> E max(E[] list)
 *
 * Created by Luiz Arantes Sa on 12/17/14.
 */
public class Exercise_05 {

    public static void main(String[] args) {

        Integer[] list = new Integer[10];
        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }

        System.out.println("Max = " + max(list));
    }

    public static <E extends Comparable<E>> E max(E[] list) {

        E max = list[0];
        for (int i = 1; i < list.length; i++) {
            E element = list[i];
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }

        return max;
    }
}
