package Chapter_17;

/**
 * Created by Kernel on 11/4/14.
 */
public class temp {

    public static void main(String[] args) {

        int[] array = getUnsortedArray();

        temp(array);
        printArray(array);
    }

    public static void temp(int[] m) {

        for (int i = 1; i < m.length; i++) {
            int currentE = m[i];
            int k;
            for (k = i - 1; k >= 0 && currentE < m[k]; k--)
                m[k + 1] = m[k];

            m[k + 1] = currentE;
        }
    }
    /** Selection sort */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }

            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }

    }
    /** insertion sort */
    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            /** insert list[i] into a sorted sublist list[0..i-1] so that
             list[0..i] is sorted. */
            int currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
                list[k + 1] = list[k];
            }

            // Insert the current element into list[k+1]
            list[k + 1] = currentElement;
        }
    }
    public static int[] getUnsortedArray() {
        int[] array = new int[] {10,9,7,6,5,4,3,2,1};

        for (int i = 0; i < array.length; i++) {
           // array[i] = (int)(Math.random() * 101);
        }
        return array;
    }

    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {

            if (i % 10 == 0) System.out.println();

            System.out.print(array[i] + " ");
        }
    }
}
