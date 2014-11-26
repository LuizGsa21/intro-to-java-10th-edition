package Chapter_07;

import java.util.Scanner;

/**
 * Chapter 7 Exercise 33:
 *
 *      (Culture: Chinese Zodiac)
 *      Simplify Listing 3.9 using an array of strings to store the animal names.
 *
 * Created by Luiz Arantes Sa on 8/29/14.
 */
public class Exercise_33 {

    public static void main(String[] args) {

        String[] chineseZodiac = new String[] {
                "monkey","rooster","dog","pig","rat","ox","tiger","rabbit","dragon","snake","horse","sheep"
        };
        Scanner input = new Scanner(System.in);


        System.out.print("Enter a year: ");
        int year = input.nextInt();

        System.out.println(chineseZodiac[year % 12]);
    }
}
