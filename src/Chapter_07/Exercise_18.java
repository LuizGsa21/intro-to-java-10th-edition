package Chapter_07;

/**
 * Chapter 7 Exercise 18:
 *
 *      (Bubble sort)
 *      Write a sort method that uses the bubble sort algorithm.
 *      The bubble sort algorithm makes several passes through the array.
 *      On each pass, successive neighboring pairs are compared.
 *      If a pair is not in order, its values are swapped; otherwise,
 *      the values remain unchanged. The technique is called a bubble sort or
 *      sinking sort because the smaller values gradually “bubble” their way to the
 *      top and the larger values “sink” to the bottom. Write a test program that reads
 *      in ten double numbers, invokes the method, and displays the sorted numbers.
 *
 * Created by Luiz Arantes Sa on 8/27/14.
 */
public class Exercise_18 {

    public static void main(String[] args) {

        double[] numbers = new double[100];

        for (int i = 0; i < numbers.length ; i++) {
            numbers[i] = Math.random() * 200;
        }
        bubbleSort(numbers);
        printArray(numbers, 10);
    }

    public static void printArray(double[] array, int numberPerLine) {

            for (int i = 0; i < array.length; i++) {

                System.out.printf("%4.0f ", array[i]);
                if ((i + 1) % numberPerLine == 0) System.out.println("");
            }
    }

    public static void bubbleSort(double[] numbers) {

        boolean change;
        do {
            change = false;
            for (int i = 0; i < numbers.length - 1; i++) {

                if (numbers[i] > numbers[i + 1]) {
                    double temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                    change = true;
                 }
            }

        } while (change);

    }



}
