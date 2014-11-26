package Chapter_07;

/**
 * Chapter 7 Exercise 7:
 *
 *      (Count single digits)
 *      Write a program that generates 100 random integers between 0 and 9
 *      and displays the count for each number. (Hint: Use an array of ten
 *      integers, say counts, to store the counts for the number of 0s, 1s, . . . , 9s.)
 *
 * Created by Luiz Arantes Sa on 8/27/14.
 */
public class Exercise_07 {

    static final int SIZE = 100;
    static final int RANGE = 10;
    public static void main(String[] args) {

        int[] randomNumbers = new int[SIZE];
        int[] occurrence = new int[RANGE];
        // generate random numbers 0-9
        for (int i = 0; i < randomNumbers.length; i++) {
            int num = (int)(Math.random() * RANGE);
            randomNumbers[i] = num;
            occurrence[num]++;
        }

        for (int i = 0; i < randomNumbers.length; i++) {

            System.out.print(randomNumbers[i] + " ");
            if ((i + 1) % 10 == 0) System.out.println("");
        }

        System.out.println("---------------------------");
        for (int i = 0; i < occurrence.length; i++) {
            System.out.println("Occurrences for "+ i + " = " + occurrence[i]);


        }




    }

    public static void printArray(int[] array, int numberPerLine) {

        for (int i = 0; i < array.length; i++) {

            System.out.printf("%4d", array[i]);
            if ((i + 1) % numberPerLine == 0) System.out.println("");
        }
    }
}
