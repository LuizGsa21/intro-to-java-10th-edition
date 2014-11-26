package ToolKit;

/**
 * Sort methods
 *
 * Created by Luiz Arantes Sa on 9/7/14.
 */
public class Sort {

    public static void main(String[] args) {
        int[] matrix1 = Kit.makeUnsortedArray(10, 20);

        Kit.displayGrid(matrix1);
        System.out.println();


        insertionSort(matrix1);
        Kit.displayGrid(matrix1);
    }

    /** sort in ascending order using selection sort **/
    public static void selectionSort(int[] m) {

        for (int i = 0; i < m.length - 1; i++) {
            int currentIndex = i;
            int currentMin = m[i];

            for (int j = i + 1; j < m.length; j++) {
                if (m[j] < currentMin) {
                    currentIndex = j;
                    currentMin = m[j];
                }
            }
            if (currentIndex != i) {
                m[currentIndex] = m[i];
                m[i] = currentMin;
            }
        }
    }
    /** sort ascending order using bubble sort **/
    public static void bubbleSort(int[] m) {
        boolean hasChanged;

        do {
            hasChanged = false;
            for (int i = 0; i < m.length - 1; i++) {
                if (m[i] > m[i + 1]) {
                    hasChanged = true;
                    int temp = m[i + 1];
                    m[i + 1] = m[i];
                    m[i] = temp;
                }
            }
        } while (hasChanged);
    }

    /** sort using insertion sort **/
    public static void insertionSort(int[] m) {

        for (int i = 1; i < m.length; i++) {
            int currentElement = m[i];
            int k;
            for (k = i - 1; k >= 0 && m[k] > currentElement; k--) {
                m[k + 1] = m[k];
            }
            m[k + 1] = currentElement;
        }
    }

    /** quickSort/partition **/
    public static int partitionSort(int[] m) {

        int first = 0;
        int pivot = m[first];
        int low = first + 1;
        int high = m.length -1;

        while (high > low) {

            while (low <= high && m[low] <= pivot) low++;
            while (low <= high && m[high] > pivot) high--;

            if (high > low) {
                int temp = m[high];
                m[high] = m[low];
                m[low] = temp;

            }

        }
        while (high >= low && m[high] >= pivot) high--;

        if (high > first) {
            int temp = m[high];
            m[high] = m[first];
            m[first] = temp;
            return high;
        } else {
            return first;
        }
    }

}
