package Chapter_08;

import java.util.Scanner;

/**
 * Chapter 8 Exercise 37:
 *
 *      (Guess the capitals)
 *      Write a program that repeatedly prompts the user to enter a capital for a state.
 *      Upon receiving the user input, the program reports whether the answer is correct.
 *      Assume that 50 states and their capitals are stored in a two-dimensional array,
 *      as shown in Figure 8.10. The program prompts the user to answer all states’
 *      capitals and displays the total correct count. The user’s answer is not case-sensitive.
 *
 * Created by Luiz Arantes Sa on 9/1/14.
 */
public class Exercise_37 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int correctCount = 0;
        for (int i = 0; i < stateCapitals.length; i++) {
            System.out.print("What is the capital of " + stateCapitals[i][0]+"? ");
            String s = input.nextLine();
            if (s.equalsIgnoreCase(stateCapitals[i][1])) {
                System.out.println("Your answer is correct!");
                correctCount++;
            } else {
                System.out.println("WRONG - The correct answer is " + stateCapitals[i][1]);
            }
        }
        System.out.println("The correct count is " + correctCount);
    }

    private static String[][] stateCapitals = {
                    {"Alabama", "Montgomery"},
                    {"Alaska", "Juneau"},
                    {"Arizona", "Phoenix"},
                    {"Arkansas", "Little Rock"},
                    {"California", "Sacramento"},
                    {"Colorado", "Denver"},
                    {"Connecticut", "Hartford"},
                    {"Delaware", "Dover"},
                    {"Florida", "Tallahassee"},
                    {"Georgia", "Atlanta"},
                    {"Hawaii", "Honolulu"},
                    {"Idaho", "Boise"},
                    {"Illinois", "Springfield"},
                    {"Maryland", "Annapolis"},
                    {"Minnesota", "Saint Paul"},
                    {"Iowa", "Des Moines"},
                    {"Maine", "Augusta"},
                    {"Kentucky", "Frankfort"},
                    {"Indiana", "Indianapolis"},
                    {"Kansas", "Topeka"},
                    {"Louisiana", "Baton Rouge"},
                    {"Oregon", "Salem"},
                    {"Oklahoma", "Oklahoma City"},
                    {"Ohio", "Columbus"},
                    {"North Dakota", "Bismark"},
                    {"New York", "Albany"},
                    {"New Mexico", "Santa Fe"},
                    {"New Jersey", "Trenton"},
                    {"New Hampshire", "Concord"},
                    {"Nevada", "Carson City"},
                    {"Nebraska", "Lincoln"},
                    {"Montana", "Helena"},
                    {"North Carolina", "Raleigh"},
                    {"Missouri", "Jefferson City"},
                    {"Mississippi", "Jackson"},
                    {"Massachusetts", "Boston"},
                    {"Michigan", "Lansing"},
                    {"Pennsylvania", "Harrisburg"},
                    {"Rhode Island", "Providence"},
                    {"South Carolina", "Columbia"},
                    {"South Dakota", "Pierre"},
                    {"Tennessee", "Nashville"},
                    {"Texas", "Austin"},
                    {"Utah", "Salt Lake City"},
                    {"Vermont", "Montpelier"},
                    {"Virginia", "Richmond"},
                    {"Washington", "Olympia"},
                    {"West Virginia", "Charleston"},
                    {"Wisconsin", "Madison"},
                    {"Wyoming", "Cheyenne"}
            };
}
