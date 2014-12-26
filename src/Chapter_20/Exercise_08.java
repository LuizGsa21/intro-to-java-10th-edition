package Chapter_20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * (Game: lottery)
 * Revise Programming Exercise 3.15 to add an additional $2,000 award
 * if two digits from the user input are in the lottery number.
 * Created by Luiz Arantes Sa on 12/24/14.
 */
public class Exercise_08 {

    public static void main(String[] strings) {

        // Generate a lottery
        int lottery = (int)(Math.random() * 1000);

        // Prompt the user to enter a guess
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Enter your lottery pick (three digits): ");
        int guess = input.nextInt();

        // Put lottery and guess digits in two separate list then sort
        List<Integer> lotteryList = getDigits(lottery, 3);
        Collections.sort(lotteryList);

        List<Integer> guessList = getDigits(guess, 3);
        Collections.sort(guessList);

        System.out.println("Lottery number: " + lottery);

        // Check the guess
        if (guess  == lottery) // exact match
            System.out.println("Exact match: you win $10,000");
        else if (lotteryList.equals(guessList)) // match all 3
            System.out.println("Match all digits: you win $3,000");
        else if (lotteryList.containsAll(guessList.subList(0, 2)) || // match 2
                 lotteryList.containsAll(guessList.subList(1, 3)) ||
                (lotteryList.contains(guessList.get(0)) && lotteryList.contains(guessList.get(3))))
            System.out.println("Match two digit: you win $2,000");
        else if (lotteryList.contains(guessList.get(0)) || // match 1
                 lotteryList.contains(guessList.get(1)) ||
                 lotteryList.contains(guessList.get(2)))
            System.out.println("Match one digit: you win $1,000");
        else
            System.out.println("Sorry, no match");

    }

    public static ArrayList<Integer> getDigits(int number, int digitCount) {

        int count = 0;
        ArrayList<Integer> list = new ArrayList<>(digitCount);

        while (number > 0) {
            list.add(number % 10);
            number /= 10;
            count++;
        }

        while (count < digitCount) {
            list.add(0, 0);
            count++;
        }

        return list;
    }

}
