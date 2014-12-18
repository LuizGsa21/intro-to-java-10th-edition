package Chapter_19;

/**
 * (Generic binary search)
 * Implement the following method using binary search
 *
 * public static <E extends Comparable<E>> int binarySearch(E[] list, E value)
 *
 * Created by Luiz Arantes Sa on 12/17/14.
 */
public class Exercise_07 {

    public static void main(String[] args) {

        Integer[] list = new Integer[10];
        for (int i = 0; i < list.length; i++) {
                list[i] = i;
        }

        // Test binarySearch
        for (int i = 0; i < list.length + 4; i++) {
            System.out.println("Max = " + binarySearch(list, i));
        }

    }

    public static <E extends Comparable<E>> int binarySearch(E[] list, E value) {

        int low = 0;
        int high = list.length - 1;

        while (high >= low) {
            int mid = (high - low) / 2 + low;
            if (list[mid].compareTo(value) == 0) return mid;

            if (list[mid].compareTo(value) < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
}
