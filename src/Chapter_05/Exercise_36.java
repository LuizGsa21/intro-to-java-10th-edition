package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 36:
 *
 *      (Business application: checking ISBN)
 *      Use loops to simplify Programming Exercise 3.9.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_36 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first 9 digits of an ISBN as integer: ");
        int nineDigitISBN = input.nextInt();

        int checksum = 0;
        int divide = 100000000;
        for (int i = 1; i < 10; i++) {
            if (i == 9){
                checksum += nineDigitISBN % 10 * i;
                checksum = checksum % 11;
            }
            else
                checksum += nineDigitISBN / divide % 10 * i;
            divide = divide / 10;

        }

        divide = 100000000;
        while (nineDigitISBN / divide == 0) {
            System.out.print("0");
            divide = divide / 10;
        }
        System.out.print(nineDigitISBN);
        if (checksum == 10) {
            System.out.print("X");
        } else {
            System.out.print(checksum);
        }

    }
}
